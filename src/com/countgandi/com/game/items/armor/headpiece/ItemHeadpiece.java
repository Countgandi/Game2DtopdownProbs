package com.countgandi.com.game.items.armor.headpiece;

import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.armor.ItemArmor;
import com.countgandi.com.game.items.materials.Material;

public class ItemHeadpiece extends ItemArmor {

	public ItemHeadpiece(Material mat, BufferedImage icon, Handler handler) {
		super(mat, icon, handler);
		this.armor = 0.15f * mat.getStatMultiplier();
	}

}
