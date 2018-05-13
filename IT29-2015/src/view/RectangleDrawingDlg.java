package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RectangleDrawingDlg extends JDialog {

	private final JPanel pnlRecrDrawing = new JPanel();
	private JTextField txtHeight;
	private JTextField txtWidth;
	protected int widthRectangle;
	protected int heightRectangle;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleDrawingDlg dialog = new RectangleDrawingDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDrawingDlg() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlRecrDrawing.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlRecrDrawing, BorderLayout.CENTER);
		setTitle("Rectangle drawing");
		pnlRecrDrawing.setLayout(null);
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setBounds(97, 68, 69, 14);
			pnlRecrDrawing.add(lblHeight);
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBounds(229, 65, 86, 20);
			pnlRecrDrawing.add(txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setBounds(97, 93, 69, 14);
			pnlRecrDrawing.add(lblWidth);
		}
		{
			txtWidth = new JTextField();
			txtWidth.setBounds(229, 96, 86, 20);
			pnlRecrDrawing.add(txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						try{
							
							
							
							heightRectangle=Integer.parseInt(txtHeight.getText());
							widthRectangle=Integer.parseInt(txtWidth.getText());
					

						if ( heightRectangle <= 0 || widthRectangle <=0 )
								
						{
							JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
						}
						else
						{
							
							
							setVisible(false);
						}
						
							
						} catch (Exception e1) {
							
							JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
						}
						
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
	public int  getWidthRectangle () 
	{
		return widthRectangle;
	}
	public int getHeightRectangle ()
	{
		return heightRectangle;
	}
	
	public void setHeightRectangle(int visina) {
		
		this.heightRectangle = visina;
	}
	
	public void setWidthRectangle(int sirina) {
		this.widthRectangle = sirina;
	}

	public String getHeightText() {
		return txtHeight.getText();
	}
	
	public String getWidthText() {
		return txtWidth.getText();
	}
	
	public boolean isEnteredData() { //provera da li su vrednosti unete
		if(heightRectangle > 0 && widthRectangle > 0) {
			return true;
		}
		return false;
	}

}
