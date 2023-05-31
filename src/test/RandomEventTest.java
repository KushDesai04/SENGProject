package test;

import main.*;
import main.Athlete.POSITION;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class RandomEventTest {

	private Team team;
	private RandomEvent randomEvent;

	public Athlete generateAthlete(String tempName, POSITION pos) {
		String name = tempName;
		HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
		stats.put(Athlete.STATS.O, 80);
		stats.put(Athlete.STATS.D, 75);
		stats.put(Athlete.STATS.S, 90);
		stats.put(Athlete.STATS.A, 85);
		Athlete athlete = new Athlete(name, pos, stats);
		return athlete;
	}

	@BeforeEach
	public void setUp() {
		team = new Team("Test Team");
		Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PG);
		Athlete player2 = generateAthlete("Player2", Athlete.POSITION.SG);
		Athlete player3 = generateAthlete("Player3", Athlete.POSITION.C);
		Athlete player4 = generateAthlete("Player4", Athlete.POSITION.SF);
		Athlete player5 = generateAthlete("Player5", Athlete.POSITION.PF);

		team.addPlayer(player1);
		randomEvent = new RandomEvent(team);
	}

	@Test
	public void testGenerateRandom() {
		boolean result = randomEvent.generateRandom();
		assertNotNull(result);
	}

	@Test
	public void testGenerateRandomNumber() {
		int result = randomEvent.generateRandomNumber();
		assertNotNull(result);
	}

	@Test
	public void testStarterAthleteBoostEvent() {
		int initalRatings = team.getPlayersArray().get(0).getRating();
		String message = randomEvent.generateEvent(true, 0);
		int finalRatings = team.getPlayersArray().get(0).getRating();

		assertTrue(initalRatings < finalRatings);
	}

	@Test
	public void testReserveAthleteBoostEvent() {
		team.addReserves(generateAthlete("reserve1", Athlete.POSITION.C));
		int initalRatings = team.getReserves().get(0).getRating();
		String message = randomEvent.generateEvent(true, 1);
		int finalRatings = team.getReserves().get(0).getRating();

		assertTrue(initalRatings < finalRatings);
	}

	@Test
	public void testReserveQuits() {
		team.getReserves().clear();
		team.addReserves(generateAthlete("reserve1", Athlete.POSITION.C));
		assertNotNull(team.getReserves());
		Athlete reserve = team.getReserves().get(0);
		reserve.changeStat(-reserve.getStat(Athlete.STATS.CS), Athlete.STATS.CS);

		// There is a 1/5 chance that the test will fail (if random.nextInt() returns 0)
		for (int i = 0; i < 500; i++) {
			reserve.isInjured();
		}
		String message = randomEvent.generateEvent(true, 2);

		assertTrue(team.getReserves().size() == 0);
	}

	@Test
	public void testReserveJoins() {
		team.getReserves().clear();
		assertTrue(team.getReserves().size() == 0);
		// There is a 1/5 chance that the test will fail (if random.nextInt() returns 0)
		for (int i = 0; i < 500; i++) {
			String message = randomEvent.generateEvent(true, 3);
		}

		assertTrue(team.getReserves().size() > 0);
	}
}
