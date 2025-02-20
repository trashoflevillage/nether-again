package io.github.trashoflevillage.netheragain.items;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.items.custom.ObsidianPickaxeItem;
import io.github.trashoflevillage.trashlib.initializers.ItemInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.BlockTags;

public class ModItems {
    private static final ItemInitializer initializer = new ItemInitializer(NetherAgain.MOD_ID);

    public static final Item OBSIDIAN_PICKAXE = initializer.register(
            "obsidian_pickaxe",
            (s) -> new ObsidianPickaxeItem(ModToolMaterials.OBSIDIAN_PICKAXE, BlockTags.PICKAXE_MINEABLE, 1.0F, -2.8F, s)
    );

    public static void register() {}
}
