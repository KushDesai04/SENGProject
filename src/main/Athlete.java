package main;
import java.util.*;

public class Athlete extends Purchasable {
	
	private String name;
	private int price;
	private int rating;
	private int offence;
	private int defence;
	private int stamina;
	private int agility;
	private String position;
	private boolean isPlaying;
	private ArrayList<Integer> statsArray = new ArrayList<Integer>();
	
	
	public Athlete() {
		// TODO Auto-generated constructor stub
		
	}
	public Athlete (String tempName, int tempRating, String tempPosition, ArrayList<Integer> tempStats) {
		name = tempName;
		rating = tempRating;
		position = tempPosition;
		offence = tempStats.get(0);
		defence = tempStats.get(1);
		stamina = tempStats.get(2);
		agility = tempStats.get(3);
		statsArray = tempStats;
		
	}
	public void setNickname(String newName) {
		name = newName;
	}
	
	public enum Stats {O, D, S, A}
	
	public void increase(int value, Stats stat) {
		switch (stat) {
			case O:
				offence += value;
				statsArray.set(0, offence);
				break;
			case D:
				defence += value;
				statsArray.set(1, defence);
				break;
			case S:
				stamina += value;
				statsArray.set(2, stamina);
				break;
			case A:
				agility += value;
				statsArray.set(3, agility);
				break;
		}
	}	
	
	public int getStat() {
		return Collections.max(statsArray);
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
		Athlete a = new Athlete("A", 99, "PG", statListsA);
		System.out.println(a.offence);
		Stats increaseStat = Stats.O;
		System.out.println(a.getStat());
		System.out.println(a.statsArray);
		a.increase(99, increaseStat);
		System.out.println(a.offence);
		
		System.out.println(a.getStat());
		System.out.println(a.statsArray);
	}
	
}


