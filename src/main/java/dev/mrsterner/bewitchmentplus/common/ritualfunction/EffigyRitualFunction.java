package dev.mrsterner.bewitchmentplus.common.ritualfunction;

import dev.mrsterner.bewitchmentplus.common.entity.EffigyEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPComponents;
import dev.mrsterner.bewitchmentplus.common.registry.BWPEntityTypes;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.item.TaglockItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;

import java.util.List;
import java.util.function.Predicate;

public class EffigyRitualFunction extends RitualFunction {
    private boolean found = false;

    public EffigyRitualFunction(ParticleType<?> startParticle, Predicate<LivingEntity> sacrifice) {
        super(startParticle, sacrifice);
    }

    @Override
    public boolean isValid(ServerWorld world, BlockPos pos, Inventory inventory) {
        ItemStack taglock = null;
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (inventory.getStack(i).getItem() instanceof TaglockItem && TaglockItem.hasTaglock(stack)) {
                taglock = stack;
                break;
            }
        }
        List<ArmorStandEntity> armorStandEntityList = world.getEntitiesByClass(ArmorStandEntity.class, (new Box(pos)).expand(16, 0.0D, 16), ArmorStandEntity::isAlive);

        return armorStandEntityList.iterator().hasNext() && taglock != null && BewitchmentAPI.getTaglockOwner(world, taglock) != null;
    }

    @Override
    public void start(ServerWorld world, BlockPos glyphPos, BlockPos effectivePos, Inventory inventory, boolean catFamiliar) {
        found = false;
        int radius = 16;
        ItemStack tagLock = null;
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (inventory.getStack(i).getItem() instanceof TaglockItem) {
                tagLock = stack;
                break;
            }
        }
        if (tagLock != null) {
            List<ArmorStandEntity> armorStandEntityList = world.getEntitiesByClass(ArmorStandEntity.class, (new Box(effectivePos)).expand(radius, 0.0D, radius), ArmorStandEntity::isAlive);
            if (armorStandEntityList.iterator().hasNext() && !found) {
                ArmorStandEntity armorStandEntity = armorStandEntityList.iterator().next();
                EffigyEntity effigyEntity = BWPEntityTypes.EFFIGY.create(world);
                if (effigyEntity != null) {
                    found = true;
                    effigyEntity.updatePositionAndAngles(armorStandEntity.getX() + 0.5, armorStandEntity.getY(), armorStandEntity.getZ() + 0.5, world.random.nextFloat() * 360, 0);
                    var ownerUUID = BewitchmentAPI.getTaglockOwner(world, tagLock);
                    if (ownerUUID instanceof PlayerEntity player) {
                        if (!BWPComponents.EFFIGY_COMPONENT.get(player).getHasEffigy()) {
                            BWPComponents.EFFIGY_COMPONENT.get(player).setEffigy(effigyEntity.getUuid());
                            BWPComponents.EFFIGY_COMPONENT.get(player).setHasEffigy(true);
                        }
                        armorStandEntity.discard();
                        world.spawnEntity(effigyEntity);
                        if (world.isClient()) {
                            effigyEntity.playSound(SoundEvents.BLOCK_ROOTS_BREAK, 3F, 1);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, effigyEntity.getX() + MathHelper.nextDouble(world.random, (-radius), radius), effigyEntity.getY() + 0.5D, effigyEntity.getZ() + MathHelper.nextDouble(world.random, (-radius), radius), 0.0D, 0.0D, 0.0D);
                        }
                    }

                }
            }
        }
        super.start(world, glyphPos, effectivePos, inventory, catFamiliar);
    }
}
