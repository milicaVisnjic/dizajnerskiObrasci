package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import model.Rectangle;
import view.RectangleModificationDlg;

public class ModificationRectangleListener implements ActionListener {
	
	private RectangleModificationDlg dpm;
	
	public ModificationRectangleListener(RectangleModificationDlg dpm) {
		super();
		this.dpm = dpm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			int x=Integer.parseInt(dpm.getx());
			int y=Integer.parseInt(dpm.gety());
			int height=Integer.parseInt(dpm.getHeightText());
			int width=Integer.parseInt(dpm.getWidthText());
			
			if (x<=0 || y<=0 || height<=0 || width<=0)
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			
			else {
				dpm.setVisible(false);
				Rectangle rectangle= new Rectangle(new Point(x,y), width, height,dpm.getBtnConturColor().getBackground(), dpm.getBtnAreaColor().getBackground());
				dpm.setRectangle(rectangle);
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
	}
		

}
