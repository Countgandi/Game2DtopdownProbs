package com.countgandi.com.game.entities.creatures;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;

public abstract class Creature extends Entity {

	public Creature(float x, float y, Handler handler) {
		super(x, y, handler);
	}
	
	@Override
	public void tick() {
		
		etick();
	}
	
	public abstract void etick();

}
