package main;

/**
 * This is an abstract class that is extended. The class
 * ensures the methods that allow an object to be 'purchased'
 * in the game
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
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
