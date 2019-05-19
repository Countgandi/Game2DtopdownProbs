package com.countgandi.com.game.items.armor;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.materials.Material;

public class ItemBoot extends ItemArmor {

	public ItemBoot(Material mat, BufferedImage icon, Handler handler) {
		super(mat, icon, handler);
		this.armor = 0.15f * mat.getStatMultiplier();
	}

}
