package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import commands.CommandManager;

@SuppressWarnings("serial")
public class LogPanel extends JPanel implements Observer{
	private JTextPane textPane;
	
	public LogPanel() {
		textPane = new JTextPane();
		textPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(1200, 150));
		this.add(scrollPane);
			
	}

	@Override
	public void update(Observable o, Object arg1) {
		
		CommandManager commandManager = (CommandManager)o;
		String log = ""; //string koji ce se ispisati u textPane
		for(int i = 0 ; i< commandManager.numberOfCommands(); i++) {
			if(i == commandManager.getIndex()) { //ako je i-ta komanda na tekucem indeksu
				log+="--->>";
			}
			log += commandManager.getCommand(i).getDescription();
			log += "\n";		
		}
		textPane.setText(log);
	}
}
