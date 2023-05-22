package test;

import main.*;
import main.Athlete.POSITION;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;

public class GamePlayTest {

	private Team playerTeam;
	private Team opposingTeam;
	private Gameplay gameplay;

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

	@Before
	public void setUp() {
		// Create player team and opposing team
		playerTeam = new Team("Player Team");
		opposingTeam = new Team("Opponent Team");

		// Add players to the teams (replace with actual player objects)
		Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PG);
		Athlete player2 = generateAthlete("Player2", Athlete.POSITION.SG);
		Athlete player3 = generateAthlete("Player3", Athlete.POSITION.C);
		Athlete player4 = generateAthlete("Player4", Athlete.POSITION.SF);
		Athlete player5 = generateAthlete("Player5", Athlete.POSITION.PF);

		playerTeam.addPlayer(player1);
		playerTeam.addPlayer(player2);
		playerTeam.addPlayer(player3);
		playerTeam.addPlayer(player4);
		playerTeam.addPlayer(player5);

		opposingTeam.addPlayer(player1);
		opposingTeam.addPlayer(player2);
		opposingTeam.addPlayer(player3);
		opposingTeam.addPlayer(player4);
		opposingTeam.addPlayer(player5);

		// Create Gameplay object
		gameplay = new Gameplay(playerTeam, opposingTeam, "easy");
	}

	@Test
	public void testGetPlayerPoints() {
		// Set up the initial player points

		assertEquals(0, gameplay.getPlayerPoints());
	}

	@Test
	public void testGetOpponentPoints() {
		// Set up the initial opponent points

		assertEquals(0, gameplay.getOpponentPoints());
	}

	@Test
	public void testPlay() {
		HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
		stats.put(Athlete.STATS.O, 99);
		stats.put(Athlete.STATS.D, 99);
		stats.put(Athlete.STATS.S, 99);
		stats.put(Athlete.STATS.A, 99);
		playerTeam.addPlayer(new Athlete("A", Athlete.POSITION.C, stats));
		gameplay.play();
		// Verify that player points and opponent points are updated correctly
		assertEquals(1, gameplay.getPlayerPoints());
		assertEquals(0, gameplay.getOpponentPoints());
	}

	@Test
	public void testDeclarePlayerWins() {
		// Set up the player points and opponent points
		HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
		stats.put(Athlete.STATS.O, 99);
		stats.put(Athlete.STATS.D, 99);
		stats.put(Athlete.STATS.S, 99);
		stats.put(Athlete.STATS.A, 99);
		playerTeam.addPlayer(new Athlete("A", Athlete.POSITION.C, stats));
		gameplay.play();

		assertEquals("player", gameplay.declareWinner());
	}

	@Test
	public void testDeclareDraw() {
		// Set up the player points and opponent points to be equal
		gameplay.play();
		assertEquals("draw", gameplay.declareWinner());
	}

	@Test
	public void testDeclareOpponentWins() {
		// Set up the player points and opponent points
		HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
		stats.put(Athlete.STATS.O, 9);
		stats.put(Athlete.STATS.D, 9);
		stats.put(Athlete.STATS.S, 9);
		stats.put(Athlete.STATS.A, 9);
		playerTeam.addPlayer(new Athlete("A", Athlete.POSITION.C, stats));
		gameplay.play();

		assertEquals("opponent", gameplay.declareWinner());
	}
}
