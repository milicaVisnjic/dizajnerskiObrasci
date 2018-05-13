package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.CommandManager;
import commands.ModificationCommand;
import model.Circle;
import model.HexagonAdapter;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.ShapeRepository;
import model.Square;
import view.CircleModificationDlg;
import view.SquareModificationDlg;
import view.LineDlg;
import view.RectangleModificationDlg;
import view.PointModificationDlg;
import view.GuiDrawing;

public class UpdateActionListener implements ActionListener{
	private ShapeRepository repository;
	private GuiDrawing gui;
	

	public UpdateActionListener(GuiDrawing gui) {
		super();
		repository = ShapeRepository.getInstance();
		this.gui = gui; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(repository.getSelectedShapes().size() != 1) { //mora da se nalazi samo jedan jedini selektovani oblik
			return;
		}
		
		Shape shape = null;
		Shape selectedShape = repository.getSelectedShapes().get(0); //uzimamo prvi i jedini selektovani oblik
		//u zavisnosti od oblika poziva se dijalog 
		if ( selectedShape instanceof Point)
		{

			 PointModificationDlg dt = new PointModificationDlg(selectedShape);
			
		     dt.setVisible(true);
		     
		     if (dt.getData()!=null)
		     {
		    	 shape = dt.getData(); 	
		     }
			
		}else if(selectedShape instanceof Line) {
			LineDlg dl = new LineDlg(selectedShape);
			dl.setVisible(true);
			 if (dl.getData()!=null)
		     {
		    	 shape = dl.getData(); 	
		     }
		}else if(selectedShape instanceof Rectangle) {
			RectangleModificationDlg dp = new RectangleModificationDlg(selectedShape);
			dp.setVisible(true);
			 if (dp.getData()!=null)
		     {
		    	 shape = dp.getData(); 	
		     }
		}else if(selectedShape instanceof Square) {
			SquareModificationDlg dk = new SquareModificationDlg(selectedShape);
			dk.setVisible(true);
			 if (dk.getData()!=null)
		     {
		    	 shape = dk.getData(); 	
		     }
		}else if(selectedShape instanceof Circle) {
			CircleModificationDlg dk = new CircleModificationDlg(selectedShape);
			dk.setVisible(true);
			 if (dk.getPodaci()!=null)
		     {
		    	 shape = dk.getPodaci(); 	
		     }
		}else if(selectedShape instanceof HexagonAdapter) {
			CircleModificationDlg dk = new CircleModificationDlg(selectedShape);
			dk.setVisible(true);
			 if (dk.getPodaci()!=null)
		     {
		    	 shape = dk.getPodaci(); 	
		     }
		}
		
		if(shape == null) {
			return;
		}
		
		CommandManager commandManager = CommandManager.getInstance(); 
		ModificationCommand modificationCommand = new ModificationCommand(selectedShape,shape); 
		modificationCommand.execute(); 
		commandManager.addCommand(modificationCommand);
		gui.getUndoButton().setEnabled(true);
		gui.getRedoButton().setEnabled(false);

	}

}
