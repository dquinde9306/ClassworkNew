package gui.samplename;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.ClickableGraphics;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLable;
import gui.components.Visible;

public class ClickScreen extends Screen  implements MouseListener  {
	private TextArea area;
	private ClickableGraphics image;

	public ClickScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObject(ArrayList<Visible> viewObjects) {
		area = new TextArea(20, 200, 500, 100, "because a vision softly creeping, Left its seed while I was sleeping");
		viewObjects.add(area);
		image = new ClickableGraphics(30,300,"resources/sampleImages/hip.png",new Action(){
			public void act(){
				image.setX(image.getX() +1);
				//MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		viewObjects.add(image);	


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(image.isHovered(e.getX(), e.getY())){
			image.act();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseListener getMouseListener(){
		return this;

	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

}
