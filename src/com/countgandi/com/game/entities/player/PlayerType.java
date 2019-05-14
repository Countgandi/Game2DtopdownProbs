package com.countgandi.com.game.entities.player;

import com.countgandi.com.game.Handler;

public abstract class PlayerType {
	
	protected int spriteOffset = 0;
	protected Handler handler;
	
	public PlayerType(int spriteOffset, Handler handler) {
		this.spriteOffset = spriteOffset * 12;
		this.handler = handler;
	}
	
	public abstract void useItem(int attackTimer, Player p);

	public int getSpriteOffset() {
		return spriteOffset;
	}
}
