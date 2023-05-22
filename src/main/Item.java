package main;

/**
 * This is the Item class which represents a single Item. Items are used to
 * boost player stats.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class Item {

	/**
	 * The name of the Item.
	 */
	private String name;

	/**
	 * The stat affected by the Item.
	 */
	private Athlete.STATS stat;

	/**
	 * The value by which the stat is increased.
	 */
	private int value;

	/**
	 * The price of the Item.
	 */
	private int price;

	/**
	 * The description of the Item.
	 */
	private String description;

	/**
	 * Constructs a new Item with the specified name, stat, value, and price.
	 * 
	 * @param name  the name of the Item
	 * @param stat  the stat affected by the Item
	 * @param value the value by which the stat is increased
	 */
	public Item(String name, Athlete.STATS stat, int value) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.price = value * 100;
		this.description = "This item increases a player's " + getStatName() + " by " + value;
	}

	/**
	 * Returns the value of the Item.
	 * 
	 * @return the value of the Item
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the price of the Item.
	 * 
	 * @return the price of the Item
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Returns a string representation of the Item.
	 * 
	 * @return the name of the item
	 */
	public String toString() {
		return name;
	}

	/**
	 * Returns the description of the Item.
	 * 
	 * @return the description of the Item
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
	 * Returns the name of the Item.
	 * 
	 * @return the name of the Item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the stat affected by the Item.
	 * 
	 * @return the stat affected by the Item
	 */
	public Athlete.STATS getStat() {
		return stat;
	}

	/**
	 * Applies the Item's effect on the given Athlete.
	 * 
	 * @param athlete the Athlete on which to apply the Item's effect
	 */
	public void consume(Athlete athlete) {

		athlete.changeStat(value, stat);
	}
}