package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import view.PointModificationDlg;

public class ModificationPointListener implements ActionListener {
	private PointModificationDlg dtm;

	
	public ModificationPointListener(PointModificationDlg dtm) {
		super();
		this.dtm = dtm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			int x=Integer.parseInt(dtm.getx());
			int y=Integer.parseInt(dtm.gety());
			
			
			
			if (x <= 0 || y<=0 )
			{
				JOptionPane.showMessageDialog(null, "Coordinates must be greater than 0!");
			}
			
			else {
				Point point = new Point (x,y,dtm.getBtnColor().getBackground());
				dtm.setPoint(point);
				dtm.setVisible(false);
			}
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter both coordinates!");
		
		}
	
		
	}

}
