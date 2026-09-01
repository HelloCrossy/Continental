package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;


public class ContinentalTagsProviders {
    public static class ContinentalEntityTypeTagsProvider extends EntityTypeTagsProvider {
        public ContinentalEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, p_256572_, Continental.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            //     tag(ZawaEntityTypeTags.SPECIES_VARIANTS).add();
            //     tag(ZawaEntityTypeTags.ZOO_ANIMALS).add();
        }
    }

    public static class ContinentalBlockTagsProvider extends BlockTagsProvider {
        public ContinentalBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Continental.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            //   tag(BlockTags.MINEABLE_WITH_AXE).add(
            //  );
            //   tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
            //  );
            //   tag(BlockTags.MINEABLE_WITH_SHOVEL).addTag(
            //  );
            //   tag(BlockTags.SMALL_FLOWERS).add(
            //   );
            //  tag(BlockTags.DOORS).add(
            //  );
            //  tag(BlockTags.WOODEN_DOORS).add(
            //  );
            //  tag(BlockTags.TRAPDOORS).add(
            //  );
            //  tag(BlockTags.WOODEN_TRAPDOORS).add(
            // );
            //  tag(BlockTags.WALLS).add(
            //  );
            //  tag(BlockTags.FENCE_GATES).add(
            //  );
            // tag(BlockTags.WOODEN_FENCES).add(
            // );
            // tag(BlockTags.SLABS).add(
            //  );
            //  tag(BlockTags.WOODEN_SLABS).add(
            //  );
            //  tag(BlockTags.WOODEN_STAIRS).add(
            //  );
            //  tag(BlockTags.DIRT).addTag(
            //  );
        }
    }

    public static class ContinentalItemTagsProvider extends ItemTagsProvider {
        public ContinentalItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider tagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(packOutput, lookupProvider, tagsProvider.contentsGetter(), Continental.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {

        }
    }

    //copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

    // copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);

    //copy(BlockTags.DOORS, ItemTags.DOORS);

    //copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

    //copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);

    //copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);

    //copy(BlockTags.WALLS, ItemTags.WALLS);

    //copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

    //copy(BlockTags.FENCES, ItemTags.FENCES);

    //copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

    //copy(BlockTags.SLABS, ItemTags.SLABS);

    //copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

    //copy(BlockTags.STAIRS, ItemTags.STAIRS);

    //copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

    //copy(BlockTags.DIRT, ItemTags.DIRT);

    // tag(ItemTags.AXOLOTL_TEMPT_ITEMS).

    //add(
    //);

    //tag(ItemTags.FISHES).

    // add(
    // );

    //tag(Tags.Items.EGGS).

    //add(
    // );

    //tag(ZawaItemTags.BUSHES).

    //add(
    //);

    // tag(ZawaItemTags.GRASSES).

    //add(
    //);

    //tag(ZawaItemTags.RAW_FISHES).

    //add(
    // );
}
