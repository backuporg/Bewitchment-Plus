package dev.mrsterner.bewitchmentplus.common.entity;

import dev.mrsterner.bewitchmentplus.common.entity.ai.LeshonMeleeAttackGoal;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

@SuppressWarnings("ALL")
public class LeshonEntity extends HostileEntity implements IAnimatable {
    public static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(LeshonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final AnimationFactory factory = new AnimationFactory(this);
    public Vec3d motionCalc = new Vec3d(0, 0, 0);
    public boolean isAttacking = false;

    public LeshonEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_ARMOR, 20)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new LeshonMeleeAttackGoal(this, 1, true));
        goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8));
        goalSelector.add(3, new LookAroundGoal(this));
        targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(1, new RevengeGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    public boolean getAttckingState() {
        return this.dataTracker.get(ATTACKING);
    }

    public void setAttackingState(boolean isAttacking) {
        this.dataTracker.set(ATTACKING, isAttacking);
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    private <E extends IAnimatable> PlayState devMovement(AnimationEvent<E> animationEvent) {
        AnimationBuilder builder = new AnimationBuilder();
        boolean isMovingHorizontal = Math.sqrt(Math.pow(motionCalc.x, 2) + Math.pow(motionCalc.z, 2)) > 0.005;
        if (this.isSleeping()) {
            builder.addAnimation("animation.leshon.quad.sleep", true);
        } else if (this.getPose() == EntityPose.SWIMMING || this.touchingWater) {
            builder.addAnimation("animation.leshin.standing.swim", true);
        } else if (!this.isOnGround() && motionCalc.getY() < -0.6) {
            if (!this.isClimbing()) {
                builder.addAnimation("animation.leshon.standing.fall", false);
            }
        } else if (this.handSwinging) {
            builder.addAnimation("animation.leshon.standing.attack", false);
        } else if (this.isSneaking()) {
            if (isMovingHorizontal) {
                if (this.forwardSpeed < 0) {
                    builder.addAnimation("animation.leshon.standing.sneakDev_back", true);
                } else {
                    builder.addAnimation("animation.leshon.standing.sneakDev", true);
                }
            } else {
                builder.addAnimation("animation.leshon.standing.sneak_idle", true);
            }
        } else {
            if (this.isSprinting()) {
                builder.addAnimation("animation.leshon.quad.runningDev", true);
                if (this.handSwinging) {
                    builder.addAnimation("animation.leshon.quad.attack", false);
                }
            } else if (this.forwardSpeed < 0) {
                builder.addAnimation("animation.leshon.standing.walk_back", true);
            } else if (isMovingHorizontal || animationEvent.isMoving()) {
                builder.addAnimation("animation.leshon.standing.walk", true);
            }
        }
        if (animationEvent.getController().getCurrentAnimation() == null || builder.getRawAnimationList().size() <= 0) {
            builder.addAnimation("animation.leshon.standing.idle", true);
        }
        animationEvent.getController().setAnimation(builder);
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState devAttack(AnimationEvent<E> animationEvent) {
        /*
        if (this.getDataTracker().get(ATTACKING)) {
            animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.leshon.standing.attack", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;

         */
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "DevMovement", 2, this::devMovement));
        animationData.addAnimationController(new AnimationController(this, "DevAttack", 2, this::devAttack));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
