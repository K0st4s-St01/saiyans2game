package com.kstoi.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.services.TextureService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class Item implements Serializable{
    private String texture;
    public Rectangle pos;

    public void render(SpriteBatch batch){
        batch.draw(TextureService.getItems().get(texture), pos.x,pos.y, pos.width, pos.height);

    }
    public void renderOnEntity(SpriteBatch batch,Rectangle target){
        batch.draw(TextureService.getItems().get(texture), target.x, target.y,target.width,target.height);
    }
    public void shape(ShapeRenderer renderer){
        renderer.setColor(Color.DARK_GRAY);
        renderer.rect(pos.x, pos.y, pos.width,pos.height);
    }
}
