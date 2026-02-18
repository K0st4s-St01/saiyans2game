package com.kstoi.generators.entities.sub;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.kstoi.generators.stats.StatsGen;
import com.kstoi.items.Equipment;
import com.kstoi.martial_arts.MartialArt;
import com.kstoi.models.entities.Human;
import com.kstoi.services.TextureService;

public class HumanGen {
    private HumanGen() {
    }

    private static final String[] START = { "Ka", "Le", "Ri", "Da", "Ma", "Va", "Sa", "Ny" };
    private static final String[] MID = { "ra", "lo", "mi", "zen", "ki", "ta", "rin", "sha" };
    private static final String[] END = { "n", "ra", "s", "el", "on", "a", "is", "or" };

    public static String generateHumanName(Random random) {
        return START[random.nextInt(START.length)]
                + MID[random.nextInt(MID.length)]
                + END[random.nextInt(END.length)];
    }

    public static Human nextHuman(float x, float y, float size, float powerlevel, Random random, Equipment eq,
            String factionName,MartialArt martialArt) {
        var result = new Human();
        result.setAvatar("human");
        result.setName(generateHumanName(random));
        result.setArchetype(StatsGen.nextCharacterArch(random));
        result.setStats(StatsGen.genArchetypeStats(result.getArchetype(), powerlevel, random));
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
