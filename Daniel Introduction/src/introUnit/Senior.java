package introUnit;

public class Senior extends Student {
	
	private String internship;

	public Senior(String name, String internship, String year) {
		super(name, year);
		this.internship = internship;
	}
	
	public void talk(){
		//super.talk();//call the super method
		System.out.println( "... and I am a senior!");

	//	super.talk();//call the super method
		//System.out.println( "... and I am a senior!");

		System.out.println(" I intern as " + internship);
	}
	
	
	
}
