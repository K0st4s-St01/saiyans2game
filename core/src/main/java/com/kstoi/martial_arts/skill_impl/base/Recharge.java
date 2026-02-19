package com.kstoi.martial_arts.skill_impl.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.martial_arts.Skill;
import com.kstoi.models.entities.Entity;
import com.kstoi.services.TextureService;

public class Recharge extends Skill {

  public Recharge() {
    setName("recharge");
    setRequirement(0f);
    setKiCost(0f);
    setOnSelf(true);
  }

  @Override
  public SkillAnimation fireOnEntity(Entity target, float skillMultiplier) {
    throw new RuntimeException(this.toString() + " fires on self");
  }

  @Override
  public SkillAnimation fireOnSelf(Entity target, float skillMultiplier) {
    return new RechargeAnimation(target.pos,true);
  }


  private static class RechargeAnimation extends SkillAnimation {
    private Color tint = Color.WHITE;
    public RechargeAnimation(Rectangle position, boolean active) {
      super(position, active);
    }

    private String[] aura = new String[]{
      "aura_0001",
      "aura_0002",
      "aura_0003"
    };
    @Override
    public void render(SpriteBatch batch) {
      var sprite = TextureService.getAnimations().get(aura[(int) (System.currentTimeMillis()%3)]);
      sprite.setColor(tint);
      batch.draw(sprite,super.position.x,super.position.y,super.position.width,super.position.height);
    }

    @Override
    public void shape(ShapeRenderer renderer) {
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public boolean ended() {
      return !isActive();
    }

	@Override
	public void stop() {
	  this.setActive(false);
	}
  }

}
