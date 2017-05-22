package fin;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Login {
	
	
	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	private static ArrayList<String> usernames = new ArrayList<String>();
	
	public static void main(String[] args){
		window();
		
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
		JFrame frame = new JFrame("This is my frame");
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void buttons(){ 
		
	}

}
