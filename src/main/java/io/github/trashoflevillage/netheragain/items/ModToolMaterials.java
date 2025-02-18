package io.github.trashoflevillage.netheragain.items;

import io.github.trashoflevillage.netheragain.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;


public class ModToolMaterials {
    public static final ToolMaterial OBSIDIAN_PICKAXE =
            new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 4000, 8.0F, 3.0F, 10, ModTags.Items.OBSIDIAN_PICKAXE_REPAIRABLE);
}

