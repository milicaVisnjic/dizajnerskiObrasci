package model;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Line extends Shape implements Moveable{
	private Point tStart;
	private Point tEnd;

	public Line(){
		super();
	}
	public Line(Point tStart, Point tEnd){
		this();
		this.tStart = tStart;
		this.tEnd = tEnd;
	}

	public Line(Point tStart, Point tEnd, Color color){
		this(tStart, tEnd);
		setColor(color);
	}

	public Point middleOfLine(){
		int middleX = (tStart.getX() + tEnd.getX()) / 2;
		int middleY = (tStart.getY() + tEnd.getY()) / 2;
		return new Point(middleX, middleY);
	}

	public String toString(){
		return "Line:("+tStart.getX()+"," +tStart.getY()+"),(" + tEnd.getX()+","+ tEnd.getY() + "),color="+ getColor()+",id="+getId();
	}

	public boolean equals(Object obj){
		if(obj instanceof Line){
			Line extraLine=(Line) obj;
			if(this.tStart.equals(extraLine.tStart) && this.tEnd.equals(extraLine.tEnd))
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public double lengthOfLine(){
		return tStart.distance(tEnd);
	}

	public void moveBy(int x, int y){
		tStart.setX(tStart.getX()+x);
		tStart.setY(tStart.getY()+y);
		tEnd.setX(tEnd.getX()+x);
		tEnd.setY(tEnd.getY()+y);

	}
	
	public void moveTo(int x, int y){
		int rx = tStart.getX() - tEnd.getX();
		int ry = tStart.getY() - tEnd.getY();
		tStart.setX(x);
		tStart.setY(y);
		tEnd.setX(x+rx);
		tEnd.setY(y+ry);
		
		
	}
	
	public boolean contains(int x, int y){
		Point placeOfClick = new Point(x, y);
		if(placeOfClick.distance(tStart)+placeOfClick.distance(tEnd)-this.lengthOfLine()<=0.5)
			return true;
		 else 
			return false;		
	}
	public void selected(Graphics g){
		g.setColor(Color.BLUE);
		tStart.selected(g);
		tEnd.selected(g);
		middleOfLine().selected(g);
	}
	public void drawShape(Graphics g){
		g.setColor(getColor());
		g.drawLine(tStart.getX(), tStart.getY(), tEnd.getX(), tEnd.getY());
		if(isSelected())
			selected(g);
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Line){
			Line extraLine  = (Line) o;
			
			return (int) (this.lengthOfLine()-extraLine.lengthOfLine());

		}
		else
			return 0;
	}
	public Point gettStart() {
		return tStart;
	}
	public void settStart(Point tStart) {
		this.tStart = tStart;
	}
	public Point gettEnd() {
		return tEnd;
	}
	public void settEnd(Point tEnd) {
		this.tEnd = tEnd;
	}
}
