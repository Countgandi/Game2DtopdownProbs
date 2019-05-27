package com.countgandi.com.game.items.tools.axes;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public abstract class ItemAxe extends ItemTool {

	public ItemAxe(Animation anim, BufferedImage img, Handler handler) {
		super(anim, img, handler);
	}

}
