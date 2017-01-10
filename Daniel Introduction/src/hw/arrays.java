package hw;

import java.lang.reflect.Array;

public class arrays {

	public static void main(String[] args){
		int[]arr  = {2,3,4,6,9,11,12,15};
		swap(arr,0,arr.length-1);
		shuffle(arr);
		if(checkHalfway(arr,12,0,arr.length-1)){
			System.out.println("The number you are looking for is less than the value in the middle of the array");
		}
		else System.out.println("The number you are looking for is greater than the value in the middle of the array");

		testPrimes(50);
		
		
		
		
		
		
	}
	
	
	
	private static void shuffle(int[] arr) {
		for(int i = 0; i<arr.length;i++){
			int rand = (int) (Math.random() * arr.length);
			swap(arr,i,rand);
		
		}
	}



	private static void swap(int[] arr, int i, int j) {
		int placeholder = arr[j];
		arr[j] = arr[i];
		arr[i] = placeholder;
	}



	/**
	 * returns true if search value is less than the element halfway between beginning and end
	 * @param arr
	 * @param i
	 * @param j
	 * @param length
	 * @return 
	 */

	private static boolean checkHalfway(int[] arr, int searchValue, int begin, int end) {
		return searchValue < arr[begin+end]/2;
		
	}
	
	
//	
//	public static int[] randomPop(int[]arr){
//		double rand = Math.random();
//		int index =  (int) ((arr.length * rand)+1);
//		int[] array =  new int[index];
//		for()
//	}
	
	
	

	private static void testPrimes(int numberToTest){
		int lastToCheck = (int)(Math.sqrt(numberToTest));
		boolean[] theNumbers = new boolean[numberToTest];
		for(int i = 0; i < numberToTest;i++){
			theNumbers[i] = true;
		}
		theNumbers[0] = false;
		theNumbers[1] = false;
		for(int prime = 2; prime<=lastToCheck;prime++ ){
			//when checking fifty numbers 
			//will test 2,3,4,5,6,7
			if(theNumbers[prime]){
				//only checks numbers that are prime
				//(numbers that haven't been crossed off)
				//won't check 4 and 6
				System.out.println(prime + "\n is prime. Crossing off:");
				int increment = prime;
				boolean first = true;
				for(int a = prime + prime; a <= numberToTest-1;a = a +prime){
						System.out.print(a + ", ");
						theNumbers[a] = false;
				}
			}
		}
		for(int b = 0; b<theNumbers.length;b++){
			if (theNumbers[b]){
				System.out.println(b + " is prime");
			}
		}
	}





}
