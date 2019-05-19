package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.armor.boots.ItemBoot;

public class SlotArmorBoot extends Slot {

	public SlotArmorBoot(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemBoot || item == null) {
			return true;
		}
		return false;
	}

}
