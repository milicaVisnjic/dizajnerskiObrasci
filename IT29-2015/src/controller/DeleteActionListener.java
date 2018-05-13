package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.CommandManager;
import commands.DeleteCommand;
import model.ShapeRepository;
import view.DeleteDlg;
import view.GuiDrawing;

public class DeleteActionListener implements ActionListener {
	
	private GuiDrawing gui;
	private ShapeRepository repository;
	
	
	public DeleteActionListener(GuiDrawing gui) {
		super();
		this.gui = gui;
		repository = ShapeRepository.getInstance();
	}
   

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DeleteDlg b= new DeleteDlg();
		b.setVisible(true);
		
		if (b.getOptions()==1)
		{
			CommandManager commandManager = CommandManager.getInstance();
			DeleteCommand deleteCommand = new DeleteCommand(repository.getSelectedShapes());
			commandManager.addCommand(deleteCommand);
			deleteCommand.execute();
			
			gui.getUndoButton().setEnabled(true);
			gui.getRedoButton().setEnabled(false);

			
		}
	
	
	}


}
