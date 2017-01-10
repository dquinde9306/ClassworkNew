package gui.whackAMole;

import java.util.ArrayList;
import java.util.List;

import gui.components.TextLable;
import gui.components.Visible;
import gui.samplename.ClickScreen;
import gui.screens.ClickableScreen;
import sort.Action;

public class WhackAMoleScreen extends ClickableScreen implements Runnable {

	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLable label;
	private TextLable timeLabel;
	private double timeLeft;



	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread play = new Thread(this);
		play.start();
	}

	/**
	 * this method is a placeholder until our partner finishes the design of players
	 * For the time being, it returns null, this means the code wont work until our partner is done
	 * But the code will compile
	 * 
	 * @return
	 */

//	public PlayerInterface getAPlayer() {
//		return new PLayer;
//	}
//
//
//	public MoleInterface getAMole() {
//		return new Mole((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
//	}
//

	@Override
	public void run() {
		changeText("Ready...");
		changeText("set...");
		changeText("go...");
		label.setText(" ");
		while(timeLeft > 0){
			updateTimer();
			updateAllMoles();
			appearNewMole();
		}
	}

	private void updateAllMoles() {
		for(int i = 0; i<moles.size();i++){
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime();
			m.setAppearanceTme(screenTime);
			if(m.getAppearanceTime()<0){
				remove(m);//remove from screen
				moles.remove(m);
				i--;//compensate for removal
			}
		}

	}

	private void appearNewMole() {
		double chance = (Math.random()*.2)*(60-timeLeft)/60;
		if(Math.random()<chance){
			MoleInterface mole = getAMole();
			mole.setAppearanceTme((int)(500+Math.random()*2000));
			mole.setAction(new Action(){
				public void act(){
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
					
				}
				
			});
			addObject(mole);
			moles.add(mole);
		}

	}

	private MoleInterface getAMole() {
		// TODO Auto-generated method stub
		return null;
	}

	private void updateTimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timeLeft -= .1;
		timeLabel.setText(" " +(int)(timeLeft*10)/10.0);
		//.1 is not a clean number so we use the formula

	}

	private void changeText(String string) {
		label.setText(string);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLable(350,220,100,40,"blank ");
		timeLabel = new TextLable(360,40,80,40,"30.0");
		viewObjects.add(player);
		viewObjects.add(timeLabel);
		viewObjects.add(label);

	// TODO Auto-generated method stub

	}

	private PlayerInterface getAPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initObject(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

}
