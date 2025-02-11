package io.github.trashoflevillage.netheragain.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class NetherAgainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        FluidRenderHandlerRegistry.INSTANCE.register(Fluids.LAVA, new FluidRenderHandler() {
//            @Override
//            public Sprite[] getFluidSprites(@Nullable BlockRenderView blockRenderView, @Nullable BlockPos blockPos, FluidState fluidState) {
//                return Objects.requireNonNull(FluidRenderHandlerRegistry.INSTANCE.get(Fluids.LAVA)).getFluidSprites(blockRenderView, blockPos, fluidState);
//            }
//
//            @Override
//            public int getFluidColor(@Nullable BlockRenderView view, @Nullable BlockPos pos, FluidState state) {
//                return 0x00FF00;
//            }
//        });
    }
}
