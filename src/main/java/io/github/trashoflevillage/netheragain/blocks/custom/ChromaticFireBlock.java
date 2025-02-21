package io.github.trashoflevillage.netheragain.blocks.custom;

import com.mojang.serialization.MapCodec;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.util.ModTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.tick.TickPriority;
import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class ChromaticFireBlock extends AbstractFireBlock {
    public static final MapCodec<ChromaticFireBlock> CODEC = createCodec(ChromaticFireBlock::new);

    public ChromaticFireBlock(Settings settings) {
        super(settings, 1.0F);
    }

    @Override
    public MapCodec<ChromaticFireBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isChromaticBase(world.getBlockState(pos.down()));
    }

    public static boolean isChromaticBase(BlockState state) {
        return state.isIn(ModTags.Blocks.CHROMATIC_FIRE_BASE_BLOCKS);
    }
}
