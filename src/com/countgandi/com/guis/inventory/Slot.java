package com.countgandi.com.guis.inventory;

import java.awt.Rectangle;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;

public class Slot {
	
	private Rectangle rect;
	
	public Slot(Rectangle rect) {
		this.rect = new Rectangle(rect.width * Handler.ZOOM, rect.height * Handler.ZOOM, 8 * Handler.ZOOM, 8 * Handler.ZOOM);
	}
	
	public boolean meetsRequirements(Item item) {
		return true;
	}
	
	public Rectangle getRectangle() {
		return rect;
	}

}
