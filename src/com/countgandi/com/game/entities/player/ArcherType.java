package com.countgandi.com.game.entities.player;

import com.countgandi.com.game.Handler;
import com.countgandi.com.game.entities.projectiles.PlayerProjectile;

public class ArcherType extends PlayerType {

	public ArcherType(Handler handler) {
		super(0, handler);
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
				xx = (p.getWidth() - 5) * Handler.ZOOM;
			}
			handler.addEntity(new PlayerProjectile((int) p.getX() + xx, (int) p.getY() + Handler.ZOOM * 4, 0, velX * 6, handler));
		}
	}

}
