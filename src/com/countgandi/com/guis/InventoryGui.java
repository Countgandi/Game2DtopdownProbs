package com.countgandi.com.guis;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.countgandi.com.Assets;
import com.countgandi.com.Game;
import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;

public class InventoryGui extends Gui {

	private static final int row = 4, column = 5;
	public static Item[] inventory = new Item[row * column];
	public static Rectangle[] inventoryBounds = new Rectangle[row * column];

	private Handler handler;

	public InventoryGui(Handler handler) {
		this.handler = handler;

		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				inventoryBounds[y * column + x] = new Rectangle(170 * Handler.ZOOM + x * 22 * Handler.ZOOM, 46 * Handler.ZOOM + y * 24 * Handler.ZOOM, 16 * Handler.ZOOM, 16 * Handler.ZOOM);
			}
		}

		addItem(new Item(Assets.items[0], handler) {
			@Override
			public void renderInUse(Graphics g) {

			}

			@Override
			public void onUse() {

			}
		});
		addItem(new Item(Assets.items[1], handler) {
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
		g.drawImage(Assets.inventoryGui, 0, 0, Assets.inventoryGui.getWidth() * Handler.ZOOM, Assets.inventoryGui.getHeight() * Handler.ZOOM, null);
		
		
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				if (inventory[y * column + x] != null) {
					g.drawImage(inventory[y * column + x].getIcon(), x * 22 * Handler.ZOOM + 170 * Handler.ZOOM, y * 24 * Handler.ZOOM + 46 * Handler.ZOOM, 16 * Handler.ZOOM, 16 * Handler.ZOOM, null);
				}
			}
		}

		if (holdingThing) {
			g.drawImage(holdingItem, (int) holdingPoint.getX(), (int) holdingPoint.getY(), 16 * Handler.ZOOM, 16 * Handler.ZOOM, null);
		}
		
	}

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
		for (int i = 0; i < inventoryBounds.length; i++) {
			if (inventoryBounds[i].contains(p)) {
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

	public void moveItem(int slot1, int slot2) {
		Item s1item = inventory[slot1];
		inventory[slot1] = inventory[slot2];
		inventory[slot2] = s1item;
	}

}
