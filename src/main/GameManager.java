package main;
import java.util.*;
public class GameManager {
	
//	private ArrayList<Athlete> startingTeam;
//	private String teamName;
//	private int numWeeks;

	
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	public void closeStartScreen(StartScreen startWindow) { 
		startWindow.closeWindow();
		launchGameSetupScreen();
	}
	
	public void launchGameSetupScreen() {
		SetupScreen gameSetupWindow = new SetupScreen(this);
	}
	public void closeGameSetupScreen(SetupScreen gameSetupWindow) {
		gameSetupWindow.closeWindow();
		launchTeamSetupScreen();
	}
	
	public void launchTeamSetupScreen() {
		TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
	}
	public void closeTeamSetupScreen(TeamSetupScreen teamSetupWindow) { 
		teamSetupWindow.closeWindow();
	}
	
	public void launchMainScreen() {
	 	MainScreen mainWindow = new MainScreen(this);
	 }
	 public void closeMainScreen(MainScreen mainWindow) {
	 	mainWindow.closeWindow();
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
	 public void goToGame(StadiumScreen stadiumWindow) {
		 stadiumWindow.closeWindow();
		 
	 }
	 public void closeStadiumScreen(StadiumScreen stadiumWindow) {
	 	stadiumWindow.closeWindow();
	 	launchMainScreen();
	 }
	 public void gameScreen() {
		 GameScreen gameWindow = new GameScreen(this);
	 }
	 public void closeGameScreen(GameScreen gameWindow) {
		 gameWindow.closeWindow();
		 launchMainScreen();
	 }
	
	public static void main(String args[]) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}
	
}
