package me.foursquare.block.custom;

import me.foursquare.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public class CrackedPolishedTuff extends Block {
    public CrackedPolishedTuff(Settings settings) { super(settings);}

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(ModItems.TUFF_FRAGMENT)) {
            world.setBlockState(pos, Blocks.POLISHED_TUFF.getDefaultState());
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            stack.decrementUnlessCreative(1, player);
            world.playSound(player, pos, SoundEvents.ITEM_WOLF_ARMOR_REPAIR, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_TUFF_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_POLISHED_TUFF_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_POLISHED_TUFF_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_STONE_STEP, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_TUFF_STEP, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_TUFF_STEP, SoundCategory.BLOCKS, 1f, 1f);
            return ItemActionResult.SUCCESS;
        }
        else {
            return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }
}
