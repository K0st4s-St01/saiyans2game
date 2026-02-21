package com.kstoi.martial_arts.skill_impl.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.martial_arts.Skill;
import com.kstoi.models.entities.Entity;

import lombok.ToString;

public class Hit extends Skill {
  private Entity source;

  public Hit(Entity source) {
    this.setCooldown(0.10f);
    this.setOnSelf(false);
    this.setKiCost(0f);
    this.setRequirement(0f);
    this.setName("Hit");
    this.source = source;
  }

  @Override
  public SkillAnimation fireOnEntity(Entity target, float skillMultiplier) {
    return new HitAnimation(
      source.pos,
       true,
       target,
       (float) (20f * skillMultiplier * Math.log(source.getStats().get("agility").getCurrent())),
      source.getStats().get("strength").getCurrent());
  }

  @Override
  public SkillAnimation fireOnSelf(Entity target, float skillMultiplier) {
    throw new RuntimeException("why are you hitting yourserlf");
  }

  @ToString
  private class HitAnimation extends SkillAnimation {
    private float duration = 0.15f;
    private float timePassed = 0f;
    private float len;
    private Entity target;
    private float dirX, dirY;
    private float x, y;
    private float range;
    private float damage;
    private boolean hit = false;

    public HitAnimation(Rectangle position, boolean active, Entity target, float range , float dmgMultiplier) {
      super(position, active);
      this.range = range;
      this.target = target;
      float dx = target.pos.x + target.pos.width / 2f - (position.x + position.width / 2f);
      float dy = target.pos.y + target.pos.height / 2f - (position.y + position.height / 2f);
      float len = (float) Math.sqrt(dx * dx + dy * dy);
      System.out.println(dx + " " + dy);
      System.out.println(len);
      if (len != 0) {
        this.dirX = dx / len;
        this.dirY = dy / len;
      }

      // Spawn position = edge of rectangle
      if (this.dirX > 0) { // right
        x = position.x + position.width;
        y = position.y + position.height / 2f;
      } else if (this.dirX < 0) { // left
        x = position.x;
        y = position.y + position.height / 2f;
      } else if (this.dirY > 0) { // up
        x = position.x + position.width / 2f;
        y = position.y + position.height;
      } else { // down
        x = position.x + position.width / 2f;
        y = position.y;
      }
      this.damage=(float) (30+Math.log10(dmgMultiplier));
    }

    @Override
    public void render(SpriteBatch batch) {
    }

    @Override
    public void shape(ShapeRenderer renderer) {

      float progress = timePassed / duration;
      progress = 1 - (1 - progress) * (1 - progress); // ease-out

      float length = range * progress;
      float alpha = 1f - progress;

      renderer.setColor(1f, 1f, 1f, alpha);

      if (target.pos.contains(x + dirX * length, y + dirY * length)) {
        renderer.setColor(1f, 0f, 0f, alpha);
        renderer.circle(
            x + dirX * length,
            y + dirY * length,
            10f);
          if(!hit)
            target.getHealth().add(-damage);
          hit = true;
          System.out.println(target.getHealth()+"  "+damage);
      }
      // Draw a stretched impact line
      renderer.rectLine(
          x,
          y,
          x + dirX * length,
          y + dirY * length,
          5f);
    }

    @Override
    public void update(float delta) {
      timePassed += delta;
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean ended() {
      return timePassed >= duration;
    }

  }
}
