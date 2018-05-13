package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import commands.AddCommand;
import commands.CommandManager;
import hexagon.Hexagon;
import model.Circle;
import model.HexagonAdapter;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.ShapeRepository;
import model.Square;
import view.Circle_HexagonDrawingDlg;
import view.SquareDrawingDlg;
import view.RectangleDrawingDlg;
import view.GuiDrawing;
import view.State;

public class DrawMouseListener extends MouseAdapter{
	private GuiDrawing gui;
	private int xPoint;
	private int yPoint;
	private ShapeRepository repository;
	
	
	public DrawMouseListener(GuiDrawing gui) {
		super();
		this.gui = gui;
		repository = ShapeRepository.getInstance();
	}
	


	@Override
	public void mousePressed(MouseEvent e) {
		Shape shape = null;
		//proveravamo koje je stanje, iz guija
		if (gui.getstate()== State.POINT) 
		{
			int xTacka=e.getX();
			int yTacka=e.getY();
			shape = new Point (xTacka, yTacka, gui.getBtnKontura().getBackground());
		}
		else if (gui.getstate() == State.LINE)
		{
			if(gui.getClick() == 1){
				 xPoint=e.getX();
				 yPoint=e.getY();
				 gui.setClick(2);
			}else{
				 int xPoint1=e.getX();
				 int yPoint1=e.getY();
				 
				 shape = new Line( new Point(xPoint,yPoint), new Point(xPoint1,yPoint1),gui.getBtnKontura().getBackground());
				 gui.setClick(1);
			}

		}
		
		else if (gui.getstate() == State.SQUARE)
		{
			xPoint=e.getX();
			yPoint=e.getY();
			SquareDrawingDlg dk = new SquareDrawingDlg();
			dk.setVisible(true);
			if(dk.isEnteredData()) {
				shape=new Square(new Point(xPoint, yPoint), dk.getSideLength(), gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
			}
		}
		else if (gui.getstate() == State.RECTANGLE)
		{
			
				xPoint=e.getX();
				yPoint=e.getY();
				
				RectangleDrawingDlg rectangleDlg = new RectangleDrawingDlg();
				rectangleDlg.setVisible(true);
				if(rectangleDlg.isEnteredData()) {
					shape= new Rectangle(new Point(xPoint, yPoint), rectangleDlg.getWidthRectangle(),rectangleDlg.getHeightRectangle(),  gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
				}
			
		}
		else if (gui.getstate() == State.CIRCLE)
		{
			xPoint=e.getX();
			yPoint=e.getY();
			Circle_HexagonDrawingDlg circleDlg= new Circle_HexagonDrawingDlg();
			circleDlg.setVisible(true);
			if(circleDlg.isEnteredData()) {
				shape= new Circle(new Point(xPoint, yPoint), circleDlg.getRadius(), gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
			}
		}else if(gui.getstate() == State.HEXAGON) {
			xPoint=e.getX();
			yPoint=e.getY();
			Circle_HexagonDrawingDlg hexagonDlg= new Circle_HexagonDrawingDlg();
			hexagonDlg.setVisible(true);
			if(hexagonDlg.isEnteredData()) {
				Hexagon hexagon= new Hexagon(xPoint, yPoint, hexagonDlg.getRadius());
				hexagon.setAreaColor( gui.getBtnUnutrasnjost().getBackground());
				hexagon.setBorderColor(gui.getBtnKontura().getBackground());
				shape = new HexagonAdapter(hexagon);
			}
			
			
		}else if (gui.getstate() == State.SELECT)
		{
			xPoint=e.getX();
			yPoint=e.getY();
			List<Shape> allShapes = repository.getShapes(); //uzimamo sve oblike iz repoziorijuma
			
			for(int i = allShapes.size() - 1; i >= 0  ; i--)
			{
				if(allShapes.get(i).contains(xPoint, yPoint)){
					Shape selectedShape = allShapes.get(i);
					if(selectedShape.isSelected()) {
						selectedShape.setSelected(false); 
						repository.removeSelectedShape(selectedShape); 
					
						return;
					}
					repository.addSelectedShape(selectedShape); //ako nije vec bio selekovan, ubacujemo ga u listu selektovanih
					repository.getShapes().remove(i); //brisemo stari
					repository.getShapes().add(i, selectedShape);//dodajemo novi (jer se hash code ne poklapa)
					
					
					selectedShape.setSelected(true);
					
					gui.repaint();
					return;
				}
				
			}
			//ako se nije desila ni selekcija ni deselekcija, tj ako je kliknuto u prazno
			repository.removeSelectedShapes();
			repository.getSelectedShapes().stream().forEach(s->s.setSelected(false)); 
			repository.getShapes().stream().forEach(s->s.setSelected(false));
			gui.repaint();
			
			
		}
		
		//ako nije uslo  u selekciju
		if(shape != null) {
			CommandManager commandManager = CommandManager.getInstance();
			AddCommand addCommand = new AddCommand(shape);
			addCommand.execute();//
			commandManager.addCommand(addCommand); 
			gui.getUndoButton().setEnabled(true);
			gui.getRedoButton().setEnabled(false);
		}
		
		
		
	}
	

}
