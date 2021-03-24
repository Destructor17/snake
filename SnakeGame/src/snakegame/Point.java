package snakegame;

public class Point {
	private int x,y;
	public Point(int x,int y) { 
		this.x = x;
		this.y = y;
	}
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	public void move(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void move(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	public Point addTo(Point p) {
		this.x += p.x;
		this.y += p.y; 
		return this;
	}
	public Point addTo(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}
	public Point add(Point p) {
		return new Point(x + p.x,y + p.y);
	}
	public Point add(int x, int y) {
		return new Point(x + this.x,y + this.y);
	}
	public Point sub(Point p) {
		return new Point(x - p.x,y - p.y);
	}
	public Point sub(int x, int y) {
		return new Point(this.x - x,this.y - y);
	}
	public Point subFrom(Point p ) {
		this.x -= p.x;
		this.y -= p.y;
		return this;
	}
	public Point subFrom(int x, int y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	public Point scalMulWith(int mul) {
		this.x *= mul;
		this.y *= mul;
		return this;
	}
	public Point scalMul(int mul) {
		return new Point(this).scalMulWith(mul);
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public boolean equals(Point p) {
		return x == p.x && y == p.y;
	}
	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}
}
