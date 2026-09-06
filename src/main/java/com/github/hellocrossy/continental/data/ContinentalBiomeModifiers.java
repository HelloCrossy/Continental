package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.config.ZawaSpawnCategory;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ContinentalBiomeModifiers extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(ForgeRegistries.Keys.BIOME_MODIFIERS, (context) -> ZawaSpawnCategory.bootstrap(context, Continental.MOD_ID));

    public ContinentalBiomeModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Continental.MOD_ID));
    }

    @Override
    public String getName() {
        return "Biome Modifier Registries: " + Continental.MOD_ID;
    }
}