package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.AbstractComand;
import commands.CommandManager;
import model.ShapeRepository;

public class RedoListener implements ActionListener {

	
	
	public RedoListener() {
		super();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeRepository.getInstance().removeSelectedShapes();
		CommandManager commandManager = CommandManager.getInstance();
		int index = commandManager.getIndex();
		AbstractComand command = commandManager.getCommand(index+1);
		command.execute();
		commandManager.setIndex(index+1);
	}

}
