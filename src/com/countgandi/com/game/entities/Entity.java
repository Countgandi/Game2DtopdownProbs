package com.countgandi.com.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.countgandi.com.game.Handler;

public abstract class Entity {

	protected float x, y, velX, velY;
	protected int width = 16, height = 16;
	protected Handler handler;

	public Entity(float x, float y, Handler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public Rectangle getRectangle() {
		return new Rectangle((int) x, (int) y, width * Handler.ZOOM, height * Handler.ZOOM);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean spawnIn() {
		return true;
	}

}
