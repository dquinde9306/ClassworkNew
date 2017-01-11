package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLable;
import gui.components.Visible;
import gui.samplename.MouseFollower;

public class CoordinateScreen extends Screen implements MouseMotionListener,MouseListener{
	private Button myButton;
	private TextLable text;
	private TextArea area;
	private Graphic image;

	public CoordinateScreen(int width, int height)  {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObject(ArrayList<Visible> viewObjects) {
		text = new TextLable(20, 150, 500, 40, "Some text");
		viewObjects.add(text);
		myButton = new Button(100,100,100,30,"Button",new Color(100,100,250), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.clickScreen);
			}
		});
		viewObjects.add(myButton);
		area = new TextArea(20, 200, 500, 100, "Hello darkness my old friend I've come to talk with you again");
		viewObjects.add(area);
		image = new Graphic(30,300,0.5,"resources/sampleImages/hip.png");
		viewObjects.add(image);


	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		text.setText("Mouse at " +mx+", "+ my);
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(myButton.isHovered(e.getX(), e.getY())){
			myButton.act();
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