package com.countgandi.com.game.map;

import java.awt.Graphics;

import com.countgandi.com.Assets;

public class WaterTile extends Tile {
	
	public boolean isDeepOcean = true;

	public WaterTile(int x, int y, boolean isShore, boolean deepShore) {
		super(x, y, 8);
		if (isShore) {
			if (deepShore) {
				id = 120;
			} else {
				id = 112;
			}
			isDeepOcean = false;
		} else {
			id = 8;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tiles[id + (int) ((MapHandler.tileTick % 80) / 10.0f)], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
	}

}
