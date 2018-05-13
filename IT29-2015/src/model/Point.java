package model;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Point extends Shape implements Moveable{
	private int x;
	private int y;
	

	public Point(){
		super();
	}
	public Point(int x, int y){
		this();
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color color) {
		this(x,y);
		setColor(color);
		
	}
	public String toString(){
		return "Point:(" + x+ ","+ getY()+ "),color="+getColor()+",id="+getId();
	}
	
	public String toStringPoint() {
		return "(" + x+ ","+ getY()+ ")";
	}

	public boolean equals(Object obj){
		if(obj instanceof Point){
			Point extraPoint=(Point) obj;
			if(x==extraPoint.getX() && y==extraPoint.getY())
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public void moveTo(int newX, int newY){
		x = newX;
		y = newY;
	}

	public void moveBy(int newX, int newY){
		x = x + newX;
		y = y + newY;
	}

	public double distance(Point t2){
		double dx = x - t2.x;
		double dy = y - t2.getY();
		double result = Math.sqrt(dx*dx + dy*dy);

		return result;
	}
	public boolean contains(int x, int y){
		Point placeOfClick = new Point(x, y);
		if(placeOfClick.distance(this)<=2)
			return true;
		else
			return false;

	}
	public void selected(Graphics g){
		g.setColor(findColor("blue"));
		g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
	}
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected())
			selected(g);

	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Point){
			
			Point zero = new Point(0, 0);
			Point secondExtraPoint = new Point(x, y);
			int extraPoint1 = (int) zero.distance(secondExtraPoint);
			int extraPoint2 = (int) zero.distance(secondExtraPoint);

			return extraPoint1 - extraPoint2;

		}
		else
			return 0;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setX(int newX){
		
			x = newX;
	}
	public void setY(int newY){
		
	
			y = newY;
	}

}
