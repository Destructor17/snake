package snakegame;

public class SquareShape {
	private Point center;
	private Point animDir;
	public Point getAnimDir() {
		return animDir;
	}
	private int size;
	public SquareShape(Point center,int size,Point animDir) {
		this.setCenter(center);
		this.setSize(size);
		this.setAnimDir(animDir);
	}
	private void setAnimDir(Point animDir) {
		this.animDir = animDir;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Point getCornerTL() {
		return new Point(center.getx() - size/2, center.gety() - size/2);
	}
	public Point getCornerBR() {
		return new Point(center.getx() + size/2, center.gety() + size/2);
	}
}
