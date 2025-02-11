package io.github.trashoflevillage.netheragain.mixin;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.impl.client.rendering.fluid.FluidRenderHandlerRegistryImpl;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.ColorResolver;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(targets = "net/fabricmc/fabric/impl/client/rendering/fluid/FluidRenderHandlerRegistryImpl$LavaRenderHandler")
public class LavaRenderHandlerMixin implements FluidRenderHandler {
    @Shadow
    private Sprite[] sprites;

    @Shadow
    public Sprite[] getFluidSprites(@Nullable BlockRenderView view, @Nullable BlockPos pos, FluidState state) {
        return sprites;
    }

    @Override
    public int getFluidColor(@Nullable BlockRenderView view, @Nullable BlockPos pos, FluidState state) {
        if (pos == null) return -1;
        int color = 0;
        color += getLavaColor(view, pos);
        color += getLavaColor(view, pos.add(1, 0, 0));
        color += getLavaColor(view, pos.add(-1, 0, 0));
        color += getLavaColor(view, pos.add(0, 0, 1));
        color += getLavaColor(view, pos.add(0, 0, -1));
        return color / 5;
    }

    @Unique
    private static int getLavaColor(@Nullable BlockRenderView view, @Nullable BlockPos pos) {
        if (view.getBiomeFabric(pos).matchesKey(BiomeKeys.SOUL_SAND_VALLEY)) return  -16751361;
        return -1;
    }
}
