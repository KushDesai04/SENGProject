package main;
import java.util.*;
public class GameManager {
	
	private String teamName;
	private int numWeeks;
	private Team team = new Team(teamName);
	private String difficulty;
	private Market market = new Market();
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
		launchGameSetupScreen();
	}
	
	public void launchGameSetupScreen() {
		SetupScreen gameSetupWindow = new SetupScreen(this);
	}
	public void closeGameSetupScreen(SetupScreen gameSetupWindow) {
		System.out.println(String.format("%s,%s,%d",teamName, difficulty, numWeeks ));
		gameSetupWindow.closeWindow();
		launchTeamSetupScreen();
	}
//	
	public void launchTeamSetupScreen() {
		TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
	}
	public void closeTeamSetupScreen(TeamSetupScreen teamSetupWindow) { 
		teamSetupWindow.closeWindow();
		
	}
	
//	public void launchMainScreen() {
//	 	MainScreen mainWindow = new MainScreen(this);
//	 }
//	 public void closeMainScreen(MainScreen mainWindow) {
//	 	mainWindow.closeWindow();
//	 }
//	
//	 public void launchShopScreen() {
//	 	ShopScreen shopWindow = new ShopScreen(this);
//	 }
//	 public void closeShopScreen(ShopScreen shopWindow) {
//	 	shopWindow.closeWindow();
//	 	launchMainScreen();
//	 }
//	
//	 public void launchTeamScreen() {
//	 	TeamScreen teamWindow = new TeamScreen(this);
//	 }
//	 public void closeTeamScreen(TeamScreen teamWindow) {
//	 	teamWindow.closeWindow();
//	 	launchMainScreen();
//	 }
//	
//	 public void launchStadiumScreen() {
//	 	StadiumScreen stadiumWindow = new StadiumScreen(this);
//	 }
//	 public void goToGame(StadiumScreen stadiumWindow) {
//		 stadiumWindow.closeWindow();
//		 
//	 }
//	 public void closeStadiumScreen(StadiumScreen stadiumWindow) {
//	 	stadiumWindow.closeWindow();
//	 	launchMainScreen();
//	 }
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
