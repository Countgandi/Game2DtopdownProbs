package com.countgandi.com.game.items.tools.picks;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public class ItemPickaxe extends ItemTool {

	public ItemPickaxe(Handler handler) {
		super(new Animation(Assets.pickaxe_anim, 10, 0, 2), Assets.items[0], handler);
	}

}
