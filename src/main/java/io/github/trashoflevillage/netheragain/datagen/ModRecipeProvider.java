package io.github.trashoflevillage.netheragain.datagen;

import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.items.ModItems;
import io.github.trashoflevillage.trashlib.datagen.TrashlibRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new TrashlibRecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offerSmeltingAndBlasting(
                        List.of(ModItems.RAW_DEBRIS),
                        RecipeCategory.MISC,
                        Items.NETHERITE_SCRAP,
                        2.0F,
                        200,
                        "netherite_scraps"
                );

                offerCompactingRecipe(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.PRISMITE_BLOCK,
                        ModItems.PRISMITE
                );
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
