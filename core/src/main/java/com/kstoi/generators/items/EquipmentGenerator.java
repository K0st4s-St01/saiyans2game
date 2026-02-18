package com.kstoi.generators.items;
import com.kstoi.factions.Faction;
import com.kstoi.generators.entities.EntityGen;
import com.kstoi.items.Equipment;
public class EquipmentGenerator{
    private EquipmentGenerator(){

    }
    public static Equipment generateEquipment(EntityGen.Role role,Faction.FactionArchetype factionArchetype){
        Equipment result = new Equipment();
        result.setTexture(factionArchetype.toString().toLowerCase()+"_"+role.toString().toLowerCase());
        return result;
    }
}
