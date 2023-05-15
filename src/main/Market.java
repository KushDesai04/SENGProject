package main;
import java.util.ArrayList;

/**
 * This is the Market class. This class will control the logic
 * for buying and selling all purchasable items such as Athletes
 * and Items.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Market {
	private ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	private ArrayList<Item> purchasableItems = new ArrayList<Item>();
	
	public Market() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean buy() {
		return false;
	}
	public void sell() {
		
	}
	public ArrayList<Athlete> getPurchasableAthletes() {
		return purchasableAthletes;
	}

}
