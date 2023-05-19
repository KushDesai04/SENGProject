package main;

public class Gameplay {
	private Team playerTeam;
	private Team opposingTeam;
	private int playerPoints;
	private int opponentPoints;
	private String difficulty;

	public Gameplay(Team playerTeam, Team opposingTeam, String difficulty) {
		// TODO Auto-generated constructor stub
		this.playerTeam = playerTeam;
		this.opposingTeam = opposingTeam;
		this.difficulty = difficulty;
	}

	public int getPlayerPoints() {
		return playerPoints;
	}

	public int getOpponentPoints() {
		return opponentPoints;
	}

	public void play() {
		for (Athlete player : playerTeam.getPlayersArray()) {
			Athlete opponent = opposingTeam.getPlayersMap().get(player.getPosition());
			if (player.getRating() > opponent.getRating()) {
				playerPoints += 1;
				if (difficulty == "easy") {
					player.changeStat(-10, Athlete.STATS.S);
				}
				else {
					player.changeStat(-20, Athlete.STATS.S);
				}
			}
			
			else if (player.getRating() < opponent.getRating()) {
				opponentPoints += 1;
				if (difficulty == "easy") {
					player.changeStat(-20, Athlete.STATS.S);
				}
				else {
					player.changeStat(-40, Athlete.STATS.S);
				}
			}
			
		}
	}
	public String declareWinner() {
		if (playerPoints > opponentPoints) {
			return "player";
			
		}

		else if (playerPoints == opponentPoints) {
			return "draw";
		}

		else {
			return "opponent";
		}

	}
}
