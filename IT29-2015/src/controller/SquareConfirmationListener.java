package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.SquareDrawingDlg;

public class SquareConfirmationListener implements ActionListener {
	private SquareDrawingDlg dkc;
	
	public SquareConfirmationListener(SquareDrawingDlg dkc) {
		super();
		this.dkc = dkc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int sideLength=Integer.parseInt(dkc.getLengthText());
			if (sideLength <= 0)
			{
				JOptionPane.showMessageDialog(null, "Error! Side length must be greater than 0!");
			}
			else
			{
				dkc.setSideLength(sideLength);
				dkc.setVisible(false);
				
			}
			
		} catch (Exception e1) {
		
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
				
		}
	}

}
