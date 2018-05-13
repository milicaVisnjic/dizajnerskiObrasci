package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import model.Square;
import view.SquareModificationDlg;

public class ModificationSquareListener implements ActionListener{
	private SquareModificationDlg dkm;
	
	
	public ModificationSquareListener(SquareModificationDlg dkm) {
		super();
		this.dkm = dkm;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			
			int x=Integer.parseInt(dkm.getx());
			int y=Integer.parseInt(dkm.gety());
			int sideLength=Integer.parseInt(dkm.getSideLength());
			
			if (x<=0 || y<=0 || sideLength<=0 )
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			else
			{
				dkm.setVisible(false);
				Square square= new Square(new Point(x,y), sideLength, dkm.getBtnContourColor().getBackground(), dkm.getBtnAreaColor().getBackground());
				dkm.setSquare(square);
			}
			
		} catch (Exception ee) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
		
	}
	
}
