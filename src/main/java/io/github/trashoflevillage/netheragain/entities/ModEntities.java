package io.github.trashoflevillage.netheragain.entities;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.entities.custom.NetherMoleEntity;
import io.github.trashoflevillage.trashlib.initializers.EntityInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;

public class ModEntities {
    private static final EntityInitializer initializer = new EntityInitializer(NetherAgain.MOD_ID);

    public static final RegistryKey<EntityType<?>> NETHER_MOLE_KEY = initializer.registerKey(
            "nether_mole"
    );

    public static final EntityType<NetherMoleEntity> NETHER_MOLE = initializer.register(
            "nether_mole",
            NETHER_MOLE_KEY,
            EntityType.Builder.create(SpawnGroup.MONSTER)
    );

    public static void registerAll() {}
}
