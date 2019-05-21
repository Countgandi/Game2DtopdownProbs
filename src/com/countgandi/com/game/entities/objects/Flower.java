package com.countgandi.com.game.entities.objects;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;

public class Flower extends Foilage {

	public Flower(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
	}

	@Override
	public void tick() {
		tt += 0.05;
		
		tt %= 4;
	}
	private float tt;

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flower1[(int) tt], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
	}

}
