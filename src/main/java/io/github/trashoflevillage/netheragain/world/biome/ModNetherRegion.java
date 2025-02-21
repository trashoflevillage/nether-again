package io.github.trashoflevillage.netheragain.world.biome;

import net.minecraft.data.report.BiomeParametersProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModNetherRegion extends Region {
    public ModNetherRegion(Identifier name, int weight) {
        super(name, RegionType.NETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<com.mojang.datafixers.util.Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addBiome(mapper,
                new MultiNoiseUtil.ParameterRange(0, 0),
                new MultiNoiseUtil.ParameterRange(0, 0),
                new MultiNoiseUtil.ParameterRange(0, 0),
                new MultiNoiseUtil.ParameterRange(0, 0),
                new MultiNoiseUtil.ParameterRange(0, 0),
                new MultiNoiseUtil.ParameterRange(0, 0),
                0.0f,
                ModBiomes.PRISMITE_GORGE
        );
    }
}
