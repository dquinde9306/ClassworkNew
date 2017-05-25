package fin;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Login extends JPanel
//implements ActionListener
{
	
	
	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	private static ArrayList<String> usernames = new ArrayList<String>();
	private static JButton b1;
	private static JButton b2;
	
	public static void main(String[] args){
		window();
		buttons();
		usernames.add("a");
		System.out.println("user?");
		String entry = waitForEntry();
		for (int i = 0; i < usernames.size(); i++){
			if(entry.equals(usernames.get(i))){
				System.out.println("!");
			}
			else{
				System.out.println("?");
			}
		}
	}
	
	public static void window(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}

	

	private static void createAndShowGUI() {

		//Create and set up the window.
		JFrame frame = new JFrame("Register or Login?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonDemo newContentPane = new ButtonDemo();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);
	
		//Display the window.
		frame.setSize(300,400);
		frame.setVisible(true);
//		frame.add(b1, BorderLayout.PAGE_START); 
	}

	public static void buttons(){ 
		b1 = new JButton("Register");
		b2 = new JButton("Login");
		//b1.setLayout(null);
		
	}

}
