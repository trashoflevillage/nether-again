package io.github.trashoflevillage.netheragain.client;

import io.github.trashoflevillage.lavaworks.LavaWorks;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.util.VoronoiGenerator;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.gen.noise.NoiseHelper;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Objects;

public class NetherAgainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) ->
                {
                    if (pos != null) {
                        int cellSize = 15;
                        VoronoiGenerator voronoi = new VoronoiGenerator(10000L, (short)1);
                        float noise = (float)voronoi.noise(
                                (double) pos.getX() / cellSize,
                                (double) pos.getY() / cellSize,
                                (double) pos.getZ() / cellSize,
                                0.2);
                        return Color.HSBtoRGB(((noise + 1) / 2), 1, 1);
                    }
                    return -1;
                },
                ModBlocks.PRISMITE_BLOCK
        );


    }
}
