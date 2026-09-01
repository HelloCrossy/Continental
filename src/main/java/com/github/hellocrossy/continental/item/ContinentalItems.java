package com.github.hellocrossy.continental.item;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContinentalItems {
    public static final DeferredRegister<Item> ITEMS_REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, Continental.MOD_ID);
    public static final DeferredRegister<Item> DECORATIONS_REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, Continental.MOD_ID);
}