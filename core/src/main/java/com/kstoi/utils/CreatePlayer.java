package com.kstoi.utils;

import com.kstoi.models.player.Player;


import com.kstoi.models.entities.*;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.kstoi.factions.Faction;
import com.kstoi.generators.stats.StatsGen;
public final class CreatePlayer{
  private CreatePlayer(){}
  public static Player of(CharacterCreationData data){
    Entity ent;
    Faction faction = new Faction();
    faction.setName(data.getName());
    switch(data.getRace()){
      case "android":
        ent = new Android();
        break;
      case "buu_type":
        ent = new Buu();
        break;
      case "frost_demon":
        ent = new FrostDemon();
        break;
      case "human":
        ent = new Human();
        break;
      case "kai_race":
        ent = new Majin();
        break;
      case "namekian":
        ent = new Namekian();
        break;
      case "saiyan":
        ent = new Saiyan();
        break;
      default:
        throw new UnsupportedOperationException("no such race");
    }
    ent.pos = new Rectangle();
    ent.pos.width = 100f;
    ent.pos.height = 100f;
    var cust = new ArrayList<String>();
    cust.add(data.getCustom());
    ent.setCustomizations(cust);
    ent.setArchetype(data.getArchetype());
    ent.setAvatar(data.getRace());
    ent.setName(data.getName());
    ent.setStats(StatsGen.genArchetypeStats(ent.getArchetype(), 300, new Random(nameToSeed(ent.getName()))));
    ent.setHealth(StatsGen.genBaseStat(ent.getStats().get("endurance").getCurrent()));
    ent.setKi(StatsGen.genBaseStat(ent.getStats().get("kiControl").getCurrent()));
    return new Player(ent, faction);
  }
  private static long nameToSeed(String name){
    long value = 0L;
    for(Character c : name.toCharArray()){
      value+=c.BYTES;
    }
    return value;
  }
}
