package com.kstoi.factions;

import java.io.Serializable;

import com.kstoi.generators.martial_arts.MartialArtGen.Type;
import com.kstoi.martial_arts.MartialArt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Faction implements Serializable{
    private String name;
    private FactionArchetype archetype;
    private Type factionMartialArt;
    public static enum FactionArchetype {
        Overlord, // Frost Demon
        Saiyans,
        Humans,
        Majins,
        GalacticPatrol,
        SaiyanArmy,
        RebelArmy,
        Traders,
        Mercenaries,
        Nomads,
        HiddenNetwork,
        WildLife,
        ;
    }
}
