package com.countgandi.com.game.entities.objects;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;

public class Rock extends Foilage {

	public Rock(float x, float y, Handler handler) {
		super(x, y, handler);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock1, (int)x, (int)y, width * Handler.ZOOM, height * Handler.ZOOM, null);
	}

}
