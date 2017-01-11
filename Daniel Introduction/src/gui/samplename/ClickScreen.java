package gui.samplename;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import gui.Screen;
import gui.components.Action;
import gui.components.ClickableGraphics;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLable;
import gui.components.Visible;

public class ClickScreen extends Screen implements MouseListener{

	public ClickScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	private ClickableGraphics mario;

	public void mouseClicked(MouseEvent m) {
		if(mario.isHovered(m.getX(), m.getY())){
			mario.act();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		mario = new ClickableGraphics(100, 100, 1, "resources/sampleImages/hip.png");
		mario.setAction(new Action() {
			
			public void act() {
				mario.setX(mario.getX() + 10);
			}
		});
		viewObjects.add(mario);
	}

}