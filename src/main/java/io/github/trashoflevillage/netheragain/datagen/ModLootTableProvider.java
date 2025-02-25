package io.github.trashoflevillage.netheragain.datagen;

import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.items.ModItems;
import io.github.trashoflevillage.trashlib.datagen.TrashlibBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends TrashlibBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHROMARACK);
        addDrop(ModBlocks.OBSIDIAN_BRICKS);
        addDrop(ModBlocks.OBSIDIAN_BRICK_STAIRS);
        addSlabDrops(ModBlocks.OBSIDIAN_BRICK_SLAB);
        addOreDrops(Blocks.ANCIENT_DEBRIS, ModItems.RAW_DEBRIS);
        addOreDrops(ModBlocks.PRISMITE_BLOCK, ModItems.PRISMITE);
    }
}
