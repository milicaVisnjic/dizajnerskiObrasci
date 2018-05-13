package model;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public abstract class SurfaceShape extends Shape {
	private Color insideColor = Color.WHITE;
	private String insideColorStr = "white";
	
	public SurfaceShape() {
		super();
	}
	
	public abstract void fill(Graphics g);

	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	public String getInsideColorStr() {
		return insideColorStr;
	}

	public void setInsideColorStr(String insideColorStr) {
		this.insideColorStr = insideColorStr;
	}

}
