package com.countgandi.com.game.renders;

import java.awt.image.BufferedImage;

public class Animation {
	
	protected BufferedImage[] imgs;
	protected int ticksPerFrame, frameStart, frameEnd, currentTick, frame, offset;
	
	public Animation(BufferedImage[] imgs, int ticksPerFrame, int frameStart, int frameEnd) {
		this.imgs = imgs;
		this.ticksPerFrame = ticksPerFrame;
		this.frameStart = frameStart;
		this.frameEnd = frameEnd;
	}
	
	public void tick(int offset) {
		this.offset = offset;
		currentTick++;
		if(currentTick >= ticksPerFrame) {
			frame ++;
			currentTick = 0;
		}
		if(frame >= frameEnd) {
			frame = frameStart;
		}
	}
	
	public void resetAnimation() {
		currentTick = 0;
		frame = frameStart;
	}
	
	public BufferedImage getCurrentFrame() {
		return imgs[offset + frame];
	}
	
	public int getFrameNumber() {
		return offset + frame;
	}
	
	public int getSize() {
		return imgs.length;
	}
	
	public int getTicksPerFrame() {
		return this.ticksPerFrame;
	}

}
