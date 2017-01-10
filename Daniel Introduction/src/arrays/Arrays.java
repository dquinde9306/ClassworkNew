package arrays;

public class Arrays {

	public static void main(String[] args){
		// this is how you time how quickly a computer processes
		long startTime = System.currentTimeMillis();
		
		SampleElement sample = new SampleElement(10);
		sample.increase();
		System.out.println("The sample element has a number equal to" + sample.getNumber());
		
		

		
		//arrayIntroMethod();
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in " + (endTime-startTime) + " milliseconds");
		
		printInt(oneToFifty());
		
		printInt(randomArray());
		
		printInt(diceArray());
		
		
	}  
	
	
	private static void passByValueDemo(){
		
		String[] someStrings = new String[100];
		populateArray(someStrings);
		
		int ten = 10;
		increase(ten);
		System.out.println("Ten, increased is " + ten );
		
		// in this method, we pass the element
		//(a variable not the array,so
		//no change will be made
		
		System.out.println("Before " + someStrings[99] );
		changeString(someStrings);
		System.out.println("After " + someStrings[99] );
		printArray(someStrings);
		changeArrayElement(someStrings,99);
		System.out.println("After " + someStrings[99] );
		
		
		
	}
	
	
	private static void changeArrayElement(String[] someStrings, int i) {
		someStrings[i] = "new item" + (i+1);
		
	}
	
	// this does nothing

	private static void increase(int x) {
		x = x+1;
		
	}

	private static void changeString (String[] someStrings){
		someStrings =  new String[100];
		for(int i = 0; i < someStrings.length;i++ ){
			someStrings[i] = "new item " + (i +1);
		}
	}
	
	private static void printArray(String[] a) {
		for(String s: a){
			System.out.println(s);
		}
		
		
	}
	private static void populateArray(String[] a) {
		for(int index = 0; index < a.length; index++){
			a[index] = "value " + (index + 1); 
		}
		
		
	}
	public static void arrayIntroMethod() {
		//construct 2 integer arrays
		// these two methods do the same thing
		// primitive type arrays are filled with zeroes 0 0.0 false
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];

		boolean [] booleans = new boolean[3];
		//iterate (2 ways)
		//WHEN TO USE THIS FOR LOOP
		//  - when the index of the data is important to reference
		//  - you need to customize how you iterate ie by 2 or backwards
		for(int index = 0; index < booleans.length; index++){
			System.out.println(index + ") " + booleans[index]);
		}

		//SECOND METHOD: FOR EACH
		// always goes inorder, does not keep track of index
		// easier to type

		for(boolean b: booleans){
			System.out.println(""+b);
		}

		//these two arrays are different
		String[] strings1 = {"","",""};
		String[] strings2 = new String[3]; 
		
		
		
		// this loop instantiates the array
		for(int index = 0; index < strings2.length; index++){
			strings2[index] = "value " + (index + 1); 
		}
		
		
		
		// prints each array index
		for(String s: strings2){
			System.out.println(s);
		}
	}


	public static int[] oneToFifty(){
		int [] numbers = new int [50];
		for(int i=0; i < numbers.length;i++){
			numbers[i] = i+1;
		
		}
		return numbers;
		
	}
	
	public static int[] randomArray(){
		int[] randomNums = new int [10];
		for(int a = 0; a < randomNums.length; a++){
			double rand = Math.random();
			randomNums[a] = (int) (100 * rand);
			
		}
		
		return randomNums;
	}
	
	public static int[] diceArray(){
		int[] dieRolls = new int[20];
		for(int b = 0; b < dieRolls.length; b++){
			double rand = Math.random(); 
			double rand2 = Math.random(); 
			
			int die1 = ((int) (6*rand) +1);
			int die2 = ((int) (6*rand2) +1);
			
			dieRolls[b] = (die1 + die2);
		}
		
		return dieRolls;
	}
	
	public static void printInt(int array[]){
		for(int i = 0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
	}
	
	public static String[] deckArray(){
		return null;
		
	}
	
	public static int[] results(int rolls[]){
		int[] results = new int [11];
		for(int i = 0; i < rolls.length; i = 0){
			results[rolls[i]-2]++;
		}
		
		for(int a= 0; a<results.length; a++){
			results[a]=(((results[a])/rolls.length)*100);
		}
		return results;
	}
















}
