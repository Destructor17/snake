package snakegame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
//import java.util.Timer;

import javax.swing.Timer;
import javax.swing.JButton;
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
		JButton restartButton = new JButton("RESTART");
		restartButton.addActionListener(Main::restartListener);
		frame.getContentPane().add(restartButton);
		frame.setVisible(true);
	}
	public static void restartListener(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		createGUI();
	}
	public static void initGUI()
    {
        frame = new JFrame("Snake");
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyEventHandler());
        createGUI();
   }
	public static void createGUI() {
		game = new SnakeGame(width, height, 50, 50, animDurationMS*targetFPS/1000f);
		game.registerGameOverHandler(Main::onGameOver);
		s = game.getScreen();
		gameTimer = new javax.swing.Timer(1000 / targetFPS, game::tick);
		gameTimer.start();
        frame.add(s);
        //frame.setSize(new Dimension(width+16, height+39));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true); 
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		javax.swing.SwingUtilities.invokeLater(Main::initGUI);
	}

}
