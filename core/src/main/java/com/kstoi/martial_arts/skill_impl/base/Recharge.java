package com.kstoi.martial_arts.skill_impl.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.martial_arts.Skill;
import com.kstoi.models.entities.Entity;


public class Recharge extends Skill {
    private float changePerDelta = 1f;
    public Recharge(){
        setName("recharge");
        setRequirement(0f);
        setKiCost(0f);
        setOnSelf(false);
    }
    @Override
    public SkillAnimation fireOnEntity(Entity target, float skillMultiplier) {
        throw new RuntimeException(this.toString()+" fires on self");
    }

    @Override
    public SkillAnimation fireOnSelf(Entity target, float skillMultiplier) {
        return new RechargeAnimation(target.pos);
    }

    @Override
    public boolean ended() {
    }

    private static class RechargeAnimation extends SkillAnimation {
        public RechargeAnimation(Rectangle position) {
            super(position);

        }

        @Override
        public void render(SpriteBatch batch) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'render'");
        }

        @Override
        public void shape(ShapeRenderer renderer) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'shape'");
        }

        @Override
        public void update(float delta) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'update'");
        }
    }

}
