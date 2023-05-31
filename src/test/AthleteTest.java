package test;

import main.*;
import main.Athlete.STATS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.HashMap;

public class AthleteTest {

	private Athlete athlete;

	@BeforeEach
	public void setUp() {
		String name = "John Doe";
		Athlete.POSITION position = Athlete.POSITION.PG;
		HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
		stats.put(Athlete.STATS.O, 80);
		stats.put(Athlete.STATS.D, 75);
		stats.put(Athlete.STATS.S, 90);
		stats.put(Athlete.STATS.A, 85);
		athlete = new Athlete(name, position, stats);
	}

	@Test
	public void testSetNickname() {
		String newNickname = "JD";
		athlete.setNickname(newNickname);
		assertEquals(newNickname, athlete.getName());
	}

	@Test
	public void testChangeStat() {
		int initialValue = athlete.getStat(Athlete.STATS.O);
		int changeValue = 10;
		athlete.changeStat(changeValue, Athlete.STATS.O);
		int expectedValue = initialValue + changeValue;
		assertEquals(expectedValue, athlete.getStat(Athlete.STATS.O));
		
		// Check max stat is 99
		initialValue = athlete.getStat(Athlete.STATS.O);
		changeValue = 100;
		athlete.changeStat(changeValue, Athlete.STATS.O);
		assertEquals(99, athlete.getStat(Athlete.STATS.O));
		
		// Check min stat is 0
		initialValue = athlete.getStat(Athlete.STATS.O);
		changeValue = -(athlete.getStat(Athlete.STATS.O) + 50);
		athlete.changeStat(changeValue, Athlete.STATS.O);
		assertEquals(0, athlete.getStat(Athlete.STATS.O));
	}

	@Test
	public void testChangeCurrentStamina() {
		int initialValue = athlete.getStat(Athlete.STATS.CS);
		int changeValue = -20;
		athlete.changeStat(changeValue, Athlete.STATS.CS);
		int expectedValue = initialValue + changeValue;
		assertEquals(expectedValue, athlete.getStat(Athlete.STATS.CS));

		// Check that current stamina does not go over max
		athlete.changeStat(athlete.getStat(Athlete.STATS.S) + 20, Athlete.STATS.CS);
		assertEquals(99, athlete.getStat(Athlete.STATS.CS));

		// Check current stamina does not go below 0
		athlete.changeStat(-(athlete.getStat(Athlete.STATS.CS) + 1), Athlete.STATS.CS);
		assertEquals(0, athlete.getStat(Athlete.STATS.CS));

	}

	@Test
	public void testRestoreCurrentStamina() {
		athlete.changeStat(-20, Athlete.STATS.CS);
		athlete.restoreCurrentStamina();
		int expectedValue = athlete.getStat(Athlete.STATS.S);
		assertEquals(expectedValue, athlete.getStat(Athlete.STATS.CS));
	}

	@Test
	public void testIsInjured() {
		athlete.changeStat(-athlete.getStat(Athlete.STATS.CS), Athlete.STATS.CS);
		assertTrue(athlete.isInjured());
		assertEquals(1, athlete.getInjuries());
	}

	@Test
	public void testToString() {
		String expectedString = "John Doe, Point Guard, 82 OVR";
		assertEquals(expectedString, athlete.toString());
	}

}
