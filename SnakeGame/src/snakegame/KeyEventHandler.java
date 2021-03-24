package snakegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
	private static Point nextdir;
	static {
		nextdir = new Point(0,1);
	}
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			nextdir.move(0,1);
			break;
		case KeyEvent.VK_UP:
			nextdir.move(0,-1);
			break;
		case KeyEvent.VK_LEFT:
			nextdir.move(-1,0);
			break;
		case KeyEvent.VK_RIGHT:
			nextdir.move(1,0);
			break;
		}
	}
	public static Point getDir() {
		return new Point(nextdir);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}