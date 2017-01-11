package arrays;

import java.lang.reflect.Array;

public class Something {
	private static boolean[][] bob = new boolean[5][5];

	public static void main(String[] args) {

		printGrid(bob);
		buttonClick(3,3);
		printGrid(bob);
		buttonClick(3,3);
		printGrid(bob);


	}

	public static void buttonClick(int r, int c) {
		boolean win = true;
		if( r > 0 && r< bob.length){
			switchRow(bob[r],c);
		}
		switchColumn(bob,r,c);
		for(int i = 0; i < bob.length;i++){
			for(int j = 0 ; j < bob[0].length;j++){
				if(bob[i][j]){
					win = false;
					break;
				}
			}
		}
		System.out.println("You have solved the puzzle");
	}

	public static void switchRow(boolean[]row,int x){	
		if(x>=0 && x<row.length){
			for(int i  = -1; i < 2; i++){
				if(x + i >= 0 && x + 1 < row.length){
					row[x+1] =!row[x+1];
				}
			}
		}
	}

	public static void switchColumn(boolean [][]grid,int r, int c){
		switchIfValid(grid,r-1,c);
		switchIfValid(grid,r+1,c);
		


	}
	
	public static void switchIfValid(boolean [][] b ,int r , int c){
		if(r>=0 && r<b.length && c>=0 && c <b[r].length){
			b[r][c] = !b[r][c];
		}
		
	}
	

	public static void printGrid(boolean[][] grid){
		for(boolean[]row:grid){
			for(boolean b:row){
				if(b)System.out.print("o");
				else System.out.print("x");
			}
			System.out.println(  );
		}
	}
}
