package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ModificationRectangleListener;
import controller.SelectColorMouseAdapter;
import model.Rectangle;
import model.Shape;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RectangleModificationDlg extends JDialog {

	private final JPanel pnlRectangleMod = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton btnContourColor;
	private JButton btnAreaColor;
	private Rectangle pr1 = null;
	

	/**
	 * Create the dialog.
	 */
	public RectangleModificationDlg(Shape selectedShape) {
		setModal(true);
		setBounds(100, 100, 358, 264);
		getContentPane().setLayout(new BorderLayout());
		pnlRectangleMod.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Rectangle modification");
		getContentPane().add(pnlRectangleMod, BorderLayout.CENTER);
		{
			JLabel lblX = new JLabel("Top left point X coordinate:");
			pnlRectangleMod.add(lblX);
		}
		{
			txtX = new JTextField();
			pnlRectangleMod.add(txtX);
			txtX.setColumns(5);
			txtX.setText("" + ((Rectangle)selectedShape).getTopLeftPoint().getX());
		}
		{
			JLabel lblY = new JLabel("Top left point Y coordinate:");
			pnlRectangleMod.add(lblY);
		}
		{
			txtY = new JTextField();
			pnlRectangleMod.add(txtY);
			txtY.setColumns(5);
			txtY.setText(""+ ((Rectangle)selectedShape).getTopLeftPoint().getY());
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			pnlRectangleMod.add(lblHeight);
		}
		{
			txtHeight = new JTextField();
			pnlRectangleMod.add(txtHeight);
			txtHeight.setColumns(5);
			txtHeight.setText("" + ((Rectangle)selectedShape).getHeight());
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			pnlRectangleMod.add(lblWidth);
		}
		{
			txtWidth = new JTextField();
			pnlRectangleMod.add(txtWidth);
			txtWidth.setColumns(5);
			txtWidth.setText("" + ((Rectangle)selectedShape).getWidth());
		}
		{
			JLabel lblContourColor = new JLabel("Contur color:");
			pnlRectangleMod.add(lblContourColor);
		}
		{
			btnContourColor = new JButton("");
			btnContourColor.setBackground(((Rectangle)selectedShape).getColor());
			btnContourColor.addMouseListener(new SelectColorMouseAdapter());
			pnlRectangleMod.add(btnContourColor);
		}
		{
			JLabel lblAreaColor = new JLabel("Area color:");
			pnlRectangleMod.add(lblAreaColor);
		}
		{
			btnAreaColor = new JButton("");
			btnAreaColor.setBackground(((Rectangle)selectedShape).getInsideColor());
			btnAreaColor.addMouseListener(new SelectColorMouseAdapter());
			pnlRectangleMod.add(btnAreaColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ModificationRectangleListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
		}
	}
	
	public Rectangle getData()
	{
		return pr1;
	}

	public String getx() {
		return txtX.getText();
	}
	
	public String gety() {
		return txtY.getText();
	}
	public String getHeightText() {
		return txtHeight.getText();
	}
	public String getWidthText() {
		return txtWidth.getText();
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.pr1 = rectangle;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}
	
	public JButton getBtnConturColor() {
		return btnContourColor;
	}
	

}
