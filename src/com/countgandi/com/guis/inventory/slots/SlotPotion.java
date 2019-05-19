package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.potions.ItemPotion;

public class SlotPotion extends Slot {

	public SlotPotion(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemPotion || item == null) {
			return true;
		}
		return false;
	}

}
