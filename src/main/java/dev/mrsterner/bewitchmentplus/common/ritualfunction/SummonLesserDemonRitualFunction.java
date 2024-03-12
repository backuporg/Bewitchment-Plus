package dev.mrsterner.bewitchmentplus.common.ritualfunction;

import dev.mrsterner.bewitchmentplus.common.entity.CambionEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPEntityTypes;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.function.Predicate;

public class SummonLesserDemonRitualFunction extends RitualFunction {
    public SummonLesserDemonRitualFunction(ParticleType<?> startParticle, Predicate<LivingEntity> sacrifice) {
        super(startParticle, sacrifice);
    }

    //Takes a sacrifice of goats or sheep.
    public String getInvalidMessage() {
        return "ritual.precondition.sacrifice";
    }

    //Valid under a full moon... hopefully.
    public boolean isValid(ServerWorld world, BlockPos pos, Inventory inventory) {
        return BewitchmentAPI.getMoonPhase(world.toServerWorld()) == 4 && world.isNight();
    }

    //TODO: CALL FROM THE SUMMONABLES TAG. I will talk with the Alex's Mobs fabric port guy about helping me a bit, since he is the only active coder I know of ATM.
    //TODO: When it does summon, it will summon three of one specific mob.
    public void start(ServerWorld world, BlockPos glyphPos, BlockPos effectivePos, Inventory inventory, boolean catFamiliar) {
        CambionEntity entity = BWPEntityTypes.CAMBION.create(world);
        if (entity != null) {
            entity.initialize(world, world.getLocalDifficulty(effectivePos), SpawnReason.EVENT, null, null);
            entity.updatePositionAndAngles((double) effectivePos.getX() + 0.5, effectivePos.getY(), (double) effectivePos.getZ() + 0.5, world.random.nextFloat() * 360.0F, 0.0F);
            world.spawnEntity(entity);
        }

        super.start(world, glyphPos, effectivePos, inventory, catFamiliar);
    }
}