package com.kstoi.martial_arts;

import java.io.Serializable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.models.entities.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Skill implements Serializable {
    private String name;
    private float requirement;
    private float kiCost;
    private boolean onSelf;
    private float cooldown;

    public abstract SkillAnimation fireOnEntity(Entity target, float skillMultiplier);
    public abstract SkillAnimation fireOnSelf(Entity target, float skillMultiplier);

    @AllArgsConstructor
    @Setter
    @Getter
    public static abstract class SkillAnimation {
        public Rectangle position;
        private boolean active = false;

        public abstract void render(SpriteBatch batch);

        public abstract void shape(ShapeRenderer renderer);

        public abstract void update(float delta);
        public abstract void stop();
        public abstract boolean ended();
    }
}
