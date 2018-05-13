package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class SelectColorMouseAdapter extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JButton button = (JButton)arg0.getComponent();
		Color color= JColorChooser.showDialog(null, "Choose color", Color.black);
		button.setBackground(color);
	
	}
}
