package io.github.trashoflevillage.netheragain.world.features;

import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.trashlib.initializers.ConfiguredFeatureInitializer;
import io.github.trashoflevillage.trashlib.worldgen.features.TrashlibFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import static net.minecraft.world.gen.feature.ConfiguredFeatures.createRandomPatchFeatureConfig;

public class ModConfiguredFeatures {
    private static final ConfiguredFeatureInitializer initializer = new ConfiguredFeatureInitializer(NetherAgain.MOD_ID);

    public static final RegistryKey<ConfiguredFeature<?, ?>> PRISMITE_SPIKE = initializer.registerKey("prismite_spike");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        System.out.println("Running ModConfiguredFeatures boostrap");
        register(
                context,
                PRISMITE_SPIKE,
                TrashlibFeatures.CRYSTAL_SPIKE,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PRISMITE_BLOCK))
        );
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
