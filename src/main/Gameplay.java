package main;

/**
 * The Gameplay class represents a game session between a player's team and an opposing team.
 * It manages the gameplay logic, including calculating points and determining the winner.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 */
public class Gameplay {
    /**
     * The player's team participating in the game.
     */
    private Team playerTeam;

    /**
     * The opposing team participating in the game.
     */
    private Team opposingTeam;

    /**
     * The total points earned by the player's team.
     */
    private int playerPoints;

    /**
     * The total points earned by the opposing team.
     */
    private int opponentPoints;

    /**
     * The difficulty level of the game.
     */
    private String difficulty;

    /**
     * Constructs a new Gameplay object with the specified player's team, opposing team, and difficulty.
     *
     * @param playerTeam    The player's team participating in the game.
     * @param opposingTeam  The opposing team participating in the game.
     * @param difficulty    The difficulty level of the game.
     */
    public Gameplay(Team playerTeam, Team opposingTeam, String difficulty) {
        this.playerTeam = playerTeam;
        this.opposingTeam = opposingTeam;
        this.difficulty = difficulty;
    }

    /**
     * Retrieves the total points earned by the player's team.
     *
     * @return The total points earned by the player's team.
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * Retrieves the total points earned by the opposing team.
     *
     * @return The total points earned by the opposing team.
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
                    player.changeCurrentStamina(-10);
                } else {
                    player.changeCurrentStamina(-20);
                }
            }
        }
    }

    /**
     * Determines the winner of the game based on the total points earned by the player's team and the opposing team.
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

