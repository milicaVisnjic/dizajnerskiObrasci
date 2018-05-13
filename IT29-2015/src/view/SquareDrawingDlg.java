package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.SquareConfirmationListener;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SquareDrawingDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSideLength;
	private int sideLength;
	private boolean enteredData ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SquareDrawingDlg dialog = new SquareDrawingDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SquareDrawingDlg() {
		setModal(true);
		setBounds(100, 100, 410, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Square drawing");
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			JLabel lblDuzinaStranice = new JLabel("Side length: ");
			contentPanel.add(lblDuzinaStranice);
		}
		{
			txtSideLength = new JTextField();
			contentPanel.add(txtSideLength);
			txtSideLength.setColumns(5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new SquareConfirmationListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.enteredData = false;
	}
	
	public String getLengthText() {
		return txtSideLength.getText();
	}
	public void setSideLength(int sideLength) {
		this.enteredData=true;
		this.sideLength = sideLength;
	}
	public int getSideLength()
	{

		return sideLength;
	}

	public boolean isEnteredData() {
		return enteredData;
	}


}


