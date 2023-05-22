package main;

/**
 * This is the Item class which represents a single Item. Items are used to boost player stats.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 */
public class Item {
	
	/**
	 * The name of the item.
	 */
	private String name;
	
	/**
	 * The stat affected by the item.
	 */
	private Athlete.STATS stat;
	
	/**
	 * The value by which the stat is increased.
	 */
	private int value;
	
	/**
	 * The price of the item.
	 */
	private int price;
	
	/**
	 * The description of the item.
	 */
	private String description;

	/**
	 * Constructs a new Item with the specified name, stat, value, and price.
	 * 
	 * @param name  the name of the item
	 * @param stat  the stat affected by the item
	 * @param value the value by which the stat is increased
	 * @param price the price of the item
	 */
	public Item(String name, Athlete.STATS stat, int value, int price) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.price = price;
		this.description = "This item increases a player's " + getStatName() + " by " + value;
	}

	/**
	 * Returns the value of the item.
	 * 
	 * @return the value of the item
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the price of the item.
	 * 
	 * @return the price of the item
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Returns a string representation of the item.
	 * 
	 * @return the name of the item
	 */
	public String toString() {
		return name;
	}

	/**
	 * Returns the description of the item.
	 * 
	 * @return the description of the item
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the name of the stat as a string.
	 * 
	 * @return the name of the stat
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
		case CS:
			return "current stamina";
		default:
			return "error";
		}
	}

	/**
	 * Returns the name of the item.
	 * 
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the stat affected by the item.
	 * 
	 * @return the stat affected by the item
	 */
	public Athlete.STATS getStat() {
		return stat;
	}

	/**
	 * Applies the item's effect on the given athlete.
	 * 
	 * @param athlete the athlete on which to apply the item's effect
	 */
	public void consume(Athlete athlete) {
		if (stat == Athlete.STATS.CS) {
			athlete.changeCurrentStamina(value);
		} else {
			athlete.changeStat(value, stat);
		}
	}

	/**
	 * The main method used for testing the Item class.
	 * 
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
//		Item item = new Item("Cake", Athlete.STATS.D, 12, 6000);
//		System.out.println(item);
	}

}