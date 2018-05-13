package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Line;
import model.Point;
import view.LineDlg;

public class ModificationLineListener implements ActionListener {
	private LineDlg dl;
	
	
	public ModificationLineListener(LineDlg dl) {
		super();
		this.dl = dl;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

		try{
			int x1=Integer.parseInt(dl.getx1());
			int y1=Integer.parseInt(dl.gety1());
			int x2=Integer.parseInt(dl.getx2());
			int y2=Integer.parseInt(dl.gety2());
			
			if (x1<=0 || y1<=0 || x2<=0 || y2<=0)
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			else
			{
				Line line=new Line (new Point (x1,y1), new Point (x2,y2), dl.getBtnLineColor().getBackground());
				dl.setLine(line);
				dl.setVisible(false);
			}
			
			
			
			
		} catch (Exception e1) {
		
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
	}
		
}
