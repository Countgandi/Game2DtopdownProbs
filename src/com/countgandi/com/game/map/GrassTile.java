package com.countgandi.com.game.map;

import java.awt.Graphics;

import com.countgandi.com.Assets;

public class GrassTile  extends Tile {

	public GrassTile(int x, int y, int id) {
		super(x, y, id);
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tiles[id + (int)((MapHandler.tileTick % 40) / 10.0f)], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
	}

}