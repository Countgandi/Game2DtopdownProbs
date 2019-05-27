package com.countgandi.com.game.items.tools.swords;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public abstract class ItemSword extends ItemTool {

	public ItemSword(Animation anim, BufferedImage icon, Handler handler) {
		super(anim, icon, handler);
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

}
