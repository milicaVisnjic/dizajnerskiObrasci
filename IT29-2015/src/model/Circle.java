package model;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Circle extends SurfaceShape implements Moveable{
	private Point center;
	private int r;


	public Circle(){
		super();
	}
	public Circle(Point center, int r){
		this();
		this.center = center;
		this.r = r;
	}
	public Circle(Point center, int r, Color color){
		this(center, r);
		setColor(color);
	}
	
	public Circle(Point center, int r, Color contourColor, Color insideColor){
		this(center, r, contourColor);
		setInsideColor(insideColor);
	}

	public String toString(){
		return "Circle:" + center.toStringPoint() + ",radius=" + r + ",colorLine="+getColor()+",colorArea="+getInsideColor()+",id="+getId();
	}

	public void moveTo(int x, int y) {
		center.setX(x);
		center.setY(y);
	}
	public void moveBy(int x, int y) {
		center.setX(center.getX()+x);
		center.setY(center.getY()+y);
	}
	public double area(){
		return r * r * Math.PI;
	}
	public double perimeter(){
		return 2 * r * Math.PI;
	}
	public boolean contains(int x, int y){
		Point pointOfclick = new Point(x, y);
		if(pointOfclick.distance(center)<=r)
			return true;
		else
			return false;
		
	}
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		new Line(new Point(center.getX(), center.getY()-r), new Point(center.getX(), center.getY() + r)).selected(g);
		new Line(new Point(center.getX()-r, center.getY()), new Point(center.getX()+r, center.getY())).selected(g);
	}
	public void drawShape(Graphics g){
		fill(g);
		g.setColor(getColor());
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r*2);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getInsideColor());
		g.fillOval(center.getX()-r, center.getY()-r, 2*r+1, r*2+1);
	}

	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle extraCircle  = (Circle) o;
			return this.r - extraCircle.r;
		}
		else
			return 0;
	}
	public Point getCentar() {
		return center;
	}
	public int getR() {
		return r;
	}
	public void setCentar(Point center) {
		this.center = center;
	}
	




}
