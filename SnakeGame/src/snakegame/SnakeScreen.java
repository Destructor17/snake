package snakegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class SnakeScreen extends Canvas implements IRenderer {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	Image img;
	public SnakeScreen(int width,int height) {
		super();
		this.width = width;
		this.height = height;
		img = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	}
	@Override
	public void update(Graphics g) {
		g.drawImage(img, 0, 0,null);
	}
	@Override
	public void drawRect(int x0, int y0, int x1, int y1) {
		Graphics g = img.getGraphics();
		g.setColor(Color.RED);
		g.fillRect(x0, y0, x1-x0, y1-y0);
		g.dispose();
		
	}
	@Override
	public void clear() {
		Graphics g =  img.getGraphics();
		g.clearRect(0, 0, width, height);
		g.dispose();
		
	}
}