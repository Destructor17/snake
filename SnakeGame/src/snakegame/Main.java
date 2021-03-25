package snakegame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
//import java.util.Timer;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Main {

	static Timer gameTimer;
	private static SnakeScreen s;
	private static SnakeGame game;
	private static JFrame frame;
	private static final int width = 500;
	private static final int height = 500;

	private static final int targetFPS = 50;
	private static final int animDurationMS = 49;
	public static void onGameOver(int score) {
		frame.getContentPane().removeAll();
		gameTimer.stop();
		game = null;
		frame.getContentPane().add(new JLabel("YOU DIED with score " + score));
		frame.setVisible(true);
	}
	public static void createGUI()
    {
        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(s);
        frame.setSize(new Dimension(width+16, height+39));
        frame.setResizable(false);
        frame.addKeyListener(new KeyEventHandler());
        frame.setVisible(true);          
   }
	public static void main(String[] args) {
		game = new SnakeGame(width, height, 50, 50, animDurationMS*targetFPS/1000f);
		game.registerGameOverHandler(Main::onGameOver);
		s = game.getScreen();
		gameTimer = new javax.swing.Timer(1000 / targetFPS, game::tick);
		gameTimer.start();
		JFrame.setDefaultLookAndFeelDecorated(false);
		javax.swing.SwingUtilities.invokeLater(Main::createGUI);
	}

}
