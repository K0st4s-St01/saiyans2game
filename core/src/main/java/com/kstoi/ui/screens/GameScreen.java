package com.kstoi.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.kstoi.Main;
import com.kstoi.handlers.GameHandler;
import com.kstoi.utils.CharacterCreationData;

public class GameScreen implements Screen{
  private SpriteBatch batch;
  private ShapeRenderer renderer;
  private BitmapFont font;
  private GameHandler gameHandler;
  private OrthographicCamera camera;
  public GameScreen(Main main,CharacterCreationData chardata){
    gameHandler = new GameHandler(chardata);
  }
  
	@Override
	public void show() {
    batch = new SpriteBatch();
    renderer = new ShapeRenderer();
    font = new BitmapFont();
    renderer.setAutoShapeType(true);
    camera = new OrthographicCamera();
    camera.setToOrtho(false);
    Gdx.input.setInputProcessor(gameHandler.getPlayerHandler());
	}
	

	@Override
	public void render(float delta) {
	  var cameraPosition = gameHandler.getPlayerHandler().updateCamera();
	  camera.position.x=  cameraPosition.x;
	  camera.position.y = cameraPosition.y;
	  camera.position.z = cameraPosition.z;
	  camera.update();
	  Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
	  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    renderer.setProjectionMatrix(camera.combined);

    renderer.begin(ShapeType.Filled);
    gameHandler.shapes(renderer);
    renderer.end();
	  
	  batch.setProjectionMatrix(camera.combined);
	  batch.begin();
	  gameHandler.render(batch, font);
	  batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	  batch.dispose();
	  renderer.dispose();
	  font.dispose();
	}
  
}
