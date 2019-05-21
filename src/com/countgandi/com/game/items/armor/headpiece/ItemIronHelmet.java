package com.countgandi.com.game.items.armor.headpiece;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.materials.Materials;

public class ItemIronHelmet extends ItemHelmet {

	public ItemIronHelmet(Handler handler) {
		super(Materials.iron, Assets.items[12], handler);
	}

}
