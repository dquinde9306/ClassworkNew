package Chatbot;

import java.util.Scanner;

public class DanielQMain {
	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic like;
	

	public static void main(String[] args) {
		createTopics();
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
			if(findKeyword(response, "good", 0) >= 0){
				print("I'm so happy you're good.");
			}
			else if(findKeyword(response, "like", 0) >= 0){
				inLoop = false;
				like.talk();
				
			}
			
			else if(findKeyword(response, "good", 0) >= 0){
				inLoop = false; // exit this loop
				school.talk();
				
			}
			
			else{ print("I'm sorry I don't understand you");
			
			}
		}
	}
	
	
	public static int findKeyword(String searchString, String key, int startIndex) {
		//delete white space
		String phrase = searchString.trim();
		//set all letters to lower case
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
	//	System.out.println("The Phrase is " + phrase);
	//	System.out.println("The key is " + key);
		
		// find position of key
		int psn = phrase.indexOf(key);
		//keep looking for the word until you find the right context
//		System.out.println("The position found is " + psn);
		
		while(psn >= 0 ){
			String before = " ";
			String after = " ";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length()+1);
		//		System.out.println("The character after " + key + " is " + after);
			}
			if(psn> 0){
				before = phrase.substring(psn-1,psn).toLowerCase();
		//		System.out.println("The character before " + key + " is " + before);

			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
	//			System.out.println(key + " was found at " + psn);
				if(noNegation(phrase, psn))				
				return psn;
				
			}
			psn = phrase.indexOf(key,psn+1);
//			System.out.println(key + " was not found. Checking " + psn);
		}
		return -1;
	}

	//helper method a method that contributes functionality to another method
	// helper methods are common when you need to do the same things repeatedly
	// method is private because it is only used by the method it is helping
	
	private static boolean noNegation(String phrase, int index) {
		//check for word no (3 characters)
		if(index - 3 >= 0 && phrase.substring(index -3, index).equals("no ")){
			return false;
		}
		
		if(index - 4 >= 0 && phrase.substring(index -4, index).equals("not ")){
			return false;
		}
		
		if(index - 6 >= 0 && phrase.substring(index -6, index).equals("never ")){
			return false;
		}
		
		if(index - 4 >= 0 && phrase.substring(index -4, index).equals("n't ")){
			return false;
		}
		
		return true;
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



	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		like = new DanielLike();
		
	}	
}
