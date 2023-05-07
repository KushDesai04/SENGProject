package main;
import java.util.*;
public class GameManager {
	
	private ArrayList<Athlete> startingTeam;
	private String teamName;
	private int numWeeks;
	
	public GameManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	public void closeStartScreen() { 
		startWindow.closeWindow();
	}
	
	public void launchGameSetupScreen() {
		SetupScreen gameSetupWindow = new SetupScreen(this);
	}
	public void closeGameSetupScreen() {
		gameSetupWindow.close();
	}
	
	public void launchTeamSetupScreen() {
		TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
	}
	public void closeTeamSetupScreen() { 
		teamSetupWindow.closeWindow();
	}
	
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	public void closeMainScreen() {
		mainWindow.closeWindow();
	}
	
	public void launchShopScreen() {
		ShopScreen shopWindow = new ShopScreen(this);
	}
	public void closeShopScreen() {
		shopWindow.closeWindow();
	}
	
	public void launchTeamScreen() {
		TeamScreen teamWindow = new TeamScreen(this);
	}
	public void closeTeamScreen() {
		teamWindow.closeWindow();
	}
	
	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
	}
	public void closeStadiumScreen() {
		stadiumWindow.closeWindow();
	}
	
	
	
}
