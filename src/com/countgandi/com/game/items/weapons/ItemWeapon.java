package com.countgandi.com.game.items.weapons;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;

public abstract class ItemWeapon extends Item {

	public ItemWeapon(BufferedImage icon, Handler handler) {
		super(icon, handler);
	}

}
