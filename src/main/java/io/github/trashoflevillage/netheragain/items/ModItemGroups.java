package io.github.trashoflevillage.netheragain.items;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.trashlib.initializers.ItemGroupInitializer;
import io.github.trashoflevillage.trashlib.initializers.ItemInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    private static final ItemGroupInitializer initializer = new ItemGroupInitializer(NetherAgain.MOD_ID);

    public static final ItemGroup NETHER_AGAIN_GROUP = initializer.register(
            "netheragain", "itemgroup.netheragain",
            ModBlocks.OBSIDIAN_BRICKS,
            ModItems.getRegisteredItems(),
            ModBlocks.getRegisteredItems()
    );

    public static void registerAll() {

    }
}
