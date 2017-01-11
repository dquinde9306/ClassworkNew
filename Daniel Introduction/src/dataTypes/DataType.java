package dataTypes;

public class DataType {

	public static void main(String[] args) {
		System.out.println(5.0/2); // double divided by integer
		System.out.println((double)5/2);// casting
		System.out.println(5/2);
		// The first two are using doubles while the third is an int divided by an int. Therefore it rounds
		System.out.println(3+5.0/2+5*2);
		System.out.println(3.0+5/2+5*2);
		System.out.println((int)(3.0 + 5)/(2 + 5 * 2));
		// the placement of the double causes the answer to change because it causes different rounding: 5.0/2 = 2.5 but 5/2 = 2 and 8/12 is 0
	//	if(42 == 42.0) System.out.println("42 equals 42.0");
		
		double d1 = 4.64; 
		double d2 = 2.0;
		double d3 = 2.64;

		System.out.println("d1 : " + d1); 
		System.out.println("d2 : " + d2); 
		System.out.println("d3 : " + d3);  
		System.out.println("d1 - d2 : " + (d1 - d2));
		
//		String s = 1; // 1 is an int but it is trying to return as a string
//		System.out.println(s);
//		
//		String s = (String)1; // can't change an int into a string
//		System.out.println(s);
//		
//		String s = "1";
//		System.out.println(s);
//		
//		String s = ""+1;
//		System.out.println(s);
//		
//		String s = "Happy "+18+"th birthday!";
//		System.out.println(s);
//		
//		String s = "Happy 18th birthday!";
//		System.out.println(s);

//		String s = "Happy "+54/3+"th birthday!";
//		System.out.println(s);
//		
//		String s = "Happy "+(54/3)+"th birthday!";
//		System.out.println(s);
//		
//		int m = 22;
//		int n = 7;
//		System.out.println("m/n is "+(m/n));
//		
//		int m = 22;
//		int n = 7;
//		System.out.println("m/n is "+((double)m/n));
//		
		
		String ten = "10";
		String two = "2";
		if(ten.compareTo(two)>0)System.out.println("10 is greater than two");
		else System.out.println("ten is not greater than two");
		
		
		
		
		


	
	}

}
