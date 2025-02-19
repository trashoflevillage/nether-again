package io.github.trashoflevillage.netheragain.blocks;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.custom.BoomshroomBlock;
import io.github.trashoflevillage.trashlib.blocks.BlockInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ModBlocks {
    private static final BlockInitializer initializer = new BlockInitializer(NetherAgain.MOD_ID);

    public static Block BOOMSHROOM = initializer.registerBlock(
            "boomshroom",
            BoomshroomBlock::new,
            AbstractBlock.Settings.copy(Blocks.CRIMSON_FUNGUS)
    );

    public static Block OBSIDIAN_BRICKS = initializer.registerBlock(
            "obsidian_bricks",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
    );

    public static Block PRISMITE_BLOCK = initializer.registerBlock(
            "prismite_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.BLUE_ICE).slipperiness(0.6f)
    );

    public static void register() {

    }
}
