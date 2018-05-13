package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ModificationLineListener;
import controller.SelectColorMouseAdapter;
import model.Line;
import model.Shape;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LineDlg extends JDialog {

	private final JPanel pnlLine = new JPanel();
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;
	private Line l1 = null;
	private JButton btnLineColor;

	/**
	 * Create the dialog.
	 */
	public LineDlg(Shape selectedShape) {
		setModal(true);
		setBounds(100, 100, 650, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlLine.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlLine, BorderLayout.CENTER);
		setTitle("Line");
		
		{
			JLabel lblX1 = new JLabel("X coordinate of the first point:");
			pnlLine.add(lblX1);
		}
		{
			txtX1 = new JTextField();
			pnlLine.add(txtX1);
			txtX1.setColumns(5);
			txtX1.setText("" + ((Line)selectedShape).gettStart().getX());
		}
		{
			JLabel lblY1 = new JLabel("Y coordinate of the first point:");
			pnlLine.add(lblY1);
		}
		{
			txtY1 = new JTextField();
			pnlLine.add(txtY1);
			txtY1.setColumns(5);
			txtY1.setText(""  + ((Line)selectedShape).gettStart().getY());
		}
		{
			JLabel lblX2 = new JLabel("X coordinate of the second point:");
			pnlLine.add(lblX2);
		}
		{
			txtX2 = new JTextField();
			pnlLine.add(txtX2);
			txtX2.setColumns(5);
			txtX2.setText("" + ((Line)selectedShape).gettEnd().getX());
		}
		{
			JLabel lblY2 = new JLabel("Y coordinate of the second point:");
			pnlLine.add(lblY2);
		}
		{
			txtY2 = new JTextField();
			pnlLine.add(txtY2);
			txtY2.setColumns(5);
			txtY2.setText("" + ((Line)selectedShape).gettEnd().getY());
		}
		{
			JLabel lblColor = new JLabel("Color:");
			pnlLine.add(lblColor);
		}
		{
			btnLineColor = new JButton("");
			btnLineColor.setBackground(Color.BLACK);
		
			btnLineColor.setBackground(((Line)selectedShape).getColor());

			btnLineColor.addMouseListener(new SelectColorMouseAdapter());
			pnlLine.add(btnLineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ModificationLineListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public String getx1() {
		return txtX1.getText();
	}
	public String gety1() {
		return txtY1.getText();
	}
	public String getx2() {
		return txtX2.getText();
	}
	public String gety2() {
		return txtY2.getText();
	}
	public void setLine(Line line) {
		l1 =line;
	}

	public Line getData()
	{
		return l1;
	}

	public JButton getBtnLineColor() {
		return btnLineColor;
	}
}
