package com.countgandi.com.game.entities.objects;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;

public abstract class Foilage extends Entity {

	public Foilage(float x, float y, Handler handler) {
		super(x, y, handler);
	}
	
	@Override
	public boolean spawnIn() {
		for(Entity e: handler.entities) {
			if(e.getRectangle().intersects(this.getRectangle())) {
				return false;
			}
		}
		return true;
	}

}
