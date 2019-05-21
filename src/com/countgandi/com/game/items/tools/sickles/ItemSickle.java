package com.countgandi.com.game.items.tools.sickles;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public class ItemSickle extends ItemTool {

	public ItemSickle(BufferedImage icon, Handler handler) {
		super(new Animation(null, 0, 0, 0), icon, handler);
	}

}
