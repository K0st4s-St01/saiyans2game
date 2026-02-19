package com.kstoi.ui.screens;

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
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kstoi.Main;
import com.kstoi.services.TextureService;
import com.kstoi.stats.CharacterArchetypes;
import com.kstoi.ui.SaiyanButton;
import com.kstoi.ui.SaiyanSelectBox;
import com.kstoi.ui.SaiyanTextField;
import com.kstoi.utils.CharacterCreationData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CharCreation implements Screen {
    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private Stage stage;
    private Skin skin;
    private Texture background;
    private final Main main;
    private SelectBox<CharacterArchetypes> charch;
    private SelectBox<String> cust;
    private SelectBox<String> ent;
    private SelectBox<String> previewEquipment;
    private TextField nameTextField;
    private TextField factionNameTextField;

    @Override
    public void show() {
        TextureService.loadEmAll();
        this.batch = new SpriteBatch();
        this.shapes = new ShapeRenderer();
        this.shapes.setAutoShapeType(true);

        background = new Texture("ui/char_creation.png");
        skin = new Skin(new FileHandle("defaultUiSkin/skin/uiskin.json"));
        stage = new Stage();

        font = new BitmapFont();

        stage.addActor(SaiyanButton.of(skin, "back", 160, 140, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.main_menu();
            }
        }));
        charch = (SaiyanSelectBox.<CharacterArchetypes>of(skin, CharacterArchetypes.toList(), 160, 900));
        cust = (SaiyanSelectBox.<String>of(skin, TextureService.getCustomization().keySet().stream().toList(), 160,
                850));
        ent = (SaiyanSelectBox.<String>of(skin, TextureService.getEntities().keySet().stream().toList(), 160, 800));
        previewEquipment = SaiyanSelectBox.<String>of(skin,TextureService.getItems().keySet().stream().toList(),160,500);
        nameTextField = SaiyanTextField.of(skin, "please enter character name", 160, 700);
        factionNameTextField = SaiyanTextField.of(skin, "please enter player faction name", 160, 600);
        stage.addActor(charch);
        stage.addActor(cust);
        stage.addActor(ent);
        stage.addActor(nameTextField);
        stage.addActor(factionNameTextField);
        stage.addActor(previewEquipment);

        stage.addActor(SaiyanButton.of(skin, "start game", 360, 140, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CharacterCreationData data = new CharacterCreationData();
                data.setArchetype(charch.getSelected());
                data.setCustom(cust.getSelected());
                data.setFaction(factionNameTextField.getText());
                data.setName(nameTextField.getText());
                data.setRace(ent.getSelected());
                System.out.println(data);
                if(data.getName().isEmpty() || data.getFaction().isEmpty()){
                    return;
                }
                main.startGame(data);
            }
        }));

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, 1920, 1080);
        batch.draw(TextureService.getEntities().get(ent.getSelected()), 500, 300, 500, 500);
        batch.draw(TextureService.getCustomization().get(cust.getSelected()), 500, 300, 500, 500);
        batch.draw(TextureService.getItems().get(previewEquipment.getSelected()), 500, 300,500,500);
        batch.end();

        shapes.begin(ShapeType.Filled);
        shapes.end();

        stage.act(delta);
        stage.draw();
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
    }

}
