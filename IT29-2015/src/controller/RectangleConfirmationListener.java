package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.RectangleDrawingDlg;

public class RectangleConfirmationListener implements ActionListener {
	
	private RectangleDrawingDlg dpc;
	
	public RectangleConfirmationListener(RectangleDrawingDlg dpc) {
		super();
		this.dpc = dpc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{

			int height=Integer.parseInt(dpc.getHeightText());
			int width=Integer.parseInt(dpc.getWidthText());
	

		if ( height <= 0 || width <=0 )
				
		{
			JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
		}
		else
		{
			
			dpc.setHeightRectangle(height);
			dpc.setWidthRectangle(width);
			dpc.setVisible(false);
		}
		
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
	
	}

}
