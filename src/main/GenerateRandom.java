package main;
import java.util.*;

public class GenerateRandom {
	private Random random;
	private float multiplier = 1.0f;
	private ArrayList<String> possibleNames = new ArrayList<String>(Arrays.asList(
			"Michael", "Jordan", "Steph", "Kush", "Droopy", "Hoi Fung", "Ray", 
			"Zaza", "Archibold", "Freddie", "Wij", "Richard", "Kang", "Zheng",
			"Rundle", "Tim", "Sum", "Ting", "Wong", "Jake", "Tuffy", "Stevo"));
	private ArrayList<String> possibleItemNames = new ArrayList<String>(Arrays.asList(
			"Apple", "Blue Pot", "Sushi", "Katsu Chicken Sandwich", "Protein Shake",
			"Trenbolone Acetate"));
	private ArrayList<String> possibleTeamNames = new ArrayList<String>(Arrays.asList(
			"Celtics", "Nets", "Knicks", "76ers", "Raptors", "Bulls", "Cavaliers", "Pistons",
			"Pacers", "Bucks", "Hawks", "Hornets", "Heat", "Magic", "Wizards", "Nuggets",
			"Timberwolves", "Thunder", "Trail Blazers", "Jazz", "Warriors", "Clippers",
			"Lakers", "Suns", "Kings", "Mavericks", "Rockets", "Grizzlies", "Pelicans", 
			"Spurs"));
	
	public GenerateRandom() {
		random = new Random();
		
	}
	public Athlete.POSITION generatePosition(int index) {
		switch (index) {
			case 0:
				return Athlete.POSITION.PG;
			case 1:
				return Athlete.POSITION.SG;
			case 2:
				return Athlete.POSITION.SF;
			case 3:
				return Athlete.POSITION.PF;
			case 4:
				return Athlete.POSITION.C;
			default:
				return null;
			}
	}
	
	
	public ArrayList<Athlete> generateWeeklyAthletes() {
		ArrayList<Athlete> weeklyAthletes = new ArrayList<Athlete>();
		HashMap<Athlete.STATS, Integer> statValues = new HashMap<Athlete.STATS, Integer>();
		while (weeklyAthletes.size()<3) {
			int index = random.nextInt(possibleNames.size());
			int positionIndex = random.nextInt(5);
			String name = possibleNames.get(index);
			possibleNames.remove(index);
			int offence = (int) (random.nextInt(60, 70) * multiplier);
			statValues.put(Athlete.STATS.O, offence);
			int defence = (int) (random.nextInt(60, 70) * multiplier);
			statValues.put(Athlete.STATS.D, defence);
			int stamina = (int) (random.nextInt(60, 70) * multiplier);
			statValues.put(Athlete.STATS.S, stamina);
			int agility = (int) (random.nextInt(60, 70) * multiplier);
			statValues.put(Athlete.STATS.A, agility);
			Athlete.POSITION p = generatePosition(positionIndex);
			Athlete athlete = new Athlete(name, p, statValues); 
			weeklyAthletes.add(athlete);
		}
		return weeklyAthletes;
	}
	public ArrayList<Item> generateWeeklyItems() {
		ArrayList<Item> weeklyItems = new ArrayList<Item>();
		while (weeklyItems.size()<3) {
			int index = random.nextInt(possibleItemNames.size());
			int statIndex = random.nextInt(4);
			Athlete.STATS s = Athlete.STATS.O;
			String name = possibleItemNames.get(index);
			possibleItemNames.remove(index);
			int increaseBy = (int) (random.nextInt(10) * multiplier);
			int price = increaseBy * 100;
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
			default:
				break;
			}
			Item item = new Item(name, s, increaseBy, price);
			weeklyItems.add(item);
		}	
		return weeklyItems;
	}
	public ArrayList<Team> generateTeams() {
		ArrayList<Team> opposingTeams = new ArrayList<Team>();
		while (opposingTeams.size()<3) {
			int teamIndex = random.nextInt(possibleTeamNames.size());
			Team team = new Team(possibleTeamNames.get(teamIndex));
			possibleTeamNames.remove(teamIndex);
				for (int i=0; i<5; i++) {
					HashMap<Athlete.STATS, Integer> statValues = new HashMap<Athlete.STATS, Integer>();
					int nameIndex = random.nextInt(possibleNames.size());
					String name = possibleNames.get(nameIndex);
					possibleNames.remove(nameIndex);
					int offence = (int) (random.nextInt(60, 70) * multiplier);
					statValues.put(Athlete.STATS.O, offence);
					int defence = (int) (random.nextInt(60, 70) * multiplier);
					statValues.put(Athlete.STATS.D, defence);
					int stamina = (int) (random.nextInt(60, 70) * multiplier);
					statValues.put(Athlete.STATS.S, stamina);
					int agility = (int) (random.nextInt(60, 70) * multiplier);
					statValues.put(Athlete.STATS.A, agility);
					Athlete.POSITION p = generatePosition(i);
					Athlete athlete = new Athlete(name, p, statValues); 	
					team.addPlayer(athlete);
				}
				opposingTeams.add(team);
			}
		return opposingTeams;
	}
	
}
