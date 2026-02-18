package com.kstoi.services;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.Texture;

import lombok.Getter;

public final class TextureService {
    @Getter
    private static Map<String, Texture> entities;
    @Getter
    private static Map<String, Texture> customization;
    @Getter
    private static Map<String, Texture> items;
    @Getter
    private static Map<String, Texture> buildings;
    @Getter
    private static Map<String, Texture> spaceships;

    private static Map<String, Texture> load(File directory) {
        var result = new TreeMap<String, Texture>();
        for (File file : directory.listFiles()) {
            if (file.getName().contains(".png")) {
                result.put(file.getName().replace(".png", ""), new Texture(directory.getName() + "/" + file.getName()));
            }
        }
        return result;
    }

    public static void loadEmAll() {
        entities = load(new File("entities"));
        customization = load(new File("character_customization"));
        items = load(new File("items"));
        buildings = load(new File("buildings"));
        spaceships = load(new File("spaceships"));
    }

    private TextureService() {
    }

}
