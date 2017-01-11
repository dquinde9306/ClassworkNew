package gui.whackAMole;

import gui.components.ClickableGraphics;
import sort.Action;

public class Mole extends ClickableGraphics implements MoleInterface {
	private int appearanceTime;


//	public Mole(int x, int y) {
//		super(x, y, "resources/sample/mole.jpg", action);
//		// TODO Auto-generated constructor stub
//	}

	public Mole(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Mole(int x, int y, double scale, String imageLocation) {
		super(x, y, .9, "resources/sample/mole.jpg");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAppearanceTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAppearanceTme(int screenTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction1(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub
		
	}

}
