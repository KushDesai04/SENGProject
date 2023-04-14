package main;

public abstract class Purchasable {	
	protected int price;
	protected int sellback;
	protected String description;
	
	public abstract boolean buy();
	public abstract void sell();
	public String toString() {
		return description;
	}
	
}
