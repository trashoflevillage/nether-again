package io.github.trashoflevillage.netheragain.datagen;

import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHROMARACK);
        addDrop(ModBlocks.OBSIDIAN_BRICKS);
        addDrop(ModBlocks.OBSIDIAN_BRICK_STAIRS);
        addSlabDrops(ModBlocks.OBSIDIAN_BRICK_SLAB);
    }

    private void addSlabDrops(Block block) {
        lootTables.put(block.getLootTableKey().orElseThrow(() -> new IllegalStateException("Block " + block + " does not have loot table")), slabDrops(ModBlocks.OBSIDIAN_BRICK_SLAB));
    }
}
