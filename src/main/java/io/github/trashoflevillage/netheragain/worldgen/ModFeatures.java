package io.github.trashoflevillage.netheragain.worldgen;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.worldgen.features.PrismiteSpikeFeature;
import io.github.trashoflevillage.trashlib.initializers.FeatureInitializer;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    private static FeatureInitializer initializer = new FeatureInitializer(NetherAgain.MOD_ID);

    public static Feature<DefaultFeatureConfig> PRISMITE_SPIKE = initializer.register(
            "prismite_spike", new PrismiteSpikeFeature(DefaultFeatureConfig.CODEC)
    );

    public static void register() {}
}
