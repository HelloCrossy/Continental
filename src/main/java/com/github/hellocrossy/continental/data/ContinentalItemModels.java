package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ContinentalItemModels extends ItemModelProvider {
    public ContinentalItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Continental.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
