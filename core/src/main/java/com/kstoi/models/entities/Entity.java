package com.kstoi.models.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.kstoi.martial_arts.MartialArt;
import com.kstoi.martial_arts.Skill;
import com.kstoi.martial_arts.Skill.SkillAnimation;
import com.kstoi.martial_arts.skill_impl.base.Hit;
import com.kstoi.martial_arts.skill_impl.base.KiBlast;
import com.kstoi.martial_arts.skill_impl.base.Recharge;
import com.kstoi.services.TextureService;
import com.kstoi.stats.BaseStat;
import com.kstoi.stats.CharacterArchetypes;
import com.kstoi.stats.SkillStat;
import com.kstoi.items.Equipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * Entity
 */
@NoArgsConstructor
@ToString
@Setter
@Getter
public abstract class Entity implements Serializable {
    private String name;
    private BaseStat health;
    private BaseStat ki;
    private Map<String, SkillStat> stats;
    private String avatar;
    private List<String> customizations;
    private CharacterArchetypes archetype;
    public Rectangle pos;

    private MartialArt martialArt;
    private String factionName;

    private Equipment clothes;
    private Skill[] baseSkills = new Skill[]{new Hit(this),new Recharge(),new KiBlast(this)};

    public void render(SpriteBatch batch, BitmapFont font) {
        batch.draw(TextureService.getEntities().get(avatar), pos.x, pos.y, pos.width, pos.height);
        for (var c : this.customizations) {
            batch.draw(TextureService.getCustomization().get(c), pos.x, pos.y, pos.width, pos.height);
        }
        font.draw(batch, name, pos.x, pos.y);
        if(clothes!=null){
            clothes.renderOnEntity(batch,this.pos);
        }
    }

    public void move(float x,float y){
        this.pos.x+=x;
        this.pos.y+=y;
    }
    public SkillAnimation fireBaseSkill(int index,Entity target){
        if(index<=baseSkills.length && baseSkills[index] != null){
            var skill = baseSkills[index];
            if(skill.isOnSelf()){
                return skill.fireOnSelf(this, 1f);
            }else if(target != null){
                return skill.fireOnEntity(target, 1f);
            }
        }
        throw new RuntimeException("skill not yet implemented");
    }
    public void shape(ShapeRenderer renderer) {
        //TODO
        // renderer.setColor(Color.BLACK);
        // renderer.rect(pos.x, pos.y + 10, health.getMax(), 10);
        // renderer.setColor(Color.GREEN);
        // renderer.rect(pos.x, pos.y + 10, health.getCurrent(), 10);

        // renderer.setColor(Color.BLACK);
        // renderer.rect(pos.x, pos.y, ki.getMax(), 10);
        // renderer.setColor(Color.CYAN);
        // renderer.rect(pos.x, pos.y, ki.getCurrent(), 10);
    }
}
