package me.foursquare.util;

import me.foursquare.Cracked;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> BRICK_BLOCKS = createTag("brick_blocks");
        public static final TagKey<Block> DEEPSLATE_BLOCKS = createTag("deepslate_blocks");
        public static final TagKey<Block> TUFF_BLOCKS = createTag("tuff_blocks");



        public static final TagKey<Block> NEEDS_S_FRACTURER = createTag("needs_s_fracturer");
        public static final TagKey<Block> INCORRECT_FOR_S_FRACTURER = createTag("incorrect_for_s_fracturer");

        public static final TagKey<Block> NEEDS_I_FRACTURER = createTag("needs_i_fracturer");
        public static final TagKey<Block> INCORRECT_FOR_I_FRACTURER = createTag("incorrect_for_i_fracturer");

        public static final TagKey<Block> NEEDS_D_FRACTURER = createTag("needs_d_fracturer");
        public static final TagKey<Block> INCORRECT_FOR_D_FRACTURER = createTag("incorrect_for_d_fracturer");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Cracked.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FRACTURED_ITEMS = createTag("fractured_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Cracked.MOD_ID, name));
        }
    }
}