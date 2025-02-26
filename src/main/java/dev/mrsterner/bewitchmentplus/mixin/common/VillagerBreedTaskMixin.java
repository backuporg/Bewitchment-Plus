package dev.mrsterner.bewitchmentplus.mixin.common;

import dev.mrsterner.bewitchmentplus.common.entity.CambionEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPEntityTypes;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.VillagerBreedTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(VillagerBreedTask.class)
public class VillagerBreedTaskMixin {
    @Inject(method = "createChild", at = @At(value = "HEAD"))
    private void cambianConseption(ServerWorld world, VillagerEntity parent, VillagerEntity partner, CallbackInfoReturnable<Optional<VillagerEntity>> cir) {
        world.getOtherEntities(parent, parent.getBoundingBox().expand(10, 10, 10)).stream().filter((living) -> {
            boolean bl = living instanceof LivingEntity livingEntity && livingEntity.getGroup() == BewitchmentAPI.DEMON;
            if (world.random.nextInt(bl ? 10 : 30) == 1) {
                CambionEntity cambionEntity = BWPEntityTypes.CAMBION.create(world);
                cambionEntity.setBaby(true);
                cambionEntity.setAge(CambionEntity.BABY_AGE);
                cambionEntity.refreshPositionAndAngles(parent.getX(), parent.getY(), parent.getZ(), 0.0f, 0.0f);
                cambionEntity.setPersistent();
                world.spawnEntity(cambionEntity);
                world.sendEntityStatus(cambionEntity, (byte) 12);
            }
            return false;
        });

    }
}
