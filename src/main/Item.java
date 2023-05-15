package main;

/**
 * This is the Item class which represents a single Item.
 * The class extends Purchasable as Items can be bought and sold
 * to consume. Items are used to boost player stats.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Item extends Purchasable {
	private String name;
	private STATS stat;
	private int value;
	public Item(String name, STATS stat, int value) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.description = name + ". This item increases a players " + getStatName() + " by " + value;
	}

	@Override
	public boolean buy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		
	}
	public int getValue() {
		return value;
	}
	
	/**
	 * Method to represent a stat as a string
	 * @param stat    takes an enum value to return as a string
	 */
	public String getStatName() {
		switch (this.stat){
		case A:
			return "agility";
		case D:
			return "defence";
		case O:
			return "offence";
		case S:
			return "stamina";
		default:
			return "error";
		}
	}
	
	public STATS getStat() {
		return (this.stat);
	}
	
	public static void main(String[] args) {
		Item item = new Item("Cake", STATS.D, 12);
		System.out.println(item);
	}

}
