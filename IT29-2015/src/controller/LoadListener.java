package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import serialization.SerializeDrawing;
import serialization.SerializeLog;
import serialization.Serializer;

public class LoadListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Serializer serializer = new Serializer();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		JButton button = (JButton)e.getSource();
		if(button.getName().equals("btnLoadLog")) {
			serializer.setSerializeStrategy(new SerializeLog());
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
			fileChooser.setFileFilter(filter);
			
		}else {
			serializer.setSerializeStrategy(new SerializeDrawing());
			FileNameExtensionFilter filter = new FileNameExtensionFilter("bin", "bin");
			fileChooser.setFileFilter(filter);
		}
		int returnValue = fileChooser.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			serializer.load(fileChooser.getSelectedFile().getPath()); 
		}
	}

}
