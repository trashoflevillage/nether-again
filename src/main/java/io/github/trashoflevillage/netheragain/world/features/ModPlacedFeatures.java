package io.github.trashoflevillage.netheragain.world.features;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.trashlib.initializers.PlacedFeatureInitializer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {
    private static final PlacedFeatureInitializer initializer = new PlacedFeatureInitializer(NetherAgain.MOD_ID);

    public static final RegistryKey<PlacedFeature> PRISMITE_SPIKE = initializer.register("prismite_spike");
}
