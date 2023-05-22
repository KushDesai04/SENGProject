package test;

import GUI.*;
import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void testChangeMoney() {
        int initialMoney = gameManager.getMoney();
        int amount = 100;

        gameManager.changeMoney(amount);

        assertEquals(initialMoney + amount, gameManager.getMoney());
    }

    @Test
    void testGenerateRandomTeams() {
        gameManager.generateRandomTeams();
        assertNotNull(gameManager.getWeeklyTeams());
        assertFalse(gameManager.getWeeklyTeams().isEmpty());
    }

    @Test
    void testIncrementWeek() {
        int initialWeek = gameManager.getCurrentWeek();
        gameManager.incrementWeek();
        assertEquals(initialWeek + 1, gameManager.getCurrentWeek());    }

    @Test
    void testSetAndGetNumWeeks() {
        int numWeeks = 10;
        gameManager.setNumWeeks(numWeeks);

        assertEquals(numWeeks, gameManager.getNumWeeks());
    }

    @Test
    void testLaunchStartScreen() {
        // Test if the method runs without errors
        assertDoesNotThrow(() -> gameManager.launchStartScreen());
    }

    // Add more test cases as needed for the remaining methods

}
