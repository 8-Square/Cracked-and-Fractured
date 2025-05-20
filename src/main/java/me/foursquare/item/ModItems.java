package me.foursquare.item;

import me.foursquare.Cracked;
import me.foursquare.item.custom.FracturerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FRACTURER = registerItem("fracturer", new FracturerItem(new Item.Settings().maxDamage(250)));

    public static final Item DEEPSLATE_FRAGMENT = registerItem("deepslate_fragment", new Item(new Item.Settings()));
    public static final Item TUFF_FRAGMENT = registerItem("tuff_fragment", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cracked.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Cracked.LOGGER.info("Registering Mod Items for " + Cracked.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(FRACTURER);
        } );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(DEEPSLATE_FRAGMENT);
            entries.add(TUFF_FRAGMENT);
        } );
    }
}
