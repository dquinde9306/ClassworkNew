package arrays;

import java.util.Scanner;

public class Login {
	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	private static String username = "test_user";
	private static String password = "test";
	
	public static void main (String[] args){
		if (correctUser()){
			askPassword();
		}
		
	}

	private static void askPassword() {
		boolean inLoop = true;
		int remainingTries = 3;
		while(inLoop){
			System.out.println("Enter Password");
			String entry = waitForEntry();
			if(entry.equals(password)){
				System.out.println("You are in");
			}
			else{
				remainingTries--;
				if(remainingTries == 0){
					System.out.println("invalid password");
					inLoop = false;
				}
				else{
					System.out.println("incorrect password. You have " + remainingTries + " tries left" );
				}
			}
		}
	}

	private static boolean correctUser() {
		System.out.println("Enter Username");
		return (waitForEntry().equals(username));
	}
	
	
	
}
