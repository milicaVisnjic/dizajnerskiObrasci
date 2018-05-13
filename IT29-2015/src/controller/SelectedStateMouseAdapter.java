package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.GuiDrawing;
import view.State;

public class SelectedStateMouseAdapter extends MouseAdapter{ 
			
		private GuiDrawing gui;
		private State chosenShape;
			
		public SelectedStateMouseAdapter(GuiDrawing gui, State odabraniOblik ) {
			super();
			this.gui = gui;
			this.chosenShape = odabraniOblik;
		}
			
			
		@Override
		public void mouseClicked(MouseEvent arg0) {
				
			gui.setState(chosenShape); //podesavamo koje ce biti stanje za crtanje
							
		}
}

