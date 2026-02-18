package com.kstoi.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RaceAbillity {
    public Effect[] effects;
    public static enum Effect {
        // Saiyan
        SAIYAN_PRIDE,
        ZENKAI_BOOST,
        TAIL_REVENGE,
        TRANSFORMATION_POTENTIAL,

        // Namekian
        REGENERATION,
        STRETCHING_LIMBS,
        MYSTIC_POTENTIAL,

        // Human
        EARTH_DETERMINATION,
        KI_ADAPTABILITY,
        TACTICAL_ACUMEN,

        // Majin
        ABSORPTION,
        ELASTIC_BODY,
        CHAOS_RESISTANCE,

        // Frieza Race
        EMPIRE_BLOODLINE,
        NATURAL_FLIGHT,
        RESILIENCE,

        // Android
        UNLIMITED_ENERGY,
        TECH_MASTERY,
        HIGH_DURABILITY
    }
}
