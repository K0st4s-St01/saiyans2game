package com.kstoi.generators.martial_arts;

import java.util.Random;

import com.kstoi.martial_arts.MartialArt;
import com.kstoi.stats.SkillStat;

public class MartialArtGen {
  public enum Type {
    Striker,
    KiBlasting,
    Kai,
    Saiyan,
    FrostDemon,
    Buu,
    Magic,
    Rebels,
    Assassination
  }

  private static final String[] PREFIX = {
      "Crimson", "Azure", "Iron", "Shadow", "Solar",
      "Thunder", "Silent", "Golden", "Storm", "Void"
  };

  private static final String[] ANIMAL = {
      "Tiger", "Dragon", "Crane", "Wolf", "Serpent",
      "Mantis", "Phoenix", "Leopard", "Falcon"
  };

  private static final String[] SUFFIX = {
      "Fist", "Style", "School", "Technique",
      "Method", "Discipline", "Art", "Way"
  };

  public static String generateMartialArtName(Random random) {
    String prefix = PREFIX[random.nextInt(PREFIX.length)];
    String animal = ANIMAL[random.nextInt(ANIMAL.length)];
    String suffix = SUFFIX[random.nextInt(SUFFIX.length)];
    return prefix + " " + animal + " " + suffix;
  }


  public static MartialArt genMartialArt(Type type, Random random) {
    var result = new MartialArt();
    result.setName(generateMartialArtName(random));
    var progress = new SkillStat();
    progress.setCurrent(1f);
    progress.setMin(1f);
    progress.setMax(100f);
    progress.setLearningRate(0.1f);
    switch (type) {
      case Assassination:
        // fingerBeam
        // execution dash
        // teleportation
        // slay hp < x -> instant kill
        // shadow clones
        break;
      case Buu:
        // beam
        // homing missles
        // planet destroyer ball
        // ball dash chain (target multiple chars)
        // absorve character if hp < x
        break;
      case FrostDemon:
        // fingerBeam
        // energy ball
        // rapid ki blasts
        // energy disc
        // evil beam sword
        break;
      case Kai:
        // meele dash
        // kai o ken
        // energy wave
        // spirit bomb
        // kai o ken times x
        break;
      case KiBlasting:
        // homing rapid blasts
        // homing energy wave
        // ki purification -> less ki cost and more dmg
        // aoe energy blast
        // energy surge -> fast ki regen
        break;
      case Magic:
        // Signature Attacks
        // Elemental Blast: fire, ice, or lightning projectiles
        // Binding Spell: temporarily trap enemies
        // Curse / Hex: debuff enemy stats
        // Arcane Surge: increase damage for a short period
        break;
      case Rebels:
        // beam sword
        // rapid blasts
        // energy disc
        // last resort // reduce health for dmg buff
        // aoe energy blast
        break;
      case Saiyan:
        // dash
        // rapid ki blast
        // energy wave
        // warrior race -> natural stat scale
        // saiyan pride -> raise max ki and fill ki
        break;
      case Striker:
        // dash
        // multiple hits
        // reflexes -> dodge hits with probability
        // smash -> super hard hit
        // dragon fist
        break;
      default:
        break;
    }

    return result;
  }
}
