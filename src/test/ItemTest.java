package test;
import main.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class ItemTest {

    @Test
    public void testConstructorAndGetters() {
        String name = "Health Potion";
        Athlete.STATS stat = Athlete.STATS.S;
        int value = 10;

        Item item = new Item(name, stat, value);

        assertEquals(name, item.getName());
        assertEquals(stat, item.getStat());
        assertEquals(value, item.getValue());
        assertEquals(value * 100, item.getPrice());
        assertEquals("This item increases a player's stamina by 10", item.getDescription());
    }

    @Test
    public void testToString() {
        String name = "Health Potion";
        Athlete.STATS stat = Athlete.STATS.S;
        int value = 10;

        Item item = new Item(name, stat, value);

        assertEquals(name, item.toString());
    }

    @Test
    public void testGetStatName() {
        Item item1 = new Item("Item1", Athlete.STATS.A, 5);
        Item item2 = new Item("Item2", Athlete.STATS.D, 5);
        Item item3 = new Item("Item3", Athlete.STATS.O, 5);
        Item item4 = new Item("Item4", Athlete.STATS.S, 5);
        Item item5 = new Item("Item5", Athlete.STATS.CS, 5);

        assertEquals("agility", item1.getStatName());
        assertEquals("defence", item2.getStatName());
        assertEquals("offence", item3.getStatName());
        assertEquals("stamina", item4.getStatName());
        assertEquals("current stamina", item5.getStatName());
    }

    @Test
    public void testConsume() {
        HashMap<Athlete.STATS, Integer> stats = new HashMap<Athlete.STATS, Integer>();
        stats.put(Athlete.STATS.O, 99);
        stats.put(Athlete.STATS.D, 99);
        stats.put(Athlete.STATS.S, 99);
        stats.put(Athlete.STATS.A, 99);
        
    	Athlete athlete = new Athlete("A", Athlete.POSITION.C, stats);
        Item item = new Item("Health Potion", Athlete.STATS.A, 10);

        int originalAgility = athlete.getStat(Athlete.STATS.A);
        item.consume(athlete);
        int increasedAgility = athlete.getStat(Athlete.STATS.A);

        assertEquals(originalAgility + 10, increasedAgility);
    }
}
