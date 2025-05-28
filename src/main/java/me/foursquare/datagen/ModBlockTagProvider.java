package me.foursquare.datagen;

import me.foursquare.block.ModBlocks;
import me.foursquare.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CRACKED_POLISHED_DEEPSLATE)
                .add(ModBlocks.CRACKED_POLISHED_TUFF);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CRACKED_POLISHED_TUFF)
                .add(ModBlocks.CRACKED_POLISHED_DEEPSLATE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_S_FRACTURER)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_I_FRACTURER)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_D_FRACTURER)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
