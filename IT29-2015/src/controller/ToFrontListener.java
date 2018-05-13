package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Shape;
import model.ShapeRepository;

public class ToFrontListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ShapeRepository repository =  ShapeRepository.getInstance();
		List<Shape> selectedShapes =repository.getSelectedShapes();
		for (Shape selectedShape : selectedShapes) {
			int selectedIndex = repository.getIndexOf(selectedShape);
			Shape nextShape = repository.getShapes().get(selectedIndex+1);
			repository.getShapes().remove(selectedIndex);
			repository.getShapes().remove(selectedIndex);
			repository.getShapes().add(selectedIndex, nextShape);
			repository.getShapes().add(selectedIndex+1, selectedShape);
			repository.notifyDraw();
		
		}
		

	}

}
