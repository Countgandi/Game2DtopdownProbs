package com.countgandi.com.game.items.tools.hoes;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public abstract class ItemHoe extends ItemTool {

	public ItemHoe(Animation anim, BufferedImage img, Handler handler) {
		super(anim, img, handler);
	}

}
