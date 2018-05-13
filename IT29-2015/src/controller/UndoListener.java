package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.AbstractComand;
import commands.CommandManager;
import model.ShapeRepository;

public class UndoListener implements ActionListener {


	public UndoListener( ) {
		super();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		ShapeRepository.getInstance().removeSelectedShapes();  
		CommandManager commandManager = CommandManager.getInstance();
		int index = commandManager.getIndex();
		AbstractComand command = commandManager.getCommand(index); 
		command.unexecute();
		commandManager.setIndex(index-1); 
		

	}

}
