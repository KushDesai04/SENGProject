package main;

import java.util.*;

/**
 * This is the Athlete class which represents a single Athlete. The class
 * Athletes can be bought and sold to make a Team.
 *
 * @Author Yunu Cho
 * @Author Kush Desai
 * 
 */
public class Athlete {

	/**
	 * The name of the Athlete.
	 */
	private String name;

	/**
	 * The price of the Athlete.
	 */
	private int price;

	/**
	 * The rating of the Athlete.
	 */
	private int rating;

	/**
	 * The position of the Athlete.
	 */
	private POSITION position;

	/**
	 * The number of injuries the Athlete has.
	 */
	private int injuries = 0;

	/**
	 * The current stamina of the Athlete.
	 */
	private int currentStamina;

	/**
	 * The stats of the Athlete.
	 */
	private HashMap<STATS, Integer> stats = new HashMap<STATS, Integer>();

	/**
	 * Constructor to create an Athlete object.
	 * 
	 * @param tempName     The name of the Athlete.
	 * @param tempPosition The position of the Athlete.
	 * @param tempStats    The stats of the Athlete.
	 */
	public Athlete(String tempName, POSITION tempPosition, HashMap<STATS, Integer> tempStats) {
		name = tempName;
		position = tempPosition;
		int offence = tempStats.get(STATS.O);
		int defence = tempStats.get(STATS.D);
		int stamina = tempStats.get(STATS.S);
		int agility = tempStats.get(STATS.A);
		rating = (offence + defence + stamina + agility) / 4;
		price = rating * 20;
		stats.put(STATS.O, offence);
		stats.put(STATS.D, defence);
		stats.put(STATS.S, stamina);
		stats.put(STATS.A, agility);
		currentStamina = stats.get(Athlete.STATS.S);
	}

	/**
	 * Enum to represent the possible player positions.
	 */
	public enum POSITION {
		/**
		 * Point Guard
		 */
        PG, 
        
        /**
		 * Power Forward
		 */
        PF,
        
        /**
		 * Center
		 */
        C,
        
        /**
		 * Small Forward
		 */
        SF, 
        
        /**
		 * Shooting Guard
		 */
        SG; 
	}

	/**
	 * Enum to represent the player stats: Offence, Defence, Stamina, Agility,
	 * Current Stamina.
	 */
	public enum STATS {
		/**
		 * Offence
		 */
		O, 
		
		/**
		 * Defence
		 */
		D, 
		
		/**
		 * Stamina
		 */
		S, 
		
		/**
		 * Agility
		 */
		A,
		
		/**
		 * Current Stamina
		 */
		CS;
	}

	/**
	 * Sets the nickname of the Athlete.
	 * 
	 * @param newName The new nickname to assign to the Athlete.
	 */
	public void setNickname(String newName) {
		name = newName;
	}

	/**
	 * Changes a certain stat of the Athlete. Used when consuming Items or playing a
	 * match.
	 * 
	 * @param value The amount to change the stat by.
	 * @param stat  The stat to change.
	 */
	public void changeStat(int value, STATS stat) {
		int newVal = getStat(stat) + value;
		if (newVal < 0) {
			newVal = 0;
		}
		else if (newVal > 99) {
			newVal = 99;
		}
		stats.put(stat, newVal);
		rating = (getStat(STATS.O) + getStat(STATS.D) + getStat(STATS.A) + getStat(STATS.S)) / 4;

	}

	/**
	 * Returns a string representation of the Athlete.
	 * 
	 * @return The string representation of the Athlete.
	 */
	public String toString() {
		POSITION athletePosition = position;
		String positionText = null;
		switch (athletePosition) {
		case PG:
			positionText = "Point Guard";
			break;
		case SG:
			positionText = "Shooting Guard";
			break;
		case SF:
			positionText = "Small Forward";
			break;
		case PF:
			positionText = "Power Forward";
			break;
		case C:
			positionText = "Center";
			break;
		default:
			break;
		}
		return String.format("%s, %s, %d OVR", name, positionText, rating);
	}

	/**
	 * Retrieves the value of the specified stat for the Athlete.
	 * 
	 * @param stat The stat to retrieve.
	 * @return The value of the specified stat.
	 */
	public int getStat(STATS stat) {
		return stats.get(stat);
	}

	/**
	 * Changes the current stamina of the Athlete.
	 * 
	 * @param value The amount to change the current stamina by.
	 */
	public void changeCurrentStamina(int value) {
		currentStamina += value;
		if (currentStamina < 0) {
			currentStamina = 0;
		}

		else if (currentStamina > stats.get(STATS.S)) {
			currentStamina = stats.get(STATS.S);
		}
	}

	/**
	 * Restores the current stamina of the Athlete to its maximum value.
	 */
	public void restoreCurrentStamina() {
		currentStamina = getStat(Athlete.STATS.S);
	}

	/**
	 * Retrieves the current stamina of the Athlete.
	 * 
	 * @return The current stamina of the Athlete.
	 */
	public int getCurrentStamina() {
		return currentStamina;
	}

	/**
	 * Retrieves the name of the Athlete.
	 * 
	 * @return The name of the Athlete.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves the price of the Athlete.
	 * 
	 * @return The price of the Athlete.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Retrieves the rating of the Athlete.
	 * 
	 * @return The rating of the Athlete.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Retrieves the position of the Athlete.
	 * 
	 * @return The position of the Athlete.
	 */
	public POSITION getPosition() {
		return position;
	}

	/**
	 * Retrieves the number of injuries the Athlete has.
	 * 
	 * @return The number of injuries the Athlete has.
	 */
	public int getInjuries() {
		return injuries;
	}

	/**
	 * Checks if the Athlete is injured. If the current stamina of the Athlete is 0,
	 * increment injuries by 1.
	 * 
	 * @return true if the Athlete is injured, false otherwise.
	 */
	public boolean isInjured() {
		if (currentStamina == 0) {
			injuries += 1;
			return true;
		}
		return false;
	}

}
