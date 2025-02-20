package io.github.trashoflevillage.netheragain.world.biome;

import io.github.trashoflevillage.netheragain.NetherAgain;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModNetherRegion(Identifier.of(NetherAgain.MOD_ID, "nether"), RegionType.NETHER, 2));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, NetherAgain.MOD_ID,
                MaterialRules.block(Blocks.NETHERRACK.getDefaultState()));
    }
}
