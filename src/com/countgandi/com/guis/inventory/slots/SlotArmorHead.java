package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.armor.headpiece.ItemHelmet;

public class SlotArmorHead extends Slot {

	public SlotArmorHead(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemHelmet || item == null) {
			return true;
		}
		return false;
	}

}
