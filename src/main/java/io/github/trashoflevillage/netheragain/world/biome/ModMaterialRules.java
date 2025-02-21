package io.github.trashoflevillage.netheragain.world.biome;

import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule AIR = block(Blocks.AIR);
    private static final MaterialRules.MaterialRule BEDROCK = block(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule WHITE_TERRACOTTA = block(Blocks.WHITE_TERRACOTTA);
    private static final MaterialRules.MaterialRule ORANGE_TERRACOTTA = block(Blocks.ORANGE_TERRACOTTA);
    private static final MaterialRules.MaterialRule TERRACOTTA = block(Blocks.TERRACOTTA);
    private static final MaterialRules.MaterialRule RED_SAND = block(Blocks.RED_SAND);
    private static final MaterialRules.MaterialRule RED_SANDSTONE = block(Blocks.RED_SANDSTONE);
    private static final MaterialRules.MaterialRule STONE = block(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = block(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule DIRT = block(Blocks.DIRT);
    private static final MaterialRules.MaterialRule PODZOL = block(Blocks.PODZOL);
    private static final MaterialRules.MaterialRule COARSE_DIRT = block(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule MYCELIUM = block(Blocks.MYCELIUM);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = block(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule CALCITE = block(Blocks.CALCITE);
    private static final MaterialRules.MaterialRule GRAVEL = block(Blocks.GRAVEL);
    private static final MaterialRules.MaterialRule SAND = block(Blocks.SAND);
    private static final MaterialRules.MaterialRule SANDSTONE = block(Blocks.SANDSTONE);
    private static final MaterialRules.MaterialRule PACKED_ICE = block(Blocks.PACKED_ICE);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = block(Blocks.SNOW_BLOCK);
    private static final MaterialRules.MaterialRule MUD = block(Blocks.MUD);
    private static final MaterialRules.MaterialRule POWDER_SNOW = block(Blocks.POWDER_SNOW);
    private static final MaterialRules.MaterialRule ICE = block(Blocks.ICE);
    private static final MaterialRules.MaterialRule WATER = block(Blocks.WATER);
    private static final MaterialRules.MaterialRule LAVA = block(Blocks.LAVA);
    private static final MaterialRules.MaterialRule NETHERRACK = block(Blocks.NETHERRACK);
    private static final MaterialRules.MaterialRule SOUL_SAND = block(Blocks.SOUL_SAND);
    private static final MaterialRules.MaterialRule SOUL_SOIL = block(Blocks.SOUL_SOIL);
    private static final MaterialRules.MaterialRule BASALT = block(Blocks.BASALT);
    private static final MaterialRules.MaterialRule BLACKSTONE = block(Blocks.BLACKSTONE);
    private static final MaterialRules.MaterialRule WARPED_WART_BLOCK = block(Blocks.WARPED_WART_BLOCK);
    private static final MaterialRules.MaterialRule WARPED_NYLIUM = block(Blocks.WARPED_NYLIUM);
    private static final MaterialRules.MaterialRule NETHER_WART_BLOCK = block(Blocks.NETHER_WART_BLOCK);
    private static final MaterialRules.MaterialRule CRIMSON_NYLIUM = block(Blocks.CRIMSON_NYLIUM);
    private static final MaterialRules.MaterialRule END_STONE = block(Blocks.END_STONE);
    private static final MaterialRules.MaterialRule CHROMARACK = block(ModBlocks.CHROMARACK);

    private static MaterialRules.MaterialRule block(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    public static MaterialRules.MaterialRule createCustomNetherSurfaceRule() {
        MaterialRules.MaterialCondition materialCondition = MaterialRules.aboveY(YOffset.fixed(31), 0);
        MaterialRules.MaterialCondition materialCondition2 = MaterialRules.aboveY(YOffset.fixed(32), 0);
        MaterialRules.MaterialCondition materialCondition3 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(30), 0);
        MaterialRules.MaterialCondition materialCondition4 = MaterialRules.not(MaterialRules.aboveYWithStoneDepth(YOffset.fixed(35), 0));
        MaterialRules.MaterialCondition materialCondition5 = MaterialRules.aboveY(YOffset.belowTop(5), 0);
        MaterialRules.MaterialCondition materialCondition6 = MaterialRules.hole();
        MaterialRules.MaterialCondition materialCondition7 = MaterialRules.noiseThreshold(NoiseParametersKeys.SOUL_SAND_LAYER, -0.012);
        MaterialRules.MaterialCondition materialCondition8 = MaterialRules.noiseThreshold(NoiseParametersKeys.GRAVEL_LAYER, -0.012);
        MaterialRules.MaterialCondition materialCondition9 = MaterialRules.noiseThreshold(NoiseParametersKeys.PATCH, -0.012);
        MaterialRules.MaterialCondition materialCondition10 = MaterialRules.noiseThreshold(NoiseParametersKeys.NETHERRACK, 0.54);
        MaterialRules.MaterialCondition materialCondition11 = MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17);
        MaterialRules.MaterialCondition materialCondition12 = MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_STATE_SELECTOR, 0.0);
        MaterialRules.MaterialRule materialRule = MaterialRules.condition(
                materialCondition9, MaterialRules.condition(materialCondition3, MaterialRules.condition(materialCondition4, GRAVEL))
        );
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK),
                MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), BEDROCK),
                MaterialRules.condition(materialCondition5, NETHERRACK),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.BASALT_DELTAS),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, BASALT),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        MaterialRules.sequence(materialRule, MaterialRules.condition(materialCondition12, BASALT), BLACKSTONE)
                                )
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.PRISMITE_GORGE),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, CHROMARACK),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        MaterialRules.sequence(materialRule, MaterialRules.condition(materialCondition12, CHROMARACK), CHROMARACK)
                                )
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.SOUL_SAND_VALLEY),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, MaterialRules.sequence(MaterialRules.condition(materialCondition12, SOUL_SAND), SOUL_SOIL)
                                ),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        MaterialRules.sequence(materialRule, MaterialRules.condition(materialCondition12, SOUL_SAND), SOUL_SOIL)
                                )
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.not(materialCondition2), MaterialRules.condition(materialCondition6, LAVA)),
                                MaterialRules.condition(
                                        MaterialRules.biome(BiomeKeys.WARPED_FOREST),
                                        MaterialRules.condition(
                                                MaterialRules.not(materialCondition10),
                                                MaterialRules.condition(materialCondition, MaterialRules.sequence(MaterialRules.condition(materialCondition11, WARPED_WART_BLOCK), WARPED_NYLIUM))
                                        )
                                ),
                                MaterialRules.condition(
                                        MaterialRules.biome(BiomeKeys.CRIMSON_FOREST),
                                        MaterialRules.condition(
                                                MaterialRules.not(materialCondition10),
                                                MaterialRules.condition(materialCondition, MaterialRules.sequence(MaterialRules.condition(materialCondition11, NETHER_WART_BLOCK), CRIMSON_NYLIUM))
                                        )
                                )
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.NETHER_WASTES),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        MaterialRules.condition(
                                                materialCondition7,
                                                MaterialRules.sequence(
                                                        MaterialRules.condition(
                                                                MaterialRules.not(materialCondition6), MaterialRules.condition(materialCondition3, MaterialRules.condition(materialCondition4, SOUL_SAND))
                                                        ),
                                                        NETHERRACK
                                                )
                                        )
                                ),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.condition(
                                                materialCondition,
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.condition(
                                                                materialCondition8,
                                                                MaterialRules.sequence(MaterialRules.condition(materialCondition2, GRAVEL), MaterialRules.condition(MaterialRules.not(materialCondition6), GRAVEL))
                                                        )
                                                )
                                        )
                                )
                        )
                ),
                NETHERRACK
        );
    }
}
