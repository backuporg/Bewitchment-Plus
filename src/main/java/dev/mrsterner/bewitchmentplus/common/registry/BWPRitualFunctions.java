package dev.mrsterner.bewitchmentplus.common.registry;

import dev.mrsterner.bewitchmentplus.BewitchmentPlus;
import dev.mrsterner.bewitchmentplus.common.ritualfunction.SpectralFamiliarRitualFunction;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.registry.BWRegistries;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class BWPRitualFunctions {
    private static final Map<RitualFunction, Identifier> RITUAL_FUNCTIONS = new LinkedHashMap<>();


    public static final RitualFunction SUMMON_SPECTRAL_FAMILIAR = create("summon_spectral_familiar", new SpectralFamiliarRitualFunction(ParticleTypes.HAPPY_VILLAGER, livingEntity -> BWPTags.FAMILIAR.contains(livingEntity.getType())));

    private static <T extends RitualFunction> T create(String name, T ritualFunction) {
        RITUAL_FUNCTIONS.put(ritualFunction, new Identifier(BewitchmentPlus.MODID, name));
        return ritualFunction;
    }

    public static void init() {
        RITUAL_FUNCTIONS.keySet().forEach(contract -> Registry.register(BWRegistries.RITUAL_FUNCTIONS, RITUAL_FUNCTIONS.get(contract), contract));
    }
}