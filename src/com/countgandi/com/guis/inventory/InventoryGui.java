package com.countgandi.com.guis.inventory;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;
import com.countgandi.com.guis.Gui;

public abstract class InventoryGui extends Gui {

	protected static final int row = 3, column = 4;
	public static Item[] inventory = new Item[row * column];
	public static List<Slot> inventorySlots;

	public InventoryGui(Handler handler) {
		if (inventorySlots == null) {
			initInventory();
		}
		addItem(new Item(Assets.items[0], handler) {

			@Override
			public void renderInUse(Graphics g) {

			}

			@Override
			public void onUse() {

			}

		});
	}

	@Override
	public void render(Graphics g) {
		renderChild(g);
		for (int i = 0; i < inventorySlots.size(); i++) {
			if (inventory[i] != null) {
				g.drawImage(inventory[i].getIcon(), (int) inventorySlots.get(i).getRectangle().getX(), (int) inventorySlots.get(i).getRectangle().getY(), (int) inventorySlots.get(i).getRectangle().getWidth(), (int) inventorySlots.get(i).getRectangle().getHeight(), null);
			}
		}

		if (holdingThing) {
			g.drawImage(holdingItem, (int) holdingPoint.getX(), (int) holdingPoint.getY(), 8 * Handler.ZOOM, 8 * Handler.ZOOM, null);
		}

	}

	protected abstract void renderChild(Graphics g);

	@Override
	public void tick() {

	}

	private boolean holdingThing = false;
	private BufferedImage holdingItem;
	private Point holdingPoint = new Point();
	private int previousSlot = 0;

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		holdingPoint = e.getPoint();
		holdingPoint.setLocation(holdingPoint.getX() / Game.WIDTH_SCALE, holdingPoint.getY() / Game.HEIGHT_SCALE);
	}

	public void mousePressed(MouseEvent e) {
		holdingPoint = e.getPoint();
		holdingPoint.setLocation(holdingPoint.getX() / Game.WIDTH_SCALE, holdingPoint.getY() / Game.HEIGHT_SCALE);

		if (!holdingThing) {
			int i = slotFromPoint(holdingPoint);
			if (i > -1 && inventory[i] != null) {
				holdingThing = true;

				holdingItem = inventory[i].getIcon();
				previousSlot = i;

			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (holdingThing) {
			int slot = slotFromPoint(holdingPoint);
			if (slot > -1) {
				moveItem(slot, previousSlot);
			}
			holdingThing = false;
			holdingItem = null;
			previousSlot = 0;
		}
	}

	public int slotFromPoint(Point p) {
		for (int i = 0; i < inventorySlots.size(); i++) {
			if (inventorySlots.get(i).getRectangle().contains(p)) {
				return i;
			}
		}
		return -1;
	}

	public void addItem(Item item) {
		boolean flag = true;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				inventory[i] = item;
				flag = false;
				break;
			} else if (inventory[i].getClass().equals(item.getClass()) && item.isStackable()) {

				break;
			}
		}
		if (flag) {
			System.err.println("Not enough space for addition items...");
		}
	}

	public void removeItem(Item item) {
		boolean flag = true;
		for (int i = 0; i < inventory.length; i++) {
			if (item.equals(inventory[i])) {
				inventory[i] = null;
				flag = false;
				break;
			}
		}
		if (flag) {
			System.err.println("Item does not exist in inventory");
		}
	}

	public boolean moveItem(int slot1, int slot2) {
		Item s1item = inventory[slot1];
		Item s2item = inventory[slot2];
		if (inventorySlots.get(slot2).meetsRequirements(s1item) && inventorySlots.get(slot1).meetsRequirements(s2item)) {
			inventory[slot1] = inventory[slot2];
			inventory[slot2] = s1item;
			return true;
		}
		return false;
	}

	public abstract void closeInventory();

	public void close() {
		closeInventory();
		inventorySlots = (List<Slot>) inventorySlots.subList(0, row * column);
		Item[] items = new Item[row * column];
		for (int i = 0; i < items.length; i++) {
			items[i] = inventory[i];
		}
		inventory = items;
	}

	public ArrayList<Item> returnItemsPastInvetoryCapacity() {
		ArrayList<Item> items = new ArrayList<Item>();
		int capacity = row * column;
		for (int i = capacity; i < inventory.length; i++) {
			items.add(inventory[i]);
		}
		return items;
	}

	protected void addMoreInvetorySpace(Item[] items) {
		Item[] nitems = new Item[inventory.length + items.length];
		for (int i = 0; i < inventory.length; i++) {
			nitems[i] = inventory[i];
		}
		for (int i = 0; i < items.length; i++) {
			nitems[inventory.length + i] = items[i];
		}
		inventory = nitems;
	}

	private void initInventory() {
		inventorySlots = new ArrayList<Slot>();
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				inventorySlots.add(new Slot(new Rectangle(85 + x * 14, 27 + y * 14)));
			}
		}
	}

}
