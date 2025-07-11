package me.foursquare.datagen;

import me.foursquare.block.ModBlocks;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelTagProvider extends FabricModelProvider {
    public ModModelTagProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_POLISHED_TUFF);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_POLISHED_DEEPSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_BRICKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DEEPSLATE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUFF_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRICK_FRAGMENT, Models.GENERATED);

        itemModelGenerator.register(ModItems.STONE_FRACTURER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_FRACTURER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_FRACTURER, Models.HANDHELD);

    }
}
