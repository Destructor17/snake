package snakegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Snake {
	List<Point> segments;
	List<Point> oldSegments;
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
		oldSegments = new ArrayList<>();
		putFood();
		for(int i = 0;i<length;i++)
		{
			segments.add(new Point(start.increase(0, 1)));
			oldSegments.add(new Point(start));
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
		int lastIndex = segments.size()-1;
		Point seg = segments.get(lastIndex).add(moveDir);
		segments.add(seg);
		Point oldSeg = oldSegments.get(lastIndex).add(moveDir);
		oldSegments.add(oldSeg);
		
		
	}
	public void update() throws GameOverException {
		if (alive) {
			for(int i=0; i<segments.size();i++) {
				oldSegments.get(i).move(segments.get(i));
			}
			moveDir = KeyEventHandler.getDir().equals(moveDir.scalMul(-1)) ? moveDir : KeyEventHandler.getDir();
			Point head = segments.get(segments.size() - 1);
			Point nextpos = head.add(moveDir);
			for (Point s : segments) {
				if (nextpos.equals(s)) {
					alive = false;
					throw new GameOverException();
				}
			}
			if (nextpos.getx() >= xcells || nextpos.getx() < 0 || nextpos.gety() >= ycells || nextpos.gety() < 0) {
				alive = false;
				throw new Exception("Snake Died");
			}
			segments.add(nextpos);
			
			segments.remove(0);
			if (nextpos.equals(food)) {
				putFood();
				elongate();
			}
			/*for (int i = segments.size() - 2; i >= 0; i--) {
				Point nprevpoint = new Point(segments.get(i));
				segments.get(i).move(prevpoint);
				prevpoint = nprevpoint;
			} */
		}
	}
	public void animate(AnimSquareGrid asg) {
		asg.clear();
		for (int i = 0; i < segments.size();i++) {
			Point animdir = segments.get(i).
					sub(oldSegments.get(i));
			asg.addSquare(oldSegments.get(i), animdir);
		}

		
		asg.addSquare(food, new Point(0,0));
		asg.doAnim();
	}
	public boolean isAlive() {
		return alive;
	}
}
