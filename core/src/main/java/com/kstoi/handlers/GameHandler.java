package com.kstoi.handlers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kstoi.utils.CharacterCreationData;

import lombok.Getter;
@Getter
public class GameHandler{
  private PlayerHandler playerHandler;
  private final AnimationHandler animationHandler;
  public GameHandler(CharacterCreationData chardata){
    animationHandler = new AnimationHandler();
    playerHandler = new PlayerHandler(chardata,animationHandler);
  }

	public void render(SpriteBatch batch,BitmapFont font){
	  playerHandler.render(batch, font);
	  animationHandler.render(batch);
	}
	public void shapes(ShapeRenderer renderer){
	  playerHandler.shapes(renderer);
	  animationHandler.shapes(renderer);
	}
	public void update(float delta){
		playerHandler.update(delta);
		animationHandler.update(delta);
	}

}
