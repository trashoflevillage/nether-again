package io.github.trashoflevillage.netheragain;

import io.github.trashoflevillage.netheragain.datagen.ModLootTableProvider;
import io.github.trashoflevillage.netheragain.datagen.ModRecipeProvider;
import io.github.trashoflevillage.netheragain.datagen.ModWorldGenerator;
import io.github.trashoflevillage.netheragain.world.biome.ModBiomes;
import io.github.trashoflevillage.netheragain.world.features.ModConfiguredFeatures;
import io.github.trashoflevillage.netheragain.world.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class NetherAgainDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		System.out.println("Running buildRegistry");
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
	}
}
