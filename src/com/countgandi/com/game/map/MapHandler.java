package com.countgandi.com.game.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.Camera;
import com.countgandi.com.game.Handler;

public class MapHandler {

	public static int tileTick = 0;

	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public static int MapSizeX = 0, MapSizeY = 0;

	public void tick(Handler handler) {

		for (int x = (int) Math.round(Camera.x / Tile.tileWidth) - 1; x < (int) Math.round(Camera.x / Tile.tileWidth + Camera.getRectangle().getWidth() / Tile.tileWidth) + 1; x++) {
			for (int y = (int) Math.round(Camera.y / Tile.tileHeight) - 1; y < (int) Math.round(Camera.y / Tile.tileHeight + Camera.getRectangle().getHeight() / Tile.tileHeight) + 1; y++) {
				int num = (int) Math.round(y * MapSizeX + x);
				if (num < tiles.size() && num >= 0) {
					handler.getPlayer().checkIntersection(tiles.get(num));
				}
			}
		}
		handler.getPlayer().finishCheckingIntersection();
		SandTile.tick();
		tileTick++;
	}

	public void render(Graphics g) {
		for (int x = (int) Math.round(Camera.x / Tile.tileWidth) - 1; x < (int) Math.round(Camera.x / Tile.tileWidth + Camera.getRectangle().getWidth() / Tile.tileWidth) + 1; x++) {
			for (int y = (int) Math.round(Camera.y / Tile.tileHeight) - 1; y < (int) Math.round(Camera.y / Tile.tileHeight + Camera.getRectangle().getHeight() / Tile.tileHeight) + 1; y++) {
				int num = (int) Math.round(y * MapSizeX + x);
				if (num < tiles.size() && num >= 0) {
					tiles.get(num).render(g);
				}
			}
		}
	}

	public void loadMap(int lvl, Handler handler) {
		BufferedImage img = Assets.loadImage("/maps/" + lvl + "/mapImage.png");
		MapSizeX = img.getWidth();
		MapSizeY = img.getHeight();

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				tiles.add(getTileFromColor(x, y, img.getRGB(x, y), handler, true));
			}
		}

	}

	private Tile getTileFromColor(int x, int y, int color, Handler handler, boolean withPlayer) {
		Tile tile = null;
		if (color == 0xFF9F411E) {
			// Grass
			tile = (new GrassTile(x, y, 0));
		} else if (color == 0xFF00AAFF) {
			// Water
			tile = (new WaterTile(x, y, false, false));
		} else if (color == 0xFF3587B4) {
			// Water Shore
			tile = (new WaterTile(x, y, true, false));
		} else if (color == 0xFF359F24 || color == 0xFF35AADC || color == 0xFF358F84 || color == 0xFF359B3C || color == 0xFF35936C || color == 0xFF35B694 || color == 0xFF358B9C || color == 0xFF35AEC4 || color == 0xFF35A6F4 || color == 0xFF359754 || color == 0xFF35B2AC || color == 0xFF35A30C) {
			tile = (new WaterTile(x, y, true, true));
		} else if (color == 0xFF000000) {
			tile = (new GrassTile(x, y, 0));
			if (withPlayer) {
				handler.getPlayer().setX(x * Tile.tileWidth);
				handler.getPlayer().setY(y * Tile.tileHeight);
				Camera.x = handler.getPlayer().getX() - Game.WIDTH / 2 - handler.getPlayer().getWidth() / 2;
				Camera.y = handler.getPlayer().getY() - Game.HEIGHT / 2 - handler.getPlayer().getHeight() / 2;
			}
		} else if (color == 0xFF6A6469) {
			// Sand
			tile = (new Tile(x, y, 4));
		} else if (color == 0xFF9F6FFE) {
			// grass top left corner
			tile = (new GrassTile(x, y, 16));
		} else if (color == 0xFF9F6C16) {
			// grass top right corner
			tile = (new GrassTile(x, y, 20));
		} else if (color == 0xFF9F6446) {
			// grass bottom left corner
			tile = (new GrassTile(x, y, 24));
		} else if (color == 0xFF9F682E) {
			// grass bottom right corner
			tile = (new GrassTile(x, y, 28));
		} else if (color == 0xFF9F605E) {
			// grass right
			tile = (new GrassTile(x, y, 32));
		} else if (color == 0xFF9F588E) {
			// grass left
			tile = (new GrassTile(x, y, 36));
		} else if (color == 0xFF9F5C76) {
			// grass top
			tile = (new GrassTile(x, y, 40));
		} else if (color == 0xFF9F54A6) {
			// grass bottom
			tile = (new GrassTile(x, y, 44));

		} else if (color == 0xFF9F50BE) {
			// grass top right
			tile = (new GrassTile(x, y, 48));
		} else if (color == 0xFF9F4CD6) {
			// grass top left
			tile = (new GrassTile(x, y, 52));
		} else if (color == 0xFF9F4506) {
			// grass bottom right
			tile = (new GrassTile(x, y, 56));
		} else if (color == 0xFF9F48EE) {
			// grass bottom left
			tile = (new GrassTile(x, y, 60));

		} else if (color == 0xFF6A9349) {
			// sand top left corner
			tile = (new SandTile(x, y, 64));
		} else if (color == 0xFF6A8F61) {
			// sand top right corner
			tile = (new SandTile(x, y, 68));
		} else if (color == 0xFF6A8791) {
			// sand bottom left corner
			tile = (new SandTile(x, y, 72));
		} else if (color == 0xFF6A8B79) {
			// sand bottom right corner
			tile = (new SandTile(x, y, 76));
		} else if (color == 0xFF6A7FC1) {
			// sand bottom
			tile = (new SandTile(x, y, 80));
		} else if (color == 0xFF6A77F1) {
			// sand top
			tile = (new SandTile(x, y, 84));
		} else if (color == 0xFF6A83A9) {
			// sand left
			tile = (new SandTile(x, y, 88));
		} else if (color == 0xFF6A7BD9) {
			// sand right
			tile = (new SandTile(x, y, 92));
		} else if (color == 0xFF6A6851) {
			// sand top left
			tile = (new SandTile(x, y, 96));
		} else if (color == 0xFF6A6C39) {
			// sand top right
			tile = (new SandTile(x, y, 100));
		} else if (color == 0xFF6A7409) {
			// sand bottom left
			tile = (new SandTile(x, y, 104));
		} else if (color == 0xFF6A7021) {
			// sand bottom right
			tile = (new SandTile(x, y, 108));

		} else {
			tile = (new GrassTile(x, y, 0));
		}
		return tile;
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
}
