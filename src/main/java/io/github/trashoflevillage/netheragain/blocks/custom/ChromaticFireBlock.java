package io.github.trashoflevillage.netheragain.blocks.custom;

import com.mojang.serialization.MapCodec;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.blocks.entity.ModBlockEntities;
import io.github.trashoflevillage.netheragain.blocks.entity.custom.ChromaticFireBlockEntity;
import io.github.trashoflevillage.netheragain.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
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

public class ChromaticFireBlock extends AbstractFireBlock implements BlockEntityProvider {
    public static final MapCodec<ChromaticFireBlock> CODEC = createCodec(ChromaticFireBlock::new);
    public static final IntProperty HUE_SHIFT = IntProperty.of("hue_shift", 0, 255);

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

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ChromaticFireBlockEntity(pos, state);
    }


    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (type == ModBlockEntities.CHROMATIC_FIRE_BLOCK_ENTITY)
            return (world1, pos, state1, blockEntity) -> {
                ((ChromaticFireBlockEntity)blockEntity).tick(world1, pos, state1);
            };
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HUE_SHIFT);
    }
}
