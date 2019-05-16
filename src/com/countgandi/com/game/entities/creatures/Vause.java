package com.countgandi.com.game.entities.creatures;

import java.awt.Graphics;
import java.util.Random;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.renders.Animation;

public class Vause extends Creature {

	private static Random ran = new Random();
	private Animation walk;
	private int walkTimer = 160;

	public Vause(float x, float y, Handler handler) {
		super(x, y, handler);
		width = 8;
		height = 8;
		walk = new Animation(Assets.vause, 10, 0, 2);
	}

	@Override
	public void etick() {
		x += velX;
		y += velY;
		if (velX < 0) {
			walk.tick(2);
		} else if (velX > 0) {
			walk.tick(0);
		}
		if(walkTimer >= 180) {
			//starts walking again
			double direction = Math.toRadians(ran.nextInt(360));
			velX = (float) Math.sin(direction);
			velY = (float) Math.cos(direction);
			
			walkTimer = 0;
		} else if (walkTimer >= 120){
			velX = 0;
			velY = 0;
			walk.resetAnimation();
		}
		walkTimer ++;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(walk.getCurrentFrame(), (int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM, null);
	}

}
