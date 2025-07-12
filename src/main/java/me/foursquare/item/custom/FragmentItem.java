package me.foursquare.item.custom;


import me.foursquare.Cracked;
import me.foursquare.block.ModBlocks;
import me.foursquare.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.Logger;

import java.util.Map;

public class FragmentItem extends Item {

    private final Map<Block, Block> DEEPSLATE_FRAGMENTED = Map.of(
            ModBlocks.CRACKED_POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE,
            Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICKS,
            Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILES
    );

    private final Map<Block, Block> TUFF_FRAGMENTED = Map.of(
            ModBlocks.CRACKED_POLISHED_TUFF, Blocks.POLISHED_TUFF
    );

    private final Map<Block, Block> BRICK_FRAGMENTED = Map.of(
            ModBlocks.CRACKED_BRICKS, Blocks.BRICKS
    );


    public FragmentItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (!world.isClient()) {

            // TUFF FRAGMENT
            if (getDefaultStack().isOf(ModItems.TUFF_FRAGMENT)) {
                if (TUFF_FRAGMENTED.containsKey(clickedBlock)) {
                    world.setBlockState(pos, TUFF_FRAGMENTED.get(clickedBlock).getDefaultState());
                    world.playSound(null, pos, SoundEvents.ITEM_WOLF_ARMOR_REPAIR, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_TUFF_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_POLISHED_TUFF_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_TUFF_STEP, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_TUFF_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_TUFF_STEP, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_NETHER_GOLD_ORE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    context.getStack().decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            // DEEPSLATE FRAGMENT
            else if (getDefaultStack().isOf(ModItems.DEEPSLATE_FRAGMENT)) {
                if (DEEPSLATE_FRAGMENTED.containsKey(clickedBlock)) {
                    world.setBlockState(pos, DEEPSLATE_FRAGMENTED.get(clickedBlock).getDefaultState());
                    world.playSoundFromEntity(context.getPlayer(), SoundEvents.BLOCK_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_NETHER_GOLD_ORE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_DEEPSLATE_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_POLISHED_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    context.getStack().decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            //BRICK FRAGMENT
            else if (getDefaultStack().isOf(ModItems.BRICK_FRAGMENT)) {
                if (BRICK_FRAGMENTED.containsKey(clickedBlock)) {
                    world.setBlockState(pos, BRICK_FRAGMENTED.get(clickedBlock).getDefaultState());
                    world.playSound(null, pos, SoundEvents.BLOCK_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_BASALT_STEP, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_BASALT_STEP, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_DEEPSLATE_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);

                    context.getStack().decrement(1);
                }
                return ActionResult.SUCCESS;
            }
        }
        return super.useOnBlock(context);
    }
}



//    @Override
//    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
//
//        if (!player.isSpectator() && player.isHolding(ModItems.DEEPSLATE_FRAGMENT) && player.isUsingItem()) {
//            Cracked.LOGGER.info("USING ITEM SUCCESSFULLY");
//            return ActionResult.SUCCESS;
//        }
//        return ActionResult.SUCCESS;
//    }
//}