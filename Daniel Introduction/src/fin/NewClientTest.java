package fin;

import javax.swing.JFrame;

public class NewClientTest {
	public static void main(String[] args) {
		Client paul;
		paul = new Client("127.0.0.1","Paul");
		paul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paul.startRunning();
	}

}

	
	

