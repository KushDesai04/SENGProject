package main;

import GUI.*;
import java.util.*;
/**
 * This is the GameManager class which controls the logic for the game such as
 * opening/closing windows.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class GameManager {
	/**
	 * The amount of money the GameManager has.
	 */
	private int money;

	/**
	 * The name of the team controlled by the GameManager.
	 */
	private String teamName;

	/**
	 * The total number of weeks in the game.
	 */
	private int numWeeks;

	/**
	 * The current week of the game. Initialised to 1.
	 */
	private int currentWeek = 1;

	/**
	 * The Team controlled by the GameManager.
	 */
	private Team team = new Team(teamName);

	/**
	 * The difficulty level of the game.
	 */
	private String difficulty;

	/**
	 * A flag indicating whether the game setup has been completed.
	 */
	private boolean isSetup = false;

	/**
	 * The list of weekly teams in the game.
	 */
	private ArrayList<Team> weeklyTeams;

	/**
	 * The opposing Team in the current game.
	 */
	private Team opposingTeam;

	/**
	 * The random Object generator used in the game.
	 */
	private GenerateRandom random;

	/**
	 * The Market in the game.
	 */
	private Market market;

	/**
	 * The final score of the game.
	 */
	private int finalScore = 0;

	/**
	 * The next screen to navigate to in the game.
	 */
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

    /**
     * Retrieves the team name.
     * 
     * @return The team name.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Retrieves the amount of money.
     * 
     * @return The amount of money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Changes the amount of money by the specified amount.
     * 
     * @param amount The amount to change the money by.
     */
    public void changeMoney(int amount) {
        money += amount;
        if (money < 0) {
        	money = 0;
        }
    }

    /**
     * Sets the team name.
     * 
     * @param teamName The team name to set.
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Retrieves the current week.
     * 
     * @return The current week.
     */
    public int getCurrentWeek() {
        return currentWeek;
    }

    /**
     * Generates random Teams for the current week.
     */
    public void generateRandomTeams() {
        weeklyTeams = random.generateTeams();
    }

    /**
     * Increments the current week and updates the Market and random Teams accordingly.
     */
    public void incrementWeek() {
        currentWeek += 1;
        market.setPurchasableAthletes();
        market.setPurchasableItems();
        market.clearWeeklyPurchases();
        random.incrementMultiplier();
        generateRandomTeams();
    }

    /**
     * Retrieves the total number of weeks.
     * 
     * @return The total number of weeks.
     */
    public int getNumWeeks() {
        return numWeeks;
    }

    /**
     * Sets the total number of weeks.
     * 
     * @param numWeeks The total number of weeks to set.
     */
    public void setNumWeeks(int numWeeks) {
        this.numWeeks = numWeeks;
    }

    /**
     * Retrieves the player's Team.
     * 
     * @return The player's Team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Retrieves the game difficulty.
     * 
     * @return The game difficulty.
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the game difficulty.
     * 
     * @param difficulty The game difficulty to set.
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Retrieves the game Market.
     * 
     * @return The game Market.
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Retrieves the random Teams for the current week.
     * 
     * @return The random Teams for the current week.
     */
    public ArrayList<Team> getWeeklyTeams() {
        return weeklyTeams;
    }

    /**
     * Retrieves the opposing Team.
     * 
     * @return The opposing Team.
     */
    public Team getOpposingTeam() {
        return opposingTeam;
    }

    /**
     * Sets the opposing Team.
     * 
     * @param team The opposing Team to set.
     */
    public void setOpposingTeam(Team team) {
        opposingTeam = team;
    }

    /**
     * Launches the start screen.
     */
    public void launchStartScreen() {
        StartScreen startWindow = new StartScreen(this);
    }

    /**
     * Closes the start screen and launches the game setup screen or main screen.
     * 
     * @param startWindow The start screen to close.
     */
    public void closeStartScreen(StartScreen startWindow) {
        startWindow.closeWindow();
        if (!isSetup) {
            isSetup = true;
            launchGameSetupScreen();
        } else {
            launchMainScreen();
        }
    }

    /**
     * Launches the game setup screen.
     */
    public void launchGameSetupScreen() {
        SetupScreen gameSetupWindow = new SetupScreen(this);
    }

    /**
     * Closes the game setup screen and launches the team setup screen.
     * 
     * @param gameSetupWindow The game setup screen to close.
     */
    public void closeGameSetupScreen(SetupScreen gameSetupWindow) {
        if (difficulty.equals("Easy")) {
            money = 5000;
        } else {
            money = 3000;
        }
        gameSetupWindow.closeWindow();
        launchTeamSetupScreen();
    }

    /**
     * Launches the team setup screen after generating random starting Athletes
     */
    public void launchTeamSetupScreen() {
        market.getStarterAthletes().add(random.generateAthlete(0));
        market.getStarterAthletes().add(random.generateAthlete(1));
        market.getStarterAthletes().add(random.generateAthlete(2));
        market.getStarterAthletes().add(random.generateAthlete(3));
        market.getStarterAthletes().add(random.generateAthlete(4));
        market.getStarterAthletes().add(random.generateAthlete(random.getRandomNumber(5)));
        TeamSetupScreen teamSetupWindow = new TeamSetupScreen(this);
    }

    /**
     * Closes the team setup screen and launches the main screen.
     * 
     * @param teamSetupWindow The team setup screen to close.
     */
    public void closeTeamSetupScreen(TeamSetupScreen teamSetupWindow) {
        teamSetupWindow.closeWindow();
        team.getReserves().clear();
        launchMainScreen();
    }

    /**
     * Launches the main screen.
     */
    public void launchMainScreen() {
        if (currentWeek < numWeeks) {
            MainScreen mainWindow = new MainScreen(this);
        } else {
            launchGameOverScreen();
        }
    }

    /**
     * Closes the main screen and navigates to the specified screen.
     * 
     * @param mainWindow The main screen to close.
     * @param toScreen   The screen to navigate to.
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

    /**
     * Launches the shop screen.
     */
    public void launchShopScreen() {
        ShopScreen shopWindow = new ShopScreen(this);
    }

    /**
     * Closes the shop screen and launches the main screen.
     * 
     * @param shopWindow The shop screen to close.
     */
    public void closeShopScreen(ShopScreen shopWindow) {
        shopWindow.closeWindow();
        launchMainScreen();
    }

    /**
     * Launches the team screen.
     */
    public void launchTeamScreen() {
        TeamScreen teamWindow = new TeamScreen(this);
    }

    /**
     * Closes the team screen and launches the main screen.
     * 
     * @param teamWindow The team screen to close.
     */
    public void closeTeamScreen(TeamScreen teamWindow) {
        teamWindow.closeWindow();
        launchMainScreen();
    }

    /**
     * Launches the stadium screen.
     */
    public void launchStadiumScreen() {
        StadiumScreen stadiumWindow = new StadiumScreen(this);
    }

    /**
     * Closes the stadium screen.
     * 
     * @param stadiumWindow The stadium screen to close.
     */
    public void closeStadiumScreen(StadiumScreen stadiumWindow) {
        stadiumWindow.closeWindow();
    }

    /**
     * Launches the opponent selector screen.
     */
    public void LaunchOpponentSelectorScreen() {
        OpponentSelectorScreen opponentSelectorWindow = new OpponentSelectorScreen(this);
    }

    /**
     * Closes the opponent selector screen.
     * 
     * @param opponentSelectorWindow The opponent selector screen to close.
     */
    public void closeOpponentSelectorScreen(OpponentSelectorScreen opponentSelectorWindow) {
        opponentSelectorWindow.closeWindow();
    }

    /**
     * Launches the game screen and updates points, and money according to match results
     */
    public void launchGameScreen() {
        Gameplay gamePlay = new Gameplay(team, opposingTeam, difficulty);
        gamePlay.play();
        String result = gamePlay.declareWinner();
        switch (result) {
            case "player":
                finalScore += 3;
                money += 2000;
                if (difficulty.equals("hard")) {
                    finalScore += 3;
                }
                break;
            case "draw":
                finalScore += 1;
                money += 1000;
                if (difficulty.equals("hard")) {
                    finalScore += 1;
                }
                break;
            case "opponent":
                money += 500;
                if (difficulty.equals("hard")) {
                    money += 500;
                }
                break;
        }
        GameScreen gameWindow = new GameScreen(this);
    }

    /**
     * Closes the game screen and launches the main screen.
     * 
     * @param gameWindow The game screen to close.
     */
    public void closeGameScreen(GameScreen gameWindow) {
        gameWindow.closeWindow();
        incrementWeek();
        launchMainScreen();
    }

    /**
     * Retrieves the final score.
     * 
     * @return The final score.
     */
    public int getScore() {
        return finalScore;
    }

    /**
     * Launches the game over screen.
     */
    public void launchGameOverScreen() {
        GameOverScreen gameOverWindow = new GameOverScreen(this);
    }

    /**
     * Closes the game over screen and launches the start screen.
     * 
     * @param gameOverWindow The game over screen to close.
     */
    public void closeGameOverScreen(GameOverScreen gameOverWindow) {
        gameOverWindow.closeWindow();
        System.exit(0);
    }
    
    
    /**
     * Closes the train athlete screen and launches the main screen.
     * 
     * @param trainAthleteScreen The train athlete screen to close.
     */
	public void closeTrainAthleteScreen(TrainAthleteScreen trainAthleteScreen) {
		trainAthleteScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
     * Launches the train athlete screen.
     */
	public void launchTrainAthleteScreen() {
		TrainAthleteScreen trainAthleteWindow = new TrainAthleteScreen(this);
	}
	
	/**
     * Launches a dialogue box to provide information about random events.
     */
	public void launchDialogueBox(String message) {
		DialogueBox dialogueBox = new DialogueBox(this, message);
	}
	
	/**
     * Launches a random event
     */
	public void launchRandomEvent() {
		RandomEvent randomEvent = new RandomEvent(team);
		String message = randomEvent.generateEvent(randomEvent.generateRandom());
		if (message instanceof String) {
			launchDialogueBox(message);
		}
	}

	/**
     * Launches the application
     */
    public static void main(String args[]) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}

}
