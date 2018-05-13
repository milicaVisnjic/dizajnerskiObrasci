package serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import commands.CommandManager;
import model.Shape;
import model.ShapeRepository;

public class SerializeDrawing implements SerializeStrategy {

	
	private ShapeRepository repository; 
	
	public  SerializeDrawing() {
		repository = ShapeRepository.getInstance();
	}
	@Override
	public void save(String path) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path))) ){
			for(Shape shape : repository.getShapes()) {
				oos.writeObject(shape); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error saving file: "+ path, "Save error", JOptionPane.ERROR_MESSAGE);

		}
	}

	@Override
	public void load(String path) {
		
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path))) ){
			repository.getShapes().clear();
			repository.getSelectedShapes().clear();
			CommandManager.getInstance().clearAllCommands();
			Shape shape;
			try {
				while( (shape=(Shape) ois.readObject()) != null) { 
						repository.addShape(shape);
				}
			}catch (EOFException e) {
				return;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error by reading file: "+ path, "Error loading file", JOptionPane.ERROR_MESSAGE);

		}
	}

}
