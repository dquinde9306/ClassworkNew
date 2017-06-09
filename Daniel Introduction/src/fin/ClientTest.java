package fin;
import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args) {
		Client john;
		john = new Client("127.0.0.1","John");
		john.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread go = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				john.startRunning();
				
			}
		});
		go.start();
	}

}

