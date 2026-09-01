package com.github.hellocrossy.continental.client.model;

import com.github.hellocrossy.continental.Continental;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class ContinentalModelLayers {
    public static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final List<Tuple<ModelLayerLocation, Supplier<LayerDefinition>>> MODEL_LAYERS_LIST = new ArrayList<>();

    public ContinentalModelLayers() {
    }

    private static ModelLayerLocation register(String path, Supplier<LayerDefinition> layerDefinition) {
        return register(path, "main", layerDefinition);
    }

    private static ModelLayerLocation register(String path, String model, Supplier<LayerDefinition> layerDefinition) {
        ModelLayerLocation modellayerlocation = createLocation(path, model);
        MODEL_LAYERS_LIST.add(new Tuple<>(modellayerlocation, layerDefinition));
        if (!ALL_MODELS.add(modellayerlocation))
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        else return modellayerlocation;
    }

    private static ModelLayerLocation createLocation(String path, String model) {
        return new ModelLayerLocation(new ResourceLocation(Continental.MOD_ID, path), model);
    }
}