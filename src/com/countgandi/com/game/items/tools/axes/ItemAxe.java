package com.countgandi.com.game.items.tools.axes;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public class ItemAxe extends ItemTool {

	public ItemAxe(Handler handler) {
		super(new Animation(Assets.axe_anim, 10, 0, 2), Assets.items[1], handler);
	}

}
