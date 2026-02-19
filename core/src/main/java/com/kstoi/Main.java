package com.kstoi;

import com.badlogic.gdx.Game;
import com.kstoi.ui.screens.CharCreation;
import com.kstoi.ui.screens.GameScreen;
import com.kstoi.utils.CharacterCreationData;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private FirstScreen firstScreen = new FirstScreen(this);
    @Override
    public void create() {
        setScreen(firstScreen);
    }
    public void main_menu(){
        setScreen(firstScreen);
    }
    public void characterCreation(){
        setScreen(new CharCreation(this));

    }
    public void loadGame(){

    }
    public void startGame(CharacterCreationData data){
        setScreen(new GameScreen(this,data));
    }
}
