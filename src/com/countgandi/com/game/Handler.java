package com.countgandi.com.game;

import java.awt.Graphics;
import java.util.ArrayList;

import com.countgandi.com.Game;
import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.entities.creatures.Creature;
import com.countgandi.com.game.entities.player.Player;
import com.countgandi.com.game.map.MapHandler;

public class Handler {

	public static final int ZOOM = 8;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Entity> creatureEntities = new ArrayList<Entity>();

	private Player player;
	private Game game;
	private MapHandler mapHandler;

	public Handler() {
		this.game = Game.gameInstance;
		player = new Player(0, 0, this);
		mapHandler = new MapHandler();
		mapHandler.loadMap(0, this);
	}

	public void tick() {
		Camera.tick(this);
		for (int i = 0; i < creatureEntities.size(); i++) {
			creatureEntities.get(i).tick();
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		player.tick();
		mapHandler.tick(this);
	}

	public void render(Graphics g) {
		g.translate((int) -Camera.x, (int) -Camera.y);
		mapHandler.render(g);
		player.render(g);
		for (int i = 0; i < creatureEntities.size(); i++) {
			creatureEntities.get(i).render(g);
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}

		g.translate((int) Camera.x, (int) Camera.y);
	}

	public void addEntity(Entity e) {
		if (e instanceof Player) {
			player = null;
			player = (Player) e;
		} else if(e instanceof Creature) {
			creatureEntities.add(e);
		} else {
			entities.add(e);
		}
	}

	public void removeEntity(Entity e) {
		if(e instanceof Creature) {
			creatureEntities.remove(e);
		} else {
			entities.remove(e);
		}
	}

	public Game getGame() {
		return game;
	}

	public Player getPlayer() {
		return player;
	}

	public MapHandler getMapHandler() {
		return mapHandler;
	}

}
