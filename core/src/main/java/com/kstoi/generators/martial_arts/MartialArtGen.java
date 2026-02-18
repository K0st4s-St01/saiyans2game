package com.kstoi.generators.martial_arts;

import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.kstoi.martial_arts.MartialArt;

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

    public static String generateMartialArt(Random random) {
        String prefix = PREFIX[random.nextInt(PREFIX.length)];
        String animal = ANIMAL[random.nextInt(ANIMAL.length)];
        String suffix = SUFFIX[random.nextInt(SUFFIX.length)];
        return prefix + " " + animal + " " + suffix;
    }

    public static Map<String,Type> genAll(Random random) {
        Map<String,Type> results = new TreeMap<>();
        return results;
    }
    private static MartialArt genMartialArt(Type type,long seed){
        var result = new MartialArt();
        return result;
    }
}
