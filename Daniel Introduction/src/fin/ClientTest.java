package fin;
import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args) {
		Client john;
		john = new Client("165.155.196.87");
		john.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		john.startRunning();
	}

}


