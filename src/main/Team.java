
package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This is the Team class. This class handles the logic to provide a functioning team for the game.
 * The team consists of players, reserves, and consumable items.
 * It allows adding, selling, and replacing Athletes, as well as buying and selling consumable Items.
 * The Team's ability to play is determined by the number of players and their injury status.
 * The Team can also restore the stamina of its players.
 * Each Team has a unique name.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class Team {
    /**
     * The name of the Team.
     */
    private String teamName;
    /**
     * The mapping of player positions to athlete objects in the Team.
     */
    private HashMap<Athlete.POSITION, Athlete> players = new HashMap<Athlete.POSITION, Athlete>();
    /**
     * The list of reserve Athletes in the Team.
     */
    private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
    /**
     * The list of consumable Items held by the Team.
     */
    private ArrayList<Item> consumables = new ArrayList<Item>();

    /**
     * Constructs a new Team object with the given name.
     *
     * @param name the name of the team
     */
    public Team(String name) {
        teamName = name;
    }

    /**
     * Adds an Athlete to the Team's player mapping.
     *
     * @param player the Athlete to be added to the team
     */
    public void addPlayer(Athlete player) {
        players.put(player.getPosition(), player);
    }

    /**
     * Adds a reserve Athlete to the Team's reserves list.
     *
     * @param player the Athlete to be added as a reserve
     */
    public void addReserves(Athlete player) {
        reserves.add(player);
    }

    /**
     * Buys an Athlete by adding them to the Team's reserves list.
     *
     * @param player the Athlete to be bought and added to the reserves
     */
    public void buyPlayer(Athlete player) {
        reserves.add(player);
    }

    /**
     * Sells an Athlete by removing them from the Team's reserves list.
     *
     * @param player the Athlete to be sold and removed from the reserves
     */
    public void sellPlayer(Athlete player) {
        reserves.remove(player);
        // TODO throw exception if player is in team
    }

    /**
     * Removes an Athlete from the Team's player mapping and adds them to the reserves.
     *
     * @param player the Athlete to be removed from the Team and added to the reserves
     */
    public void removePlayer(Athlete player) {
        players.put(player.getPosition(), null);
        reserves.add(player);
    }

    /**
     * Replaces an Athlete in the Team's player mapping with another Athlete.
     * The replaced Athlete is added to the reserves.
     *
     * @param in  the Athlete to be added to the team
     * @param out the Athlete to be removed from the team and added to the reserves
     */
    public void replacePlayer(Athlete in, Athlete out) {
        players.put(in.getPosition(), in);
        reserves.add(out);
        reserves.remove(in);
    }

    /**
     * Purchases a consumable Item by adding it to the Team's consumables list.
     *
     * @param consumable the Item to be bought and added to the consumables
     */
    public void buyConsumable(Item consumable) {
        consumables.add(consumable);
    }

    /**
     * Sells a consumable Item by removing it from the Team's consumables list.
     *
     * @param consumable the Item to be sold and removed from the consumables
     */
    public void sellConsumable(Item consumable) {
        consumables.remove(consumable);
    }

    /**
     * Checks if the Team can play a game.
     * A Team can play if it has exactly 5 players and none of them are injured.
     *
     * @return true if the Team can play, false otherwise
     */
    public boolean canPlay() {
        if (players.size() == 5) {
            for (Athlete athlete : players.values()) 
            {
                if (athlete.isInjured()) 
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retrieves the Team name.
     *
     * @return the Team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Retrieves the mapping of player positions to Athlete objects in the Team.
     *
     * @return the player mapping
     */
    public HashMap<Athlete.POSITION, Athlete> getPlayersMap() {
        return players;
    }

    /**
     * Retrieves the list of player Athletes in the Team.
     *
     * @return the list of players
     */
    public ArrayList<Athlete> getPlayersArray() {
        ArrayList<Athlete> playersArray = new ArrayList<>(players.values());
        return playersArray;
    }

    /**
     * Retrieves the list of reserve Athletes in the Team.
     *
     * @return the list of reserves
     */
    public ArrayList<Athlete> getReserves() {
        return reserves;
    }

    /**
     * Retrieves the list of consumable Items held by the Team.
     *
     * @return the list of consumables
     */
    public ArrayList<Item> getItems() {
        return consumables;
    }

    /**
     * Removes a consumable Item from the Team's consumables list.
     *
     * @param item the Item to be removed from the consumables
     */
    public void removeItem(Item item) {
        consumables.remove(item);
    }

    /**
     * Restores the stamina of all Athletes in the Team.
     * This method sets the current stamina of each Athlete to their maximum stamina.
     */
    public void restoreStamina() {
        for (Athlete athlete : players.values()) {
            athlete.restoreCurrentStamina();
        }
    }
}
