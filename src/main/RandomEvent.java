package main;

import java.util.*;

public class RandomEvent {
	private Random random;
	private int randomInt;
	private Team team;
	private GenerateRandom generateRandom = new GenerateRandom();

	public RandomEvent(Team tempTeam) {
		random = new Random();
		randomInt = random.nextInt(50);
		team = tempTeam;
		
	}

	public boolean generateRandom() {
//		return random.nextInt(50) == randomInt;
		return true;
	}

	public String generateEvent(Boolean run) {
		String message = null;
		if (run) {
			ArrayList<Athlete> reserves = team.getReserves();
			int i = random.nextInt(50);
			switch (i) {
			case 0:
				// random starter athlete gets a stat boost
				Athlete athlete = team.getPlayersArray().get(random.nextInt(team.getPlayersArray().size()));
				
				athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.O);
				athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.D);
				athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.A);
				athlete.changeStat(random.nextInt(1, 11), Athlete.STATS.S);
				message = athlete.getName() + " has been working out. Their stats have increased!";
				break;
				
			case 1:
				// random reserve athlete gets a stat boost
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
				// athlete quits
				
				for (int j = 0; j < reserves.size(); j++) {
					Athlete player = reserves.get(j);
					if (random.nextInt(5) * (player.getInjuries() / 100) >= 5) {
						reserves.remove(j);
						message = player.getName() + " has quit the team because of a broken foot!";
						break;
					}
				}
				
				break;
			case 3:
				// new athlete joins
				int chance = random.nextInt(50);
				if (reserves.size() < 5 && chance < 5) {
					Athlete a = generateRandom.generateAthlete(chance);
					reserves.add(a);
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
