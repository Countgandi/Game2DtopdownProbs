package com.countgandi.com.game.items.armor.boots;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.armor.ItemArmor;
import com.countgandi.com.game.items.materials.Material;

public class ItemBoots extends ItemArmor {

	public ItemBoots(Material mat, BufferedImage icon, Handler handler) {
		super(mat, icon, handler);
		this.armor = 0.15f * mat.getStatMultiplier();
	}

}
