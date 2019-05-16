package com.countgandi.com.game.entities.objects;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.map.MapHandler;

public class Flower extends Foilage {

	public Flower(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flower1[(int) ((MapHandler.tileTick % 40) / 10.0f)], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
	}

}
