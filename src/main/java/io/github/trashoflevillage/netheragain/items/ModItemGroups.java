package io.github.trashoflevillage.netheragain.items;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup NETHER_AGAIN_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(NetherAgain.MOD_ID, "netheragain"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.netheragain"))
                    .icon(() -> new ItemStack(ModBlocks.OBSIDIAN_BRICKS))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.OBSIDIAN_PICKAXE);
                        entries.add(ModBlocks.OBSIDIAN_BRICKS);
                        entries.add(ModBlocks.PRISMITE_BLOCK);
                        entries.add(ModBlocks.CHROMARACK);
                    }))
                    .build()
    );

    public static void registerAll() {

    }

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemConvertible... items) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            for (ItemConvertible i : items)
                content.add(i);
        });
    }
}
