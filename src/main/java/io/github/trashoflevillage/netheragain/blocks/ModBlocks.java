package io.github.trashoflevillage.netheragain.blocks;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.custom.BoomshroomBlock;
import io.github.trashoflevillage.trashlib.blocks.BlockInitializer;
import io.github.trashoflevillage.trashlib.items.ItemInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    private static final BlockInitializer initializer = new BlockInitializer(NetherAgain.MOD_ID);

    public static Block BOOMSHROOM = initializer.registerBlock(
            "boomshroom",
            BoomshroomBlock::new,
            AbstractBlock.Settings.copy(Blocks.CRIMSON_FUNGUS)
    );

    public static void register() {

    }
}
