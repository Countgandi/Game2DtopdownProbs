package com.countgandi.com.game.items.tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.items.Item;
import com.countgandi.com.game.renders.Animation;

public class ItemTool extends Item {
	
	private Animation anim;

	public ItemTool(Animation anim, BufferedImage icon, Handler handler) {
		super(icon, handler);
		this.anim = anim;
	}

	@Override
	public void renderInUse(Graphics g) {
		
	}

	@Override
	public void onUse() {
		
	}

	public Animation getAnimation() {
		return anim;
	}

}
