package com.kstoi.handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.kstoi.martial_arts.Skill.SkillAnimation;
import com.kstoi.models.entities.Entity;
import com.kstoi.models.player.Player;
import com.kstoi.utils.*;
import com.sun.source.tree.CaseTree.CaseKind;

import lombok.Getter;

@Getter
public class PlayerHandler implements InputProcessor {
	private Player player;
	private Vector2 movement = new Vector2();
	private AnimationHandler animationHandler;
	private final EntityHandler entityHandler;

	public PlayerHandler(CharacterCreationData data, AnimationHandler animationHandler, EntityHandler entityHandler) {
		player = CreatePlayer.of(data);
		this.animationHandler = animationHandler;
		this.entityHandler = entityHandler;
	}

	@Override
	public boolean keyDown(int keycode) {
		SkillAnimation animation = null;
		Entity target = entityHandler.closestTarget(player.entity.pos);
		switch (keycode) {
			case Keys.A:
				movement.x = -300f;
				break;
			case Keys.D:
				movement.x = 300f;
				break;
			case Keys.W:
				movement.y = 300f;
				break;
			case Keys.S:
				movement.y = -300f;
				break;
			case Keys.SPACE:
				animation = player.entity.fireBaseSkill(1, null);
				animation.setActive(true);
				animationHandler.addSkillAnimation(player.entity.getName(), animation);
				break;
			case Keys.Z:
				if (target != null) {
					animation = player.entity.fireBaseSkill(0, target);
					animation.setActive(true);
					animationHandler.addSkillAnimation(player.entity.getName(), animation);
				}
				break;
			case Keys.X:
				if (target != null) {
					animation = player.entity.fireBaseSkill(2, target);
					animation.setActive(true);
					animationHandler.addSkillAnimation(player.entity.getName() + "kiBlast", animation);
				}
				break;
			default:
				return true;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Keys.SPACE:
				animationHandler.stopOnSelf(player.entity.getName());
				break;
			case Keys.A:
				this.movement.x = 0;
				break;
			case Keys.D:
				this.movement.x = 0;
				break;
			case Keys.W:
				this.movement.y = 0;
				break;
			case Keys.S:
				this.movement.y = 0;
				break;
			default:
				return true;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return true;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return true;
	}

	public void render(SpriteBatch batch, BitmapFont font) {
		player.entity.render(batch, font);
	}

	public void shapes(ShapeRenderer renderer) {
		player.entity.shape(renderer);
	}

	public void update(float delta) {
		player.entity.move(movement.x * delta, movement.y * delta);

	}

	public Vector3 updateCamera() {
		var v = new Vector3(player.entity.pos.x, player.entity.pos.y, 1f);
		return v;
	}

}
