package test;

public class Item {
	
	private String description;
	
	private boolean purchased;
	
	public Item(String d){
		this.description = d;
		this.purchased = false;
		
	}
	public void setPurchased(boolean b){
		purchased = b;
	}
	public boolean isPurchased() {
		// TODO Auto-generated method stub
		return purchased;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;

	}
	

}
