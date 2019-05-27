package com.countgandi.com.game.items.tools.hoes;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.renders.Animation;

public class ItemStoneHoe extends ItemHoe {

	public ItemStoneHoe(Handler handler) {
		super(new Animation(Assets.hoe_anim, 10, 0, 2), Assets.items[2], handler);
	}

}
