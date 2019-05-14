package com.countgandi.com.menus;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.SpawnManager;
import com.countgandi.com.guis.InventoryGui;

public class GameMenu implements Menu {

	public InventoryGui inventory;
	private Handler handler;
	private SpawnManager manager;

	private boolean inventoryOpen = false;

	public GameMenu() {
		inventory = new InventoryGui(handler);
		handler = new Handler();
		manager = new SpawnManager(handler);
		manager.spawnWorld();
	}

	@Override
	public void tick() {
		if (inventoryOpen) {
			inventory.tick();
		} else {
			handler.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		handler.render(g);
		if (inventoryOpen) {
			inventory.render(g);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (inventoryOpen) {
			inventory.mouseMoved(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (inventoryOpen) {
			inventory.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (inventoryOpen) {
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
		if(key == KeyEvent.VK_SPACE && !handler.getPlayer().attacking) {
			handler.getPlayer().startAttack = true;
		}

		if (key == KeyEvent.VK_E) {
			inventoryOpen = !inventoryOpen;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (inventoryOpen) {
			inventory.mouseDragged(e);
		}
	}

}
