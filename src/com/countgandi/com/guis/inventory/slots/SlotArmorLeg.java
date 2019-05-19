package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.armor.leggings.ItemLegging;

public class SlotArmorLeg extends Slot {

	public SlotArmorLeg(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemLegging || item == null) {
			return true;
		}
		return false;
	}

}
