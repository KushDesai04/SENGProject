package main;
import java.util.Random;

public class RandomEvent {
	private Random random;
	private int randomInt;
	public RandomEvent() {
		// TODO Auto-generated constructor stub
		random = new Random();
		randomInt = random.nextInt(50);
	}
	public boolean generateRandom() {
		return random.nextInt(50) == randomInt;
	}
	public void generateEvent(Boolean run) {
		if (run) {
			int i = random.nextInt(4);
			switch (i) {
			case 0:
				break; // Insert special events here
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
			}
		}
	}
}
