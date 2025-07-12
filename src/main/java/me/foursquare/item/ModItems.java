package me.foursquare.item;

import me.foursquare.Cracked;
import me.foursquare.block.ModBlocks;
import me.foursquare.item.custom.FracturerItem;
import me.foursquare.item.custom.FragmentItem;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

import javax.tools.Tool;

public class ModItems {
    public static final Item STONE_FRACTURER = registerItem("stone_fracturer", new FracturerItem(ModToolMaterials.S_FRACTURER,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.S_FRACTURER, 2.0f, -2.4f))));
    public static final Item IRON_FRACTURER = registerItem("iron_fracturer", new FracturerItem(ModToolMaterials.I_FRACTURER,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers
                    (ModToolMaterials.I_FRACTURER, 2.0f, -2.4f))));
    public static final Item DIAMOND_FRACTURER = registerItem("diamond_fracturer", new FracturerItem(ModToolMaterials.D_FRACTURER,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.D_FRACTURER, 2.0f, -2.4f))));

        public static final Item DEEPSLATE_FRAGMENT = registerItem("deepslate_fragment",
                new FragmentItem(new Item.Settings()));
        public static final Item TUFF_FRAGMENT = registerItem("tuff_fragment",
            new FragmentItem(new Item.Settings()));
    public static final Item BRICK_FRAGMENT = registerItem("brick_fragment",
            new FragmentItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cracked.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Cracked.LOGGER.info("Registering Mod Items for " + Cracked.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(STONE_FRACTURER);
            entries.add(IRON_FRACTURER);
            entries.add(DIAMOND_FRACTURER);
        } );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(DEEPSLATE_FRAGMENT);
            entries.add(TUFF_FRAGMENT);
            entries.add(BRICK_FRAGMENT);
        } );
    }
}
