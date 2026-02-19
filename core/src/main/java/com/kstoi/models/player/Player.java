package com.kstoi.models.player;

import com.kstoi.factions.Faction;
import com.kstoi.models.entities.Entity;

public class Player{
  public Entity entity;
  public Faction faction;

  public Player(Entity entity , Faction faction){
    this.entity = entity;
    this.faction =faction;
  }
}
