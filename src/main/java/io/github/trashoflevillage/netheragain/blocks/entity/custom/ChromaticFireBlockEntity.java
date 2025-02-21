package io.github.trashoflevillage.netheragain.blocks.entity.custom;

import io.github.trashoflevillage.netheragain.blocks.custom.ChromaticFireBlock;
import io.github.trashoflevillage.netheragain.blocks.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ChromaticFireBlockEntity extends BlockEntity {
    public ChromaticFireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHROMATIC_FIRE_BLOCK_ENTITY, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.getTimeOfDay() % 5 == 0) {
            world.setBlockState(
                    pos,
                    state.with(ChromaticFireBlock.HUE_SHIFT, getHueShiftFromTimeOfDay(world.getTimeOfDay()))
            );
        }
    }

    private int getHueShiftFromTimeOfDay(long time) {
        return (int)(((time) / 5) % 256);
    }
}
