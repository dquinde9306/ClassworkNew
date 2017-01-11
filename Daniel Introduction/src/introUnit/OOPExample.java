/**
 * 
 */
package introUnit;

/**
 * @author Student 6
 * This class is designed to contrast
 *  with the ProceduralExample. It embodies an Object Oriented approach
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//construct a student
		Student jillian = new Senior("Jillian", "programmer", "Senior");
		Student jordan = new Student("Jordan", "Sophmore");
		Student joseph = new Student("Joseph", "Junior");
		jillian.talk();
		jordan.talk();
		joseph.talk();	
	}

}
