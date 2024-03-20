package dev.mrsterner.bewitchmentplus.common.entity;

import com.google.common.collect.Maps;
import dev.mrsterner.bewitchmentplus.common.BWPConfig;
import dev.mrsterner.bewitchmentplus.common.registry.BWPEntityTypes;
import dev.mrsterner.bewitchmentplus.common.registry.BWPLootTables;
import dev.mrsterner.bewitchmentplus.common.registry.BWPObjects;
import dev.mrsterner.bewitchmentplus.mixin.common.MobEntityAccessor;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.common.entity.living.LeonardEntity;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import moriyashiine.bewitchment.common.registry.BWObjects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.StructureTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CambionEntity extends BWHostileEntity implements InventoryChangedListener, InventoryOwner {
    private static final TrackedData<Boolean> BABY = DataTracker.registerData(CambionEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> MALE = DataTracker.registerData(CambionEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final UUID BABY_SPEED_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final EntityAttributeModifier BABY_SPEED_BONUS = new EntityAttributeModifier(BABY_SPEED_ID, "Baby speed boost", 0.5, EntityAttributeModifier.Operation.MULTIPLY_BASE);
    public SimpleInventory cambionInventory = new SimpleInventory(8);
    public static final int BABY_AGE = -12000;
    private int age;
    int barterTimer = 0;
    private static final Map<EquipmentSlot, Identifier> EQUIPMENT_SLOT_ITEMS = Util.make(Maps.newHashMap(),
            (slotItems) -> {
                slotItems.put(EquipmentSlot.MAINHAND, BWPLootTables.CAMBION_MAIN_HAND);
                slotItems.put(EquipmentSlot.OFFHAND, BWPLootTables.CAMBION_OFF_HAND);
                slotItems.put(EquipmentSlot.HEAD, BWPLootTables.CAMBION_HELMET);
                slotItems.put(EquipmentSlot.CHEST, BWPLootTables.CAMBION_CHESTPLATE);
                slotItems.put(EquipmentSlot.LEGS, BWPLootTables.CAMBION_LEGGINGS);
                slotItems.put(EquipmentSlot.FEET, BWPLootTables.CAMBION_BOOTS);
            });

    public CambionEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.cambionInventory.addListener(this);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.35D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D);
    }

    public EntityGroup getGroup() {
        return BewitchmentAPI.DEMON;
    }

    protected boolean hasShiny() {
        return true;
    }

    @Override
    public boolean isLeftHanded() {
        return false;
    }

    @Override
    public boolean canUsePortals() {
        return true;
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        boolean flag = super.canSpawn(world, spawnReason);
        if (flag && (spawnReason == SpawnReason.SPAWNER || spawnReason == SpawnReason.STRUCTURE || spawnReason == SpawnReason.MOB_SUMMONED || spawnReason == SpawnReason.SPAWN_EGG || spawnReason == SpawnReason.COMMAND || spawnReason == SpawnReason.DISPENSER || spawnReason == SpawnReason.NATURAL)) {
            return true;
        }//Todo maybe remove natural spawn
        if (world instanceof ServerWorld && BWPConfig.cambionVillageStructureSpawn) {
            BlockPos nearestVillage = ((ServerWorld) world).locateStructure(StructureTags.VILLAGE, getBlockPos(), 3, false);
            return (nearestVillage != null && Math.sqrt(nearestVillage.getSquaredDistance(getBlockPos())) < 128);
        }
        return false;
    }

    @Override
    public void equipStack(EquipmentSlot slotIn, ItemStack stack) {
        super.equipStack(slotIn, stack);
        switch (slotIn) {
            case HEAD:
                if (this.cambionInventory.getStack(0).isEmpty())
                    this.cambionInventory.setStack(0, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
            case CHEST:
                if (this.cambionInventory.getStack(1).isEmpty())
                    this.cambionInventory.setStack(1, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
            case LEGS:
                if (this.cambionInventory.getStack(2).isEmpty())
                    this.cambionInventory.setStack(2, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
            case FEET:
                if (this.cambionInventory.getStack(3).isEmpty())
                    this.cambionInventory.setStack(3, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
            case OFFHAND:
                if (this.cambionInventory.getStack(4).isEmpty())
                    this.cambionInventory.setStack(4, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
            case MAINHAND:
                if (this.cambionInventory.getStack(5).isEmpty())
                    this.cambionInventory.setStack(5, ((MobEntityAccessor) this).armorItems().get(slotIn.getEntitySlotId()));
                break;
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Random rand = getRandom();
        int i = rand.nextInt(64);
        int j = rand.nextInt(16);
        int k = rand.nextInt(32);
        int l = rand.nextInt(8);
        if (barterTimer == 0) {
            if (itemStack.getItem() == Items.GOLD_INGOT) {
                switch (rand.nextInt(26)) {
                    default:
                        ItemStack itemStack1 = new ItemStack(Items.GOLD_INGOT, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack1);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 0:
                        ItemStack itemStack2 = new ItemStack(Items.DIAMOND, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack2);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 1:
                        ItemStack itemStack3 = new ItemStack(Items.GOLDEN_HORSE_ARMOR);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack3);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 2:
                        ItemStack itemStack4 = new ItemStack(Items.GOLDEN_APPLE);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack4);
                        barterTimer = 4800; //Timer exists to avoid cheese. Golden apples are powerful, give them a longer cooldown.
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 3:
                        ItemStack itemStack5 = new ItemStack(Items.SADDLE);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack5);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 4:
                        ItemStack itemStack6 = new ItemStack(BWObjects.DEMON_HORN, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack6);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 5:
                        ItemStack itemStack7 = new ItemStack(Items.BLAZE_POWDER, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack7);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 6:
                        ItemStack itemStack8 = new ItemStack(Items.REDSTONE, k);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack8);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 7:
                        ItemStack itemStack9 = new ItemStack(BWObjects.DEMON_HEART);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack9);
                        barterTimer = 4800; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 8:
                        ItemStack itemStack10 = new ItemStack(BWObjects.SNAKE_TONGUE, i);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack10);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 9:
                        ItemStack itemStack11 = new ItemStack(Items.NETHER_WART, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack11);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 10:
                        ItemStack itemStack12 = new ItemStack(Items.LEATHER, k);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack12);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 11:
                        ItemStack itemStack13 = new ItemStack(Items.NAUTILUS_SHELL);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack13);
                        barterTimer = 4800; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 12:
                        ItemStack itemStack14 = new ItemStack(Items.ENDER_PEARL, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack14);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 13:
                        ItemStack itemStack15 = new ItemStack(Items.IRON_INGOT, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack15);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 14:
                        ItemStack itemStack16 = new ItemStack(Items.ARROW, k);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack16);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 15:
                        ItemStack itemStack17 = new ItemStack(Items.QUARTZ, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack17);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 16:
                        ItemStack itemStack18 = new ItemStack(Items.LAPIS_LAZULI, j);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack18);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 17:
                        ItemStack itemStack19 = new ItemStack(Items.STRING, k);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack19);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 18:
                        ItemStack itemStack20 = new ItemStack(Items.GOLDEN_CHESTPLATE);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack20);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 19:
                        ItemStack itemStack21 = new ItemStack(BWObjects.DRAGONS_BLOOD_SAPLING);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack21);
                        barterTimer = 2400; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 20:
                        ItemStack itemStack22 = new ItemStack(BWObjects.DRAGONS_BLOOD_RESIN, l);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack22);
                        barterTimer = 1200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 21:
                        ItemStack itemStack23 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack23);
                        barterTimer = 7200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 22:
                        ItemStack itemStack24 = new ItemStack(Items.LODESTONE, 1);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack24);
                        barterTimer = 7200; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 23:
                        ItemStack itemStack25 = new ItemStack(BWObjects.MANDRAKE_ROOT, i);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack25);
                        barterTimer = 600; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                    case 24:
                        ItemStack itemStack26 = new ItemStack(BWObjects.ACONITE, i);
                        itemStack.decrement(1);
                        player.getInventory().insertStack(itemStack26);
                        barterTimer = 600; //Timer exists to avoid cheese
                        player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.NEUTRAL, 1, 1);
                        ActionResult.success(this.world.isClient);
                        break;
                }
            } else {
                return super.interactMob(player, hand);
            }
            ActionResult actionResult = this.interactWithSpawnEgg(player, hand);
            if (actionResult.isAccepted()) {
                return actionResult;
            }
            return super.interactMob(player, hand);
        }
        return super.interactMob(player, hand);
    }


    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(BWPObjects.CAMBION_SPAWN_EGG.asItem());
    }


    @Override
    public boolean tryAttack(Entity target) {
        ItemStack hand = this.getMainHandStack();
        hand.damage(1, this, (entity) -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return super.tryAttack(target);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityTag) {
        if (!this.isBaby()) {
            this.initEquipment(world.getRandom(), difficulty);
        }
        dataTracker.set(MALE, random.nextBoolean());
        return super.initialize(world, difficulty, spawnReason, entityData, entityTag);
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        for (EquipmentSlot equipmentslottype : EquipmentSlot.values()) {
            for (ItemStack stack : this.getItemsFromLootTable(equipmentslottype)) {
                this.equipStack(equipmentslottype, stack);
            }
        }
        this.handDropChances[EquipmentSlot.MAINHAND.getEntitySlotId()] = 100.0F;
        this.handDropChances[EquipmentSlot.OFFHAND.getEntitySlotId()] = 100.0F;
    }

    public static int slotToInventoryIndex(EquipmentSlot slot) {
        return switch (slot) {
            case CHEST -> 1;
            case LEGS -> 2;
            case FEET -> 3;
            default -> 0;
        };
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setBaby(tag.getBoolean("IsBaby"));
        dataTracker.set(MALE, tag.getBoolean("Male"));
        NbtList listnbt = tag.getList("Inventory", 10);
        for (int i = 0; i < listnbt.size(); ++i) {
            NbtCompound compoundnbt = listnbt.getCompound(i);
            int j = compoundnbt.getByte("Slot") & 255;
            this.cambionInventory.setStack(j, ItemStack.fromNbt(compoundnbt));
        }
        if (tag.contains("ArmorItems", 9)) {
            NbtList armorItems = tag.getList("ArmorItems", 10);
            for (int i = 0; i < ((MobEntityAccessor) this).armorItems().size(); ++i) {
                int index = CambionEntity.slotToInventoryIndex(MobEntity.getPreferredEquipmentSlot(ItemStack.fromNbt(armorItems.getCompound(i))));
                this.cambionInventory.setStack(index, ItemStack.fromNbt(armorItems.getCompound(i)));
            }
        }
        if (tag.contains("HandItems", 9)) {
            NbtList handItems = tag.getList("HandItems", 10);
            for (int i = 0; i < ((MobEntityAccessor) this).handItems().size(); ++i) {
                int handSlot = i == 0 ? 5 : 4;
                this.cambionInventory.setStack(handSlot, ItemStack.fromNbt(handItems.getCompound(i)));
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putBoolean("Male", dataTracker.get(MALE));
        if (this.isBaby()) {
            tag.putBoolean("IsBaby", true);
        }
        NbtList listnbt = new NbtList();
        for (int i = 0; i < this.cambionInventory.size(); ++i) {
            ItemStack itemstack = this.cambionInventory.getStack(i);
            NbtCompound compoundnbt = new NbtCompound();
            compoundnbt.putByte("Slot", (byte) i);
            itemstack.writeNbt(compoundnbt);
            listnbt.add(compoundnbt);

        }
        tag.put("Inventory", listnbt);
    }

    @Override
    public void damageArmor(DamageSource damageSource, float damage) {
        if (damage >= 0.0F) {
            damage = damage / 4.0F;
            if (damage < 1.0F) {
                damage = 1.0F;
            }
            for (int i = 0; i < this.cambionInventory.size(); ++i) {
                ItemStack itemstack = this.cambionInventory.getStack(i);
                if ((!damageSource.isFire() || !itemstack.getItem().isFireproof())
                        && itemstack.getItem() instanceof ArmorItem) {
                    int j = i;
                    itemstack.damage((int) damage, this, (p_214023_1_) -> {
                        p_214023_1_.sendEquipmentBreakStatus(EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, j));
                    });
                }
            }
        }
    }


    @Override
    public void setBaby(boolean baby) {
        this.getDataTracker().set(BABY, baby);
        if (this.world != null && !this.world.isClient) {
            EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            entityAttributeInstance.removeModifier(BABY_SPEED_BONUS);
            if (baby) {
                entityAttributeInstance.addTemporaryModifier(BABY_SPEED_BONUS);
            }
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        int i = this.age;
        this.age = age;
        if (i < 0 && age >= 0 || i >= 0 && age < 0) {
            this.dataTracker.set(BABY, age < 0);
            this.onGrowUp();
        }
    }

    protected void onGrowUp() {
        this.setBaby(false);
    }

    @Override
    public void tickMovement() {
        this.tickHandSwing();
        super.tickMovement();
        if (this.isAlive()) {
            int i = this.getAge();
            if (i < 0) {
                this.setAge(++i);
            } else if (i > 0) {
                this.setAge(--i);
            }
        }
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (BABY.equals(data)) {
            this.calculateDimensions();
        }
        super.onTrackedDataSet(data);
    }

    private ActionResult interactWithSpawnEgg(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() instanceof SpawnEggItem spawnEggItem) {
            if (this.world instanceof ServerWorld serverWorld) {
                spawnEggItem.spawnBaby(player, this, BWPEntityTypes.CAMBION, serverWorld, this.getPos(), itemStack);
                return ActionResult.SUCCESS;
            }
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        this.cambionInventory.clearToList().forEach(this::dropStack);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(MALE, true);
        dataTracker.startTracking(BABY, false);
    }

    public List<ItemStack> getItemsFromLootTable(EquipmentSlot slot) {
        if (EQUIPMENT_SLOT_ITEMS.containsKey(slot)) {
            LootTable loot = this.world.getServer().getLootManager().getTable(EQUIPMENT_SLOT_ITEMS.get(slot));
            LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld) this.world)).parameter(LootContextParameters.THIS_ENTITY, this).random(this.getRandom());
            return loot.generateLoot(lootcontext$builder.build(BWPLootTables.SLOT));
        }
        return null;
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new MeleeAttackGoal(this, 1, true));
        goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8));
        goalSelector.add(3, new LookAroundGoal(this));
        targetSelector.add(0, new RevengeGoal(this));
        targetSelector.add(3, new ActiveTargetGoal<>(this, MobEntity.class, 5, false, false, (livingEntity) -> livingEntity instanceof Monster && !(livingEntity instanceof CambionEntity) && !(livingEntity instanceof LeonardEntity)));
    }

    @Override
    public boolean canPickupItem(ItemStack stack) {
        return super.canPickupItem(stack);
    }


    @Override
    protected boolean shouldDropLoot() {
        return super.shouldDropLoot();
    }

    @Override
    public int getVariants() {
        return 3;
    }

    @Override
    public void onInventoryChanged(Inventory sender) {

    }

    @Override
    public SimpleInventory getInventory() {
        return cambionInventory;
    }

    @Override
    public boolean isBaby() {
        return this.getDataTracker().get(BABY);
    }


}
