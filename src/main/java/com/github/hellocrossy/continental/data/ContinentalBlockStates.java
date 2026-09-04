package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;


public class ContinentalBlockStates extends BlockStateProvider {
    public ContinentalBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Continental.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    public void rotateYBlock(Block block) {
        ModelFile model = models().getExistingFile(ForgeRegistries.BLOCKS.getKey(block));
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model).rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot()) % 360).build());
    }
}