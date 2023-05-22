package main;

/**
 * The Gameplay class represents a game session between a player's team and an opposing team.
 * It manages the gameplay logic, including calculating points and determining the winner.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class Gameplay {
    /**
     * The player's Team participating in the game.
     */
    private Team playerTeam;

    /**
     * The opposing Team participating in the game.
     */
    private Team opposingTeam;

    /**
     * The total points earned by the player's Team.
     */
    private int playerPoints;

    /**
     * The total points earned by the opposing Team.
     */
    private int opponentPoints;

    /**
     * The difficulty level of the game.
     */
    private String difficulty;

    /**
     * Constructs a new Gameplay object with the specified player's Team, opposing Team, and difficulty.
     *
     * @param playerTeam    The player's Team participating in the game.
     * @param opposingTeam  The opposing Team participating in the game.
     * @param difficulty    The difficulty level of the game.
     */
    public Gameplay(Team playerTeam, Team opposingTeam, String difficulty) {
        this.playerTeam = playerTeam;
        this.opposingTeam = opposingTeam;
        this.difficulty = difficulty;
    }

    /**
     * Retrieves the total points earned by the player's Team.
     *
     * @return The total points earned by the player's Team.
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * Retrieves the total points earned by the opposing Team.
     *
     * @return The total points earned by the opposing Team.
     */
    public int getOpponentPoints() {
        return opponentPoints;
    }

    /**
     * Simulates the gameplay, calculating points for each player and updating their stamina accordingly.
     */
    public void play() {
        for (Athlete player : playerTeam.getPlayersArray()) {
            Athlete opponent = opposingTeam.getPlayersMap().get(player.getPosition());
            if (player.getRating() > opponent.getRating()) {
                playerPoints += 1;
                if (difficulty.equals("easy")) {
                    player.changeCurrentStamina(-10);
                } else {
                    player.changeCurrentStamina(-20);
                }
            } else if (player.getRating() < opponent.getRating()) {
                opponentPoints += 1;
                if (difficulty.equals("easy")) {
                    player.changeCurrentStamina(-15);
                } else {
                    player.changeCurrentStamina(-25);
                }
            }
        }
    }

    /**
     * Determines the winner of the game based on the total points earned by the player's Team and the opposing Team.
     *
     * @return The result of the game: "player" if the player's team has more points,
     *         "draw" if the points are equal, or "opponent" if the opposing team has more points.
     */
    public String declareWinner() {
        if (playerPoints > opponentPoints) {
            return "player";
        } else if (playerPoints == opponentPoints) {
            return "draw";
        } else {
            return "opponent";
        }
    }
}

