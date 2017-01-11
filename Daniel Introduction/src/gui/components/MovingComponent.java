package gui.components;

import java.awt.Graphics2D;

public class MovingComponent extends Components implements Runnable {
	private long moveTime; //time when the image last moved
	private double vx; //the horizontal velocity
	private double vy; //the vertical velocity
	private double posx; //the actual x-coordinate of the object
	private double posy; //the actual y-coordinate of the object
	private boolean running;

	public static final int REFRESH_RATE = 20;
	
	
	

	public MovingComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		vx =0;
		vy = 0;
	
	}
	
	public boolean IsAnimanted(){
		return true;
		
	}
	

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
