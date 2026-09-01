package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ContinentalBlockModels extends BlockModelProvider {
    public ContinentalBlockModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Continental.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
