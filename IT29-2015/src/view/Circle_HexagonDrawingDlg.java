package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CircleConfirmationListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Circle_HexagonDrawingDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private int radius;


	/**
	 * Create the dialog.
	 */
	public Circle_HexagonDrawingDlg() {
		setModal(true); 
		setBounds(100, 100, 403, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Drawing");
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		{
			JLabel lblPoluprecnik = new JLabel("Radius:");
			contentPanel.add(lblPoluprecnik);
		}
		{
			txtRadius = new JTextField();
			contentPanel.add(txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new CircleConfirmationListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public int getRadius()
	{
		return radius;
	}

	public String getRadiusText() {
		return txtRadius.getText();
	}

	public void setRadius(int radius) {
			this.radius = radius;
	}
	
	public boolean isEnteredData() {
		if(radius > 0) {
			return true;
		}
		return false;
	}

}
