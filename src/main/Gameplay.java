package main;

public class Gameplay {
	private Team playerTeam;
	private Team opposingTeam;
	private int playerPoints;
	private int opposingPoints;
	
	public Gameplay(Team playerTeam, Team opposingTeam) {
		// TODO Auto-generated constructor stub
		this.playerTeam = playerTeam;
		this.opposingTeam = opposingTeam;
	}
	
	public int getPlayerPoints() {
		return playerPoints;
	}
	public int getOpposingPoints() {
		return opposingPoints;	
	}
	public void play() {
		for (int i=0; i<5; i++) {
			if (playerTeam.getPlayers().get(i).getRating() > opposingTeam.getPlayers().get(i).getRating()) {
				playerPoints += 1;
			}
			else if (playerTeam.getPlayers().get(i).getRating() < opposingTeam.getPlayers().get(i).getRating()) {
				opposingPoints += 1;
			}		
		}
	}
	public Team declareWinner() {
		if (playerPoints > opposingPoints) {
			return playerTeam;
		}
		else {
			return opposingTeam; // TODO: change this :)
		}
			
	}
}
