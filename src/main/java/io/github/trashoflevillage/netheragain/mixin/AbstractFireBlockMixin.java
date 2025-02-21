package io.github.trashoflevillage.netheragain.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.blocks.custom.ChromaticFireBlock;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
    @ModifyReturnValue(method = "getState", at = @At("TAIL"))
    private static BlockState getState(BlockState original, BlockView world, BlockPos pos) {
        if (original.isOf(Blocks.FIRE)) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (ChromaticFireBlock.isChromaticBase(blockState)) {
                return ModBlocks.CHROMATIC_FIRE.getDefaultState();
            }
        }
        return original;
    }
}
