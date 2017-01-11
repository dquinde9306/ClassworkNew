package caveExplorer;

public class Practice {
	public static void main(String[] args){

		makeGrid(10,10);


	}


	public static void makeGrid(int rows,int cols){
		String[][] map = new String[rows*5][rows*5];
		for(int row= 0; row < map.length;row++){
			for(int  i = 0; i < map[row].length;i++){
				map[row][i] = " ";
			}
		}
		for(int c = 0; c<cols;c++){
			for(int i  = 0; i < rows;i++){
				for(int j = 1;j<4;j++ ){
					map[c*4][j+(i*4)]  = "_";
					map[4+(c*4)][j+(i*4)]  = "_";
				}
				for(int a =(c*4); a<(4+(c*4));a++){
					map[a+1][i*4] = "|";
					map[a+1][4+(i*4)] =  "|";
				}

			}
		}
		printPic(map);
	}













	public static void mine(){
		boolean[][] mines = new boolean[6][6];
		createMines(mines,10);
		String[][] field = new String [mines.length][mines[0].length];
		matchValues(field,mines);
		printPic(field);
	}

	private static void createMines(boolean[][] mines, int numberOfMines) {
		while(numberOfMines > 0){
			int row = (int) (Math.random()*mines.length);
			int col = (int) (Math.random()*mines[0].length);
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines--;
			}
		}

	}

	private static void matchValues(String[][] field, boolean[][] mines) {
		for(int row = 0; row<field.length;row++){
			for(int col = 0; col<field[0].length;col++){
				if(mines[row][col])
					field[row][col] = "x";
				else{
					field[row][col] = countAdjacent(mines,row,col);
				}
			}
		}

	}

	private static String countAdjacent(boolean[][] mines, int r, int c) {
		int count = 0;
		//		for(int row = r-1;r<= r+1;row++){
		//			for(int col = c-1; c<=c+1;col++){
		//				if(row != r && col !=c){
		//					if(row>=0 &&row< mines.length&&col>=0&&col<mines[row].length){
		//						
		//					}
		//				}
		//			}
		//		}	
		//		this method only checks elements in the [][]		
		// 		so it is not neccesary to verify  they are valid

		//		for(int row = 0; row<mines.length;row++){
		//			for(int col = 0;col<mines[row].length;col++){
		//				if(Math.abs(row - r)+Math.abs(col-c)==1&&mines[row][col]){
		//					count++;
		//				}
		//			}
		//		}
		//		
		//		this method is helpful when you want to be very specific	

		//above
		count+=validAndTrue(mines,r-1,c);
		//below
		count+=validAndTrue(mines,r+1,c);
		//right
		count+=validAndTrue(mines,r,c+1);
		//left
		count+=validAndTrue(mines,r,c-1);


		return count+"";
	}

	private static int validAndTrue(boolean[][] mines, int i, int j) {
		if(i>= 0 && i<mines.length && j>=0 && j<mines[i].length && mines[i][j]){
			return 1;
		}
		return 0;
	}

	public static void printPic(String [][] arr2d){
		for(int row= 0; row < arr2d.length;row++){
			for(int  i = 0; i < arr2d[row].length;i++){
				System.out.print(arr2d[row][i]);
			}
			System.out.println();
		}


	}
	public static void picDrawing(){

		String[][] arr2d = new String [10][12];		
		for(int row= 0; row < arr2d.length;row++){
			for(int  i = 0; i < arr2d[row].length;i++){
				arr2d[row][i] = " ";
			}
		}

		for(int row= 7; row < arr2d.length;row++){
			for(int  i = 0; i < arr2d[row].length;i++){
				arr2d[row][i] = "M";
			}
		}

		for(int i = 0;i<5;i++){
			double rand = Math.random();
			int pos1 =  (int) ((rand * 4)+2);
			int pos2 =  (int) ((rand * 7)+3);
			arr2d[pos1][pos2] = "v";
		}

		arr2d[1][2] ="O";
		arr2d[0][2] = "|";
		arr2d[2][2] = "|";
		arr2d[1][1] = "-";
		arr2d[1][3] = "-";
		arr2d[0][1] = "\\";
		arr2d[2][3] = "\\";
		arr2d[0][3] = "/";
		arr2d[2][1] = "/";

		for(int col = 0; col < arr2d[0].length; col ++){
			arr2d[0][col] = "_";
			arr2d[arr2d.length-1][col] = "_";
		}

		for(int  i = 1; i < arr2d.length;i++){
			arr2d[i][0] = "|";
			arr2d[i][arr2d[0].length-1] = "|";
		}

		printPic(arr2d);

	}

}