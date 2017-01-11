package sort;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;

	
	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		hp = 100;
		poisoned = false;
		
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random()<.9){
			attack.attack(target);
			System.out.println("The attack hit");
		}
		else{
			System.out.println("The attack missed");

		}
		
	}
	
	public void iChooseYou(){
		System.out.println( name + " " + name + "!");
	}
	
	public int getHp(){
		return hp;
	}
	public void setHp(int newHp){
		hp = newHp;
	}
	
	public void setPoisoned (boolean newStat){
		poisoned = newStat;
		
	}
	
	public void lapse(){
		hp = hp-25;
	}

	public String getName() {
		return name;
	}

}
