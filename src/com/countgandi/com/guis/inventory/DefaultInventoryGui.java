package com.countgandi.com.guis.inventory;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.entities.player.Player;
import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.items.tools.ItemTool;
import com.countgandi.com.guis.inventory.slots.SlotArmorBoot;
import com.countgandi.com.guis.inventory.slots.SlotArmorChest;
import com.countgandi.com.guis.inventory.slots.SlotArmorHead;
import com.countgandi.com.guis.inventory.slots.SlotArmorLeg;
import com.countgandi.com.guis.inventory.slots.SlotTool;
import com.countgandi.com.guis.inventory.slots.SlotTrinket;

public class DefaultInventoryGui extends InventoryGui {
	
	private static Item[] extraItems = new Item[12];

	public DefaultInventoryGui() {
		
		inventorySlots.add(new SlotArmorHead(new Rectangle(24, 27)));
		inventorySlots.add(new SlotArmorChest(new Rectangle(24 + 14, 27)));
		inventorySlots.add(new SlotArmorLeg(new Rectangle(24 + 28, 27)));
		inventorySlots.add(new SlotArmorBoot(new Rectangle(24 + 42, 27)));
		
		inventorySlots.add(new SlotTool(new Rectangle(24, 27 + 14)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 14, 27 + 14)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 28, 27 + 14)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 42, 27 + 14)));
		
		inventorySlots.add(new SlotTrinket(new Rectangle(24, 27 + 28)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 14, 27 + 28)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 28, 27 + 28)));
		inventorySlots.add(new SlotTrinket(new Rectangle(24 + 42, 27 + 28)));
		
		this.addMoreInvetorySpace(extraItems);
	}

	@Override
	protected void renderChild(Graphics g) {
		g.drawImage(Assets.inventoryGui, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}

	@Override
	public void closeInventory() {
		ArrayList<Item> items = this.returnItemsPastInvetoryCapacity();
		for(int i = 0; i < extraItems.length; i++) {
			extraItems[i] = items.get(i);
		}
		
		if(extraItems[4] != null) {
			Player.itemInHand = (ItemTool) extraItems[4];
		} else {
			Player.itemInHand = null;
		}
	}

	@Override
	public void tick() {
	}

}
