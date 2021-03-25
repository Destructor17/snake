package snakegame;

public class SquareShape {
	public Point from;
	public Point to;
	int size;
	public SquareShape(Point from, Point to, int size) {
		this.from =from;
		this.to = to;
		this.size = size;
	}
	
	public Point lerp(float phase) {
		return new Point((int)(from.x + (to.x - from.x)*phase), (int)(from.y + (to.y - from.y)*phase));
	}
}
