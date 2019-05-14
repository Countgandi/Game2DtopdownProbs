package com.countgandi.com.game.map;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;

public class Tile {
	
	public static final int tileWidth = Assets.tiles[0].getWidth() * Handler.ZOOM, tileHeight = Assets.tiles[0].getHeight() * Handler.ZOOM;

	protected Rectangle rectangle;
	protected int id;
	
	public Tile(int x, int y, int id) {
		rectangle = new Rectangle(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
		this.id = id;
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.tiles[id], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public int getId() {
		return id;
	}

}
