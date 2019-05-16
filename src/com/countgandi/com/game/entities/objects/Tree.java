package com.countgandi.com.game.entities.objects;

import com.countgandi.com.game.Handler;

public abstract class Tree extends Foilage {

	public Tree(float x, float y, int size, Handler handler) {
		super(x, y, handler);
		width = size;
		height = width;
		
	}

	@Override
	public void tick() {
		
	}

}
