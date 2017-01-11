package gui.whackAMole;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Components;

public class PLayer extends Components implements PlayerInterface {
	private int score;

	public PLayer(int x, int y, int w, int h) {
		super(20, 20, 100, 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increaseScore(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 99, 99);
		g.drawString("Score " + score, 40, 55);
		

	}

}
