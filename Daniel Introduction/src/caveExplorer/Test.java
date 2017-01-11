package caveExplorer;

import java.util.Scanner;

public class Test {
	public static String[][]arr2d;
	public static Scanner in;
	public static void main(String args[]){
	
		setGame();
		in = new Scanner(System.in);
		Ask();
	//	String[][] test = {{"a","b","c"},{"d","e","f"}};
//		printPic(arr2d);
		System.out.println("swapping");
		swap(arr2d,0,2,"a");
		
		
	}
	public static void setGame(){
		arr2d = new String[2][3];
		String[] symbol = {"A","B","C"};
		
		for(int row= 0; row < arr2d.length;row++){
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		printPic(arr2d);
		
	}
	
	public static void printPic(String[][] pic){
		for(int row = 0; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}
	
	public static void swap(String[][] grid,int r, int c, String d){
		System.out.println(r+ "| "+ c + "| " +d);

		if(d=="w"){
			String temp = grid[r-1][c] ;
			grid[r-1][c] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d=="a"){
			String temp = grid[r][c-1];
			grid[r][c-1] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d=="s"){
			String temp =grid[r+1][c];
			grid[r+1][c] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d=="d"){
			System.out.println("swapping right");
			String temp = grid[r][c+1];
			grid[r][c+1] = grid[r][c];
			grid[r][c] = temp;
			
		}
		
		printPic( grid);
		
	}
	
	public static void Ask(){
		System.out.println("which row?");
		int row =  Integer.parseInt(in.nextLine());
		System.out.println("which column?");
		int col = Integer.parseInt(in.nextLine());
		System.out.println("which direction?");
		String dir = in.nextLine();
		System.out.println(row+ " "+ col + " " +dir);
		swap(arr2d, row,col,dir);
		
		
	}
}