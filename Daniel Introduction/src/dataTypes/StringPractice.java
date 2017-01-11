package dataTypes;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	

	public static void main(String[] args) {
		createAScanner();
		demonstrateStringMethods();
		promptName();
		talkForever();
		
	}
	
	

	private static void promptName() {
		print("Hello human! I am a  board covered in semi-conductors and other such electronic components. What is your name? ");
		user = input.nextLine();
		print("Awesome I will call you " + user +" until you terminate me");
		
	}



	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			print("greetings " + user + " How are you?");
			response = getInput();
			if(response.indexOf("good") >= 0 ){
				print("I'm so happy you're good.");
			}
			
			else{ print("I'm sorry I don't understand you");
			
			}
		}
	}
	
	
	public static void promptInput() {
		print( user +" Try inputing a String!");
		String userInput = input.nextLine();
		print("You typed: " + userInput);
		
		
	}
	
	
	
	public static String getInput(){
		return input.nextLine();
	}
	
	
	
	public static void print(String s){
		// create a multi-line String
		String printString = " ";
		int cutoff = 35;
		//  check to see if there are words to add
		// is the length of s greater than 0
		while(s.length() > 0){
			String currentLine = " ";
			String nextWord = "";
			// while the current and next word are less than the cutoff, 
			//AND there are still words to add do the following loop
			while(currentLine.length() + nextWord.length() <= cutoff && s.length() > 0 ){
				// add next word to line'
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				// get following word
				int endOfWord = s.indexOf(" ");
				//check to see if this is last word
				if(endOfWord == -1){
					endOfWord = s.length() -1;	
				}
								
				nextWord = s.substring(0,endOfWord+1);
				
				
			}
			
			printString += currentLine + "\n";
			
			
		}			
		System.out.println(printString);
			
//		System.out.println("Line#" + lineCount+" : " + s);
		
}



	public static void createAScanner() {
		input = new Scanner(System.in);
		
	}
	
	
	
	
	public static void demonstrateStringMethods(){
		
		String text1 = "Hello World";	
		String text2 = "Hello";
		String text3 = " World";
		
		if(text1 .equals(text2 + text3)){
			System.out.println("These strings are equal");
		}
		
		System.out.println(text1);
		System.out.println(text2 + text3);
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyva";
		if(word1.compareTo(word2)< 0){
			System.out.println("Word1 is before Word2," + " lexicongraphically." );
		}
			
		
	}

}
