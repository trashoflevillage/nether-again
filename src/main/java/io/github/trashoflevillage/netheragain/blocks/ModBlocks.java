package io.github.trashoflevillage.netheragain.blocks;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.custom.BoomshroomBlock;
import io.github.trashoflevillage.netheragain.blocks.custom.ChromaticFireBlock;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class ModBlocks {
    public static final BlockInitializer initializer = new BlockInitializer(NetherAgain.MOD_ID);

    public static Block OBSIDIAN_BRICKS = initializer.register(
            "obsidian_bricks",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
    );

    public static Block OBSIDIAN_BRICK_STAIRS = initializer.register(
            "obsidian_brick_stairs",
            (p) -> new StairsBlock(ModBlocks.OBSIDIAN_BRICKS.getDefaultState(), p),
            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
    );

    public static Block OBSIDIAN_BRICK_SLAB = initializer.register(
            "obsidian_brick_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
    );

    public static Block PRISMITE_BLOCK = initializer.register(
            "prismite_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.BLUE_ICE).requiresTool().slipperiness(0.6f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
    );

    public static Block CHROMARACK = initializer.register(
            "chromarack",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.NETHERRACK)
    );

    public static Block CHROMATIC_FIRE = initializer.register(
            "chromatic_fire",
            ChromaticFireBlock::new,
            AbstractBlock.Settings.copy(Blocks.FIRE).ticksRandomly(),
            false
    );

    public static void registerAll() {

    }

    public static ArrayList<ItemConvertible> getRegisteredItems() {
        return initializer.getRegisteredItems();
    }
}
