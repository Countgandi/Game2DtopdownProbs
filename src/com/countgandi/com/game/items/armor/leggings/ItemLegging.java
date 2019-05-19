package com.countgandi.com.game.items.armor.leggings;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.armor.ItemArmor;
import com.countgandi.com.game.items.materials.Material;

public class ItemLegging extends ItemArmor {

	public ItemLegging(Material mat, BufferedImage icon, Handler handler) {
		super(mat, icon, handler);
		this.armor = 0.35f * mat.getStatMultiplier();
	}

}