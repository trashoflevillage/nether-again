package io.github.trashoflevillage.netheragain.items.custom;

import io.github.trashoflevillage.netheragain.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class ObsidianPickaxeItem extends MiningToolItem {
    public ObsidianPickaxeItem(ToolMaterial material, TagKey<Block> effectiveBlocks, float attackDamage, float attackSpeed, Settings settings) {
        super(material, effectiveBlocks, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (state.isIn(ModTags.Blocks.OBSIDIAN_PICKAXE_MINES_FASTER)) return super.getMiningSpeed(stack, state) * 3;
        return super.getMiningSpeed(stack, state);
    }
}
