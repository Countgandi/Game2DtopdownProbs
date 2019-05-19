package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.tools.ItemTool;

public class SlotTool extends Slot {

	public SlotTool(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemTool || item == null) {
			return true;
		}
		return false;
	}

}
