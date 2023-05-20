
package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This is the Team class. This class will handle logic to provide a functioning
 * team so that the game is playable.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Team {

	private String teamName;
	private HashMap<Athlete.POSITION, Athlete> players = new HashMap<Athlete.POSITION, Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Item> consumables = new ArrayList<Item>();

	public Team(String name) {
		// TODO Auto-generated constructor stub
		teamName = name;
	}

	public void addPlayer(Athlete player) {
		players.put(player.getPosition(), player);
	}

	public void addReserves(Athlete player) {
		reserves.add(player);
	}

	public void buyPlayer(Athlete player) {
		reserves.add(player);
	}

	public void sellPlayer(Athlete player) {
		reserves.remove(player);
		// TODO throw exception if player is in team
	}

	public void removePlayer(Athlete player) {
		players.put(player.getPosition(), null);
		reserves.add(player);
	}

	public void replacePlayer(Athlete in, Athlete out) {
		players.put(in.getPosition(), in);
		reserves.add(out);
		reserves.remove(in);
	}

	public void buyConsumable(Item consumable) {
		consumables.add(consumable);
	}

	public void sellConsumable(Item consumable) {
		consumables.remove(consumable);
	}

	public boolean canPlay() {
		if (players.size() == 5) {
			for (Athlete athlete : players.values()) {
				if (athlete.isInjured()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	// Getter methods
	public String getTeamName() {
		return teamName;
	}

	public HashMap<Athlete.POSITION, Athlete> getPlayersMap() {
		return players;
	}

	public ArrayList<Athlete> getPlayersArray() {
		ArrayList<Athlete> playersArray = new ArrayList<>(players.values());
		return playersArray;
	}

	public ArrayList<Athlete> getReserves() {
		return reserves;
	}

	public ArrayList<Item> getItems() {
		return consumables;
	}

	public void removeItem(Item item) {
		consumables.remove(item);
	}
	
	public void restoreStamina() {
		for (Athlete athlete : players.values()) {
			athlete.restoreCurrentStamina();
		}
	}

}
