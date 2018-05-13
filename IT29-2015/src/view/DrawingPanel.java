package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Shape;
import model.ShapeRepository;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel implements Observer {
	
	private ShapeRepository repository;
	
	public DrawingPanel()
	{
		repository = ShapeRepository.getInstance();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		repository = ShapeRepository.getInstance();
		for (Shape o : repository.getShapes())
		{
			o.drawShape(g);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.paintComponent(this.getGraphics());	
	}
}
