/*
 * This is the Athlete class.
 */
package main;
import java.util.*;

enum POSITION {
	PG, PF, C, SF, SG;
}

enum STATS {O, D, S, A}

public class Athlete extends Purchasable {
	
	private String name;
	private int price;
	private int rating;
	private POSITION position;
	private boolean isPlaying;
	private HashMap<STATS, Integer> Stats = new HashMap<STATS, Integer>();
	
	
	public Athlete() {
		// TODO Auto-generated constructor stub
		
	}
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
	public void setNickname(String newName) {
		name = newName;
	}
	
	
	public void increase(int value, STATS stat) {
		Stats.put(stat, (getStat(stat) + value));
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


