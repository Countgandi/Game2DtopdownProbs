package com.countgandi.com.game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.countgandi.com.Game;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

	public static int mx, my;
	public static Point mouse = new Point();
	public static boolean mouseDown;
	private Game game;

	public InputHandler(Game game) {
		this.game = game;
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = (int) (e.getX() / Game.WIDTH_SCALE);
		my = (int) (e.getY() / Game.HEIGHT_SCALE);
		mouse.setLocation(mx, my);
		game.getMenu().mouseMoved(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
		game.getMenu().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		game.getMenu().mouseReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.getMenu().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.getMenu().keyReleased(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		game.getMenu().mouseDragged(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
