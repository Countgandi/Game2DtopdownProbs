package com.countgandi.com.game.entities.player;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.Camera;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.map.MapHandler;
import com.countgandi.com.game.map.Tile;
import com.countgandi.com.game.map.WaterTile;

public class Player extends Entity {

	public boolean up, down, left, right, moving, movingud, startAttack, attacking, inWater;
	private float speed = 4f;
	private int animNum, animation, animTimer, attackTimer;
	public Item inHand;
	private PlayerType type;

	public Player(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
		Camera.x = x - (width * Handler.ZOOM / 2) - Game.WIDTH / 2;
		Camera.y = y - (height * Handler.ZOOM / 2) - Game.HEIGHT / 2;
		type = new MartialArtsType(handler);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if (inWater) {
			startAttack = false;
		}
		if (startAttack) {
			attacking = true;
			animTimer = 0;
			animNum = 0;
			attackTimer = 0;
			startAttack = false;
		}

		if (attacking) {
			velY = 0;
			velX = 0;
			attackTimer++;
			type.useItem(attackTimer, this);
			if (attackTimer >= 20) {
				attacking = false;
				attackTimer = 0;
			}
		} else {
			if (up && !down) {
				movingud = true;
				velY = -speed;
			} else if (!down) {
				movingud = false;
				velY = 0;
			}
			if (down && !up) {
				movingud = true;
				velY = speed;
			} else if (!up) {
				movingud = false;
				velY = 0;
			}
			if (left && !right) {
				moving = true;
				animation = 1;
				velX = -speed;
			} else if (!right) {
				moving = false;
				velX = 0;
			}
			if (right && !left) {
				moving = true;
				animation = 0;
				velX = speed;
			} else if (!left) {
				moving = false;
				velX = 0;
			}
			animation();
		}
	}

	private void animation() {
		if (moving || movingud) {
			if (animTimer >= 8) {
				animNum++;
				if (animNum >= 2) {
					animNum = 0;
				}
				animTimer = 0;
			}
			animTimer++;
		} else {
			animTimer = 0;
			animNum = 0;
		}
	}

	int t = 0;
	public void checkIntersection(Tile tile) {
		if (tile.getRectangle().intersects(getRectangle())) {
			if (tile instanceof WaterTile) {
				t++;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (attacking) {
			g.drawImage(Assets.player[type.getSpriteOffset() + 4 + animation * 2 + attackTimer / 10], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
		} else if (inWater) {
			g.drawImage(Assets.player[type.getSpriteOffset() + animation * 2 + 8 + (MapHandler.tileTick % 20) / 10], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
		} else {
			g.drawImage(Assets.player[type.getSpriteOffset() + animation * 2 + animNum], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
		}
	}

	public int getAnimation() {
		return animation;
	}

	public void finishCheckingIntersection() {
		if(t != 0) {
			inWater = true;
			t = 0;
		} else {
			inWater = false;
		}
	}

}
