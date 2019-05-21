package com.countgandi.com.game.items.tools.swords;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public class ItemSword extends ItemTool {

	public ItemSword(Handler handler) {
		super(new Animation(Assets.sword_anim, 10, 0, 2), Assets.items[4], handler);
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

}
