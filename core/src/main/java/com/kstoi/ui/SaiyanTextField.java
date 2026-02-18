package com.kstoi.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class SaiyanTextField{
    private SaiyanTextField(){}
    public static TextField of(Skin skin,String text,float x,float y){
        var tf = new TextField("",skin);
        tf.setMessageText(text);
        tf.setBounds(x, y, 200, 20);
        return tf;
    }
}
