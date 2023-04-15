/*
 * This is the Athlete class.
 */
package main;
import java.util.*;

enum POSITION {
	PG, PF, CENTER, SF, SG;
}

enum STATS {O, D, S, A}

public class Athlete extends Purchasable {
	
	private String name;
	private int price;
	private int rating;
	private POSITION position;
	private boolean isPlaying;
	private HashMap<String, Integer> Stats = new HashMap<String, Integer>();
	
	
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
		Stats.put("offence", offence);
		Stats.put("defence", defence);
		Stats.put("stamina", stamina);
		Stats.put("agility", agility);
		
	}
	public void setNickname(String newName) {
		name = newName;
	}
	
	
	public void increase(int value, STATS stat) {
		switch (stat) {
			case O:
				Stats.put("offence", Stats.get("offence") + value);
				break;
			case D:
				Stats.put("defence", Stats.get("defence") + value);
				break;
			case S:
				Stats.put("stamina", Stats.get("stamina") + value);
				break;
			case A:
				Stats.put("agility", Stats.get("agility") + value);
				break;
		}
	}	
	
	public int getStat() {
		return Stats.get("offence");
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
	
	public static void main(String args[]) {
		ArrayList<Integer> statListsA = new ArrayList<Integer>();
		statListsA.add(99);
		statListsA.add(96);
		statListsA.add(95);
		statListsA.add(94);
		
		Athlete a = new Athlete("A", 99, POSITION.PG, statListsA);
		
		System.out.println(a.Stats.get("offence"));
	
		System.out.println(a.getStat());
		System.out.println(a.Stats);
		STATS pos = STATS.O;
		a.increase(99, pos);
		System.out.println(a.Stats.get("offence"));
		
		System.out.println(a.getStat());
		System.out.println(a.Stats);
	}
	
}


