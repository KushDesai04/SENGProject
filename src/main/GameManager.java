package main;
import java.util.*;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.EnumSelector;

/**
* Enum to select next screen
*/
enum GOTOSCREEN {START, MAIN, SHOP, TEAM, STADIUM, QUIT}

/**
 * This is the GameManager class which controls the logic for the game
 * such as opening/closing windows.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class GameManager {
	
	private String teamName;
	private int numWeeks;
	private int currentWeek = 1;
	private Team team = new Team(teamName);
	private String difficulty;
	private Market market = new Market();
	private boolean isSetup = false;
	GOTOSCREEN screen;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getCurrentWeek() {
		return currentWeek;
	}
	public void incrementWeek() {
		currentWeek += 1;
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
	
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	public void closeStartScreen(StartScreen startWindow) { 
		startWindow.closeWindow();
		if (!isSetup) {
		    isSetup = true;
		    launchGameSetupScreen();
		}
		else {
			launchMainScreen();
		}
	}
	
	public void launchGameSetupScreen() {
		SetupScreen gameSetupWindow = new SetupScreen(this);
	}
	public void closeGameSetupScreen(SetupScreen gameSetupWindow) {
		System.out.println(String.format("%s,%s,%d",teamName, difficulty, numWeeks));
		gameSetupWindow.closeWindow();
		launchTeamSetupScreen();
	}
//	
	public void launchTeamSetupScreen() {
		ArrayList<Integer> stats1= new ArrayList<Integer>();
		stats1.add(99);
		stats1.add(99);
		stats1.add(99);
		stats1.add(99);
		Athlete athlete1 =  new Athlete("Athlete 1", 70, POSITION.PG, stats1);
		Athlete athlete2 =  new Athlete("Athlete 2", 80, POSITION.SG, stats1);
		Athlete athlete3 =  new Athlete("Athlete 3", 79, POSITION.SF, stats1);
		Athlete athlete4 =  new Athlete("Athlete 4", 76, POSITION.PF, stats1);
		Athlete athlete5 =  new Athlete("Athlete 5", 89, POSITION.C, stats1);
		Athlete athlete6 =  new Athlete("Athlete 6", 99, POSITION.PG, stats1);
		market.getPurchasableAthletes().add(athlete1);
		market.getPurchasableAthletes().add(athlete2);
		market.getPurchasableAthletes().add(athlete3);
		market.getPurchasableAthletes().add(athlete4);
		market.getPurchasableAthletes().add(athlete5);
		market.getPurchasableAthletes().add(athlete6);
		TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
	}
	public void closeTeamSetupScreen(TeamSetupScreen teamSetupWindow) { 
		teamSetupWindow.closeWindow();	
		launchMainScreen();
	}
	
	public void launchMainScreen() {
	 	MainScreen mainWindow = new MainScreen(this);
	 }
	
	/**
	 * Close main screen and navigate to one of 5 options
	 * @param toScreen    The screen to navigate to
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
	 	launchMainScreen();
	 }
//	 public void gameScreen() {
//		 GameScreen gameWindow = new GameScreen(this);
//	 }
//	 public void closeGameScreen(GameScreen gameWindow) {
//		 gameWindow.closeWindow();
//		 launchMainScreen();
//	 }
	
	public static void main(String args[]) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}
	
	
	
	
}
