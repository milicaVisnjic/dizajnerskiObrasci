package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import serialization.SerializeDrawing;
import serialization.SerializeLog;
import serialization.Serializer;

public class SaveListener implements ActionListener {

	//u zavisnosti od toga koje je dugme kliknuto, radimo serijalizaciju 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Serializer serializer = new Serializer(); 
		JFileChooser fileChooser = new JFileChooser(); 
		fileChooser.setAcceptAllFileFilterUsed(false); 
		
		JButton button = (JButton)e.getSource(); 
		boolean selectedLogButton = button.getName().equals("btnSaveLog"); 
		if(selectedLogButton) {
			serializer.setSerializeStrategy(new SerializeLog());
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
			fileChooser.setFileFilter(filter);
			
		}else {
			serializer.setSerializeStrategy(new SerializeDrawing()); 
			FileNameExtensionFilter filter = new FileNameExtensionFilter("bin", "bin"); 
			fileChooser.setFileFilter(filter); 
		}
		int returnValue = fileChooser.showSaveDialog(null); 
		if(returnValue == JFileChooser.APPROVE_OPTION) { 
			String path = fileChooser.getSelectedFile().getAbsolutePath(); 
			if(selectedLogButton) {
				if(!path.endsWith(".txt")){ 
					path += ".txt"; 
				}
			}else {
				if(!path.endsWith(".bin")){
					path += ".bin";
				}
			}
			
			serializer.save(path); 
		}
	}

}
