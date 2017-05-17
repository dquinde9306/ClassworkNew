package fin;

import javax.swing.JFrame; 

public class ServerTest {

	public static void main(String[] args) {
		Server ringo = new Server("Ringo");
		
		ringo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ringo.startRunning();
	}

}

