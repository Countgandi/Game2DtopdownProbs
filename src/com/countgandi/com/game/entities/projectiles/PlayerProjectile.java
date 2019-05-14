package com.countgandi.com.game.entities.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.Entity;

public class PlayerProjectile extends Entity {

	private static Color abrown = new Color(0xFF472A13);
	private static Color agray = new Color(0xFF575757);
	private int type, timer;

	public PlayerProjectile(int x, int y, int type, int velX, Handler handler) {
		super(x, y, handler);
		this.type = type;
		this.velX = velX;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		timer++;
		if (timer >= 120) {
			handler.removeEntity(this);
		}
	}

	@Override
	public void render(Graphics g) {
		if (type == 0) {
			g.setColor(abrown);
			g.fillRect((int) x, (int) y, 5 * Handler.ZOOM, Handler.ZOOM);
			g.setColor(agray);
			if(velX < 0) {
				g.fillRect((int) x, (int) y, Handler.ZOOM, Handler.ZOOM);
			} else {
				g.fillRect((int) x + 4 * Handler.ZOOM, (int) y, Handler.ZOOM, Handler.ZOOM);
			}
		} else if (type == 1) {
			g.drawString("UR GAY", (int)x, (int)y); // a knight does not shoot projectiles
		} else if (type == 2) {
			g.setColor(Color.RED);
			g.fillRect((int) x, (int) y, Handler.ZOOM, Handler.ZOOM);
		} else if (type == 3) {
			g.setColor(Color.MAGENTA);
			g.fillRect((int) x, (int) y, Handler.ZOOM, Handler.ZOOM);
		}
	}

}
