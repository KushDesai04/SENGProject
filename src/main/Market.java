package main;

import java.util.ArrayList;

/**
 * This is the Market class. This class controls the logic for buying and
 * selling all purchasable items such as Athletes and Items. It manages the
 * lists of purchasable Athletes and Items, as well as the lists of starter
 * Athletes and weekly purchased Athletes and Items.
 * 
 * The Market class is responsible for generating random purchasable Athletes
 * and Items through the GenerateRandom class.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class Market {

	/**
	 * The list of purchasable Athletes.
	 */
	private ArrayList<Athlete> purchasableAthletes;

	/**
	 * The list of purchasable Items.
	 */
	private ArrayList<Item> purchasableItems;

	/**
	 * The list of starter Athletes.
	 */
	private ArrayList<Athlete> starterAthletes = new ArrayList<Athlete>();

	/**
	 * The list of weekly purchased Athletes.
	 */
	private ArrayList<Athlete> weeklyPurchasedAthletes = new ArrayList<Athlete>();

	/**
	 * The list of weekly purchased Items.
	 */
	private ArrayList<Item> weeklyPurchasedItems = new ArrayList<Item>();

	/**
	 * The instance of GenerateRandom used for generating random purchasable
	 * Athletes and Items.
	 */
	private GenerateRandom randomPurchasables;

	/**
	 * Constructs a new Market object with the specified instance of GenerateRandom.
	 * 
	 * @param random the instance of GenerateRandom used for generating random
	 *               purchasable Athletes and Items
	 */
	public Market(GenerateRandom random) {
		randomPurchasables = random;
	}

	/**
	 * Returns the list of purchasable Athletes.
	 * 
	 * @return the list of purchasable Athletes
	 */
	public ArrayList<Athlete> getPurchasableAthletes() {
		return purchasableAthletes;
	}

	/**
	 * Generates and sets the list of purchasable Athletes using the GenerateRandom
	 * class.
	 */
	public void setPurchasableAthletes() {
		purchasableAthletes = randomPurchasables.generateWeeklyAthletes();
	}

	/**
	 * Returns the list of purchasable Items.
	 * 
	 * @return the list of purchasable Items
	 */
	public ArrayList<Item> getPurchasableItems() {
		return purchasableItems;
	}

	/**
	 * Generates and sets the list of purchasable Items using the GenerateRandom
	 * class.
	 */
	public void setPurchasableItems() {
		purchasableItems = randomPurchasables.generateWeeklyItems();
	}

	/**
	 * Returns the list of starter Athletes.
	 * 
	 * @return the list of starter Athletes
	 */
	public ArrayList<Athlete> getStarterAthletes() {
		return starterAthletes;
	}

	/**
	 * Returns the list of weekly purchased Athletes.
	 * 
	 * @return the list of weekly purchased Athletes
	 */
	public ArrayList<Athlete> getWeeklyPurchasedAthletes() {
		return weeklyPurchasedAthletes;
	}

	/**
	 * Returns the list of weekly purchased Items.
	 * 
	 * @return the list of weekly purchased Items
	 */
	public ArrayList<Item> getWeeklyPurchasedItems() {
		return weeklyPurchasedItems;
	}

	/**
	 * Adds the specified Athlete to the list of weekly purchased Athletes.
	 * 
	 * @param athlete the Athlete to add to the list of weekly purchased Athletes
	 */
	public void addWeeklyPurchasedAthletes(Athlete athlete) {
		weeklyPurchasedAthletes.add(athlete);
	}

	/**
	 * Adds the specified Item to the list of weekly purchased Items.
	 * 
	 * @param item the Item to add to the list of weekly purchased Items
	 */
	public void addWeeklyPurchasedItems(Item item) {
		weeklyPurchasedItems.add(item);
	}

	/**
	 * Clears the lists of weekly purchased Athletes and Items.
	 */
	public void clearWeeklyPurchases() {
		weeklyPurchasedAthletes.clear();
		weeklyPurchasedItems.clear();
	}
}
