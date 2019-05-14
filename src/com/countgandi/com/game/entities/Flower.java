package com.countgandi.com.game.entities;

import java.awt.Graphics;
import java.util.Random;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.creatures.Shriel;
import com.countgandi.com.game.entities.creatures.Vause;
import com.countgandi.com.game.map.MapHandler;

public class Flower extends Entity {

	public Flower(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
		for(int i = 0; i < handler.entities.size(); i++) {
			if(handler.entities.get(i).getRectangle().intersects(this.getRectangle())) {
				handler.removeEntity(this);
			}
		}
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flower1[(int) ((MapHandler.tileTick % 40) / 10.0f)], (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
	}

}
