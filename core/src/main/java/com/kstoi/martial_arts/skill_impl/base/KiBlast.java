package com.kstoi.martial_arts.skill_impl.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.kstoi.martial_arts.Skill;
import com.kstoi.models.entities.Entity;

public class KiBlast extends Skill {
  private Entity source;

  public KiBlast(Entity source) {
    this.setCooldown(0.10f);
    this.setOnSelf(false);
    this.setKiCost(0f);
    this.setRequirement(0f);
    this.setName("ki blast");
    this.source = source;
  }

  @Override
  public SkillAnimation fireOnEntity(Entity target, float skillMultiplier) {
    return new KiBlastAnimation(source.pos, true, target);
  }

  @Override
  public SkillAnimation fireOnSelf(Entity target, float skillMultiplier) {
    throw new UnsupportedOperationException("Why are you hitting yourself");
  }

  private class KiBlastAnimation extends SkillAnimation {
    private Rectangle kiBlastPosition;
    private float Speed = 200f;
    private float duration = 1f;
    private float timePassed = 0f;
    private Entity target;

    public KiBlastAnimation(Rectangle position, boolean active, Entity target) {
      super(position, active);
      kiBlastPosition = new Rectangle();
      kiBlastPosition.x = position.x;
      kiBlastPosition.y = position.y;
      kiBlastPosition.width = 20f;
      kiBlastPosition.height = 20f;
      this.target = target;
    }

    @Override
    public void render(SpriteBatch batch) {
    }

    @Override
    public void shape(ShapeRenderer renderer) {
      renderer.setColor(Color.YELLOW);
      renderer.circle(kiBlastPosition.x, kiBlastPosition.y, kiBlastPosition.height);
    }

    @Override
    public void update(float delta) {

      float dirX = target.pos.x - kiBlastPosition.x;
      float dirY = target.pos.y - kiBlastPosition.y;

      float length = (float) Math.sqrt(dirX * dirX + dirY * dirY);

      if (length != 0) {
        dirX /= length;
        dirY /= length;
      }

      float speed = 600f; // adjust to taste

      kiBlastPosition.x += dirX * speed * delta;
      kiBlastPosition.y += dirY * speed * delta;
    }

    @Override
    public void stop() {
      this.timePassed += duration;
    }

    @Override
    public boolean ended() {
      return kiBlastPosition.overlaps(target.pos) || timePassed > duration;
    }

  }
}
