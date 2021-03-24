package snakegame;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class AnimSquareGrid {
	private int xelems;
	private int yelems;
	private int elemsize;
	private int elemClearance;
	private int animSteps;
	private int animctr;
	private int height;
	private int width;
	private List<SquareShape> squares;
	private IRenderer renderer;
	public AnimSquareGrid(IRenderer renderer,int xelems,int yelems, int width,int height,int animSteps) {
		this.xelems = xelems;
		this.yelems = yelems;
		this.height = height;
		this.width = width;
		animctr = 0;
		if (Math.min(width, height) == height) {
			elemsize = height / yelems;
		} else {
			elemsize = width / xelems;
		}
		elemClearance = (int) Math.round(elemsize * 0.1);
		elemsize -= elemClearance;
		
		this.animSteps = animSteps;
		this.renderer = renderer;
		squares = new ArrayList<>();
	}
	public void doAnim() {
		if (animctr >= animSteps) {
			animctr = 0;
		}
	}
	public void animTick() {
		if (animctr <= animSteps) {
			//renderer.clear();
			for (SquareShape s : squares) {
				s.setCenter(s.getCenter().increase(s.getAnimDir()));
			}
			render();
			animctr++;
		}
	}
	public boolean isAnimating() {
		return animctr <= animSteps;
	}
	private void render() {
		renderer.clear();
		for (SquareShape s : squares) {
			Point topLeft = s.getCornerTL();
			Point bottomRight = s.getCornerBR();
			renderer.drawRect(topLeft.getx(), topLeft.gety(), bottomRight.getx(), bottomRight.gety());
		}
	}
	private Point convertPos(Point p) throws Exception {
		int x = (elemsize/2) + (p.getx())*(elemsize + elemClearance);
		int y = (elemsize/2) + (p.gety())*(elemsize + elemClearance);
		if (p.getx() == 49 || p.gety() == 49) {
			System.out.println(x + " " + y);
		}
		return new Point(x,y);
	}
	public void addSquare(Point pos,Point animdir) {
		Point realpos = null;
		try {
			realpos = convertPos(pos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stepval = (elemsize + elemClearance) / animSteps;
		squares.add(new SquareShape(realpos, elemsize, new Point(animdir).scalMulWith(stepval)));
	}
	public void clear() {
		squares.clear();
	}
	
}
