
package main;
import java.util.ArrayList;

/**
 * This is the Team class. This class will handle logic
 * to provide a functioning team so that the game is playable.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Team{
	
	private String teamName;
	private ArrayList<Athlete> players = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Item> consumables = new ArrayList<Item>();
	private boolean canPlay;
	
	public Team(String name) {
		// TODO Auto-generated constructor stub
		teamName = name;
	}

	public void addPlayer(Athlete player) {
		players.add(player);
	}
	
	public void buyPlayer(Athlete player) {
		reserves.add(player);
	}
	
	public void sellPlayer(Athlete player) {
		reserves.remove(player);
		// TODO throw exception if player is in team
	}
	
	public void removePlayer(Athlete player) {
		players.remove(player);
		reserves.add(player);
	}
	
	public void buyConsumable(Item consumable) {
		consumables.add(consumable);
	}
	
	public void sellConsumable(Item consumable) {
		consumables.remove(consumable);
	}
	
	/**
	 * Given an item and player, consume the item and increase player stats
	 * @param consumable    The item to consume
	 * @param athlete       The athlete whos stats should increase
	 */
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
		if (players.size() == 5 && reserves.size() >= 5) {
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
