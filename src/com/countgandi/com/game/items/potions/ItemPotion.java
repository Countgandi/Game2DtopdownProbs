package com.countgandi.com.game.items.potions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;

public class ItemPotion extends Item {

	public ItemPotion(BufferedImage icon, Handler handler) {
		super(icon, handler);
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

}
