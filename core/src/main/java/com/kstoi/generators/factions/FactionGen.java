package com.kstoi.generators.factions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial.MaterialType;
import com.kstoi.factions.Faction;
import com.kstoi.factions.Faction.FactionArchetype;
import com.kstoi.generators.martial_arts.MartialArtGen;
import com.kstoi.generators.martial_arts.MartialArtGen.Type;

public class FactionGen{

  private FactionGen(){}
  
  public static Set<Faction> generateFactions(Random random,int size){
    var result = new HashSet<Faction>();
    for(int i=0;i<size;i++){
      result.add(nextFaction(random));
    }
    return result;
  }
  private static Faction nextFaction(Random random){
    var current = new Faction();
    var archetypes = FactionArchetype.values();
    current.setArchetype(archetypes[random.nextInt(archetypes.length)]);
    int msize = MartialArtGen.Type.values().length;
    MartialArtGen.Type mtype = MartialArtGen.Type.values()[random.nextInt(msize)];
    while(mtype == Type.Saiyan || mtype == Type.Buu || mtype == Type.FrostDemon){
      mtype = MartialArtGen.Type.values()[random.nextInt(msize)];
    }
    current.setName(current.getArchetype().toString()+"@"+random.nextInt());
    switch(current.getArchetype()){
      case Saiyans:
      mtype = MartialArtGen.Type.Saiyan;
      break;
		case GalacticPatrol:
			break;
		case HiddenNetwork:
			break;
		case Humans:
			break;
		case Majins:
      mtype = MartialArtGen.Type.Magic;
			break;
		case Mercenaries:
			break;
		case Nomads:
			break;
		case Overlord:
			break;
		case RebelArmy:
  		mtype =  MartialArtGen.Type.Rebels;
			break;
		case SaiyanArmy:
      mtype = MartialArtGen.Type.Saiyan;
			break;
		case Traders:
			break;
		case WildLife:
			break;
		default:
			break;
    }
    current.setFactionMartialArt(mtype);
    return current;
  }

}
