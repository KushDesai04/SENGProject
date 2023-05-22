package test;
import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenerateRandomTest {
    private GenerateRandom generateRandom;

    @BeforeEach
    void setUp() {
        generateRandom = new GenerateRandom();
    }

    @Test
    void testGenerateAthlete() {
        Athlete athlete = generateRandom.generateAthlete(0);
        assertNotNull(athlete);
        assertNotNull(athlete.getName());
        assertNotNull(athlete.getPosition());
    }

    @Test
    void testGeneratePosition() {
        Athlete.POSITION position = generateRandom.generatePosition(0);
        assertEquals(Athlete.POSITION.PG, position);
    }

    @Test
    void testGenerateWeeklyAthletes() {
        ArrayList<Athlete> weeklyAthletes = generateRandom.generateWeeklyAthletes();
        assertNotNull(weeklyAthletes);
        assertEquals(3, weeklyAthletes.size());
    }

    @Test
    void testGenerateWeeklyItems() {
        ArrayList<Item> weeklyItems = generateRandom.generateWeeklyItems();
        assertNotNull(weeklyItems);
        assertEquals(3, weeklyItems.size());
    }

    @Test
    void testGenerateTeams() {
        ArrayList<Team> opposingTeams = generateRandom.generateTeams();
        assertNotNull(opposingTeams);
        assertEquals(3, opposingTeams.size());

        for (Team team : opposingTeams) {
            assertNotNull(team);
            assertNotNull(team.getTeamName());
            assertNotNull(team.getPlayersMap());
            assertEquals(5, team.getPlayersArray().size());
        }
    }

    @Test
    void testGetRandomNumber() {
        int randomNumber = generateRandom.getRandomNumber(100);
        assertTrue(randomNumber >= 0 && randomNumber < 100);
    }
}
