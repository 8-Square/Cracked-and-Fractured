package me.foursquare.datagen;

import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STONE_FRACTURER)
                .add(ModItems.IRON_FRACTURER)
                .add(ModItems.DIAMOND_FRACTURER);


        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.STONE_FRACTURER)
                .add(ModItems.IRON_FRACTURER)
                .add(ModItems.DIAMOND_FRACTURER);


        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.STONE_FRACTURER)
                .add(ModItems.IRON_FRACTURER)
                .add(ModItems.DIAMOND_FRACTURER);

    }
}
