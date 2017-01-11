package sort;

public class MainBattle {
	public static void main(String[] args) {
		Pokemon raticate = new Pokemon("Raticate",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		raticate.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Raticate is preparing to attack with Hyper Fang");
		raticate.attack(bulbasaur,new Attack() {
			
			public void attack(Pokemon target) {
				System.out.println("Hyper Fang is used!");
				target.setPoisoned(true);
			}
		});
		bulbasaur.attack(raticate, new Attack(){

			@Override
			public void attack(Pokemon target) {
				System.out.println("Hyper Fang is used!");
				
			}
			
		});
		printScore(raticate,bulbasaur);
	}
	
	private static void printScore(Pokemon p1, Pokemon p2){
		System.out.println(p1.getName() + ", HP = " + p1.getHp());
		System.out.println(p2.getName() + ", HP = " + p2.getHp());

	}

}
