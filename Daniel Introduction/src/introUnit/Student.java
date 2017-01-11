package introUnit;

public class Student {

	//fields
	private String name;
	private String year;

	//constructor(no return type. It creates students)
	public Student(String name, String year){
		//initialize fields
		this.name = name;
		this.year = year;
	}

	public void talk(){
		System.out.println("Hi, my name is " + name + " and I am a " + year );
	}
	
	

	
	
	
}
