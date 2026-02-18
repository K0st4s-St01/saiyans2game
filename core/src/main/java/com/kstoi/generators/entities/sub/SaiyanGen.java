package com.kstoi.generators.entities.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.kstoi.generators.stats.StatsGen;
import com.kstoi.models.entities.Saiyan;
import com.kstoi.services.TextureService;
import com.kstoi.items.Equipment;
import com.kstoi.martial_arts.MartialArt;

public class SaiyanGen {
    private SaiyanGen() {
    }

    private static final String[] VEGETABLES = {
            "Carrot", "Radish", "Spinach", "Kale", "Pepper",
            "Onion", "Turnip", "Parsley", "Celery",
            "Broccoli", "Garlic", "Leek", "Okra",
            "Cabbage", "Beet", "Tomato"
    };

    private static final String[] ENDINGS = {
            "ar", "ek", "on", "or", "ix", "ak", "en"
    };

    public static String generateSaiyanName(Random random) {
        String base = VEGETABLES[random.nextInt(VEGETABLES.length)];
        base = base.substring(0, Math.min(4, base.length()));
        String ending = ENDINGS[random.nextInt(ENDINGS.length)];
        return base + ending;
    }

    public static Saiyan nextSaiyan(float x, float y, float size, float powerlevel, Random random,Equipment eq,String factionName,MartialArt martialArt) {
        var result = new Saiyan();
        result.setAvatar("saiyan");
        result.setName(generateSaiyanName(random));
        result.setArchetype(StatsGen.nextCharacterArch(random));
        result.setStats(StatsGen.genArchetypeStats(result.getArchetype(),powerlevel,random));
        result.setClothes(eq);
        var keys = TextureService.getCustomization().keySet();
        result.setCustomizations(new ArrayList<String>());
        result.getCustomizations().add((String) keys.toArray()[random.nextInt(keys.size())]);

        result.setHealth(StatsGen.genBaseStat(result.getStats().get("endurance").getCurrent() / 10f));
        result.setKi(StatsGen.genBaseStat(result.getStats().get("kiControl").getCurrent() / 10f));
        result.setMartialArt(martialArt);
        result.setFactionName(factionName);
        result.setPos(new Rectangle(x, y, size, size));
        System.out.println(result);
        return result;
    }
}
