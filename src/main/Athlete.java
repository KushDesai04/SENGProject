package main;
import java.util.*;



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
	private int price;
	private int rating;
	private POSITION position;
	private HashMap<STATS, Integer> Stats = new HashMap<STATS, Integer>();
	
	public Athlete() {
		//TODO
	}
	
	/**
	 * Constructor to create Athlete
	 */
	public Athlete (String tempName, POSITION tempPosition, HashMap<STATS, Integer> tempStats) {
		name = tempName;
		position = tempPosition;
		int offence = tempStats.get(STATS.O);
		int defence = tempStats.get(STATS.D);
		int stamina = tempStats.get(STATS.S);
		int agility = tempStats.get(STATS.A);
		rating = (offence + defence + stamina + agility) / 4;
		price = rating * 20;
		Stats.put(STATS.O, offence);
		Stats.put(STATS.D, defence);
		Stats.put(STATS.S, stamina);
		Stats.put(STATS.A, agility);	
	}
	

	/**
	 * Enum to all player stats:
	 * Offence
	 * Defence
	 * Stamina
	 * Agility
	 */
	public enum POSITION {
		PG, PF, C, SF, SG;
	}
	
	/**
	 * Enum to represent possible player positions
	 */
	public enum STATS {
		O, D, S, A;
		}
	/**
	 * Set player nickname
	 * @param newName    The nickname to call the player
	 */
	public void setNickname(String newName) {
		name = newName;
	}
	
	/**
	 * Change a certain stat of a player
	 * Used when consuming Items or playing a match
	 * @param value   The amount to change the stat by
	 * @param stat    The stat to change
	 */
	public void changeStat(int value, STATS stat) {
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
	public boolean isInjured() {
		return Stats.get(STATS.S) == 0;
	}
	
//	public static void main(String args[]) {
//		ArrayList<Integer> statListsA = new ArrayList<Integer>();
//		statListsA.(99);
//		statListsA.add(96);
//		statListsA.add(95);
//		statListsA.add(94);
//		
//		Athlete a = new Athlete("A", POSITION.PG, statListsA);
		
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
//		System.out.println(a);
//	}
	
}


