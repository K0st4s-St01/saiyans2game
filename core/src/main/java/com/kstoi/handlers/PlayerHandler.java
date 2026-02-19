package com.kstoi.handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.kstoi.models.player.Player;
import com.kstoi.utils.*;

import lombok.Getter;

@Getter
public class PlayerHandler implements InputProcessor {
	private Player player;
	private Vector2 movement = null;
	private boolean moving = false;
	private AnimationHandler animationHandler;

	public PlayerHandler(CharacterCreationData data, AnimationHandler animationHandler) {
		player = CreatePlayer.of(data);
		this.animationHandler = animationHandler;
	}

	@Override
	public boolean keyDown(int keycode) {
		movement = new Vector2();
		switch (keycode) {
			case Keys.A:
				moving = true;
				movement.x = 100f;
				break;
			case Keys.D:
				moving = true;
				movement.x = -100f;
				break;
			case Keys.W:
				moving = true;
				movement.y = 100f;
				break;
			case Keys.S:
				moving = true;
				movement.y = -100f;
				break;
			case Keys.SPACE:
				var animation = player.entity.fireBaseSkill(1, null);
				animation.setActive(true);
				animationHandler.addSkillAnimation(player.entity.getName(), animation);
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
			case Keys.A, Keys.D, Keys.W, Keys.S:
				moving = false;
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
		if (moving)
			player.entity.move(movement.x * delta, movement.y * delta);

	}

	public Vector3 updateCamera() {
		var v = new Vector3(player.entity.pos.x, player.entity.pos.y, 1f);
		return v;
	}

}
