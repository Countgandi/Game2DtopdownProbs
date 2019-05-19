package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.trinkets.ItemTrinket;

public class SlotTrinket extends Slot {

	public SlotTrinket(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemTrinket || item == null) {
			return true;
		}
		return false;
	}

}
