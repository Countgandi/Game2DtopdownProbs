package com.countgandi.com.game.entities.player;

import com.countgandi.com.game.Handler;

public class MartialArtsType extends PlayerType {

	public MartialArtsType(Handler handler) {
		super(4, handler);
	}
	
	@Override
	public void useItem(int attackTimer, Player p) {
		if (attackTimer == 19) {
			
		}
	}

}
