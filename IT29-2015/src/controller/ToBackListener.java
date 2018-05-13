package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Shape;
import model.ShapeRepository;

public class ToBackListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeRepository repository =  ShapeRepository.getInstance();
		List<Shape> selectedShapes =repository.getSelectedShapes();
		for (Shape selectedShape : selectedShapes) {
			int selectedIndex = repository.getIndexOf(selectedShape);
			Shape previousShape = repository.getShapes().get(selectedIndex-1);
			repository.getShapes().remove(selectedIndex-1);
			repository.getShapes().remove(selectedIndex-1);
			repository.getShapes().add(selectedIndex-1, selectedShape);
			repository.getShapes().add(selectedIndex, previousShape);
			repository.notifyDraw();
		
		}
		

	}

}
