package main;

import java.util.ArrayList;

/**
 * This is the Market class. This class controls the logic for buying and selling all purchasable items such as Athletes and Items.
 * It manages the lists of purchasable athletes and items, as well as the lists of starter athletes and weekly purchased athletes and items.
 * 
 * The Market class is responsible for generating random purchasable athletes and items through the GenerateRandom class.
 * 
 * The buying and selling logic is not fully implemented in this version.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 */
public class Market {
	
	/**
	 * The list of purchasable athletes.
	 */
	private ArrayList<Athlete> purchasableAthletes;
	
	/**
	 * The list of purchasable items.
	 */
	private ArrayList<Item> purchasableItems;
	
	/**
	 * The list of starter athletes.
	 */
	private ArrayList<Athlete> starterAthletes = new ArrayList<Athlete>();
	
	/**
	 * The list of weekly purchased athletes.
	 */
	private ArrayList<Athlete> weeklyPurchasedAthletes = new ArrayList<Athlete>();
	
	/**
	 * The list of weekly purchased items.
	 */
	private ArrayList<Item> weeklyPurchasedItems = new ArrayList<Item>();
	
	/**
	 * The instance of GenerateRandom used for generating random purchasable athletes and items.
	 */
	private GenerateRandom randomPurchasables;

	/**
	 * Constructs a new Market object with the specified instance of GenerateRandom.
	 * 
	 * @param random the instance of GenerateRandom used for generating random purchasable athletes and items
	 */
	public Market(GenerateRandom random) {
		randomPurchasables = random;
	}

	/**
	 * Placeholder method for buying an item or athlete. Returns false indicating that the purchase was not successful.
	 * 
	 * @return false indicating that the purchase was not successful
	 */
	public boolean buy() {
		return false;
	}

	/**
	 * Placeholder method for selling an item or athlete.
	 */
	public void sell() {
		// Implementation for selling an item or athlete
	}

	/**
	 * Returns the list of purchasable athletes.
	 * 
	 * @return the list of purchasable athletes
	 */
	public ArrayList<Athlete> getPurchasableAthletes() {
		return purchasableAthletes;
	}

	/**
	 * Generates and sets the list of purchasable athletes using the GenerateRandom class.
	 */
	public void setPurchasableAthletes() {
		purchasableAthletes = randomPurchasables.generateWeeklyAthletes();
	}

	/**
	 * Returns the list of purchasable items.
	 * 
	 * @return the list of purchasable items
	 */
	public ArrayList<Item> getPurchasableItems() {
		return purchasableItems;
	}

	/**
	 * Generates and sets the list of purchasable items using the GenerateRandom class.
	 */
	public void setPurchasableItems() {
		purchasableItems = randomPurchasables.generateWeeklyItems();
	}

	/**
	 * Returns the list of starter athletes.
	 * 
	 * @return the list of starter athletes
	 */
	public ArrayList<Athlete> getStarterAthletes() {
		return starterAthletes;
	}

	/**
	 * Returns the list of weekly purchased athletes.
	 * 
	 * @return the list of weekly purchased athletes
	 */
	public ArrayList<Athlete> getWeeklyPurchasedAthletes() {
		return weeklyPurchasedAthletes;
	}

	/**
	 * Returns the list of weekly purchased items.
	 * 
	 * @return the list of weekly purchased items
	 */
	public ArrayList<Item> getWeeklyPurchasedItems() {
		return weeklyPurchasedItems;
	}

	/**
	 * Adds the specified athlete to the list of weekly purchased athletes.
	 * 
	 * @param athlete the athlete to add to the list of weekly purchased athletes
	 */
	public void addWeeklyPurchasedAthletes(Athlete athlete) {
		weeklyPurchasedAthletes.add(athlete);
	}

	/**
	 * Adds the specified item to the list of weekly purchased items.
	 * 
	 * @param item the item to add to the list of weekly purchased items
	 */
	public void addWeeklyPurchasedItems(Item item) {
		weeklyPurchasedItems.add(item);
	}

	/**
	 * Clears the lists of weekly purchased athletes and items.
	 */
	public void clearWeeklyPurchases() {
		weeklyPurchasedAthletes.clear();
		weeklyPurchasedItems.clear();
	}
}

