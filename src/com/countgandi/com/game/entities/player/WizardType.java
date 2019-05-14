package com.countgandi.com.game.entities.player;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.projectiles.PlayerProjectile;

public class WizardType extends PlayerType {

	public WizardType(Handler handler) {
		super(3, handler);
	}

	@Override
	public void useItem(int attackTimer, Player p) {
		if (attackTimer == 19) {
			int velX = handler.getPlayer().getAnimation();
			if (velX == 0)
				velX = -1;
			velX *= -1;
			int xx = 0;
			if (handler.getPlayer().getAnimation() == 0) {
				xx = (p.getWidth()) * Handler.ZOOM;
			}
			handler.addEntity(new PlayerProjectile((int) p.getX() + xx, (int) p.getY() + Handler.ZOOM * 3, 3, velX * 6, handler));
		}
	}

}
