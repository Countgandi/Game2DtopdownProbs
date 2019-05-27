package com.countgandi.com.game.entities.player;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.Camera;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.items.armor.boots.ItemIronBoots;
import com.countgandi.com.game.items.armor.chestplates.ItemIronChestplate;
import com.countgandi.com.game.items.armor.headpiece.ItemIronHelmet;
import com.countgandi.com.game.items.armor.leggings.ItemIronLegging;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.items.tools.axes.ItemStoneAxe;
import com.countgandi.com.game.items.tools.hoes.ItemStoneHoe;
import com.countgandi.com.game.items.tools.maces.ItemStoneMace;
import com.countgandi.com.game.items.tools.picks.ItemStonePickaxe;
import com.countgandi.com.game.items.tools.swords.ItemStoneSword;
import com.countgandi.com.game.items.trinkets.ItemTrinketSpeedRing;
import com.countgandi.com.game.map.MapHandler;
import com.countgandi.com.game.map.Tile;
import com.countgandi.com.game.map.WaterTile;
import com.countgandi.com.guis.inventory.InventoryGui;

public class Player extends Entity {

	public static ItemTool itemInHand;
	public boolean up, down, left, right, moving, movingud, startUsingItem, usingItem, inWater;
	private float speed = 4f;
	private int animNum, animation, animTimer, attackTimer;

	public Player(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
		Camera.x = x - (width * Handler.ZOOM / 2) - Game.WIDTH / 2;
		Camera.y = y - (height * Handler.ZOOM / 2) - Game.HEIGHT / 2;
		
		InventoryGui.addItem(new ItemIronBoots(handler));
		InventoryGui.addItem(new ItemIronLegging(handler));
		InventoryGui.addItem(new ItemIronChestplate(handler));
		InventoryGui.addItem(new ItemIronHelmet(handler));
		InventoryGui.addItem(new ItemTrinketSpeedRing(handler));
		InventoryGui.addItem(new ItemStoneSword(handler));
		InventoryGui.addItem(new ItemStoneMace(handler));
		InventoryGui.addItem(new ItemStonePickaxe(handler));
		InventoryGui.addItem(new ItemStoneAxe(handler));
		InventoryGui.addItem(new ItemStoneHoe(handler));
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if (inWater || itemInHand == null) {
			startUsingItem = false;
		}
		if (startUsingItem) {
			usingItem = true;
			animTimer = 0;
			animNum = 0;
			attackTimer = 0;
			startUsingItem = false;
		}

		if (usingItem) {
			velY = 0;
			velX = 0;
			attackTimer++;
			itemInHand.getAnimation().tick(animation * (itemInHand.getAnimation().getSize() / 2));
			if (attackTimer >= (itemInHand.getAnimation().getSize() / 2) * itemInHand.getAnimation().getTicksPerFrame()) {
				itemInHand.onUse();
				usingItem = false;
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
		if (usingItem) {
			g.drawImage(Assets.player_anim[animation], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);

			if (animation == 0) {
				g.drawImage(itemInHand.getAnimation().getCurrentFrame(), (int) x, (int) y - width * Handler.ZOOM, width * 2 * Handler.ZOOM, height * 2 * Handler.ZOOM, null);
			} else {
				g.drawImage(itemInHand.getAnimation().getCurrentFrame(), (int) x - width * Handler.ZOOM, (int) y - height * Handler.ZOOM, width * 2 * Handler.ZOOM, height * 2 * Handler.ZOOM, null);
			}
		} else if (inWater) {
			g.drawImage(Assets.player[animation * 2 + 4 + (MapHandler.tileTick % 20) / 10], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
		} else {
			g.drawImage(Assets.player[animation * 2 + animNum], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
		}
	}

	public int getAnimation() {
		return animation;
	}

	public void finishCheckingIntersection() {
		if (t != 0) {
			inWater = true;
			t = 0;
		} else {
			inWater = false;
		}
	}

}
