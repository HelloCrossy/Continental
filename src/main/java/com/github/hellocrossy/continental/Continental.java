package com.github.hellocrossy.continental;

import com.github.hellocrossy.continental.blocks.ContinentalBlocks;
import com.github.hellocrossy.continental.client.model.ContinentalModelLayers;
import com.github.hellocrossy.continental.data.*;
import com.github.hellocrossy.continental.entity.ContinentalEntities;
import com.github.hellocrossy.continental.item.ContinentalItems;
import com.github.hellocrossy.continental.sounds.ContinentalSounds;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.zawamod.zawa.Zawa;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@Mod(Continental.MOD_ID)
public class Continental {
    public static final String MOD_ID = "continental";
    //public static final String[] PLUSHIES_LIST = new String[]{"opossum", "skunk", "squirrel"};

    public Continental() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ContinentalEntities.REGISTRY.initialize();
        ContinentalItems.ITEMS_REGISTRAR.register(bus);
        ContinentalItems.DECORATIONS_REGISTRAR.register(bus);
        ContinentalBlocks.REGISTRAR.register(bus);
        ContinentalSounds.REGISTRAR.register(bus);

        bus.addListener(this::addCreativeTabs);
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);
        bus.addListener(this::registerLayerDefinitions);
        bus.addListener(this::setupClient);
    }

    private void addCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == Zawa.ITEMS_GROUP.getKey()) {
            ContinentalItems.ITEMS_REGISTRAR.getEntries().forEach(item -> event.accept(item.get()));
        }
        if (event.getTabKey() == Zawa.DECORATIONS_GROUP.getKey()) {
            ContinentalItems.DECORATIONS_REGISTRAR.getEntries().forEach(item -> event.accept(item.get()));
        }
        if (event.getTabKey() == Zawa.ENTITIES_GROUP.getKey()) {
            ContinentalEntities.REGISTRY.itemRegistrar.getEntries().forEach(item -> event.accept(item.get()));
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        ContinentalEntities.registerSpawnPlacements();
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        dataGenerator.addProvider(event.includeClient(), new ContinentalBlockModels(packOutput, event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeClient(), new ContinentalItemModels(packOutput, event.getExistingFileHelper()));
        ContinentalTagsProviders.ContinentalBlockTagsProvider blockTagsProvider = new ContinentalTagsProviders.ContinentalBlockTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper());
        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
        dataGenerator.addProvider(event.includeServer(), new ContinentalTagsProviders.ContinentalItemTagsProvider(packOutput, event.getLookupProvider(), blockTagsProvider, event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new ContinentalTagsProviders.ContinentalEntityTypeTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ContinentalBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(ContinentalEntityLoot::new, LootContextParamSets.ENTITY))));
        dataGenerator.addProvider(event.includeServer(), new ContinentalRecipeProvider(packOutput));
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ContinentalEntities.registerRenderers();
        ContinentalBlocks.setRenderLayers();
    }

    public void registerLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (Tuple<ModelLayerLocation, Supplier<LayerDefinition>> layer : ContinentalModelLayers.MODEL_LAYERS_LIST) {
            event.registerLayerDefinition(layer.getA(), layer.getB());
        }
    }
}
