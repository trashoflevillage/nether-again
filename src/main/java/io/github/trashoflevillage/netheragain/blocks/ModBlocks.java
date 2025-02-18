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

    public static void register() {

    }
}
