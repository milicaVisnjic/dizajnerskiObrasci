package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Circle_HexagonDrawingDlg;


public class CircleConfirmationListener implements ActionListener{

	
private Circle_HexagonDrawingDlg dkc;
	
	public CircleConfirmationListener(Circle_HexagonDrawingDlg dkc) {
		super();
		this.dkc = dkc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			
			int r=Integer.parseInt(dkc.getRadiusText());
			if (r <= 0)
			{
				JOptionPane.showMessageDialog(null, "Error! Radius must be greater than 0!");
			}
			else
			{
				dkc.setRadius(r);
				dkc.setVisible(false);
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
		
		}
	}

}
