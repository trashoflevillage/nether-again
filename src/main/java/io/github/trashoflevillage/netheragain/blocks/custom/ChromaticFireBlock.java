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
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ChromaticFireBlock extends AbstractFireBlock {
    public static final MapCodec<ChromaticFireBlock> CODEC = createCodec(ChromaticFireBlock::new);
    public static final IntProperty HUE_SHIFT = IntProperty.of("hue_shift", 0, 255);

    private static final int SCHEDULED_TICK_DELAY = 5;

    public ChromaticFireBlock(Settings settings) {
        super(settings, 1.0F);
        this.setDefaultState(this.getStateManager().getDefaultState().with(HUE_SHIFT, 0));
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockState state = super.getPlacementState(ctx).with(HUE_SHIFT, getHueShiftFromTimeOfDay(world.getTimeOfDay()));
        world.scheduleBlockTick(ctx.getBlockPos(), state.getBlock(), SCHEDULED_TICK_DELAY);
        return state;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        world.scheduleBlockTick(pos, state.getBlock(), SCHEDULED_TICK_DELAY);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        world.scheduleBlockTick(pos, state.getBlock(), SCHEDULED_TICK_DELAY);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);
        if (state.isOf(ModBlocks.CHROMATIC_FIRE)) {
            world.setBlockState(pos, state.with(HUE_SHIFT, getHueShiftFromTimeOfDay(world.getTimeOfDay())));
            world.scheduleBlockTick(pos, state.getBlock(), SCHEDULED_TICK_DELAY);
        }
    }

    private int getHueShiftFromTimeOfDay(long time) {
        return (int)((time) % 256);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HUE_SHIFT);
    }
}
