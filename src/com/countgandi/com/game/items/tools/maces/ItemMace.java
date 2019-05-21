package com.countgandi.com.game.items.tools.maces;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public class ItemMace extends ItemTool {

	public ItemMace(Handler handler) {
		super(new Animation(Assets.mace_anim, 10, 0, 3), Assets.items[8], handler);
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

}
