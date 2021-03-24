package snakegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Snake {
	List<Point> segments;
	Point moveDir;
	Point food;
	int xcells;
	int ycells;
	Random rng;
	boolean alive;
	public Snake(int length,int xcells, int ycells) {
		this.xcells = xcells;
		this.ycells = ycells;
		rng = new Random();
		alive = true;
		moveDir = new Point(1,0);
		Point start = new Point(20,20);
		segments = new ArrayList<>();
		putFood();
		for(int i = 0;i<length;i++) {
			segments.add(new Point(start.addTo(0, 1)));
		}
	}
	private void putFood() {
		int newx = rng.nextInt(xcells);
		int newy = rng.nextInt(ycells);
		if (food == null) {
			food = new Point(newx,newy);
		} else {
			food.move(newx, newy);
		}
	}
	private void elongate() {
		Point newseg = segments.get(0).sub(segments.get(1)).add(segments.get(0));
		segments.add(0,newseg);
	}
	public void update() throws Exception {
		if (alive) {
			moveDir = KeyEventHandler.getDir().equals(moveDir.scalMul(-1)) ? moveDir : KeyEventHandler.getDir();
			Point head = segments.get(segments.size() - 1);
			Point nextpos = head.add(moveDir);
			for (Point s : segments) {
				if (nextpos.equals(s)) {
					alive = false;
					throw new Exception("Snake Died");
				}
			}
			if (nextpos.equals(food)) {
				putFood();
				elongate();
			} else if (nextpos.getx() >= xcells || nextpos.getx() < 0 || nextpos.gety() >= ycells || nextpos.gety() < 0) {
				alive = false;
				throw new Exception("Snake Died");
			}
			segments.add(nextpos);
			
			System.out.println(head);
			segments.remove(0);
			/*for (int i = segments.size() - 2; i >= 0; i--) {
				Point nprevpoint = new Point(segments.get(i));
				segments.get(i).move(prevpoint);
				prevpoint = nprevpoint;
			} */
		}
	}
	public void animate(AnimSquareGrid asg) {
		asg.clear();
		for (int i = 0; i < segments.size()-1;i++) {
			Point animdir = segments.get(i+1).sub(segments.get(i));
			asg.addSquare(segments.get(i), animdir);
		}
		asg.addSquare(segments.get(segments.size()-1), moveDir);
		asg.addSquare(food, new Point(0,0));
		asg.doAnim();
	}
	public boolean isAlive() {
		return alive;
	}
}
