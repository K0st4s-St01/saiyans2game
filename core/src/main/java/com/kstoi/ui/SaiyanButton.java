package com.kstoi.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public final class SaiyanButton{
    private SaiyanButton(){}
    public static TextButton of(Skin skin,String title,float x,float y,ClickListener listener){
        var button = new TextButton(title,skin,"default");
        button.setBounds(x, y, 200, 30);
        button.addListener(listener);
        return button;
    }
}
