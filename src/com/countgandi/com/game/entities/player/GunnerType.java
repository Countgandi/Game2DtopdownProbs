package com.countgandi.com.game.entities.player;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.projectiles.PlayerProjectile;

public class GunnerType extends PlayerType {

	public GunnerType(Handler handler) {
		super(2, handler);
	}

	@Override
	public void useItem(int attackTimer, Player p) {
		if (attackTimer == 9) {
			int velX = handler.getPlayer().getAnimation();
			if (velX == 0)
				velX = -1;
			velX *= -1;
			int xx = 0;
			if (handler.getPlayer().getAnimation() == 0) {
				xx = (p.getWidth() - 1) * Handler.ZOOM;
			}
			handler.addEntity(new PlayerProjectile((int) p.getX() + xx, (int) p.getY() + Handler.ZOOM * 5, 2, velX * 6, handler));
		}
	}

}
