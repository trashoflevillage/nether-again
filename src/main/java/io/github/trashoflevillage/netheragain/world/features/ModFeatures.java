package io.github.trashoflevillage.netheragain.world.features;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.world.features.custom.MoleDenFeature;
import io.github.trashoflevillage.trashlib.initializers.FeatureInitializer;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

public class ModFeatures {
    private static final FeatureInitializer initializer = new FeatureInitializer(NetherAgain.MOD_ID);

    public static final Feature<SimpleBlockFeatureConfig> MOLE_DEN = initializer.register("mole_den", new MoleDenFeature(SimpleBlockFeatureConfig.CODEC));

    public static void registerAll() {}
}
