package com.countgandi.com;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {
	
	public static BufferedImage[] items = loadImageSheet(8, 8, "/items.png");
	public static BufferedImage[] tiles = loadImageSheet(16, 16, "/tileset.png");
	public static BufferedImage[] player = loadImageSheet(8, 8, "/entities/player/players.png");
	public static BufferedImage[] flower1 = loadImageSheet(8, 8, "/entities/objects/foilage/flower1.png");
	public static BufferedImage[] vause = loadImageSheet(8, 8, "/entities/creatures/vause.png");
	public static BufferedImage[] shriel = loadImageSheet(8, 8, "/entities/creatures/shriel.png");
	public static BufferedImage tree1 = loadImage("/entities/objects/trees/tree3.png");
	public static BufferedImage tree2 = loadImage("/entities/objects/trees/tree6.png");
	public static BufferedImage rock1 = loadImage("/entities/objects/rocks/rock1.png");
	
	
	public static BufferedImage inventoryGui = loadImage("/guis/inventory.png");
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Assets.class.getResource("/tex" + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage[] loadImageSheet(int tx, int ty, String path) {
		BufferedImage img = loadImage(path);
		BufferedImage[] imgs = new BufferedImage[(img.getWidth() / tx) * (img.getHeight() / ty)];
		int id = 0;
		for(int y = 0; y < img.getHeight(); y += ty) {
			for(int x = 0; x < img.getWidth(); x += tx) {
				imgs[id] = img.getSubimage(x, y, tx, ty);
				id++;
			}
		}
		return imgs;
	}
	
	public static BufferedImage[] loadImageSheet(int tx, int ty, BufferedImage img) {
		BufferedImage[] imgs = new BufferedImage[(img.getWidth() / tx) * (img.getHeight() / ty)];
		int id = 0;
		for(int y = 0; y < img.getHeight(); y += ty) {
			for(int x = 0; x < img.getWidth(); x += tx) {
				imgs[id] = img.getSubimage(x, y, tx, ty);
				id++;
			}
		}
		return imgs;
	}
	
	public static BufferedImage changeColors(int color, BufferedImage img) {
		BufferedImage nimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				nimg.setRGB(x, y, color * img.getRGB(x, y));
			}
		}
		return nimg;
	}

}
