package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import hexagon.Hexagon;
import model.Circle;
import model.HexagonAdapter;
import model.Point;
import model.Shape;
import view.CircleModificationDlg;

public class ModificationCircleListener implements ActionListener {
	
	private CircleModificationDlg dkm ;
	private Shape selectedShape;
	
	public ModificationCircleListener(CircleModificationDlg dkm, Shape shape) {
		super();
		this.dkm = dkm;
		this.selectedShape = shape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			int x=Integer.parseInt(dkm.getx());
			int y=Integer.parseInt(dkm.gety());
			int r=Integer.parseInt(dkm.getRadiusText());
			
			if (x <=0 || y<=0 || r<=0)
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			
			else{
				Shape newShape;
				if(selectedShape instanceof Circle) {
					newShape= new Circle(new Point (x,y), r, dkm.getBtnContourColor().getBackground(), dkm.getBtnAreaColor().getBackground());
				}else {
					Hexagon hexagon= new Hexagon(x, y, r);
					hexagon.setAreaColor( dkm.getBtnAreaColor().getBackground());
					hexagon.setBorderColor(dkm.getBtnContourColor().getBackground());
					newShape = new HexagonAdapter(hexagon);
				}
				dkm.setShape(newShape);
				dkm.setVisible(false);

			}
			
		} catch (Exception ee) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
		}
		
	}

}
