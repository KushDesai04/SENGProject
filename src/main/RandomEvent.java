package main;

import java.util.ArrayList;
import java.util.Random;
/** 
 * This is the RandomEvent class. This class controls the logic for generating random events when the player takes a bye.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 *
 */
public class RandomEvent {
	/**
	 * The random number generator used for generating random events.
	 */
	private Random random;

	/**
	 * The randomly generated integer used for event generation comparison.
	 */
	private int randomInt;

	/**
	 * The Team object to which the random events will be applied.
	 */
	private Team team;

	/**
	 * The instance of the GenerateRandom class used for generating random Athletes.
	 */
	private GenerateRandom generateRandom = new GenerateRandom();


    /**
     * Constructs a new RandomEvent object with the given Team.
     *
     * @param tempTeam The Team object to which the random events will be applied.
     */
    public RandomEvent(Team tempTeam) {
        random = new Random();
        randomInt = random.nextInt(50);
        team = tempTeam;
    }

    /**
     * Generates a random boolean value.
     *
     * @return A boolean value indicating whether the event should be generated.
     */
    public boolean generateRandom() {
        return random.nextInt(50) == randomInt;
    }
    
    /**
     * Generates a random int value.
     *
     * @return A random integer
     */
    public int generateRandomNumber() {
        return random.nextInt(50);
    }

    /**
     * Generates a random event based on the given boolean value.
     *
     * @param run A boolean value indicating whether the event should be generated.
     * @return A string message describing the event that occurred.
     */
    public String generateEvent(Boolean run, int chanceOfEvent) {
        String message = null;
        if (run) {
            ArrayList<Athlete> reserves = team.getReserves();
            
            switch (chanceOfEvent) {
                case 0:
                    // Random starter Athlete gets a stat boost
                    Athlete athlete = team.getPlayersArray().get(random.nextInt(team.getPlayersArray().size()));
                    athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.O);
                    athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.D);
                    athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.A);
                    athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.S);
                    message = athlete.getName() + " has been working out. Their stats have increased!";
                    break;

                case 1:
                    // Random reserve Athlete gets a stat boost
                    if (reserves.size() > 0) {
                        Athlete reserve = reserves.get(random.nextInt(team.getReserves().size()));
                        reserve.changeStat(random.nextInt(1, 11), Athlete.STATS.O);
                        reserve.changeStat(random.nextInt(1, 11), Athlete.STATS.D);
                        reserve.changeStat(random.nextInt(1, 11), Athlete.STATS.A);
                        reserve.changeStat(random.nextInt(1, 11), Athlete.STATS.S);
                        message = reserve.getName() + " has been working out. Their stats have increased!";
                    }
                    break;

                case 2:
                    // Athlete quits
                    for (int j = 0; j < reserves.size(); j++) {
                        Athlete player = reserves.get(j);
                        if (random.nextInt(5) * (player.getInjuries() / 100) >= 5) {
                            team.getReserves().remove(j);
                            message = player.getName() + " has quit the team because of a broken foot!";
                            break;
                        }
                    }
                    break;

                case 3:
                    // New Athlete joins
                    int chance = random.nextInt(50);
                    if (reserves.size() < 5 && chance < 5) {
                        Athlete a = generateRandom.generateAthlete(chance);
                        team.getReserves().add(a);
                        message = a.getName() + " has joined your team!";
                    }
                    break;

                default:
                    break;
            }
        }
        return message;
    }
}
