package snakegame;

import java.awt.event.ActionEvent;

public class SnakeGame {
	private AnimSquareGrid asg;
	private SnakeScreen ss;
	private Snake snake;
	public SnakeGame( int width, int height,int xsquares,int ysquares,float animSteps) {
		ss = new SnakeScreen(width, height);
		asg = new AnimSquareGrid(ss, ysquares, xsquares, width, height, 1/animSteps);
		snake = new Snake(6, xsquares, ysquares);
	}
	public SnakeScreen getScreen() {
		return ss;
	}
	public void tick(ActionEvent e) {
		if(!asg.isAnimating() && snake.isAlive()) {
			gameLogicTick();
		}
		asg.animTick();
		ss.repaint();
	}
	private void gameLogicTick() {
		
		try {
			snake.update();
		} catch (GameOverException e) {
			System.out.print("Game over");
		}
		snake.animate(asg);
	}
}
