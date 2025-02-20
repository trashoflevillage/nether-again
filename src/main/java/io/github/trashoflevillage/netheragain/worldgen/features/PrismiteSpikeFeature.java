package io.github.trashoflevillage.netheragain.worldgen.features;

import com.mojang.serialization.Codec;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.function.Predicate;

public class PrismiteSpikeFeature extends Feature<DefaultFeatureConfig> {
    public PrismiteSpikeFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Predicate<BlockState> predicate = Feature.notInBlockTagPredicate(BlockTags.FEATURES_CANNOT_REPLACE);
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();

        int size = random.nextBetween(15, 30);

        Vector3f vec = new Vector3f(0, 0, 0);
        while (vec.equals(new Vector3f(0, 0, 0))) {
            vec = new Vector3f(
                    (random.nextFloat() * 2) - 1,
                    (random.nextFloat() * 2) - 1,
                    (random.nextFloat() * 2) - 1
            );
        }

        int distance = 0;
        for (int i = 0; i < size; i++) {
            Vector3f precisePos = blockPos.toCenterPos().toVector3f().add(vec.mul(distance));
            BlockPos currentPos = new BlockPos((int)precisePos.x, (int)precisePos.y, (int)precisePos.z);
            BlockPos[] positions;
            if (i < size - 1) {
                 positions = new BlockPos[] {
                        currentPos,
                        currentPos.north(),
                        currentPos.east(),
                        currentPos.south(),
                        currentPos.west(),
                        currentPos.up(),
                        currentPos.down()
                };
            } else {
                positions = new BlockPos[] {
                        currentPos
                };
            }
            for (BlockPos pos : positions) {
                if (pos == currentPos || random.nextBoolean()) {
                    this.setBlockStateIf(
                            world,
                            pos,
                            ModBlocks.PRISMITE_BLOCK.getDefaultState(),
                            predicate
                    );
                }
            }
            distance++;
        }
        return true;
    }
}
