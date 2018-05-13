package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Shape;
import model.ShapeRepository;

public class BringToFrontListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeRepository repository =  ShapeRepository.getInstance();
		List<Shape> selectedShapes =repository.getSelectedShapes();
		for (Shape selectedShape : selectedShapes) {
			int selectedIndex = repository.getIndexOf(selectedShape);
			repository.getShapes().remove(selectedIndex);
			repository.getShapes().add(selectedShape);
			repository.notifyDraw();
		
		}
		

	}

}
