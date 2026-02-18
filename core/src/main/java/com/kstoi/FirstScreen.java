package com.kstoi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kstoi.ui.SaiyanButton;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FirstScreen implements Screen {
    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private Texture background;
    private Stage stage;
    private Skin skin;
    private final Main main;
    @Override
    public void show() {
        this.batch = new SpriteBatch();
        this.shapes = new ShapeRenderer();
        this.shapes.setAutoShapeType(true);

        skin = new Skin(new FileHandle("defaultUiSkin/skin/uiskin.json"));
        stage = new Stage();

        stage.addActor(SaiyanButton.of(skin,"New Game", 860, 400, new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                main.characterCreation();
            }
        }));

        stage.addActor(SaiyanButton.of(skin,"Load Game", 860, 300, new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                main.loadGame();
            }
        }));

        stage.addActor(SaiyanButton.of(skin,"Exit Game", 860, 200, new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        }));
        font = new BitmapFont();
        background = new Texture("ui/main_menu.png");
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, 1920, 1080);
        batch.end();

        shapes.begin(ShapeType.Filled);
        shapes.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height
        // are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a
        // normal size before updating.
        if (width <= 0 || height <= 0)
            return;

        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        this.background.dispose();
        this.batch.dispose();
        this.font.dispose();
        this.shapes.dispose();
        this.skin.dispose();
        this.stage.dispose();

    }
}
