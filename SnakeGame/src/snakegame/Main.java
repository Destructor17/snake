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
	private static final int targetFPS = 60;
	private static final int animDurationMS = 300;
	public static void onGameOver(int score) {
		frame.getContentPane().removeAll();
		gameTimer.stop();
		game = null;
		frame.getContentPane().add(new JLabel("YOU DIED"));
		frame.setVisible(true);
	}
	public static void createGUI()
    {
        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(s);
        frame.setSize(new Dimension(width+10, height+30));
        frame.setResizable(false);
        frame.addKeyListener(new KeyEventHandler());
        frame.setVisible(true);          
   }
	public static void main(String[] args) {
		game = new SnakeGame(width, height, 50, 50, animDurationMS / targetFPS);
		game.registerGameOverHandler(Main::onGameOver);
		s = game.getScreen();
		gameTimer = new javax.swing.Timer(1000 / targetFPS, game::tick);
		gameTimer.start();
		JFrame.setDefaultLookAndFeelDecorated(true);
		javax.swing.SwingUtilities.invokeLater(Main::createGUI);
	}

}
