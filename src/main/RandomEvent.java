package main;
import java.util.Random;

enum EVENT {A, B, C, D, E}
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
	public void generateEvent(EVENT e) {
		switch (e) {
		case A:
			break; // Insert special events here
		case B:
			break;
		case C:
			break;
		case D:
			break;
		case E:
			break;
		default:
			break;
		}
	}
}
