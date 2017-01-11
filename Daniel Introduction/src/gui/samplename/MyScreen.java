package gui.samplename;

import java.util.ArrayList;

import gui.Screen;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLable;
import gui.components.Visible;

public class MyScreen extends Screen {
	private TextArea area;
	private Graphic image;
	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		area = new TextArea(20, 200, 500, 100, "And the vision that was planted in my brain, still remains within the Sound Of Silence");
		viewObjects.add(area);		
		image = new Graphic(30,300,2.0,"resources/sampleImages/hip.png");
		viewObjects.add(image);	

		
	}

}
