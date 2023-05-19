package main;

import java.util.*;

public class RandomEvent {
	private Random random;
	private int randomInt;

	public RandomEvent() {
		random = new Random();
		randomInt = random.nextInt(50);
	}

	public boolean generateRandom() {
		return random.nextInt(50) == randomInt;
	}

	public ArrayList<Object> generateEvent(Boolean run) {
		ArrayList<Object> output = new ArrayList<Object>();
		if (run) {
			int i = random.nextInt(50);
			switch (i) {
			case 0:
				output.add(3);
				output.add(" has broken their hand and must sit out for 3 weeks."); // Insert special events here
				break;
			case 1:
				output.add(1);
				output.add(" has gotten food poisoning and must sit out the next game.");
				break;
			case 2:
				output.add(1);
				output.add(" has forgotten their uniform at home and cannot play the next game.");
				break;
			case 3:
				output.add(6);
				output.add(" has torn their ACL and must take 6 weeks off to recover.");
				break;
			case 4:
				output.add(4);
				output.add(" is currently representing their national team, and will be back after 4 weeks");
				break;
			default:
				break;
			}
		}
		return output;
	}
}
