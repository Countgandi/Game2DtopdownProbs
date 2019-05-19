package com.countgandi.com.game.items.materials;

public class Material {
	private String name;
	private int statMultiplier, id;

	public Material(String name, int id, int statMultiplier) {
		this.name = name;
		this.statMultiplier = statMultiplier;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getStatMultiplier() {
		return statMultiplier;
	}

	public int getId() {
		return id;
	}
}
