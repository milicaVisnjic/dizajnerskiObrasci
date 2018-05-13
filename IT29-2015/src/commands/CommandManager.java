package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class CommandManager extends Observable{
	private List<AbstractComand> commands;
	private int index; //indeks je postavljen na poslednje izvrsenu komandu
	private static CommandManager instance = null;
	
	private CommandManager() {
		setIndex(-1);
		commands = new ArrayList<>();
	}
	
	public static CommandManager getInstance() {
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void addCommand(AbstractComand command) {
		if(index != commands.size()-1 ) {//ako indeks ne pokazuje na poslednju komandu tj ako je odradjen undo
			for(int i = commands.size()-1; i>index; i--) {
				commands.remove(i);
			}
		}
		commands.add(command);
		setIndex(getIndex() + 1);
		setChanged();
		notifyObservers(index); //da bi bili omoguceni undo i redo
	}
	
	public void removeCommand(AbstractComand command) {
		commands.remove(command); //brisanje komande
		setIndex(getIndex() - 1); 
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		setChanged();
		notifyObservers(index);
	}
	
	public AbstractComand getCommand(int index) {
		return commands.get(index);
	}
	
	public int numberOfCommands() {
		return commands.size();
	}
	
	//zbog ucitavanja novog loga ili novog crteza moramo izbrisati sve prethodne komande
	public void clearAllCommands() { 
		commands.clear();
		index = -1;
		setChanged();
		notifyObservers(index); //da undo i redo budu invisible
	}

	
}
