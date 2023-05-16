package main;

/**
 * This is the Item class which represents a single Item.
 * Items are used to boost player stats.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Item {
	private String name;
	private STATS stat;
	private int value;
	private String description;
	public Item(String name, STATS stat, int value) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.description = name + ". This item increases a players " + getStatName() + " by " + value;
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
