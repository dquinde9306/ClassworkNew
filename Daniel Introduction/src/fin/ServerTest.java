package fin;

import java.awt.AWTException;
import java.awt.HeadlessException;

import javax.swing.JFrame; 

public class ServerTest {

	public static void main(String[] args) throws HeadlessException, AWTException {
		Server ringo = new Server("Ringo");
		
		ringo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ringo.startRunning();
	}

}

