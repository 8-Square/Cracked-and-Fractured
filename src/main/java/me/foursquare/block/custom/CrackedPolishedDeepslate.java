package me.foursquare.block.custom;

import me.foursquare.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CrackedPolishedDeepslate extends Block {
    public CrackedPolishedDeepslate(Settings settings) {
        super(settings);
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(ModItems.DEEPSLATE_FRAGMENT)) {
            world.setBlockState(pos, Blocks.POLISHED_DEEPSLATE.getDefaultState());
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            stack.decrementUnlessCreative(1, player);
            world.playSound(player, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.ITEM_WOLF_ARMOR_REPAIR, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_DEEPSLATE_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_POLISHED_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_DEEPSLATE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            return ItemActionResult.SUCCESS;
        }
        else {
            return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }
}
