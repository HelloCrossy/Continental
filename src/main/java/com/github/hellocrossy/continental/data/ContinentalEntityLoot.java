package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.data.loot.packs.VanillaEntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.stream.Stream;

public class ContinentalEntityLoot extends VanillaEntityLoot {
    @Override
    public void generate() {
    }

    public static LootTable.Builder createCookedItemTable(ItemLike item, int maxCount) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, maxCount)))
                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))));
    }

    public LootPoolEntryContainer.Builder<?> addBone(int maxCount) {
        return LootItem.lootTableItem(Items.BONE)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, maxCount)))
                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)));
    }

    public LootPoolEntryContainer.Builder<?> addLeather(int maxCount) {
        return LootItem.lootTableItem(Items.LEATHER)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, maxCount)))
                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)));
    }

    public LootPoolEntryContainer.Builder<?> addFeather(int maxCount) {
        return LootItem.lootTableItem(Items.FEATHER)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, maxCount)))
                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)));
    }

    public static LootTable.Builder createSingleItemTable(ItemLike item) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(item)));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ForgeRegistries.ENTITY_TYPES.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(Continental.MOD_ID))
                .map(Map.Entry::getValue);
    }
}