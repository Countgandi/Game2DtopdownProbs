package com.countgandi.com.game;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.entities.creatures.Shriel;
import com.countgandi.com.game.entities.creatures.Vause;
import com.countgandi.com.game.entities.objects.Flower;
import com.countgandi.com.game.entities.objects.OakTree;
import com.countgandi.com.game.entities.objects.PalmTree;
import com.countgandi.com.game.entities.objects.Rock;
import com.countgandi.com.game.map.GrassTile;
import com.countgandi.com.game.map.MapHandler;
import com.countgandi.com.game.map.Tile;
import com.countgandi.com.game.map.WaterTile;

public class SpawnManager {

	private static Random ran = new Random();
	private static float chanceEntitiesPerBlock = 0.1f;
	private static ArrayList<Class<? extends Entity>> registeredEntitiesGrass = new ArrayList<Class<? extends Entity>>();
	private static ArrayList<Class<? extends Entity>> registeredEntitiesSand = new ArrayList<Class<? extends Entity>>();
	//private static ArrayList<Class<? extends Entity>> registeredEntitiesDeepOcean = new ArrayList<Class<? extends Entity>>();
	//private static ArrayList<Class<? extends Entity>> registeredEntitiesShallowOcean = new ArrayList<Class<? extends Entity>>();
	private Handler handler;

	public SpawnManager(Handler handler) {
		this.handler = handler;
		registerEntities(handler);
	}

	public void spawnWorld() {
		MapHandler map = handler.getMapHandler();
		for (int i = 0; i < map.getTiles().size(); i++) {
			float chance = ran.nextFloat();
			if (chance <= chanceEntitiesPerBlock) {
				Tile t = map.getTiles().get(i);
				int x = t.getRectangle().x + ran.nextInt(16) * Handler.ZOOM;
				int y = t.getRectangle().y + ran.nextInt(16) * Handler.ZOOM;

				if (t instanceof GrassTile && t.getId() < 4) {
					createEntity(registeredEntitiesGrass.get(ran.nextInt(registeredEntitiesGrass.size())), x, y);
				} else if (t.getId() == 4) {
					createEntity(registeredEntitiesSand.get(ran.nextInt(registeredEntitiesSand.size())), x, y);
				} else if (t instanceof WaterTile) {
					if (((WaterTile) t).isDeepOcean) {
						// createEntity(registeredEntitiesDeepOcean.get(ran.nextInt(registeredEntitiesDeepOcean.size())),
						// t.getRectangle().x, t.getRectangle().y);
					} else {
						// createEntity(registeredEntitiesShallowOcean.get(ran.nextInt(registeredEntitiesShallowOcean.size())),
						// t.getRectangle().x, t.getRectangle().y);
					}
				}
			}
		}
	}

	private void createEntity(Class<? extends Entity> c, int x, int y) {
		try {
			Entity e = (Entity) (c.getConstructors()[0].newInstance(x, y, handler));
			if (e.spawnIn()) {
				handler.addEntity(e);
			}
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}

	public static void registerEntities(Handler handler) {
		// Grass Biome
		registeredEntitiesGrass.add(Vause.class);

		registeredEntitiesGrass.add(OakTree.class);
		registeredEntitiesGrass.add(OakTree.class);
		registeredEntitiesGrass.add(OakTree.class);

		registeredEntitiesGrass.add(Flower.class);
		registeredEntitiesGrass.add(Flower.class);
		registeredEntitiesGrass.add(Flower.class);
		registeredEntitiesGrass.add(Flower.class);
		registeredEntitiesGrass.add(Flower.class);
		registeredEntitiesGrass.add(Flower.class);

		registeredEntitiesGrass.add(Rock.class);

		// Sand Biome

		registeredEntitiesSand.add(Shriel.class);

		registeredEntitiesSand.add(PalmTree.class);
		registeredEntitiesSand.add(PalmTree.class);
		registeredEntitiesSand.add(PalmTree.class);

		// Shallow Waters

		// Deep Ocean Waters

	}

}
