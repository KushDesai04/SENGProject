package main;
import java.util.*;

/**
 * Enum to represent possible player positions
 */
enum POSITION {
	PG, PF, C, SF, SG;
}

/**
 * Enum to all player stats:
 * Offence
 * Defence
 * Stamina
 * Agility
 */
enum STATS {O, D, S, A}

/**
 * This is the Athlete class which represents a single Athlete.
 * The class extends Purchasable as Athletes can be bought and sold
 * to make a Team.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Athlete {
	
	private String name;
	private String description;
	private int price;
	private int rating;
	private POSITION position;
	private boolean isPlaying;
	private HashMap<STATS, Integer> Stats = new HashMap<STATS, Integer>();
	
	public Athlete() {
		//TODO
	}
	
	/**
	 * Constructor to create Athlete
	 */
	public Athlete (String tempName, int tempRating, POSITION tempPosition, ArrayList<Integer> tempStats) {
		name = tempName;
		rating = tempRating;
		position = tempPosition;
		int offence = tempStats.get(0);
		int defence = tempStats.get(1);
		int stamina = tempStats.get(2);
		int agility = tempStats.get(3);
		Stats.put(STATS.O, offence);
		Stats.put(STATS.D, defence);
		Stats.put(STATS.S, stamina);
		Stats.put(STATS.A, agility);
		this.description = "temp description";
		
	}
	
	/**
	 * Set player nickname
	 * @param newName    The nickname to call the player
	 */
	public void setNickname(String newName) {
		name = newName;
	}
	
	/**
	 * Increase a certain stat of a player
	 * Used when consuming Items
	 * @param value   The amount to increase the stat by
	 * @param stat    The stat to increase
	 */
	public void increase(int value, STATS stat) {
		Stats.put(stat, (getStat(stat) + value));
	}	
	
	
	public String toString() {
		return super.toString();
	}
	
	//Getter methods
	public int getStat(STATS stat) {
		return Stats.get(stat);
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getRating() {
		return rating;
	}
	public POSITION getPosition() {
		return position;
	}
	public boolean getPlaying() {
		return isPlaying;
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> statListsA = new ArrayList<Integer>();
		statListsA.add(99);
		statListsA.add(96);
		statListsA.add(95);
		statListsA.add(94);
		
		Athlete a = new Athlete("A", 99, POSITION.PG, statListsA);
		
//		System.out.println(a.Stats.get(STATS.O));
//	
//		System.out.println(a.getStat(STATS.O));
//		System.out.println(a.Stats);
//		STATS pos = STATS.O;
//		a.increase(99, pos);
//		System.out.println(a.Stats.get(STATS.O));
//		
//		System.out.println(a.getStat(STATS.O));
//		System.out.println(a.Stats);
		System.out.println(a);
	}
	
}


