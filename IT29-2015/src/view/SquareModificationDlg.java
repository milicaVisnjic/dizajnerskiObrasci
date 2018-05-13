package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ModificationSquareListener;
import controller.SelectColorMouseAdapter;
import model.Shape;
import model.Square;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SquareModificationDlg extends JDialog {

	private final JPanel pnlSquareModification = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtSideLength;
	JButton btnContourColor;
	JButton btnAreaColor;
	private Square k1 = null;

	/**
	 * Create the dialog.
	 */
	public SquareModificationDlg(Shape selectedShape) {
		setModal(true);
		setBounds(100, 100, 650, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlSquareModification.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Square modification");
		getContentPane().add(pnlSquareModification, BorderLayout.CENTER);
	
		{
			JLabel lblX = new JLabel("Upper left point X coordinate:");
			pnlSquareModification.add(lblX);
		}
		{
			txtX = new JTextField();
			pnlSquareModification.add(txtX);
			txtX.setColumns(5);
			txtX.setText("" + ((Square)selectedShape).getTopLeftPoint().getX());
		}
		{
			JLabel lblY = new JLabel("Upper left point Y coordinate:");
			pnlSquareModification.add(lblY);
		}
		{
			txtY = new JTextField();
			pnlSquareModification.add(txtY);
			txtY.setColumns(5);
			txtY.setText("" + ((Square)selectedShape).getTopLeftPoint().getY());
		}
		{
			JLabel lblSideLength = new JLabel("Side length:");
			pnlSquareModification.add(lblSideLength);
		}
		{
			txtSideLength = new JTextField();
			pnlSquareModification.add(txtSideLength);
			txtSideLength.setColumns(5);
			txtSideLength.setText(""+((Square)selectedShape).getSideLength());
		}
		{
			JLabel lblContourColor = new JLabel("Contour color:");
			pnlSquareModification.add(lblContourColor);
		}
		{
			btnContourColor = new JButton("");
			btnContourColor.setBackground(((Square)selectedShape).getColor());
			btnContourColor.addMouseListener(new SelectColorMouseAdapter());
			pnlSquareModification.add(btnContourColor);
		}
		{
			JLabel lblAreaColor = new JLabel("Area color:");
			pnlSquareModification.add(lblAreaColor);
		}
		{
			btnAreaColor = new JButton("");
			btnAreaColor.setBackground(((Square)selectedShape).getInsideColor());
			btnAreaColor.addMouseListener(new SelectColorMouseAdapter());
			pnlSquareModification.add(btnAreaColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ModificationSquareListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	
	public String getx() {
		return txtX.getText();
	}
	
	public String gety() {
		return txtY.getText();
	}
	
	public String getSideLength() {
		return txtSideLength.getText();
	}
	
	public void setSquare(Square square) {
		this.k1 = square;
	}
	
	public Square getData()
	{
		return k1;
		
	}


	public JButton getBtnContourColor() {
	
		return btnContourColor;
	}


	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

}
