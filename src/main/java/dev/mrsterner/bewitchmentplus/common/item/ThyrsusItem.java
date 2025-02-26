package dev.mrsterner.bewitchmentplus.common.item;

import moriyashiine.bewitchment.api.BewitchmentAPI;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;

public class ThyrsusItem extends SwordItem {

    public ThyrsusItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        Random random = new Random();
        if (user instanceof MagicAccessor) {
            if (stack.getDamage() > 0) {
                if (entity instanceof AnimalEntity animalEntity) {
                    if (animalEntity.isAlive() && !animalEntity.isInLove()) {
                        animalEntity.setLoveTicks(5000);
                        stack.damage(6, random, null);
                        user.playSound(SoundEvents.BLOCK_BAMBOO_HIT, 1, 1);
                        BewitchmentAPI.drainMagic(user, 2, false);
                    }
                    if (entity instanceof TameableEntity tameableEntity) {
                        if (!tameableEntity.isTamed()) {
                            tameableEntity.setOwnerUuid(user.getUuid());
                            tameableEntity.setTamed(true);
                            stack.damage(12, random, null);
                            user.playSound(SoundEvents.BLOCK_BAMBOO_HIT, 1, 1);
                            BewitchmentAPI.drainMagic(user, 4, false);
                        }
                    }
                    if (entity instanceof HorseBaseEntity horseBaseEntity) {
                        if (!horseBaseEntity.isTame()) {
                            horseBaseEntity.setOwnerUuid(user.getUuid());
                            horseBaseEntity.setTame(true);
                            stack.damage(12, random, null);
                            user.playSound(SoundEvents.BLOCK_BAMBOO_HIT, 1, 1);
                            BewitchmentAPI.drainMagic(user, 4, false);
                        }
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}