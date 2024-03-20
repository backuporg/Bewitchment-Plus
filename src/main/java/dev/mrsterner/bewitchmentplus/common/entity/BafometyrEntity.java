package dev.mrsterner.bewitchmentplus.common.entity;

import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BafometyrEntity extends BWHostileEntity {

    public BafometyrEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public EntityGroup getGroup() {
        return BewitchmentAPI.DEMON;
    }

    protected boolean hasShiny() {
        return true;
    }

    @Override
    public int getVariants() {
        return 0;
    }

    @Override
    public boolean canUsePortals() {
        return true;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new MeleeAttackGoal(this, 1, true));
        goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8));
        goalSelector.add(3, new LookAroundGoal(this));
        targetSelector.add(0, new RevengeGoal(this));
        targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, false, entity -> entity instanceof PlayerEntity || entity instanceof VillagerEntity || entity instanceof RaiderEntity || entity instanceof CambionEntity || entity.getGroup() == EntityGroup.ILLAGER));
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        boolean flag = super.canSpawn(world, spawnReason);
        if (flag && (spawnReason == SpawnReason.SPAWNER || spawnReason == SpawnReason.STRUCTURE || spawnReason == SpawnReason.MOB_SUMMONED || spawnReason == SpawnReason.SPAWN_EGG || spawnReason == SpawnReason.COMMAND || spawnReason == SpawnReason.DISPENSER || spawnReason == SpawnReason.NATURAL)) {
            return true;
        }
        if (world instanceof ServerWorld && BewitchmentPlus.config.bafometyrStructureSpawn) {
            BlockPos nearestFortress = ((ServerWorld) world).locateStructure(StructureFeature.FORTRESS, getBlockPos(), 3, false);
            return (nearestFortress != null && Math.sqrt(nearestFortress.getSquaredDistance(getBlockPos())) < 128);
        }
        return false;
    }

}
