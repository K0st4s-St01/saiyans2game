package com.kstoi.generators.entities;

import java.util.Random;

import com.kstoi.factions.Faction;
import com.kstoi.generators.entities.sub.SaiyanGen;
import com.kstoi.generators.items.EquipmentGenerator;
import com.kstoi.models.entities.Entity;

public class EntityGen{
    private EntityGen(){

    }
    public static Entity generateEntity(Race race,Role role,float x,float y,float size,float powerlevel,Random random,Faction faction){
        switch (race) {
			// case Android:
			// 	break;
			// case Buu:
			// 	break;
			// case FrostDemon:
			// 	break;
			// case Human:
			// 	break;
			// case Majin:
			// 	break;
			// case Namekian:
			// 	break;
			case Saiyan:
			    return SaiyanGen.nextSaiyan(x, y, size, powerlevel, random, EquipmentGenerator.generateEquipment(role, faction.getArchetype()), faction.getName(),;
			default:
			    throw new RuntimeException("unsupported race");
        }
    }
    public static enum Race{
        Saiyan,
        Human,
        FrostDemon,
        Majin,
        Namekian,
        Android,
        Buu
    }
    public static enum Role{
        SuperBoss,
        Boss,
        MinorBoss,
        Soldier,
        Citizen,
        QuestGiver,
        Trader
    }
}
