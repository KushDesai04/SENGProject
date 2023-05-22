
package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This is the Team class. This class handles the logic to provide a functioning team for the game.
 * The team consists of players, reserves, and consumable items.
 * It allows adding, selling, and replacing players, as well as buying and selling consumable items.
 * The team's ability to play is determined by the number of players and their injury status.
 * The team can also restore the stamina of its players.
 * Each team has a unique team name.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class Team {
    /**
     * The name of the team.
     */
    private String teamName;
    
    /**
     * The mapping of player positions to athlete objects in the team.
     */
    private HashMap<Athlete.POSITION, Athlete> players = new HashMap<Athlete.POSITION, Athlete>();
    
    /**
     * The list of reserve athletes in the team.
     */
    private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
    
    /**
     * The list of consumable items held by the team.
     */
    private ArrayList<Item> consumables = new ArrayList<Item>();

    /**
     * Constructs a new Team object with the given team name.
     *
     * @param name the name of the team
     */
    public Team(String name) {
        teamName = name;
    }

    /**
     * Adds a player to the team's player mapping.
     *
     * @param player the athlete to be added to the team
     */
    public void addPlayer(Athlete player) {
        players.put(player.getPosition(), player);
    }

    /**
     * Adds a reserve athlete to the team's reserves list.
     *
     * @param player the athlete to be added as a reserve
     */
    public void addReserves(Athlete player) {
        reserves.add(player);
    }

    /**
     * Buys a player by adding them to the team's reserves list.
     *
     * @param player the athlete to be bought and added to the reserves
     */
    public void buyPlayer(Athlete player) {
        reserves.add(player);
    }

    /**
     * Sells a player by removing them from the team's reserves list.
     *
     * @param player the athlete to be sold and removed from the reserves
     */
    public void sellPlayer(Athlete player) {
        reserves.remove(player);
        // TODO throw exception if player is in team
    }

    /**
     * Removes a player from the team's player mapping and adds them to the reserves.
     *
     * @param player the athlete to be removed from the team and added to the reserves
     */
    public void removePlayer(Athlete player) {
        players.put(player.getPosition(), null);
        reserves.add(player);
    }

    /**
     * Replaces a player in the team's player mapping with another athlete.
     * The replaced player is added to the reserves.
     *
     * @param in  the athlete to be added to the team
     * @param out the athlete to be removed from the team and added to the reserves
     */
    public void replacePlayer(Athlete in, Athlete out) {
        players.put(in.getPosition(), in);
        reserves.add(out);
        reserves.remove(in);
    }

    /**
     * Buys a consumable item by adding it to the team's consumables list.
     *
     * @param consumable the item to be bought and added to the consumables
     */
    public void buyConsumable(Item consumable) {
        consumables.add(consumable);
    }

    /**
     * Sells a consumable item by removing it from the team's consumables list.
     *
     * @param consumable the item to be sold and removed from the consumables
     */
    public void sellConsumable(Item consumable) {
        consumables.remove(consumable);
    }

    /**
     * Checks if the team can play a game.
     * A team can play if it has exactly 5 players and none of them are injured.
     *
     * @return true if the team can play, false otherwise
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
     * Retrieves the team name.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Retrieves the mapping of player positions to athlete objects in the team.
     *
     * @return the player mapping
     */
    public HashMap<Athlete.POSITION, Athlete> getPlayersMap() {
        return players;
    }

    /**
     * Retrieves the list of player athletes in the team.
     *
     * @return the list of players
     */
    public ArrayList<Athlete> getPlayersArray() {
        ArrayList<Athlete> playersArray = new ArrayList<>(players.values());
        return playersArray;
    }

    /**
     * Retrieves the list of reserve athletes in the team.
     *
     * @return the list of reserves
     */
    public ArrayList<Athlete> getReserves() {
        return reserves;
    }

    /**
     * Retrieves the list of consumable items held by the team.
     *
     * @return the list of consumables
     */
    public ArrayList<Item> getItems() {
        return consumables;
    }

    /**
     * Removes a consumable item from the team's consumables list.
     *
     * @param item the item to be removed from the consumables
     */
    public void removeItem(Item item) {
        consumables.remove(item);
    }

    /**
     * Restores the stamina of all players in the team.
     * This method sets the current stamina of each player to their maximum stamina.
     */
    public void restoreStamina() {
        for (Athlete athlete : players.values()) {
            athlete.restoreCurrentStamina();
        }
    }
}
