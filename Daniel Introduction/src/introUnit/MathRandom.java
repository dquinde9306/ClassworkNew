package introUnit;

import java.util.Random;
public class MathRandom {

	public static void main(String[] args) {
//		int[] results = new int[6];
//		
////		int totalRolls = 10000;
////		for(int index = 0; index < totalRolls; index++){
////			int roll = rollUnfairDie();
////			System.out.println("Roll#" + (index + 1)+ " Die is " + rollUnfairDie());
////			results[roll-1]++;
////		}
////		for(int i = 0; i < 6; i++){
////			System.out.println( (i+1) + " was rolled " + (int) (100 * (double)results[i]/totalRolls) + "% times");
////
////		}
		

		cardDrawer();
		
		
		
		
	
	}
	
//	public static int rollFairDie(){
////		Random gen = new Random();
////		return gen.nextInt(6)+1;
//		
//		double rand = Math.random();// it creates a random double between zero and one exclusive
//		int roll = (int) (6 * rand);// max value is 0 to 5 inclusive
//		return roll + 1;// 0 becomes 1, 5 becomes 6
//	}
	
	public static int rollUnfairDie(){
		double rand = Math.random();
		int unroll = (int) (100 * rand) +1;
		
		int die = 0;
		if ( unroll<= 10 && 0 < unroll)
			die =  1;
		
		else if ( unroll<= 20 && 11 < unroll)
			die =  2;
		
		else if ( unroll<= 30 && 21 < unroll)
			die =  3;
		
		else if ( unroll<=45 && 31 < unroll)
			die =  4;
		
		else if ( unroll<= 90 && 46 < unroll)
			die =  5;
		
		else 
			die =  6;
		return die;

	
	}
	
	
	












	public static  void cardDrawer(){
	
		double rand = Math.random();
		int card = (int) (13 * rand) +1;
		int suit = (int) (4 * rand) +1;
		String face = " ";
		String type = " ";
		int num = 0;
	
		if(card == 1){
			face =  "Ace";
		}
	
		if (card == 11){
			face =  "Jack";
		}
	
		if (card == 12){
			face =  "Queen";
		}
	
		if (card == 13){
			face = "King";
		}
	
		if(card >=2 && card <=10) {
			num = card;
			face ="";
		}
	
	
		if(suit == 1){
			type = "club";
		}
	
		if(suit == 2){
			type = "diamond";
		}
	
		if(suit == 3){
			type = "spade";
		}
	
		if(suit == 4){
			type = "hearts";
		}
	
		System.out.println( num + face + " of " + type);}}
	
	
	
	
	

