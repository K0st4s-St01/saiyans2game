package com.kstoi.stats;

import java.util.LinkedList;
import java.util.List;

public enum CharacterArchetypes {

    // ⚔️ Melee / Physical
    BERSERKER,
    ELITE_WARRIOR,
    BRUISER,
    MARTIAL_ARTIST,
    EXECUTIONER,
    JUGGERNAUT,

    // 🔥 Ki / Energy
    KI_MASTER,
    BLASTER,
    SNIPER,
    AURA_CHANNELER,
    OVERCHARGER,
    SPIRIT_MONK,

    // 🛡 Defensive
    GUARDIAN,
    DEFENDER,
    IRON_BODY,
    REGENERATOR,
    PROTECTOR,

    // ⚡ Speed / Agility
    SPEEDSTER,
    SHADOW_STRIKER,
    COMBO_ARTIST,
    WINDBLADE,
    PHANTOM,

    // 🌌 Unique / Special
    PRODIGY,
    ASCENDANT,
    SURVIVOR,
    TACTICIAN,
    WARLORD,
    MUTANT,
    LEGENDARY_BLOODLINE;
    public static List<CharacterArchetypes> toList(){
        var list = new LinkedList<CharacterArchetypes>();
        for(var v : CharacterArchetypes.values()){
            list.add(v);
        }
        return list;
    }

}
