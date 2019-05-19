package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.armor.boots.ItemBoots;

public class SlotArmorBoot extends Slot {

	public SlotArmorBoot(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemBoots || item == null) {
			return true;
		}
		return false;
	}

}
