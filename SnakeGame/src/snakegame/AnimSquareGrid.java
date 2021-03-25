package snakegame;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class AnimSquareGrid {
	private int xelems;
	private int yelems;
	private int elemsize;
	private int elemClearance;
	private float deltaPhase;
	private float phase;
	private int height;
	private int width;
	private List<SquareShape> squares;
	private IRenderer renderer;
	public AnimSquareGrid(IRenderer renderer,int xelems,int yelems, int width,int height,float deltaPhase) {
		this.xelems = xelems;
		this.yelems = yelems;
		this.height = height;
		this.width = width;
		this.deltaPhase = deltaPhase;
		phase = 0;
		if (Math.min(width, height) == height) {
			elemsize = height / yelems;
		} else {
			elemsize = width / xelems;
		}
		elemClearance = (int) Math.round(elemsize * 0.1);
		elemsize -= elemClearance;
		this.renderer = renderer;
		squares = new ArrayList<>();
	}
	public void doAnim() {
		if (phase >= 1) {
			phase -= 1;
		}
	}
	public void animTick() {
		if (phase < 1) {
			//renderer.clear();
			render();
			phase+=deltaPhase;
		}
	}
	public boolean isAnimating() {
		return phase < 1;
	}
	private void render() {
		renderer.clear();
		for (SquareShape s : squares) {
			Point center = s.lerp(phase);
			renderer.drawRect(center.x-s.size/2, center.y-s.size/2, center.x+s.size/2, center.y+s.size/2);
		}
	}
	private Point convertPos(Point p){
		int x = (elemsize/2) + (p.x)*(elemsize + elemClearance);
		int y = (elemsize/2) + (p.y)*(elemsize + elemClearance);
		return new Point(x,y);
	}
	public void addSquare(Point pos,Point animdir) {
		//int stepval = (int)Math.ceil((elemsize + elemClearance) / (double)animSteps);
		squares.add(new SquareShape(convertPos(pos), convertPos(pos.add(animdir)),elemsize));
	}
	public void clear() {
		squares.clear();
	}
	
}
