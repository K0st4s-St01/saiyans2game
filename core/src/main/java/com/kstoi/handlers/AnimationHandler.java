package com.kstoi.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kstoi.martial_arts.Skill.SkillAnimation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnimationHandler {
  private Map<String, SkillAnimation> skills = new TreeMap<>();

  // sourceName for handling duplicate inputs
  public void addSkillAnimation(String sourceName, SkillAnimation animation) {
    skills.put(sourceName, animation);
  }

  public void stopOnSelf(String sourceName) {
    if (skills.containsKey(sourceName))
      skills.remove(sourceName);
  }

  public void render(SpriteBatch batch) {
    for (SkillAnimation an : skills.values()) {
      if (an != null && !an.ended()) {
        an.render(batch);
      }
    }
  }

  public void shapes(ShapeRenderer shapeRenderer) {
    for (SkillAnimation an : skills.values()) {
      if (an != null && !an.ended()) {
        an.shape(shapeRenderer);
      }
    }
  }

  public void update(float delta) {
    var iterator = skills.entrySet().iterator();

    while (iterator.hasNext()) {
      var entry = iterator.next();
      SkillAnimation animation = entry.getValue();

      if (animation == null || animation.ended()) {
        iterator.remove();
      } else {
        animation.update(delta);
      }
    }
  }

}
