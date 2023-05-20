package main;

import GUI.*;
import java.util.*;

import org.hamcrest.core.IsInstanceOf;

/**
 * This is the GameManager class which controls the logic for the game such as
 * opening/closing windows.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class GameManager {
	private int money;
	private String teamName;
	private int numWeeks;
	private int currentWeek = 1;
	private Team team = new Team(teamName);
	private String difficulty;
	private boolean isSetup = false;
	private ArrayList<Team> weeklyTeams;
	private Team opposingTeam;
	private GenerateRandom random;
	private Market market;
	private int finalScore = 0;
	GOTOSCREEN screen;
	

	public GameManager() {
		random = new GenerateRandom();
		market = new Market(random);
		market.setPurchasableAthletes();
		market.setPurchasableItems();
		generateRandomTeams();
	}

	/**
	 * Enum to select next screen
	 */
	public enum GOTOSCREEN {
		START, MAIN, SHOP, TEAM, STADIUM, QUIT;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getMoney() {
		return money;
	}

	public void changeMoney(int amount) {
		money += amount;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getCurrentWeek() {
		return currentWeek;
	}

	public void generateRandomTeams() {
		weeklyTeams = random.generateTeams();
	}

	public void incrementWeek() {
		currentWeek += 1;
		market.setPurchasableAthletes();
		market.setPurchasableItems();
		market.clearWeeklyPurchases();
		random.incrementMultiplier();
		generateRandomTeams();
	}

	public int getNumWeeks() {
		return numWeeks;
	}

	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}

	public Team getTeam() {
		return team;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Market getMarket() {
		return market;
	}

	public ArrayList<Team> getWeeklyTeams() {
		return weeklyTeams;
	}

	public Team getOpposingTeam() {
		return opposingTeam;
	}

	public void setOpposingTeam(Team team) {
		opposingTeam = team;
	}

	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}

	public void closeStartScreen(StartScreen startWindow) {
		startWindow.closeWindow();
		if (!isSetup) {
			isSetup = true;
			launchGameSetupScreen();
		} else {
			launchMainScreen();
		}
	}

	public void launchGameSetupScreen() {
		SetupScreen gameSetupWindow = new SetupScreen(this);
	}

	public void closeGameSetupScreen(SetupScreen gameSetupWindow) {
		if (difficulty == "Easy") {
			money = 5000;
		}
		else {
			money = 3000;
		}
		gameSetupWindow.closeWindow();
		launchTeamSetupScreen();
	}

	public void launchTeamSetupScreen() {
		market.getStarterAthletes().add(random.generateAthlete(0));
		market.getStarterAthletes().add(random.generateAthlete(1));
		market.getStarterAthletes().add(random.generateAthlete(2));
		market.getStarterAthletes().add(random.generateAthlete(3));
		market.getStarterAthletes().add(random.generateAthlete(4));
		market.getStarterAthletes().add(random.generateAthlete(random.getRandomNumber(5)));
		TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
	}

	public void closeTeamSetupScreen(TeamSetupScreen teamSetupWindow) {
		teamSetupWindow.closeWindow();
		team.getReserves().clear();
		launchMainScreen();
	}

	public void launchMainScreen() {
		if (currentWeek < numWeeks) {
		    MainScreen mainWindow = new MainScreen(this);
		}
		
		else {
			launchGameOverScreen();
		}
	}

	/**
	 * Close main screen and navigate to one of 5 options
	 * 
	 * @param toScreen The screen to navigate to
	 */
	public void closeMainScreen(MainScreen mainWindow, GOTOSCREEN toScreen) {
		this.screen = toScreen;

		switch (screen) {

		case START:
			mainWindow.closeWindow();
			launchStartScreen();
			break;

		case SHOP:
			mainWindow.closeWindow();
			launchShopScreen();
			break;

		case STADIUM:
			mainWindow.closeWindow();
			launchStadiumScreen();
			break;

		case TEAM:
			mainWindow.closeWindow();
			launchTeamScreen();
			break;

		case QUIT:
			mainWindow.closeWindow();
			break;

		case MAIN:
			mainWindow.closeWindow();
			launchStartScreen();

		default:
			break;
		}
	}

	public void launchShopScreen() {
		ShopScreen shopWindow = new ShopScreen(this);
	}

	public void closeShopScreen(ShopScreen shopWindow) {
		shopWindow.closeWindow();
		launchMainScreen();
	}

	public void launchTeamScreen() {
		TeamScreen teamWindow = new TeamScreen(this);
	}

	public void closeTeamScreen(TeamScreen teamWindow) {
		teamWindow.closeWindow();
		launchMainScreen();
	}

	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
	}

	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
	}

	public void LaunchOpponentSelectorScreen() {
		OpponentSelectorScreen opponentSelectorWindow = new OpponentSelectorScreen(this);
	}

	public void closeOpponentSelectorScreen(OpponentSelectorScreen opponentSelectorWindow) {
		opponentSelectorWindow.closeWindow();
	}

	public void launchGameScreen() {
		Gameplay gamePlay = new Gameplay(team, opposingTeam, difficulty);
		gamePlay.play();
		String result = gamePlay.declareWinner();
		switch (result) {
			case "player":
				finalScore += 3;
				money += 2000;
				if (difficulty == "hard") {
				    finalScore += 3;
				}
				break;
			case "draw":
				finalScore += 1;
				money += 1000;
				if (difficulty == "hard") {
				    finalScore += 1;
				}
				break;
			case "opponent":
				money += 500;
				if (difficulty == "hard") {
				    money += 500;
				}
				break;
		}
		GameScreen gameWindow = new GameScreen(this);
	}
	
	public void closeTrainAthleteScreen(TrainAthleteScreen trainAthleteScreen) {
		trainAthleteScreen.closeWindow();
		launchMainScreen();
	}
	
	public void launchTrainAthleteScreen() {
		TrainAthleteScreen trainAthleteWindow = new TrainAthleteScreen(this);
	}
	
	public void launchDialogueBox(String message) {
		DialogueBox dialogueBox = new DialogueBox(this, message);
	}
	
	public void launchRandomEvent() {
		RandomEvent randomEvent = new RandomEvent(team);
		String message = randomEvent.generateEvent(randomEvent.generateRandom());
		if (message instanceof String) {
			launchDialogueBox(message);
		}
	}

	public void closeGameScreen(GameScreen gameWindow) {
		gameWindow.closeWindow();
		incrementWeek();
		launchMainScreen();
	}
	
	public int getScore() {
		return finalScore;
	}
	
	public void closeGameOverScreen(GameOverScreen gameOverScreen) {
		gameOverScreen.closeWindow();
	}
	
	public void launchGameOverScreen() {
		GameOverScreen gameOverScreen = new GameOverScreen(this);
	}

	public static void main(String args[]) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}

}
