package gui.components;

public class ClickableGraphics extends Graphic implements Clickable {
	private Action action;

	public ClickableGraphics(int x, int y, String imageLocation,Action action) {
		super(x, y, imageLocation);
		this.action = action;
		update();
	}

	public ClickableGraphics(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public ClickableGraphics(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && 
				y > getY() && y<getY()+getHeight();
	}

	@Override
	public void act() {
		if(action != null) 
			action.act();
	}

	public void setAction(Action a ){
		action = a;
	}



}
