package com.countgandi.com.game.items.tools.maces;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.renders.Animation;

public class ItemStoneMace extends ItemMace {

	public ItemStoneMace(Handler handler) {
		super(new Animation(Assets.mace_anim, 10, 0, 3), Assets.items[8], handler);
	}

}
