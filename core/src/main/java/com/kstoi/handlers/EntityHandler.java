package com.kstoi.handlers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.models.entities.Entity;

import lombok.Getter;

@Getter
public class EntityHandler {
  private List<Entity> entities = new ArrayList<>();
  private final AnimationHandler animationHandler;
  private static final DistanceComparator distComp = new DistanceComparator();

  public EntityHandler(AnimationHandler animationHandler) {
    this.animationHandler = animationHandler;
  }

  public void render(SpriteBatch batch, BitmapFont font) {
    for (var e : entities) {
      e.render(batch, font);
    }

  }

  public void shapes(ShapeRenderer renderer) {
    for (var e : entities) {
      e.shape(renderer);
    }
  }

  public void update(float delta) {
    entities.removeIf(e -> e.getHealth().getCurrent() <= 0.001f);

  }

  public Entity closestTarget(Rectangle position) {
    if(entities.isEmpty()){
      return null;
    }
    distComp.setPosition(position);
    entities.sort(EntityHandler.distComp);
    return entities.get(0);
  }

  private static class DistanceComparator implements Comparator<Entity> {
    private Rectangle position;

    public void setPosition(Rectangle position) {
      this.position = position;
    }

    @Override
    public int compare(Entity arg0, Entity arg1) {
      var p0 = arg0.pos;
      var p1 = arg1.pos;
      double x0 = position.x - p0.x;
      double y0 = position.y - p0.y;
      double x1 = position.x - p1.x;
      double y1 = position.y - p1.y;
      return Double.compare(Math.hypot(x0, y0), Math.hypot(x1, y1));
    }
  }
}
