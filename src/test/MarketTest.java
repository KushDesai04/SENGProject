package test;
import main.*;
import main.Athlete.POSITION;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
public class MarketTest {

    private GenerateRandom generateRandom;
    private Market market;
    
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
        market = new Market(new GenerateRandom());
    }

    @Test
    public void testGetPurchasableAthletes() {
        market.setPurchasableAthletes();

//        assertNotNull(market.getPurchasableAthletes());
    }

    @Test
    public void testGetPurchasableItems() {
        market.setPurchasableItems();
        assertNotNull(market.getPurchasableItems());
    }

    @Test
    public void testGetStarterAthletes() {
        ArrayList<Athlete> starterAthletes = market.getStarterAthletes();

        assertNotNull(starterAthletes);
    }

    @Test
    public void testGetWeeklyPurchasedAthletes() {
        ArrayList<Athlete> purchasedAthletes = market.getWeeklyPurchasedAthletes();

        assertNotNull(purchasedAthletes);
    }

    @Test
    public void testGetWeeklyPurchasedItems() {
        ArrayList<Item> purchasedItems = market.getWeeklyPurchasedItems();

        assertNotNull(purchasedItems);
        assertEquals(0, purchasedItems.size());
    }

    @Test
    public void testAddWeeklyPurchasedAthletes() {
        Athlete athlete = generateAthlete("Player1", Athlete.POSITION.C);

        market.addWeeklyPurchasedAthletes(athlete);
        ArrayList<Athlete> purchasedAthletes = market.getWeeklyPurchasedAthletes();

        assertEquals(1, purchasedAthletes.size());
        assertEquals(athlete, purchasedAthletes.get(0));
    }

    @Test
    public void testAddWeeklyPurchasedItems() {
        Item item = new Item("Health Potion", Athlete.STATS.S, 10);

        market.addWeeklyPurchasedItems(item);
        ArrayList<Item> purchasedItems = market.getWeeklyPurchasedItems();

        assertEquals(1, purchasedItems.size());
        assertEquals(item, purchasedItems.get(0));
    }

    @Test
    public void testClearWeeklyPurchases() {
        market.addWeeklyPurchasedAthletes(generateAthlete("Player1", Athlete.POSITION.C));
        market.addWeeklyPurchasedItems(new Item("Health Potion", Athlete.STATS.S, 10));

        market.clearWeeklyPurchases();

        ArrayList<Athlete> purchasedAthletes = market.getWeeklyPurchasedAthletes();
        ArrayList<Item> purchasedItems = market.getWeeklyPurchasedItems();

        assertEquals(0, purchasedAthletes.size());
        assertEquals(0, purchasedItems.size());
    }
}

