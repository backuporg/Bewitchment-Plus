package dev.mrsterner.bewitchmentplus.common.registry;

import dev.mrsterner.bewitchmentplus.BewitchmentPlus;
import dev.mrsterner.bewitchmentplus.common.ritualfunction.BindSpectralFamiliarRitualFunction;
import dev.mrsterner.bewitchmentplus.common.ritualfunction.EffigyRitualFunction;
import dev.mrsterner.bewitchmentplus.common.ritualfunction.SpectralFamiliarRitualFunction;
import dev.mrsterner.bewitchmentplus.common.ritualfunction.SummonLesserDemonRitualFunction;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.entity.living.util.BWTameableEntity;
import moriyashiine.bewitchment.common.registry.BWRegistries;
import moriyashiine.bewitchment.common.registry.BWTags;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BWPRitualFunctions {
    public static final RitualFunction SUMMON_SPECTRAL_FAMILIAR = new SpectralFamiliarRitualFunction(ParticleTypes.HAPPY_VILLAGER, livingEntity -> livingEntity.getType().isIn(BWPTags.SACRIFICES));
    public static final RitualFunction MAKE_EFFIGY = new EffigyRitualFunction(ParticleTypes.HAPPY_VILLAGER, null);
    public static final RitualFunction SUMMON_DEATH = new BindSpectralFamiliarRitualFunction(ParticleTypes.SOUL, null);
    public static final RitualFunction SUMMON_LESSER_DEMON = new SummonLesserDemonRitualFunction(ParticleTypes.SOUL_FIRE_FLAME, livingEntity -> livingEntity.getType().isIn(BWPTags.CAPRINES));

    public static <T> T register(Registry<? super T> registry, String name, T entry) {
        return Registry.register(registry, new Identifier(BewitchmentPlus.MODID, name), entry);
    }


    public static void init() {
        register(BWRegistries.RITUAL_FUNCTIONS, "spectral_familiar", SUMMON_SPECTRAL_FAMILIAR);
        register(BWRegistries.RITUAL_FUNCTIONS, "make_effigy", MAKE_EFFIGY);
        register(BWRegistries.RITUAL_FUNCTIONS, "summon_lesser_demon", SUMMON_LESSER_DEMON);
    }
}
