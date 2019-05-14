package com.countgandi.com.game.map;

import java.awt.Graphics;

import com.countgandi.com.Assets;

public class SandTile extends Tile {
	
	private static boolean forward = false;
	
	public SandTile(int x, int y, int id) {
		super(x, y, id);
	}
	
	public static void tick() {
		if((MapHandler.tileTick % 40) == 39) {
			forward = !forward;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tiles[112 + (int)((MapHandler.tileTick % 80) / 10.0f)], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);

		if(forward) {
			g.drawImage(Assets.tiles[id + (int)((MapHandler.tileTick % 40) / 10.0f)], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
		} else {
			g.drawImage(Assets.tiles[id + 3 - (int)((MapHandler.tileTick % 40) / 10.0f)], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
		}
	}

}
