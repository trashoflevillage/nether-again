package io.github.trashoflevillage.netheragain.lavaworks.resourceproviders;

import io.github.trashoflevillage.lavaworks.lavacolorproviders.LavaworksResourceProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.BlockRenderView;

import java.util.HashMap;

public class PrismaticResourceProvider extends LavaworksResourceProvider {
    @Override
    public int getColorAtPosition(HashMap<String, String> parameters, BlockRenderView blockRenderView, BlockPos blockPos) {
        return getColorAtPosition(parameters, blockPos);
    }

    @Override
    public int getColorAtPosition(HashMap<String, String> parameters, Identifier identifier, BlockPos blockPos) {
        return getColorAtPosition(parameters, blockPos);
    }

    private int getColorAtPosition(HashMap<String, String> parameters, BlockPos blockPos) {
        return ColorHelper.getArgb(
                (int)(((Math.sin(blockPos.getX()) + 1) +
                        (Math.sin(blockPos.getY()) + 1) +
                        (Math.sin(blockPos.getZ()) + 1))/3) * 255,
                (int)(((Math.cos(blockPos.getX()) + 1) +
                        (Math.cos(blockPos.getY()) + 1) +
                        (Math.cos(blockPos.getZ()) + 1))/3) * 255,
                255
        );
    }
}
