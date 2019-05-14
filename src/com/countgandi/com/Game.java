package com.countgandi.com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.countgandi.com.game.InputHandler;
import com.countgandi.com.menus.GameMenu;
import com.countgandi.com.menus.Menu;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static int WINDOW_WIDTH = 1600, WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9;
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;
	public static float WIDTH_SCALE, HEIGHT_SCALE;
	public static final String TITLE = "Game";

	public static Game gameInstance;
	private static Thread thread;
	private static boolean running = false;

	private Menu menu;

	public Game() {
		new Window(WINDOW_WIDTH, WINDOW_HEIGHT, TITLE, this);

		menu = new GameMenu();
		new InputHandler(this);

		start();
	}

	private void tick() {
		WIDTH_SCALE = (float) WINDOW_WIDTH / (float) WIDTH;
		HEIGHT_SCALE = (float) WINDOW_HEIGHT / (float) HEIGHT;
		menu.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		((Graphics2D) g).scale(WIDTH_SCALE, HEIGHT_SCALE);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		menu.render(g);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		gameInstance = new Game();
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.currentTimeMillis();
		long lastTime2 = System.currentTimeMillis();
		long lastTime3 = System.currentTimeMillis();
		float fps = 1000.0f / 60.0f;

		boolean fpsCap = false;

		int frames = 0;
		while (running) {
			long currentTime = System.currentTimeMillis();
			if (currentTime - lastTime >= fps) {
				tick();
				lastTime = currentTime;
			}

			if (fpsCap) {
				if (currentTime - lastTime3 >= (int) fps) {
					render();
					frames++;
					lastTime3 = currentTime;
				}
			} else {
				render();
				frames++;
			}

			if (currentTime - lastTime2 >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				lastTime2 = currentTime;
			}
		}
	}

	public synchronized void start() {
		if (running)
			return;

		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public Menu getMenu() {
		return menu;
	}

}
