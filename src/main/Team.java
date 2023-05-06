package main;
import java.util.ArrayList;

public class Team extends Athlete {
	
	private String teamName;
	private ArrayList<Athlete> players = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Item> consumables = new ArrayList<Item>();
	private boolean canPlay;
	
	public Team(String name) {
		// TODO Auto-generated constructor stub
		teamName = name;
	}
	
	public void addPlayers(Athlete player) {
		players.add(player);
	}
	public void removePlayers(Athlete player) {
		players.remove(player);
		reserves.add(player);
	}
	public void addConsumable(Item consumable) {
		consumables.add(consumable);
	}
	public void removeConsumable(Item consumable) {
		consumables.remove(consumable);
	}
	public boolean useConsumable(Item consumable, Athlete athlete) {
		if (consumables.contains(consumable)) {
			athlete.increase(consumable.getValue(), consumable.getStat());
			consumables.remove(consumable);
			return true;
		}
		else {
			return false;
		}
	}
	public void canPlay() {
		if (players.size() == 5 && reserves.size() == 5) {
			canPlay = true;
		}
		else {
			canPlay = false;
		}
	}
	
	//Getter methods
	public String getTeamName() {
		return teamName;
	}
	public ArrayList<Athlete> getPlayers() {
		return players;
	}
	public ArrayList<Athlete> getReserves() {
		return reserves;
	}
	public ArrayList<Item> getItems() {
		return consumables;
	}
	public boolean getStatus() {
		return canPlay;
	}

}
