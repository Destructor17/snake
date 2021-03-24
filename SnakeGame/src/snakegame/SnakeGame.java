package snakegame;

import java.awt.event.ActionEvent;

public class SnakeGame {
	private AnimSquareGrid asg;
	private SnakeScreen ss;
	private Snake snek;
	public SnakeGame( int width, int height,int xsquares,int ysquares,int smoothness) {
		ss = new SnakeScreen(width, height);
		asg = new AnimSquareGrid(ss, ysquares, xsquares, width, height, smoothness);
		snek = new Snake(3, xsquares, ysquares);
	}
	public SnakeScreen getScreen() {
		return ss;
	}
	public void tick(ActionEvent e) {
		if(!asg.isAnimating() && snek.isAlive()) {
			gameLogicTick();
		}
		asg.animTick();
		ss.repaint();
	}
	private void gameLogicTick() {
		
		try {
			snek.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
		snek.animate(asg);
	}
}
