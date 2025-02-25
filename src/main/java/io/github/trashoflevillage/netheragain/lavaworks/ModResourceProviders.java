package io.github.trashoflevillage.netheragain.lavaworks;

import io.github.trashoflevillage.lavaworks.LavaworksResourceProviders;
import io.github.trashoflevillage.lavaworks.lavacolorproviders.LavaworksResourceProvider;
import io.github.trashoflevillage.netheragain.NetherAgain;
import io.github.trashoflevillage.netheragain.lavaworks.resourceproviders.PrismaticResourceProvider;
import net.minecraft.util.Identifier;

public class ModResourceProviders {
    public static LavaworksResourceProvider PRISMATIC = register("prismatic", new PrismaticResourceProvider());

    public static void registerAll() {}

    private static LavaworksResourceProvider register(String name, LavaworksResourceProvider colorProvider) {
        return LavaworksResourceProviders.register(Identifier.of(NetherAgain.MOD_ID, name), colorProvider);
    }
}
