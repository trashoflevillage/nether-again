package io.github.trashoflevillage.netheragain.world.biome;

import net.minecraft.util.Identifier;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class ModNetherRegion extends Region {
    public ModNetherRegion(Identifier name, RegionType type, int weight) {
        super(name, type, weight);
    }
}
