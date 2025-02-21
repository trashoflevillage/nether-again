package io.github.trashoflevillage.netheragain.client;

import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.blocks.custom.ChromaticFireBlock;
import io.github.trashoflevillage.netheragain.util.VoronoiGenerator;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.awt.*;

public class NetherAgainClient implements ClientModInitializer {
    private static final Block[] blocksWithTransparency = new Block[] {
            ModBlocks.CHROMATIC_FIRE
    };

    @Override
    public void onInitializeClient() {
        for (Block i : blocksWithTransparency)
            BlockRenderLayerMap.INSTANCE.putBlock(i, RenderLayer.getCutout());
        registerBlockColors();
    }

    private static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) ->
                {
                    if (pos != null) {
                        float saturation = 1;
                        long seed = 10000L;

                        if (state.isOf(ModBlocks.CHROMARACK)) {
                            saturation = 1f;
                            seed = 5000L;
                        }

                        int cellSize = 15;
                        VoronoiGenerator voronoi = new VoronoiGenerator(seed, (short)1);
                        float noise = (float)voronoi.noise(
                                (double) pos.getX() / cellSize,
                                (double) pos.getY() / cellSize,
                                (double) pos.getZ() / cellSize,
                                0.2);
                        return Color.HSBtoRGB(((noise + 1) / 2), saturation, 1);
                    }
                    return -1;
                },
                ModBlocks.PRISMITE_BLOCK
        );

        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) ->
                {
                    if (pos != null) {
                        int cellSize = 100;
                        return Color.HSBtoRGB((
                                        (((float)pos.getX() / cellSize) +
                                        ((float)pos.getY() / cellSize) +
                                        ((float)pos.getZ() / cellSize))),
                                0.7f, 1);
                    }
                    return -1;
                },
                ModBlocks.CHROMARACK
        );

        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) ->
                {
                    if (pos != null && MinecraftClient.getInstance().player != null) {
                        return Color.HSBtoRGB(((float)(MinecraftClient.getInstance().player.age % 255) / 255),
                                1, 1);
                    }
                    return -1;
                },
                ModBlocks.CHROMATIC_FIRE
        );
    }
}
