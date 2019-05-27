package com.countgandi.com.game.items.tools.picks;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.game.renders.Animation;

public abstract class ItemPickaxe extends ItemTool {

	public ItemPickaxe(Animation anim, BufferedImage icon, Handler handler) {
		super(anim, icon, handler);
	}

}
