package io.github.trashoflevillage.netheragain.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BoomshroomBlock extends PlantBlock {
    public BoomshroomBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return
            floor.isIn(BlockTags.NYLIUM) ||
            floor.isOf(Blocks.MYCELIUM) ||
            floor.isOf(Blocks.SOUL_SOIL) ||
            super.canPlantOnTop(floor, world, pos);
    }
}
