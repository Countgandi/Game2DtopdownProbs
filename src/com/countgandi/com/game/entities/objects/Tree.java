package com.countgandi.com.game.entities.objects;

import com.countgandi.com.game.Handler;

public abstract class Tree extends Foilage {
	
	protected float timer = 0, dir = 0.08f;

	public Tree(float x, float y, int size, Handler handler) {
		super(x, y, handler);
		width = size;
		height = width;
		
	}

	@Override
	public void tick() {
		timer += dir;
		if(timer > 5.5f || timer < 0) {
			dir = -dir;
		}
	}

}
