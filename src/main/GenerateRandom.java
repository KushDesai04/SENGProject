package main;

import java.util.*;

/**
 * The GenerateRandom class provides functionality for generating random objects
 * such as Athletes, Items, and Teams. It uses randomisation to create dynamic
 * elements for the game.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class GenerateRandom {
	/**
	 * Random number generator.
	 */
	private Random random;

	/**
	 * Multiplier value used for generating random statistics.
	 */
	private float multiplier = 1.0f;

	/**
	 * List of possible names for generating Athletes.
	 */
	private ArrayList<String> possibleNames;

	/**
	 * List of possible names for generating Items.
	 */
	private ArrayList<String> possibleItemNames;

	/**
	 * List of possible names for generating Teams.
	 */
	private ArrayList<String> possibleTeamNames;

	/**
	 * List of names that have already been used for generating Athletes.
	 */
	private ArrayList<String> usedNames;

	/**
	 * List of names that have already been used for generating Items.
	 */
	private ArrayList<String> usedItemNames;

	/**
	 * List of names that have already been used for generating Teams.
	 */
	private ArrayList<String> usedTeamNames;

	/**
	 * Constructs a new GenerateRandom object with default settings.
	 */
	public GenerateRandom() {

		random = new Random();

		possibleNames = new ArrayList<String>(Arrays.asList("Michael", "Jordan", "Steph", "Kush", "Droopy", "Hoi Fung",
				"Ray", "Zaza", "Archibold", "Freddie", "Wij", "Richard", "Kang", "Zheng", "Rundle", "Tim", "Sum",
				"Ting", "Wong", "Jake", "Tuffy", "Stevo", "Gavin", "Miguel", "Andy", "Giancarlo", "Gus", "Walter",
				"Jesse", "Hank", "Cornelius", "Erik", "Bjorn", "Steve", "Alex", "Lucas", "Lars", "Jaron", "Kel",
				"Geraldo", "Sui"));

		possibleItemNames = new ArrayList<String>(Arrays.asList("Apple", "Blue Pot", "Sushi", "Katsu Chicken Sandwich",
				"Protein Shake", "Trenbolone Acetate", "Energy Drink", "Preworkout", "Ghost Pepper", "Protein Bar",
				"Can of Spinach", "Pot of Greed", "Chicken Dinner", "Stardrop", "Uranium"));

		possibleTeamNames = new ArrayList<String>(Arrays.asList("Celtics", "Nets", "Knicks", "76ers", "Raptors",
				"Bulls", "Cavaliers", "Pistons", "Pacers", "Bucks", "Hawks", "Hornets", "Heat", "Magic", "Wizards",
				"Nuggets", "Timberwolves", "Thunder", "Trail Blazers", "Jazz", "Warriors", "Clippers", "Lakers", "Suns",
				"Kings", "Mavericks", "Rockets", "Grizzlies", "Pelicans", "Spurs"));

		usedNames = new ArrayList<String>();
		usedItemNames = new ArrayList<String>();
		usedTeamNames = new ArrayList<String>();
	}

	/**
	 * Generates a random Athlete object with specified index.
	 *
	 * @param index The index used to determine the position of the Athlete.
	 * @return The generated Athlete object.
	 */
	public Athlete generateAthlete(int index) {
		HashMap<Athlete.STATS, Integer> statValues = new HashMap<Athlete.STATS, Integer>();
		int nameIndex = random.nextInt(possibleNames.size());
		String name = possibleNames.get(nameIndex);
		while (usedNames.contains(name)) {
			nameIndex = random.nextInt(possibleNames.size());
			name = possibleNames.get(nameIndex);
		}
		usedNames.add(name);
		int offence = (int) (random.nextInt(60, 70) * multiplier);
		if (offence > 99) {
			offence = 99;
		}
		statValues.put(Athlete.STATS.O, offence);
		int defence = (int) (random.nextInt(60, 70) * multiplier);
		if (defence > 99) {
			defence = 99;
		}
		statValues.put(Athlete.STATS.D, defence);
		int stamina = (int) (random.nextInt(60, 70) * multiplier);
		if (stamina > 99) {
			stamina = 99;
		}
		statValues.put(Athlete.STATS.S, stamina);
		int agility = (int) (random.nextInt(60, 70) * multiplier);
		if (agility > 99) {
			agility = 99;
		}
		statValues.put(Athlete.STATS.A, agility);
		Athlete.POSITION p = generatePosition(index);

		return new Athlete(name, p, statValues);
	}

	/**
	 * Generates a position for an Athlete based on the specified index.
	 *
	 * @param index The index used to determine the position.
	 * @return The generated position for the Athlete.
	 */
	public Athlete.POSITION generatePosition(int index) {
		Athlete.POSITION p;
		switch (index) {
		case 0:
			p = Athlete.POSITION.PG;
			break;
		case 1:
			p = Athlete.POSITION.SG;
			break;
		case 2:
			p = Athlete.POSITION.SF;
			break;
		case 3:
			p = Athlete.POSITION.PF;
			break;
		case 4:
			p = Athlete.POSITION.C;
			break;
		default:
			return null;
		}
		return p;
	}

	/**
	 * Generates a list of weekly Athletes.
	 *
	 * @return The list of generated weekly Athletes.
	 */
	public ArrayList<Athlete> generateWeeklyAthletes() {
		ArrayList<Athlete> weeklyAthletes = new ArrayList<Athlete>();
		while (weeklyAthletes.size() < 3) {
			int positionIndex = random.nextInt(5);
			Athlete athlete = generateAthlete(positionIndex);
			weeklyAthletes.add(athlete);
		}
		usedNames.clear();
		return weeklyAthletes;
	}

	/**
	 * Generates a list of weekly Items.
	 *
	 * @return The list of generated weekly Items.
	 */
	public ArrayList<Item> generateWeeklyItems() {
		ArrayList<Item> weeklyItems = new ArrayList<Item>();
		while (weeklyItems.size() < 3) {
			int index = random.nextInt(possibleItemNames.size());
			int statIndex = random.nextInt(5);
			Athlete.STATS s = Athlete.STATS.A;
			String name = possibleItemNames.get(index);
			while (usedItemNames.contains(name)) {
				index = random.nextInt(possibleItemNames.size());
				name = possibleItemNames.get(index);
			}
			usedItemNames.add(name);
			int increaseBy = (int) (random.nextInt(5, 10) * multiplier);
			switch (statIndex) {
			case 0:
				s = Athlete.STATS.O;
				break;
			case 1:
				s = Athlete.STATS.D;
				break;
			case 2:
				s = Athlete.STATS.S;
				break;
			case 3:
				s = Athlete.STATS.A;
				break;
			case 4:
				s = Athlete.STATS.CS;
				break;
			default:
				break;
			}
			Item item = new Item(name, s, increaseBy);
			weeklyItems.add(item);
		}
		usedItemNames.clear();
		return weeklyItems;
	}

	/**
	 * Generates a list of opposing Teams.
	 *
	 * @return The list of generated opposing Teams.
	 */
	public ArrayList<Team> generateTeams() {
		ArrayList<Team> opposingTeams = new ArrayList<Team>();
		while (opposingTeams.size() < 3) {
			int teamIndex = random.nextInt(possibleTeamNames.size());
			String name = possibleTeamNames.get(teamIndex);
			while (usedTeamNames.contains(name)) {
				teamIndex = random.nextInt(possibleTeamNames.size());
				name = possibleTeamNames.get(teamIndex);
			}
			usedTeamNames.add(name);
			Team team = new Team(name);
			for (int i = 0; i < 5; i++) {
				Athlete athlete = generateAthlete(i);
				team.addPlayer(athlete);
			}
			opposingTeams.add(team);
			usedNames.clear();
		}
		usedTeamNames.clear();
		return opposingTeams;
	}

	/**
	 * Generates a random number within the specified range.
	 *
	 * @param upper The upper bound for the random number (exclusive).
	 * @return The generated random number.
	 */
	public int getRandomNumber(int upper) {
		return random.nextInt(upper);
	}

	/**
	 * Increments the multiplier value. This method increases the multiplier by 0.02
	 * per week.
	 */
	public void incrementMultiplier() {
		multiplier += 0.02;
	}
}
