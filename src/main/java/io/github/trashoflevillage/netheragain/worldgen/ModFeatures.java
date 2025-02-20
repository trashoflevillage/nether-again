package io.github.trashoflevillage.netheragain.worldgen;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.worldgen.features.CrystalSpikeFeature;
import io.github.trashoflevillage.trashlib.initializers.FeatureInitializer;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

public class ModFeatures {
    private static final FeatureInitializer initializer = new FeatureInitializer(NetherAgain.MOD_ID);

    public static final Feature<SimpleBlockFeatureConfig> CRYSTAL_SPIKE = initializer.register(
            "crystal_spike", new CrystalSpikeFeature(SimpleBlockFeatureConfig.CODEC)
    );

    public static void register() {}
}
