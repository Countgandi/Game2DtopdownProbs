package com.countgandi.com.game.entities;

import com.countgandi.com.game.Handler;

public abstract class Tree extends Entity {

	public Tree(float x, float y, int size, Handler handler) {
		super(x, y, handler);
		width = size;
		height = width;
		for(int i = 0; i < handler.entities.size(); i++) {
			if(handler.entities.get(i).getRectangle().intersects(this.getRectangle())) {
				handler.removeEntity(this);
			}
		}
	}

	@Override
	public void tick() {
		
	}

}
