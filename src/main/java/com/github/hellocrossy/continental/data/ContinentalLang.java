package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ContinentalLang extends LanguageProvider {
    public ContinentalLang(PackOutput output) {
        super(output, Continental.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
    }
}
