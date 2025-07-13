package me.foursquare.item.custom;

import me.foursquare.block.ModBlocks;
import me.foursquare.util.ModTags;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class FracturerItem extends MiningToolItem {
    public static final Map<Block, Block> FRACTURER_MAP =
            Map.of(
                    Blocks.POLISHED_DEEPSLATE, ModBlocks.CRACKED_POLISHED_DEEPSLATE,
                    Blocks.POLISHED_TUFF, ModBlocks.CRACKED_POLISHED_TUFF,
                    Blocks.BRICKS, ModBlocks.CRACKED_BRICKS,
                    Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                    Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS
                    );
    public FracturerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE , settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(FRACTURER_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), FRACTURER_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                // BRICK BLOCKS CRACKING
                if (clickedBlock.getDefaultState().isIn(ModTags.Blocks.BRICK_BLOCKS)) {
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_TUFF_BRICKS_BREAK, SoundCategory.BLOCKS, 1f, 2f);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_MUD_BRICKS_FALL , SoundCategory.BLOCKS);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_NETHER_BRICKS_BREAK , SoundCategory.BLOCKS);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_DEEPSLATE_TILES_BREAK , SoundCategory.BLOCKS);
                }
                // DEEPSLATE BLOCKS CRACKING
                else if (clickedBlock.getDefaultState().isIn(ModTags.Blocks.DEEPSLATE_BLOCKS)) {
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_DEEPSLATE_BREAK,
                            SoundCategory.BLOCKS);
                }
                // TUFF BLOCKS CRACKING
                else if (clickedBlock.getDefaultState().isIn(ModTags.Blocks.TUFF_BLOCKS)) {
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_TUFF_BRICKS_BREAK, SoundCategory.BLOCKS);

                }
                // ANYTHING ELSE
                else {
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_NETHER_BRICKS_BREAK, SoundCategory.BLOCKS);
                }

            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        if (enchantment.equals(Enchantments.SILK_TOUCH)) {
            return false;
        }
        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
