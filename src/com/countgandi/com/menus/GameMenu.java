package com.countgandi.com.menus;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.SpawnManager;
import com.countgandi.com.guis.inventory.DefaultInventoryGui;
import com.countgandi.com.guis.inventory.InventoryGui;

public class GameMenu implements Menu {

	public InventoryGui inventory;
	private Handler handler;
	private SpawnManager manager;

	public GameMenu() {
		handler = new Handler();
		manager = new SpawnManager(handler);
		manager.spawnWorld();
	}

	@Override
	public void tick() {
		if (inventory != null) {
			inventory.tick();
		} else {
			handler.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		handler.render(g);
		if (inventory != null) {
			inventory.render(g);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (inventory != null) {
			inventory.mouseMoved(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (inventory != null) {
			inventory.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (inventory != null) {
			inventory.mouseReleased(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			handler.getPlayer().up = true;
		}
		if (key == KeyEvent.VK_S) {
			handler.getPlayer().down = true;
		}
		if (key == KeyEvent.VK_A) {
			handler.getPlayer().left = true;
		}
		if (key == KeyEvent.VK_D) {
			handler.getPlayer().right = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			handler.getPlayer().up = false;
		}
		if (key == KeyEvent.VK_S) {
			handler.getPlayer().down = false;
		}
		if (key == KeyEvent.VK_A) {
			handler.getPlayer().left = false;
		}
		if (key == KeyEvent.VK_D) {
			handler.getPlayer().right = false;
		}
		if(key == KeyEvent.VK_SPACE && !handler.getPlayer().usingItem) {
			handler.getPlayer().startUsingItem = true;
		}

		if (key == KeyEvent.VK_E) {
			if(inventory != null) {
				closeCurrentInventory();
			} else {
				openInventory(new DefaultInventoryGui());
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (inventory != null) {
			inventory.mouseDragged(e);
		}
	}
	
	public void closeCurrentInventory() {
		this.inventory.close();
		this.inventory = null;
	}
	
	public void openInventory(InventoryGui inventory) {
		this.inventory = inventory;
	}

}
