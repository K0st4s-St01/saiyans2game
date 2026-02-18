package com.kstoi.ui;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

public final class SaiyanSelectBox{
    private SaiyanSelectBox(){}
    public static <T> SelectBox of(Skin skin,List<T> selections,float x,float y){
        var selectBox = new SelectBox<T>(skin);
        selectBox.setX(x);
        selectBox.setY(y);
        Array<T> arr = new Array<>(selections.size());
        for(T selection : selections){
            arr.add(selection);
        }
        selectBox.setItems(arr);
        selectBox.setSize(200f, 25f);
        return selectBox;
    }
}
