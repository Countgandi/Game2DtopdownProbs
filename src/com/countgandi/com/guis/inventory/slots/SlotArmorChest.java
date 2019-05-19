package com.countgandi.com.guis.inventory.slots;

import java.awt.Rectangle;

import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.armor.chestplates.ItemChestplate;

public class SlotArmorChest extends Slot {

	public SlotArmorChest(Rectangle rect) {
		super(rect);
	}
	
	public boolean meetsRequirements(Item item) {
		if(item instanceof ItemChestplate || item == null) {
			return true;
		}
		return false;
	}

}
