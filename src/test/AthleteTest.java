package test;

import main.*;
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
	}

	@Test
	public void testChangeCurrentStamina() {
		int initialValue = athlete.getCurrentStamina();
		int changeValue = -20;
		athlete.changeCurrentStamina(changeValue);
		int expectedValue = initialValue + changeValue;
		assertEquals(expectedValue, athlete.getCurrentStamina());

		// Check that current stamina does not go over max
		athlete.changeCurrentStamina(initialValue + 20);
		assertEquals(initialValue, athlete.getCurrentStamina());

		// Check current stamina does not go below 0
		athlete.changeCurrentStamina(-(athlete.getCurrentStamina() + 1));
		assertEquals(0, athlete.getCurrentStamina());

	}

	@Test
	public void testRestoreCurrentStamina() {
		athlete.changeCurrentStamina(-20);
		athlete.restoreCurrentStamina();
		int expectedValue = athlete.getStat(Athlete.STATS.S);
		assertEquals(expectedValue, athlete.getCurrentStamina());
	}

	@Test
	public void testIsInjured() {
		athlete.changeCurrentStamina(-athlete.getCurrentStamina());
		assertTrue(athlete.isInjured());
		assertEquals(1, athlete.getInjuries());
	}

	@Test
	public void testToString() {
		String expectedString = "John Doe, Point Guard, 82 OVR";
		assertEquals(expectedString, athlete.toString());
	}

}
