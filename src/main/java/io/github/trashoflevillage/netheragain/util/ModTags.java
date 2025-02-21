package io.github.trashoflevillage.netheragain.util;

import io.github.trashoflevillage.netheragain.NetherAgain;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OBSIDIAN_PICKAXE_MINES_FASTER = createTag("obsidian_pickaxe_mines_faster");
        public static final TagKey<Block> CHROMATIC_FIRE_BASE_BLOCKS = createTag("chromatic_fire_base_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(NetherAgain.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> OBSIDIAN_PICKAXE_REPAIRABLE =
                createTag("obsidian_pickaxe_repairable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(NetherAgain.MOD_ID, name));
        }
    }

    public static class Structures {
        private static TagKey<Structure> createTag(String name) {
            return TagKey.of(RegistryKeys.STRUCTURE, Identifier.of(NetherAgain.MOD_ID, name));
        }
    }

    public static class EntityTypes {
        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(NetherAgain.MOD_ID, name));
        }
    }
}
