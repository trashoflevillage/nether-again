package io.github.trashoflevillage.netheragain.world.features;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.trashlib.initializers.PlacedFeatureInitializer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.heightprovider.HeightProviderType;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    private static final PlacedFeatureInitializer initializer = new PlacedFeatureInitializer(NetherAgain.MOD_ID);

    public static final RegistryKey<PlacedFeature> PRISMITE_SPIKE = initializer.registerKey("prismite_spike");
    public static final RegistryKey<PlacedFeature> PATCH_CHROMATIC_FIRE = initializer.registerKey("patch_chromatic_fire");

    public static void boostrap(Registerable<PlacedFeature> context) {
        System.out.println("Running ModPlacedFeatures boostrap");
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PRISMITE_SPIKE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PRISMITE_SPIKE),
                List.of(
                        CountMultilayerPlacementModifier.of(3),
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_CHROMATIC_FIRE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_CHROMATIC_FIRE),
                List.of(
                        CountPlacementModifier.of(
                                UniformIntProvider.create(0, 5)
                        ),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.of(UniformHeightProvider.create(
                                new YOffset.AboveBottom(4), new YOffset.BelowTop(4)
                        )),
                        BiomePlacementModifier.of()
                ));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
