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
  private Map<String, List<SkillAnimation>> skills = new TreeMap<>();

  // sourceName for handling duplicate inputs
  public void addSkillAnimation(String sourceName, SkillAnimation animation) {
    if(skills.containsKey(sourceName)){
      skills.get(sourceName).add(animation);
    }else{
      skills.put(sourceName,new ArrayList<SkillAnimation>());
      skills.get(sourceName).add(animation);
    }
  }

  public void stopOnSelf(String sourceName) {
    if (skills.containsKey(sourceName))
      skills.remove(sourceName);
  }

  public void render(SpriteBatch batch) {
    for (var an : skills.values()) {
      if (an != null) {
        an.forEach(animation -> animation.render(batch));
      }
    }
  }

  public void shapes(ShapeRenderer shapeRenderer) {
    for (var an : skills.values()) {
      if (an != null) {
        an.forEach(animation -> animation.shape(shapeRenderer));
      }
    }
  }

  public void update(float delta) {
    var iterator = skills.entrySet().iterator();

    while (iterator.hasNext()) {
      var entry = iterator.next();
      entry.getValue().removeIf(animation -> {
        if (animation == null || animation.ended()) {
          return true;
        } else {
          animation.update(delta);
          return false;
        }
      });

    }
  }

}
