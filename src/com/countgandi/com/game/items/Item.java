package com.countgandi.com.game.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;

public abstract class Item {
	
	protected BufferedImage icon;
	protected Handler handler;
	protected boolean isStackable;
	
	public Item(BufferedImage icon, Handler handler) {
		this.handler = handler;
		this.icon = icon;
	}
	
	/**
	 * Occurs when holding
	 */
	public void tick() {
		
	}
	
	public abstract void renderInUse(Graphics g);
	public abstract void onUse();

	public BufferedImage getIcon() {
		return icon;
	}

	public boolean isStackable() {
		return isStackable;
	}

}
