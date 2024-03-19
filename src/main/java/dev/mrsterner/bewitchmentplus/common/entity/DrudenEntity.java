package dev.mrsterner.bewitchmentplus.common.entity;

import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

@SuppressWarnings("ALL")
public class DrudenEntity extends BWHostileEntity {

    public static final TrackedData<Boolean> SPEAR_LUNGE = DataTracker.registerData(DrudenEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public DrudenEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_CACTUS, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_CACTUS, 0.0F);
        experiencePoints = 5;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 25.00D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D).add(EntityAttributes.GENERIC_ARMOR, 4.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D);
    }

    public static int getVariantsStatic() {
        return 9;
    }

    public void slowMovement(BlockState state, Vec3d multiplier) {
        if (!state.isOf(Blocks.SWEET_BERRY_BUSH)) {
            super.slowMovement(state, multiplier);
        }
    }

    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        return effect.getEffectType() == StatusEffects.SLOWNESS ? false : super.canHaveStatusEffect(effect);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    public void tick() {
        super.tick();
        if (this.isOnFire())
            this.applyDamage(DamageSource.ON_FIRE, 6);
            this.playSound(SoundEvents.BLOCK_CAMPFIRE_CRACKLE, 1, 1);
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BlockPos pos = new BlockPos.Mutable(this.getX(), this.getY(), this.getZ());
        BlockState blockState = world.getBlockState(pos);


        if (!this.isAttacking()) {
            if (blockState.getBlock() instanceof Fertilizable) {
                if (world instanceof ServerWorld) {
                    Fertilizable fertilizable = (Fertilizable) blockState.getBlock();
                    if (fertilizable.isFertilizable(world, pos, blockState, world.isClient)) {
                        if (world instanceof ServerWorld) {
                            if (!(fertilizable instanceof TallFlowerBlock)) {
                                if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                                    fertilizable.grow((ServerWorld) world, world.random, pos, blockState);
                                }
                            }
                        }
                    }
                }
            }
            if (this.isAttacking()) {
                if (!this.world.isClient) {
                    int i = MathHelper.floor(this.getX());
                    int j = MathHelper.floor(this.getY());
                    int k = MathHelper.floor(this.getZ());

                    if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        return;
                    }

                    blockState = Blocks.SWEET_BERRY_BUSH.getDefaultState();

                    for (int l = 0; l < 4; ++l) {
                        i = MathHelper.floor(this.getX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                        j = MathHelper.floor(this.getY());
                        k = MathHelper.floor(this.getZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                        BlockPos blockPos = new BlockPos(i, j, k);
                        if (this.world.getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.world, blockPos)) {
                            this.world.setBlockState(blockPos, blockState);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean flag = super.tryAttack(target);
        Random rand = new Random();
        int i = rand.nextInt(100);
        if (target instanceof LivingEntity) {
            swingHand(Hand.MAIN_HAND, true);
            this.playSound(SoundEvents.BLOCK_BAMBOO_HIT, 1, 1);
        }
        if (i <= 10) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300,1));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10000, 3));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10000, 3));
                swingHand(Hand.MAIN_HAND, true);
                this.playSound(SoundEvents.BLOCK_BAMBOO_HIT, 1, 1);
                this.playSound(SoundEvents.ENTITY_GHAST_SCREAM, 1, 1);
            }
        }
        return flag;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.world.random.nextInt(3) == 0 && !this.dataTracker.get(SPEAR_LUNGE)) {
            dataTracker.set(SPEAR_LUNGE, true);
        } else {
            dataTracker.set(SPEAR_LUNGE, false);
        }
        return this.isInvulnerableTo(source) ? false : super.damage(source, amount);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SPEAR_LUNGE, false);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GHAST_SCREAM;
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        return super.writeNbt(nbt);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound nbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, nbt);
        Random rand = new Random();
        int i = rand.nextInt(100);
        if (i <= 25) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(BWPObjects.THYRSUS_ITEM));
            if (dataTracker.get(VARIANT) != 0) {
                switch (world.getBiome(getBlockPos()).getCategory()) {
                    case FOREST:
                        dataTracker.set(VARIANT, random.nextInt(getVariants() - 4) + 4);
                        break;
                    case TAIGA:
                        dataTracker.set(VARIANT, random.nextInt(getVariants() - 5) + 5);
                        break;
                    case ICY:
                        dataTracker.set(VARIANT, random.nextInt(getVariants() - 5) + 5);
                        break;
                    case SWAMP:
                        dataTracker.set(VARIANT, random.nextInt(getVariants() - 5) + 5);
                        break;
                    default:
                        dataTracker.set(VARIANT, random.nextInt(getVariants() - 1) + 1);
                        break;
                }
            }
            return data;
        }
        return data;
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new MeleeAttackGoal(this, 1, true));
        goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8));
        goalSelector.add(3, new LookAroundGoal(this));
        targetSelector.add(0, new RevengeGoal(this));
        targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, false, entity -> entity instanceof PlayerEntity || entity instanceof VillagerEntity || entity instanceof IllagerEntity || entity instanceof PiglinEntity));
    }

    @Override
    protected boolean hasShiny() {
        return true;
    }

    public EntityGroup getGroup() {
        return BewitchmentAPI.DEMON;
    }

    @Override
    public int getVariants() {
        return getVariantsStatic();
    }
}