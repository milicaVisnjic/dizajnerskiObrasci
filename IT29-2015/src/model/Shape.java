package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Shape implements Serializable {
	public Color color = Color.BLACK;
	private String colorStr = "black";
	private boolean selected;
	
	public Shape(){
		id = ShapeRepository.getInstance().getShapes().size();
	}
	public Shape(Color color){
		this.color = color;
	}
	
	public long id;

	public abstract void drawShape(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);

	public static Color findColor(String color){
		if(color.equalsIgnoreCase("black"))
			return Color.BLACK;
		else if(color.equalsIgnoreCase("white"))
			return Color.WHITE;
		else if(color.equalsIgnoreCase("blue"))
			return Color.BLUE;
		else if(color.equalsIgnoreCase("red"))
			return Color.RED;
		else if(color.equalsIgnoreCase("yellow"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("green"))
			return Color.GREEN;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getColorStr() {
		return colorStr;
	}
	public void setColorStr(String colorStr) {
		this.colorStr = colorStr;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
		
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
