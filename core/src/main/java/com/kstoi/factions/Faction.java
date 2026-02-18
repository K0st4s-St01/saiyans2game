package com.kstoi.factions;

import java.io.Serializable;

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
    private String factionMartialArtName;
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
