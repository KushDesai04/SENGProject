package main;
import java.util.*;
public class GenerateRandom {
	private Random random;
	private float multiplier = 1.0f;
	private ArrayList<String> possibleNames = new ArrayList<String>(Arrays.asList(
			"Michael", "Jordan", "Steph", "Kush", "Droopy", "Hoi Fung", "Ray", 
			"Zaza", "Archibold", "Freddie", "Wij", "Richard", "Kang", "Zheng",
			"Rundle", "Tim", "Sum", "Ting", "Wong", "Jake", "Tuffy"));
	private ArrayList<String> possibleItemNames = new ArrayList<String>(Arrays.asList(
			"Apple", "Blue Pot", "Sushi", "Katsu Chicken Sandwich", "Protein Shake",
			"Trenbolone Acetate"));
	public GenerateRandom() {
		random = new Random();
		
	}
	
	public ArrayList<Athlete> generateWeeklyAthletes() {
		ArrayList<Athlete> weeklyAthletes = new ArrayList<Athlete>();
		HashMap<Athlete.STATS, Integer> statValues = new HashMap<Athlete.STATS, Integer>();
		while (weeklyAthletes.size()<3) {
			int index = random.nextInt(possibleNames.size());
			int positionIndex = random.nextInt(5);
			Athlete.POSITION p = Athlete.POSITION.C;
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
			switch (positionIndex) {
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
				break;
			}
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
}
