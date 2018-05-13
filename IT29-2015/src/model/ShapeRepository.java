package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ShapeRepository extends Observable{
	
	private List<Shape> shapes;

	private List<Shape> selectedShapes;
	
	private static ShapeRepository instance = null; 
	
	private ShapeRepository() { 
		this.shapes = new ArrayList<>();
		this.selectedShapes = new ArrayList<>();
	}
	
	public static ShapeRepository getInstance() {
		if(instance == null) { //ako jos nismo kreirali instancu, sada je kreiramo
			instance = new ShapeRepository(); 
		}
		return instance; 
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}

	public List<Shape> getSelectedShapes() {
		return selectedShapes;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		setChanged();
		notifyObservers(selectedShapes.size());
	}
	
	public void removeShape(List<Shape> shapes) {
		this.shapes.removeAll(shapes);
		removeSelectedShapes();
	}
	
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
		removeSelectedShape(shape);
	}
	
	public void addSelectedShape(Shape shape) {
		selectedShapes.add(shape);
		setChanged();
		notifyObservers(selectedShapes.size());
	}
	
	public void removeSelectedShape(Shape shape) {
		selectedShapes.remove(shape);
		setChanged();
		notifyObservers(selectedShapes.size());
	}
	
	public void removeSelectedShapes() {
		selectedShapes.clear();
		shapes.stream().forEach(s->s.setSelected(false));
		setChanged();
		notifyObservers(selectedShapes.size());
	}
	
	public Shape getShape(long id) { //get shape na osnovu id-ja
		for(Shape shape : shapes) {
			if(shape.getId() == id) {
				return shape;
			}
		}
		return null;
	}
	
	public int getIndexOf(Shape shape) {
		for(int i = 0; i<shapes.size(); i++) {
			if(shapes.get(i).getId() == shape.id) {
				return i;
			}
		}
		return -1;
	}
	
	public void notifyDraw() {
		setChanged();
		notifyObservers(selectedShapes.size());
	}

	public void add(int index, Shape shape) {
		shapes.add(index ,shape);
		setChanged();
		notifyObservers(selectedShapes.size());
	}
	
	
}
