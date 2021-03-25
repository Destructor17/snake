package snakegame;

public class FPoint {
	private float x,y;
	public FPoint(float x,float y) { 
		this.x = x;
		this.y = y;
	}
	public FPoint(FPoint p) {
		this.x = p.x;
		this.y = p.y;
	}
	public void move(float x,float y) {
		this.x = x;
		this.y = y;
	}
	public void move(FPoint p) {
		this.x = p.x;
		this.y = p.y;
	}
	public FPoint increase(FPoint p) {
		this.x += p.x;
		this.y += p.y; 
		return this;
	}
	public FPoint increase(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	public FPoint add(FPoint p) {
		return new FPoint(x + p.x,y + p.y);
	}
	public FPoint add(float x, float y) {
		return new FPoint(x + this.x,y + this.y);
	}
	public FPoint sub(FPoint p) {
		return new FPoint(x - p.x,y - p.y);
	}
	public FPoint sub(float x, float y) {
		return new FPoint(this.x - x,this.y - y);
	}
	public FPoint decrease(FPoint p ) {
		this.x -= p.x;
		this.y -= p.y;
		return this;
	}
	public FPoint decrease(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	public FPoint scalMulWith(float mul) {
		this.x *= mul;
		this.y *= mul;
		return this;
	}
	public FPoint scalMul(float mul) {
		return new FPoint(this).scalMulWith(mul);
	}
	public float getx() {
		return x;
	}
	public float gety() {
		return y;
	}
	public boolean equals(FPoint p) {
		return x == p.x && y == p.y;
	}
	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}
}
