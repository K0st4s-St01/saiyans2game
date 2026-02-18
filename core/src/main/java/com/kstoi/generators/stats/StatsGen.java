package com.kstoi.generators.stats;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.kstoi.stats.BaseStat;
import com.kstoi.stats.CharacterArchetypes;
import com.kstoi.stats.SkillStat;
public class StatsGen{
    private static List<String> baseStats = List.of(
        "strength",
        "kiControl",
        "intellect",
        "charisma",
        "agility",
        "endurance",
        "perception"
    );
    private StatsGen(){

    }
    public static CharacterArchetypes nextCharacterArch(Random random){
        var values = CharacterArchetypes.values();
        return values[random.nextInt(values.length)];
    }
    private static void add(Map<String,SkillStat> skills,String key,float value){
        float currentValue = skills.get(key).getCurrent();
        skills.get(key).setCurrent(currentValue + value);
    }
    public static Map<String,SkillStat> genArchetypeStats(CharacterArchetypes arch,float powerlevel,Random random){
        Map<String,SkillStat> base= genBaseStats(powerlevel);
	    SkillStat bonusStat= new SkillStat();
        switch (arch) {
			case ASCENDANT:
			    bonusStat = new SkillStat();
        	    bonusStat.setCurrent(1f);
        	    bonusStat.setLearningRate(0.01f);
        	    bonusStat.setMin(1f);
        	    bonusStat.setMax(10f);
			    base.put("undying", bonusStat);
				break;
			case AURA_CHANNELER:
			    add(base,"kiControl",(float)Math.log(powerlevel));
			    add(base,"strength",(float) -Math.log(powerlevel) / 3f);
				break;
			case BERSERKER:
			    add(base,"strength",(float)Math.log(powerlevel));
			    add(base,"endurance",(float)Math.log(powerlevel));
			    add(base,"agility",(float) -Math.log(powerlevel) / 2f);
			    add(base,"charisma",(float) -Math.log(powerlevel) / 2f);
				break;
			case BLASTER:
			    add(base,"kiControl",(float)Math.log(powerlevel));
			    add(base,"endurance",(float) -Math.log(powerlevel) / 3f);
				break;
			case BRUISER:
			    add(base,"strength",(float)Math.log(powerlevel));
			    add(base,"endurance",(float)Math.log(powerlevel));
			    add(base,"perception",(float) -Math.log(powerlevel) / 2f);
				break;
			case COMBO_ARTIST:
			    add(base,"strength",(float)Math.log(powerlevel));
			    add(base,"agility",(float)Math.log(powerlevel));
			    add(base,"kiControl",(float) -Math.log(powerlevel));
				break;
			case DEFENDER:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.01f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(30f);
			    base.put("defence", bonusStat);

			    add(base,"endurance",(float)Math.log(powerlevel));
				break;
			case ELITE_WARRIOR:
			    add(base,"strength",(float)Math.log(powerlevel)/4f);
			    add(base,"endurance",(float)Math.log(powerlevel)/4f);
			    add(base,"agility",(float)Math.log(powerlevel)/4f);
			    add(base,"kiControl",(float)Math.log(powerlevel)/4f);
				break;
			case EXECUTIONER:
			    add(base,"strength",(float)Math.log(powerlevel)/2f);
                add(base,"perception",(float)Math.log(powerlevel)/2f);
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.01f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(10f);
			    base.put("execution", bonusStat);
				break;
			case GUARDIAN:
			    add(base,"endurance",(float)Math.log(powerlevel)/3f);
			    add(base,"kiControl",(float)Math.log(powerlevel)/3f);
			    add(base,"strength",(float)Math.log(powerlevel)/3f);
				break;
			case IRON_BODY:
			    add(base,"endurance",(float)Math.log(powerlevel));
				break;
			case JUGGERNAUT:
			    for(String key : base.keySet()){
			        add(base,key,random.nextFloat((float) Math.log(powerlevel)));
			    }
			    add(base,"endurance", (float) Math.log(powerlevel));
				break;
			case KI_MASTER:
			    add(base,"kiControl",(float)Math.log(powerlevel)/2f);
			    add(base,"strength",(float)-Math.log(powerlevel)/2f);
				break;
			case LEGENDARY_BLOODLINE:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(30f);
			    base.put("legendary", bonusStat);
			    for(String key : base.keySet()){
			        base.get(key).setLearningRate(1.5f);
			    }
				break;
			case MARTIAL_ARTIST:
				break;
			case MUTANT:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("mutation", bonusStat);
				break;
			case OVERCHARGER:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("limitlessKi", bonusStat);
				break;
			case PHANTOM:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("necromancer", bonusStat);
				break;
			case PRODIGY:
			    for(String key : base.keySet()){
			        base.get(key).setLearningRate(2f);
			    }
				break;
			case PROTECTOR:
			    add(base,"endurance",(float)Math.log(powerlevel)/2f);
			    base.get("endurance").setLearningRate(1.5f);
				break;
			case REGENERATOR:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("regeneration", bonusStat);
				break;
			case SHADOW_STRIKER:
			    add(base,"kiControl",(float)-Math.log(powerlevel)/2f);
			    add(base,"strength",(float)Math.log(powerlevel)/2f);
			    add(base,"perception",(float)Math.log(powerlevel)/2f);
				break;
			case SNIPER:
			    base.get("perception").setLearningRate(3f);
				break;
			case SPEEDSTER:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("kiAgillity", bonusStat);
				break;
			case SPIRIT_MONK:
			    add(base,"intellect",(float)Math.log(powerlevel));
			    add(base,"kiControl",(float)Math.log(powerlevel));
				break;
			case SURVIVOR:
			    bonusStat = new SkillStat();
			    bonusStat.setCurrent(1f);
			    bonusStat.setLearningRate(0.1f);
			    bonusStat.setMin(1f);
			    bonusStat.setMax(50f);
			    base.put("survivalInstinct", bonusStat);
				break;
			case TACTICIAN:
			    add(base,"intellect",(float)Math.log(powerlevel));
			    add(base,"perception",(float)Math.log(powerlevel)/2f);
				break;
			case WARLORD:
			    add(base,"charisma",(float)Math.log(powerlevel)/2f);
			    add(base,"perception",(float)Math.log(powerlevel)/2f);
				break;
			case WINDBLADE:
			    add(base,"agility",(float)Math.log(powerlevel)/2f);
			    add(base,"kiControl",(float)Math.log(powerlevel)/2f);
				break;
			default:
				break;
        }
        return base;
    }
    private static Map<String,SkillStat> genBaseStats(float powerlevel){
        var skills = new TreeMap<String,SkillStat>();
        for(String skillName : baseStats){
            SkillStat current = new SkillStat();
            float value = (float) Math.sqrt(powerlevel);
            current.setLearningRate(1f);
            current.setCurrent(value);
            current.setMax(100f);
            current.setMin(1f);
            skills.put(skillName, current);
        }
        return skills;
    }
    public static BaseStat genBaseStat(float magnitude){
        BaseStat stat = new BaseStat(100+10*magnitude, 1f, 100+10*magnitude);
        return stat;
    }
}
