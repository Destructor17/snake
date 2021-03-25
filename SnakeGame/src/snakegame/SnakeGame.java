package snakegame;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class SnakeGame {
	private AnimSquareGrid asg;
	private SnakeScreen ss;
	private Snake snake;
	private Consumer<Integer> gameOverHandler;
	public SnakeGame( int width, int height,int xsquares,int ysquares,int smoothness) {
		ss = new SnakeScreen(width, height);
		asg = new AnimSquareGrid(ss, ysquares, xsquares, width, height, smoothness);
		snake = new Snake(6, xsquares, ysquares);
	}
	public SnakeScreen getScreen() {
		return ss;
	}
	public void registerGameOverHandler(Consumer<Integer> cons) {
		gameOverHandler = cons;
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
			gameOverHandler.accept(snake.getLength());
		}
		snake.animate(asg);
	}
}
