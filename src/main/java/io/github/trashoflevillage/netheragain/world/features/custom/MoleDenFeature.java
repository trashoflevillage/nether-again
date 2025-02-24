package io.github.trashoflevillage.netheragain.world.features.custom;

import com.mojang.serialization.Codec;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.trashlib.util.GenHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.function.Predicate;

public class MoleDenFeature extends Feature<SimpleBlockFeatureConfig> {

    public MoleDenFeature(Codec<SimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<SimpleBlockFeatureConfig> context) {
        Predicate<BlockState> predicate = Feature.notInBlockTagPredicate(BlockTags.FEATURES_CANNOT_REPLACE);
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        SimpleBlockFeatureConfig config = context.getConfig();
        Random rng = world.getRandom();
        SimplexNoiseSampler noise = new SimplexNoiseSampler(rng);

        generateRoom(context, world, origin, config, rng, predicate);

        return true;
    }

    private void generateRoom(
            FeatureContext<SimpleBlockFeatureConfig> context,
            StructureWorldAccess world,
            BlockPos origin,
            SimpleBlockFeatureConfig config,
            Random rng,
            Predicate<BlockState> predicate
    ) {
        GenHelper.sphere(world.toServerWorld(), origin, (w, p) -> {
            if (predicate.test(world.getBlockState(p))) {
                return context.getConfig().toPlace().get(w.random, p);
            } else return null;
        }, (w, p) -> {
            if (predicate.test(world.getBlockState(p))) {
                return Blocks.AIR.getDefaultState();
            } else return null;
        }, rng.nextBetween(8, 12));
    }
}
