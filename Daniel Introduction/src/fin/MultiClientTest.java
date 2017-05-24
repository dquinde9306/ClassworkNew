package fin;

import javax.swing.JFrame;

public class MultiClientTest {

    public static void main(String[] args) throws Exception {
		MultiClient john;
		john = new MultiClient();
		john.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		john.run();

	}

}
