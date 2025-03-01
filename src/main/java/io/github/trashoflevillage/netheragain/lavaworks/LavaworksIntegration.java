package io.github.trashoflevillage.netheragain.lavaworks;

import io.github.trashoflevillage.lavaworks.Lavaworks;
import io.github.trashoflevillage.lavaworks.LavaworksResourceProviders;
import io.github.trashoflevillage.lavaworks.resourceprovider.LavaworksResourceProvider;
import io.github.trashoflevillage.netheragain.NetherAgain;
import net.minecraft.util.Identifier;

public class LavaworksIntegration {
    public static void registerAll() {
        registerDefaultBiomeBehaviors();
    }

    private static LavaworksResourceProvider registerResourceProvider(String name, LavaworksResourceProvider colorProvider) {
        return LavaworksResourceProviders.register(Identifier.of(NetherAgain.MOD_ID, name), colorProvider);
    }

    private static void registerDefaultBiomeBehaviors() {
        Lavaworks.addDefaultBiomeBehavior(
                Identifier.of(NetherAgain.MOD_ID, "prismite_gorge"),
                Identifier.of("lavaworks", "splotches"),
                "colors=#FF9999;splotchSize=10;texture=netheragain:block/prismatic_lava_still;flowing_texture=netheragain:block/prismatic_lava_flow",
                ""
        );
    }
}
