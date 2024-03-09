package dev.mrsterner.bewitchmentplus.common.ritualfunction;

import dev.mrsterner.bewitchmentplus.common.entity.CambionEntity;
import dev.mrsterner.bewitchmentplus.common.entity.DrudenEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPTags;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import java.util.function.Predicate;

public class SummonLesserDemonRitual extends RitualFunction {
    public SummonLesserDemonRitual(ParticleType<?> startParticle, Predicate<LivingEntity> sacrifice) {
        super(startParticle, sacrifice);
    }


    @Override
    public void start(ServerWorld world, BlockPos glyphPos, BlockPos effectivePos, Inventory inventory, boolean catFamiliar) {
        LivingEntity entity;
        Random rand;
        if ((entity.getType().isIn(BWPTags.LESSER_DEMON))) {
            if (entity != null) {
                entity.initialize(world, world.getLocalDifficulty(effectivePos), SpawnReason.EVENT, (EntityData)null, (NbtCompound)null);
                entity.updatePositionAndAngles(effectivePos.getX() + 0.5, effectivePos.getY(), effectivePos.getZ() + 0.5, world.random.nextFloat() * 360, 0);
                world.spawnEntity();
            }
        }
        super.start(world, glyphPos, effectivePos, inventory, catFamiliar);
    }
}
