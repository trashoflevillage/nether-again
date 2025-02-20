package io.github.trashoflevillage.netheragain.world.biome;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.world.features.ModPlacedFeatures;
import io.github.trashoflevillage.netheragain.worldgen.features.ModFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomes {
    public static final RegistryKey<Biome> PRISMITE_GORGE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(NetherAgain.MOD_ID, "prismite_gorge"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(PRISMITE_GORGE, prismiteGorge(context));
    }

    public static Biome prismiteGorge(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.PRISMITE_SPIKE);

        return new Biome.Builder()
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .build();
    }
}
