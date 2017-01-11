package sort;

public class RecursionIntro {

	public static void main(String[] args) {
////	// with a for loop
////		System.out.println("Using a for loop...");
////		for(int i = 0; i < 5; i++){
////			System.out.println("Hello Everyone");
////		}
////		System.out.println("Using recursion...");
////		int numberOfTimes = 5;
////		forLoop(numberOfTimes, new Action() {
////			
////			public void act() {
////				System.out.println("Hello Everyone");
////				
////			}
////		} );
////		
////		
		hanoi(3,"A","B","C");
	}
//	
	public static void hanoi(int numberOfDiscs,	String from,
			String mid,
			String to){
		if(numberOfDiscs < 2){
			print("move from " + from + " to "+ to);
		}
		else{
			// move all but the last one to peg b
			hanoi(numberOfDiscs - 1,from,to,mid);
			//move the last one to c
			hanoi( 1,mid,from,to);
			// move all but last to c
			hanoi(numberOfDiscs - 1,mid,from,to);

		}
	
	}
	
	private static int movecount;

	private static void print(String string) {
		System.out.println("Move#" + movecount + " " +string);
		movecount++;
	}

	private static void forLoop(int numberOfTimes, Action action) {
		if(numberOfTimes < 2){
			action.act();
		}
		else {
			action.act();
			forLoop(numberOfTimes-1,action);
		}
		
		
	}

}
