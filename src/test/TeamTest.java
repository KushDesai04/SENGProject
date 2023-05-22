package test;
import main.*;
import main.Athlete.POSITION;
import main.Athlete.STATS;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TeamTest {

    private Team team;
    
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
        team = new Team("Test Team");
    }

    @Test
    public void testAddPlayer() {
        Athlete player = generateAthlete("Starter1", Athlete.POSITION.PG);
        team.addPlayer(player);

        assertTrue(team.getPlayersMap().containsValue(player));
    }

    @Test
    public void testAddReserves() {
        Athlete player = generateAthlete("Reserve1", Athlete.POSITION.PG);
        team.addReserves(player);

        assertTrue(team.getReserves().contains(player));
    }

    @Test
    public void testBuyPlayer() {
        Athlete player = generateAthlete("Buy1", Athlete.POSITION.PG);
        team.buyPlayer(player);

        assertTrue(team.getReserves().contains(player));
    }

    @Test
    public void testSellPlayer() {
        Athlete player = generateAthlete("Sell1", Athlete.POSITION.PG);
        team.addReserves(player);
        team.sellPlayer(player);

        assertFalse(team.getReserves().contains(player));
    }

    @Test
    public void testRemovePlayer() {
        Athlete player = generateAthlete("Remove1", Athlete.POSITION.PG);
        team.addPlayer(player);
        team.removePlayer(player);

        assertNull(team.getPlayersMap().get(player.getPosition()));
        assertTrue(team.getReserves().contains(player));
    }

    @Test
    public void testReplacePlayer() {
        Athlete in = generateAthlete("IN", Athlete.POSITION.PG);
        Athlete out = generateAthlete("OUT", Athlete.POSITION.PG);
        team.addPlayer(out);
        team.addReserves(in);
        team.replacePlayer(in, out);

        assertTrue(team.getPlayersMap().containsValue(in));
        assertTrue(team.getReserves().contains(out));
        assertFalse(team.getReserves().contains(in));
    }

    @Test
    public void testBuyConsumable() {
        Item consumable = new Item("Health Potion", Athlete.STATS.A, 10);
        team.buyConsumable(consumable);

        assertTrue(team.getItems().contains(consumable));
    }

    @Test
    public void testSellConsumable() {
        Item consumable = new Item("Health Potion", Athlete.STATS.A, 10);
        team.buyConsumable(consumable);
        team.sellConsumable(consumable);

        assertFalse(team.getItems().contains(consumable));
    }

    @Test
    public void testCanPlay_True() {
        Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PG);
        Athlete player2 = generateAthlete("Player2", Athlete.POSITION.SG);
        Athlete player3 = generateAthlete("Player3", Athlete.POSITION.C);
        Athlete player4 = generateAthlete("Player4", Athlete.POSITION.SF);
        Athlete player5 = generateAthlete("Player5", Athlete.POSITION.PF);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);

        assertTrue(team.canPlay());
    }

    @Test
    public void testCanPlay_False_PlayerInjured() {
        Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PG);
        Athlete player2 = generateAthlete("Player2", Athlete.POSITION.SG);
        Athlete player3 = generateAthlete("Player3", Athlete.POSITION.C);
        Athlete player4 = generateAthlete("Player4", Athlete.POSITION.SF);
        Athlete player5 = generateAthlete("Player5", Athlete.POSITION.PF);

        player3.changeCurrentStamina(-player3.getCurrentStamina());

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);

        assertFalse(team.canPlay());
    }

    @Test
    public void testCanPlay_False_NotEnoughPlayers() {
    	Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PG);
        Athlete player2 = generateAthlete("Player2", Athlete.POSITION.SG);
        Athlete player3 = generateAthlete("Player3", Athlete.POSITION.C);
        Athlete player4 = generateAthlete("Player4", Athlete.POSITION.SF);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);

        assertFalse(team.canPlay());
    }

    @Test
    public void testGetTeamName() {
        assertEquals("Test Team", team.getTeamName());
    }

    @Test
    public void testGetPlayersMap() {
        Athlete player = generateAthlete("Player1", Athlete.POSITION.PG);
        team.addPlayer(player);

        assertTrue(team.getPlayersMap().containsValue(player));
    }

    @Test
    public void testGetPlayersArray() {
        Athlete player = generateAthlete("Player1", Athlete.POSITION.PF);
        team.addPlayer(player);

        assertTrue(team.getPlayersArray().contains(player));
    }

    @Test
    public void testGetReserves() {
        Athlete player = generateAthlete("Player1", Athlete.POSITION.PF);
        team.addReserves(player);

        assertTrue(team.getReserves().contains(player));
    }

    @Test
    public void testGetItems() {
        Item consumable = new Item("Health Potion", Athlete.STATS.S, 10);
        team.buyConsumable(consumable);

        assertTrue(team.getItems().contains(consumable));
    }

    @Test
    public void testRemoveItem() {
        Item consumable = new Item("Health Potion", Athlete.STATS.S, 10);
        team.buyConsumable(consumable);
        team.removeItem(consumable);

        assertFalse(team.getItems().contains(consumable));
    }

    @Test
    public void testRestoreStamina() {
        Athlete player1 = generateAthlete("Player1", Athlete.POSITION.PF);
        Athlete player2 = generateAthlete("Player1", Athlete.POSITION.PG);
        team.addPlayer(player1);
        team.addPlayer(player2);

        player1.changeCurrentStamina(50);
        player2.changeCurrentStamina(60);

        team.restoreStamina();

        assertEquals(player1.getStat(STATS.S), player1.getCurrentStamina());
        assertEquals(player2.getStat(STATS.S), player2.getCurrentStamina());
    }
}
