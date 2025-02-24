package io.github.trashoflevillage.netheragain.blocks.entity;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.blocks.entity.custom.ChromaticFireBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ChromaticFireBlockEntity> CHROMATIC_FIRE_BLOCK_ENTITY =
            register("chromatic_fire", ChromaticFireBlockEntity::new, ModBlocks.CHROMATIC_FIRE);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = Identifier.of(NetherAgain.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerAll() {

    }
}
