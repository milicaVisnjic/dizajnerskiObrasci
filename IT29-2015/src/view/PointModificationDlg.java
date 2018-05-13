package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ModificationPointListener;
import controller.SelectColorMouseAdapter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

import model.Point;
import model.Shape;

@SuppressWarnings("serial")
public class PointModificationDlg extends JDialog {

	private final JPanel pnlPointMod = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	Color color;
	private Point point ;
	private JButton btnColor;
	
	public String getx() {
		return txtX.getText();
	}
	public String gety() {
		return txtY.getText();
	}
	/**
	 * Create the dialog.
	 */
	public PointModificationDlg(Shape selectedShape) {
		
		setModal(true);
		
		setBounds(100, 100, 379, 226);
		getContentPane().setLayout(new BorderLayout());
		pnlPointMod.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlPointMod, BorderLayout.CENTER);
		setTitle("Point modification");
		{
			JLabel lblX = new JLabel("Enter X coordinate:");
			pnlPointMod.add(lblX);
		}
		{
			txtX = new JTextField();
			pnlPointMod.add(txtX);
			txtX.setColumns(5);
			
			txtX.setText("" + ((Point) selectedShape).getX());
		}
		{
			JLabel lblY = new JLabel("Enter Y coordinate:");
			pnlPointMod.add(lblY);
		}
		{
			txtY = new JTextField();
			pnlPointMod.add(txtY);
			txtY.setColumns(5);
			txtY.setText("" + ((Point) selectedShape).getY());
		}
		{
			JLabel lblBojaKonture = new JLabel("Color:");
			pnlPointMod.add(lblBojaKonture);
		}
		{
			btnColor = new JButton("");
			System.out.println(((Point) selectedShape).getColor());
			btnColor.setBackground(((Point) selectedShape).getColor());
			btnColor.addMouseListener(new SelectColorMouseAdapter());
			pnlPointMod.add(btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ModificationPointListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public void setPoint(Point p) {
		point = p;
	}
	
	public Point getData()
	{
		return point;
	}

	public JButton getBtnColor() {
		return btnColor;
	}
}
