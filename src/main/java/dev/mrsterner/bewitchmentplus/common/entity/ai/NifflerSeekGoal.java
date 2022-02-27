package dev.mrsterner.bewitchmentplus.common.entity.ai;

import dev.mrsterner.bewitchmentplus.common.entity.NifflerEntity;
import dev.mrsterner.bewitchmentplus.common.registry.BWPTags;
import dev.mrsterner.bewitchmentplus.common.utils.RandomPermuteIterator;
import net.minecraft.block.*;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NifflerSeekGoal extends Goal {
    public final NifflerEntity niffler;
    List<BlockPos> blockList = new ArrayList<>();
    boolean shouldContinue = true;
    int niffleCooldown = -200;

    public NifflerSeekGoal(NifflerEntity niffler) {
        this.niffler = niffler;
    }

    @Override
    public void tick() {
        if(niffleCooldown < 0){
            niffleCooldown++;
        }
        super.tick();
    }


    @Override
    public boolean shouldContinue() {
        return super.shouldContinue() && niffleCooldown == 0;
    }

    @Override
    public void start() {
        super.start();
        try {
            RandomPermuteIterator randomPermuteIterator = new RandomPermuteIterator(blockList.size());
            while (randomPermuteIterator.hasMoreElements()){
                BlockPos chestPos = blockList.get(randomPermuteIterator.nextElement());
                Inventory inventory = getInventoryAt(niffler.world, chestPos.getX(), chestPos.getY(), chestPos.getZ());
                List<Pair<ItemStack, Integer>> itemStacks = new ArrayList<>();
                if(niffler.world.getBlockEntity(chestPos) instanceof ChestBlockEntity){
                    niffler.world.addSyncedBlockEvent(chestPos, niffler.world.getBlockState(chestPos).getBlock(), 1, 1);
                }
                for(int i = 0; i < inventory.size(); i++){
                    if(BWPTags.NIFFLER.contains(inventory.getStack(i).getItem())){
                        itemStacks.add(new Pair<>(inventory.getStack(i), i));
                    }
                }
                if(itemStacks.size()>0){
                    try{
                        RandomPermuteIterator pickItemAtRandom = new RandomPermuteIterator(itemStacks.size());

                        int k = pickItemAtRandom.nextElement();
                        System.out.println("RandomSelect: "+k);
                        ItemStack itemStack = itemStacks.get(k).getLeft();
                        if(niffler.nifflerInventory.canInsert(itemStack)){
                            for(int i = 0; i < niffler.nifflerInventory.size(); i++){
                                if(niffler.nifflerInventory.getStack(i).getItem().equals(itemStack.getItem())){
                                    niffler.nifflerInventory.getStack(i).increment(1);
                                    inventory.getStack(itemStacks.get(pickItemAtRandom.nextElement()).getRight()).decrement(1);
                                    this.niffleCooldown = -200;
                                    break;
                                }else if(niffler.nifflerInventory.getStack(i).getItem().equals(Items.AIR)){
                                    niffler.nifflerInventory.setStack(i, itemStack.split(1));
                                    this.niffleCooldown = -200;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean canStart() {
        int rangeCheck = 8;
        int yRangeCheck = 4;
        BlockPos blockPos = niffler.getBlockPos();
        for(double x = -rangeCheck; x <= rangeCheck; ++x) {
            for (double y = -yRangeCheck; y <= yRangeCheck; ++y) {
                for (double z = -rangeCheck; z <= rangeCheck; ++z) {
                    BlockPos lootPos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    if(niffler.world.getBlockEntity(lootPos) instanceof ChestBlockEntity chestBlockEntity){
                        blockList.add(chestBlockEntity.getPos());
                    }
                }
            }
        }
        return !blockList.isEmpty();
    }

    @Nullable
    private static Inventory getInventoryAt(World world, double x, double y, double z) {
        Object blockEntity;
        Inventory inventory = null;
        BlockPos blockPos = new BlockPos(x, y, z);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (block instanceof InventoryProvider) {
            inventory = ((InventoryProvider)(block)).getInventory(blockState, world, blockPos);
        } else if (blockState.hasBlockEntity() && (blockEntity = world.getBlockEntity(blockPos)) instanceof Inventory && (inventory = (Inventory)blockEntity) instanceof ChestBlockEntity && block instanceof ChestBlock) {
            inventory = ChestBlock.getInventory((ChestBlock)block, blockState, world, blockPos, true);
        }
        return inventory;
    }
}
