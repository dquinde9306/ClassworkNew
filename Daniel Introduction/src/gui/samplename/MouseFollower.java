package gui.samplename;

import gui.GUIApplication;
import gui.screens.CoordinateScreen;

public class MouseFollower extends GUIApplication {

	//FIELDS
	private CoordinateScreen cs;
	public static MouseFollower game;
	public static MyScreen myScreen;
	public static ClickScreen clickScreen;


	public MouseFollower(int width, int height) {
		super(width, height);


	}

	@Override
	public void initScreen() {
		cs = new CoordinateScreen(getWidth(),getHeight());
		myScreen = new MyScreen(getWidth(),getHeight());
		clickScreen = new ClickScreen(getWidth(),getHeight());
		setScreen(cs);
	}

	public static void main(String[] args) {
		try{
			game = new MouseFollower(800,600);
			Thread app = new Thread(game);
			app.start();
		}catch(Exception e){
			e.printStackTrace();

		}
	}


}
