package com.countgandi.com.game.items.armor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.materials.Material;

public abstract class ItemArmor extends Item {
	
	protected float armor;

	public ItemArmor(Material mat, BufferedImage icon, Handler handler) {
		super(icon, handler);
		armor = mat.getStatMultiplier();
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

}
