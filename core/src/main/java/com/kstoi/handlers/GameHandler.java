package com.kstoi.handlers;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kstoi.factions.Faction;
import com.kstoi.factions.Faction.FactionArchetype;
import com.kstoi.generators.entities.EntityGen;
import com.kstoi.generators.entities.EntityGen.Race;
import com.kstoi.generators.entities.EntityGen.Role;
import com.kstoi.utils.CharacterCreationData;

import lombok.Getter;

@Getter
public class GameHandler {
  private PlayerHandler playerHandler;
  private final AnimationHandler animationHandler;
  private final EntityHandler entityHandler;

  public GameHandler(CharacterCreationData chardata) {
    animationHandler = new AnimationHandler();
    entityHandler = new EntityHandler(animationHandler);
    playerHandler = new PlayerHandler(chardata, animationHandler,entityHandler);
    testDummy(400f,400f);
    testDummy(400f,900f);
    testDummy(500f,500f);
  }

  private void testDummy(float x,float y) {
    var dummy = new Faction();
    dummy.setName("testDummy");
    dummy.setArchetype(FactionArchetype.GalacticPatrol);
    entityHandler.getEntities().add(EntityGen.generateEntity(
        Race.Human,
        Role.SuperBoss,
        x,
        y,
        120,
        1000,
        new Random(),
        dummy));
  }

  public void render(SpriteBatch batch, BitmapFont font) {
    entityHandler.render(batch, font);
    playerHandler.render(batch, font);
    animationHandler.render(batch);
  }

  public void shapes(ShapeRenderer renderer) {
    entityHandler.shapes(renderer);
    playerHandler.shapes(renderer);
  }

  public void update(float delta) {
    playerHandler.update(delta);
    animationHandler.update(delta);
    entityHandler.update(delta);
  }

  public void animationShapes(ShapeRenderer renderer) {
    animationHandler.shapes(renderer);

  }

}
