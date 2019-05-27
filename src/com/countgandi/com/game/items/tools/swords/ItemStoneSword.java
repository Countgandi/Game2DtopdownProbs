package com.countgandi.com.game.items.tools.swords;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.renders.Animation;

public class ItemStoneSword extends ItemSword {

	public ItemStoneSword(Handler handler) {
		super(new Animation(Assets.sword_anim, 10, 0, 2), Assets.items[4], handler);
	}

}
