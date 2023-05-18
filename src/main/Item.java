package main;

/**
 * This is the Item class which represents a single Item. Items are used to
 * boost player stats.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Item {
	private String name;
	private Athlete.STATS stat;
	private int value;
	private int price;
	private String description;

	public Item(String name, Athlete.STATS stat, int value, int price) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.price = price;
		this.description = "This item increases a player's " + getStatName() + " by " + value;
	}

	public int getValue() {
		return value;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * Method to represent a stat as a string
	 * 
	 * @param stat takes an enum value to return as a string
	 */
	public String getStatName() {
		switch (this.stat) {
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

	public String getName() {
		return name;
	}

	public Athlete.STATS getStat() {
		return (this.stat);
	}

	public void consume(Athlete athlete) {
		athlete.changeStat(value, stat);

	}

	public static void main(String[] args) {
//		Item item = new Item("Cake", Athlete.STATS.D, 12, 6000);
//		System.out.println(item);
	}

}
