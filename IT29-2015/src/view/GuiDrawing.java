
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commands.CommandManager;
import view.State;
import controller.BringToBackListener;
import controller.BringToFrontListener;
import controller.DeleteActionListener;
import controller.DrawMouseListener;
import controller.LoadListener;
import controller.RedoListener;
import controller.SaveListener;
import controller.SelectColorMouseAdapter;
import controller.SelectedStateMouseAdapter;
import controller.ToBackListener;
import controller.ToFrontListener;
import controller.UndoListener;
import controller.UpdateActionListener;
import model.Shape;
import model.ShapeRepository;


@SuppressWarnings("serial")
public class GuiDrawing extends JFrame implements Observer{
	
	private DrawingPanel drawing;
	private State state;
	
	private int click = 1;
	private JPanel pnlMain;
	
	private JButton btnUndo, btnRedo, btnSaveLog, btnLoadLog, btnSaveDrawing, btnLoadDrawing, btnToFront, btnToBack, btnBringToFront, btnBringToBack,btnAreaColor, btnContour, btnDelete, btnModification;

	private LogPanel logPanel;
	
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public JButton getBtnKontura() {
		return btnContour;
	}
	public JButton getBtnUnutrasnjost() {
		return btnAreaColor;
	}
	
	public JButton getBtnModifikacija() {
		return btnModification;
	}
	public void setState(State state) {
		this.state = state;
	}
	

	public State getstate() {
		return state;
	}
	public DrawingPanel getCrtanje() {
		return drawing;
	}
	
	public JButton getBtnObrisi() {
		return btnDelete;
	}

	/**
	 * Create the frame.
	 */
	public GuiDrawing() {
		
		
		drawing=new DrawingPanel();
		ShapeRepository.getInstance().addObserver(drawing); 
		CommandManager.getInstance().addObserver(this); 
		drawing.setBackground(Color.white);
		
		setTitle("Milica Visnjic IT29-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlMain.setLayout(new BorderLayout());
		setContentPane(pnlMain);
	
		
		pnlMain.add(drawing, BorderLayout.CENTER);
		
	
		JButton btnPoint = new JButton("Point");
		btnPoint.addMouseListener(new SelectedStateMouseAdapter(this, State.POINT));
		
		
		JButton btnLine = new JButton("Line");
		btnLine.addMouseListener(new SelectedStateMouseAdapter(this, State.LINE));
			

		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addMouseListener(new SelectedStateMouseAdapter(this, State.RECTANGLE));
		
		JButton btnHexagon = new JButton("Hexagon");
		btnHexagon.addMouseListener(new SelectedStateMouseAdapter(this, State.HEXAGON));

				
		JLabel lblContourColor = new JLabel("Contour");
		
		
		btnContour = new JButton("");
		btnContour.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnContour.setBackground(Color.BLACK);
		btnContour.setForeground(Color.BLACK);

		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new SelectedStateMouseAdapter(this, State.SELECT));
		
		
		JButton btnSquare = new JButton("Square");
		btnSquare.addMouseListener(new SelectedStateMouseAdapter(this, State.SQUARE));
		
		
		JLabel lblAreaColor = new JLabel("Area color");
		
		btnAreaColor = new JButton("");
		btnAreaColor.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnAreaColor.setBackground(Color.WHITE);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addMouseListener(new SelectedStateMouseAdapter(this, State.CIRCLE));
		
		btnModification = new JButton("Modification");
		btnModification.setEnabled(false);
		
		btnUndo = new  JButton("Undo");
		btnUndo.setEnabled(false);
		btnUndo.addActionListener(new UndoListener());
		
		btnRedo = new  JButton("Redo");
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new RedoListener());
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new DeleteActionListener(this));
		
		btnModification.addActionListener(new UpdateActionListener(this));
	
		SaveListener saveListener = new SaveListener();
		
		btnSaveLog = new JButton("Save log");
		btnSaveLog.setName("btnSaveLog");
		btnSaveLog.addActionListener(saveListener);
		
		btnSaveDrawing = new JButton("Save drawing");
		btnSaveDrawing.setName("btnSaveDrawing");
		btnSaveDrawing.addActionListener(saveListener);
		
		LoadListener loadListener = new LoadListener();
		
		btnLoadLog = new JButton("Load log");
		btnLoadLog.setName("btnLoadLog");
		btnLoadLog.addActionListener(loadListener);
		
		btnLoadDrawing = new JButton("Load drawing");
		btnLoadDrawing.setName("btnLoadDrawing");
		btnLoadDrawing.addActionListener(loadListener);
		
		btnToFront = new JButton("ToFront");
		btnToFront.setEnabled(false);
		btnToFront.addActionListener(new ToFrontListener());
		btnToBack = new JButton("ToBack");
		btnToBack.setEnabled(false);
		btnToBack.addActionListener(new ToBackListener());
		btnBringToFront= new JButton("BringToFront");
		btnBringToFront.setEnabled(false);
		btnBringToFront.addActionListener(new BringToFrontListener());
		btnBringToBack = new JButton("BringToBack");
		btnBringToBack.setEnabled(false);
		btnBringToBack.addActionListener(new BringToBackListener());
		
		logPanel = new LogPanel();
		CommandManager.getInstance().addObserver(logPanel);
		
		
		JPanel pnlShapes = new JPanel();
		pnlShapes.add(btnPoint);
		pnlShapes.add(btnLine);
		pnlShapes.add(btnCircle);
		pnlShapes.add(btnSquare);
		pnlShapes.add(btnRectangle);
		pnlShapes.add(btnHexagon);
		pnlShapes.add(lblContourColor);
		pnlShapes.add(btnContour);
		pnlShapes.add(lblAreaColor);
		pnlShapes.add(btnAreaColor);
		
		pnlMain.add(pnlShapes, BorderLayout.NORTH);
		
		JPanel pnlActions = new JPanel();
		pnlActions.setLayout( new BoxLayout(pnlActions,BoxLayout.Y_AXIS));
		pnlActions.add(btnSelect);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnDelete);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnModification);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnUndo);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnRedo);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnSaveDrawing);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnLoadDrawing);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnSaveLog);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnLoadLog);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnToFront);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnToBack);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnBringToFront);
		pnlActions.add(Box.createVerticalGlue());
		pnlActions.add(btnBringToBack);
		
		
		pnlMain.add(pnlActions, BorderLayout.WEST);
		pnlMain.add(logPanel, BorderLayout.SOUTH);
		
		
		drawing.addMouseListener(new DrawMouseListener(this));
		ShapeRepository.getInstance().addObserver(this); 
		
	}
	public JButton getUndoButton() {
		return btnUndo;
	}
	public JButton getRedoButton() {
		return btnRedo;
	}
	@Override //omogucavanje i onemogucavanje dugmica
	public void update(Observable o, Object arg) { //svaki put kada se desi notifyObservers,
												//koji poziva objekat posmatranja,automatski se izvrsava update metoda svih posmatraca
		if(o instanceof CommandManager) {
			
			int index = (int)arg;
			CommandManager manger = (CommandManager)o;
			if( index >= 0 && index != manger.numberOfCommands()-1) {
				btnUndo.setEnabled(true);
				btnRedo.setEnabled(true);

			}else if( index >= 0 && index == manger.numberOfCommands()-1){
				btnUndo.setEnabled(true);
				btnRedo.setEnabled(false);
			}else if( index ==-1 && manger.numberOfCommands() != 0) {
				btnUndo.setEnabled(false);
				btnRedo.setEnabled(true);
			}else {
				btnUndo.setEnabled(false);
				btnRedo.setEnabled(false);
			}
			
		}else {
			
			int size = (int) arg;
			if(size == 1 ) { //ako je jedan oblik selektovan
				btnModification.setEnabled(true);
				btnDelete.setEnabled(true);
				ShapeRepository repository = (ShapeRepository)o;
				Shape selectedShape = repository.getSelectedShapes().get(0); //uzimamo tog prvoj (i jedinog) u listi selektovanih
				
				if(repository.getIndexOf(selectedShape) < repository.getShapes().size()-1) { //ako je indeks od selektovanog oblika manji od poslednjeg indeksa
					btnToFront.setEnabled(true);
					btnBringToFront.setEnabled(true);
				}else {

					btnToFront.setEnabled(false);
					btnBringToFront.setEnabled(false);
				}
				if(repository.getIndexOf(selectedShape) > 0 ) { //ako nije na prvom mestu u listi, moze toBack
					btnToBack.setEnabled(true);
					btnBringToBack.setEnabled(true);
				}else {
					btnToBack.setEnabled(false);
					btnBringToBack.setEnabled(false);
					
				}
				
			}else if(size > 1){ //ako je selektovano vise oblika, omogucujemo smo brisanje, bez modifikacije
				btnDelete.setEnabled(true);
				btnModification.setEnabled(false);
				
				btnToFront.setEnabled(false);
				btnToBack.setEnabled(false);
				btnBringToFront.setEnabled(false);
				btnBringToBack.setEnabled(false);
			
			}else { //ako nista nije oznaceno tj ako je argument false i nista nije selektovano
				btnModification.setEnabled(false);
				btnDelete.setEnabled(false);
				

				btnToFront.setEnabled(false);
				btnToBack.setEnabled(false);
				btnBringToFront.setEnabled(false);
				btnBringToBack.setEnabled(false);
			}
		}
	}

	
}
