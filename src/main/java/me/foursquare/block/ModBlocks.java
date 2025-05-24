package me.foursquare.block;

import me.foursquare.Cracked;
import me.foursquare.block.custom.CrackedPolishedDeepslate;
import me.foursquare.block.custom.CrackedPolishedTuff;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CRACKED_POLISHED_TUFF = registerBlock("cracked_polished_tuff",
            new CrackedPolishedTuff(AbstractBlock.Settings.copy(Blocks.POLISHED_TUFF).hardness(1.5f).strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF)));

    public static final Block CRACKED_POLISHED_DEEPSLATE = registerBlock("cracked_polished_deepslate",
            new CrackedPolishedDeepslate(AbstractBlock.Settings.copy(Blocks.POLISHED_DEEPSLATE).hardness(3.5f)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Cracked.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Cracked.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Cracked.LOGGER.info("Registering Mod Blocks for " + Cracked.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_POLISHED_DEEPSLATE);
            entries.add(ModBlocks.CRACKED_POLISHED_TUFF);
        });
    }
}
