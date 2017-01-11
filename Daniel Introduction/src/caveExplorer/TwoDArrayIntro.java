package caveExplorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayIntro {
	
	public static String[][]pic;
	public static String[][]arr2d;
	public static int i;
	public static int j;
	public static Scanner in;
	
	public static void main(String[] args){
		int[] arr = {0,1,2,3,4,5,6,7};
		//System.out.println(Arrays.toString(arr));
		
		//rows,columns
		arr2d = new String [5][4];
		pic = new String [5][4];
		
		//iterate row by row
		for(int row= 0; row < arr2d.length;row++){
			//in each row, go col by col
			for(int col = 0; col < arr2d[row].length;col++){
				arr2d[row][col] = "(" + row + "," + col + ")";
			}
		}
		
		i =2;
		j =3;
		in = new Scanner(System.in);

		for(int row= 0; row < pic.length;row++){
			//in each row, go col by col
			for(int col = 0; col < pic[row].length;col++){
				pic[row][col] = " ";
			}
		}

		startExploring();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//print each row
		for(String[] row: arr2d){
			System.out.println(Arrays.toString(row));
		}
		
	}

	private static void startExploring() {
		while(true){
			Practice.printPic(pic);
			System.out.println("you are in room " + arr2d[i][j]);
			System.out.println("what would you like to do?");
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("please enter w, a, s, d");
				input = in.nextLine();
			}
			interpretInput(input.toLowerCase());
		}
		
	}

	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;

	
		if(input.equals("w")&& i > 0){
			i--;
			pic[i--][j] = "X";
		}
		else if(input.equals("a")&& j >0)
			j--;
		else if(input.equals("s")&& i+1<arr2d.length)
			i++;
		else if(input.equals("d")&&j+1<arr2d[0].length)
			j++;
		if(iOrig == i && jOrig == j){
			System.out.println("you are at the edge of the universe. You can move no further");
		}
	}

	private static boolean isValid(String input) {
		String lc = input.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc))
				return true;
		}
		return false;
	}

}
