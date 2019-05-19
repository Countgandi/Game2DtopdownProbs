package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.weapons.ItemWeapon;

public class SlotWeapon extends Slot {

	public SlotWeapon(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemWeapon || item == null) {
			return true;
		}
		return false;
	}

}
