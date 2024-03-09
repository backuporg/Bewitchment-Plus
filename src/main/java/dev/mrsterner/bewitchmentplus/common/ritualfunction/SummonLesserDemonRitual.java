package dev.mrsterner.bewitchmentplus.common.ritualfunction;

import dev.mrsterner.bewitchmentplus.common.entity.CambionEntity;
import dev.mrsterner.bewitchmentplus.common.entity.DrudenEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPTags;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.entity.living.DemonEntity;
import moriyashiine.bewitchment.common.registry.BWEntityTypes;
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

import static net.minecraft.util.collection.Weighting.getRandom;

public class SummonLesserDemonRitual extends RitualFunction {
    public SummonLesserDemonRitual(ParticleType<?> startParticle, Predicate<LivingEntity> sacrifice) {
        super(startParticle, sacrifice);
    }

    public void start(ServerWorld world, BlockPos glyphPos, BlockPos effectivePos, Inventory inventory, boolean catFamiliar) {
        DemonEntity entity = (DemonEntity)BWEntityTypes.DEMON.create(world);
        if (entity != null) {
            entity.initialize(world, world.getLocalDifficulty(effectivePos), SpawnReason.EVENT, (EntityData) null, (NbtCompound) null);
            entity.updatePositionAndAngles((double) effectivePos.getX() + 0.5, (double) effectivePos.getY(), (double) effectivePos.getZ() + 0.5, world.random.nextFloat() * 360.0F, 0.0F);
            world.spawnEntity(entity);
        }

        super.start(world, glyphPos, effectivePos, inventory, catFamiliar);
    }
}