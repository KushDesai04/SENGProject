package GUI;
import main.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JButton;

/*
 * This is the GameScreen class. The game screen is shown when the player initiates a match against an opponent.
 * The screen will show players from both teams, and winning players have their names shown in green, losing players
 * in white, and draw in orange. The team names are also shown.
 */
public class GameScreen {

	private JFrame frame;
	private GameManager manager;
	private Gameplay gamePlay;
	private ArrayList<JLabel> playerStarters = new ArrayList<JLabel>();
	private ArrayList<JLabel> opponentStarters = new ArrayList<JLabel>();

	public GameScreen(GameManager gameManager) {
		manager = gameManager;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen window = new GameScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameScreen() {
		initialize();
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		manager.closeGameScreen(this);
	}
	
	public void setPlayerLabels(ArrayList<JLabel> btns) {
		HashMap<Athlete.POSITION, Athlete> players = manager.getTeam().getPlayersMap();
		btns.get(0).setText(String.valueOf(players.get(Athlete.POSITION.PG).getName() + " - " + players.get(Athlete.POSITION.PG).getRating()));
		btns.get(1).setText(String.valueOf(players.get(Athlete.POSITION.SG).getName() + " - " + players.get(Athlete.POSITION.SG).getRating()));
		btns.get(2).setText(String.valueOf(players.get(Athlete.POSITION.C).getName() + " - " + players.get(Athlete.POSITION.C).getRating()));
		btns.get(3).setText(String.valueOf(players.get(Athlete.POSITION.SF).getName() + " - " + players.get(Athlete.POSITION.SF).getRating()));
		btns.get(4).setText(String.valueOf(players.get(Athlete.POSITION.PF).getName() + " - " + players.get(Athlete.POSITION.PF).getRating()));
	}
	
	public void setOpponentLabels(ArrayList<JLabel> btns) {
		HashMap<Athlete.POSITION, Athlete> opponents = manager.getOpposingTeam().getPlayersMap();
		btns.get(0).setText(String.valueOf(opponents.get(Athlete.POSITION.PG).getName() + " - " + opponents.get(Athlete.POSITION.PG).getRating()));
		btns.get(1).setText(String.valueOf(opponents.get(Athlete.POSITION.SG).getName()+ " - " + opponents.get(Athlete.POSITION.SG).getRating()));
		btns.get(2).setText(String.valueOf(opponents.get(Athlete.POSITION.C).getName() + " - " + opponents.get(Athlete.POSITION.C).getRating()));
		btns.get(3).setText(String.valueOf(opponents.get(Athlete.POSITION.SF).getName() + " - " + opponents.get(Athlete.POSITION.SF).getRating()));
		btns.get(4).setText(String.valueOf(opponents.get(Athlete.POSITION.PF).getName() + " - " + opponents.get(Athlete.POSITION.PF).getRating()));
	}
	
	public void setWinners(ArrayList<JLabel> playerLabels, ArrayList<JLabel> opponentLabels, JLabel playerWinnerLbl, JLabel opponentWinnerLbl) {
		int playerScore = 0;
		for (int i=0; i<5; i++) {
			Athlete player = manager.getTeam().getPlayersArray().get(i);
			Athlete opponent = manager.getOpposingTeam().getPlayersMap().get(player.getPosition());
			Athlete.POSITION pos = opponent.getPosition();
			int index = 0;
			switch (pos) {
			    case PG:
				    index = 0;
				    break;
			    case SG:
			    	index = 1;
			    	break;
			    case C:
			    	index = 2;
			    	break;
			    case SF:
			    	index = 3;
			    	break;
			    case PF:
			    	index = 4;
			    	break;
			    default:
			    	break;
			}

			if (player.getRating() > opponent.getRating()) {
				playerLabels.get(index).setForeground(Color.green);
				playerScore += 1;
			}
			
			else if (player.getRating() < opponent.getRating()) {
				opponentLabels.get(index).setForeground(Color.green);
				playerScore -= 1;
			}
			
			else {
				playerLabels.get(index).setForeground(Color.orange);
				opponentLabels.get(index).setForeground(Color.orange);
			}
		}
		
		if (playerScore > 0) {
		    playerWinnerLbl.setText("Winner");
		}
		
		else if (playerScore < 0){
		    opponentWinnerLbl.setText("Winner");
		    	
		}
		else {
		   	playerWinnerLbl.setText("Draw!");
		   	playerWinnerLbl.setForeground(Color.orange);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));

		JLabel playerPG = new JLabel("New label");
		playerPG.setForeground(new Color(255, 255, 255));
		playerPG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel opponentPG = new JLabel("New label");
		opponentPG.setForeground(new Color(255, 255, 255));
		opponentPG.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentPG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel playerSG = new JLabel("New label");
		playerSG.setForeground(new Color(255, 255, 255));
		playerSG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel opponentSG = new JLabel("New label");
		opponentSG.setForeground(new Color(255, 255, 255));
		opponentSG.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentSG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel playerC = new JLabel("New label");
		playerC.setForeground(new Color(255, 255, 255));
		playerC.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel opponentC = new JLabel("New label");
		opponentC.setForeground(new Color(255, 255, 255));
		opponentC.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentC.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel playerSF = new JLabel("New label");
		playerSF.setForeground(new Color(255, 255, 255));
		playerSF.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel opponentSF = new JLabel("New label");
		opponentSF.setForeground(new Color(255, 255, 255));
		opponentSF.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentSF.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel playerPF = new JLabel("New label");
		playerPF.setForeground(new Color(255, 255, 255));
		playerPF.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel opponentPF = new JLabel("New label");
		opponentPF.setForeground(new Color(255, 255, 255));
		opponentPF.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentPF.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton backButton = new JButton("<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVs.setForeground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(411)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playerPF, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
							.addComponent(opponentPF, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playerSF, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
							.addComponent(opponentSF, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerPG, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(playerC, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(playerSG, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVs, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(opponentPG, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(opponentC, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
										.addComponent(opponentSG, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))))
					.addGap(329))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(backButton, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(1131))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(opponentPG, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(playerPG, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(playerSG, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(opponentSG, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerC, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(opponentC, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerSF, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(opponentSF, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerPF, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(opponentPF, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblVs, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
					.addGap(38))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(backButton)
					.addContainerGap(528, Short.MAX_VALUE))
		);

		JLabel lblPlayerHeader = new JLabel("Player");
		lblPlayerHeader.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblOpponentHeader = new JLabel("Opponent");
		lblOpponentHeader.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOpponentHeader.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel playerTeam = new JLabel("New label");
		playerTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerTeam.setText(manager.getTeamName());

		JLabel opponentTeam = new JLabel("New label");
		opponentTeam.setText(manager.getOpposingTeam().getTeamName());
		opponentTeam.setHorizontalAlignment(SwingConstants.TRAILING);
		opponentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPlayerWinner = new JLabel("");
		lblPlayerWinner.setForeground(new Color(0, 255, 0));
		lblPlayerWinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblOpponentWinner = new JLabel("");
		lblOpponentWinner.setForeground(new Color(0, 255, 0));
		lblOpponentWinner.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOpponentWinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(playerTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(142))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPlayerWinner, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(104)
									.addComponent(opponentTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblOpponentWinner, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPlayerHeader, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
							.addComponent(lblOpponentHeader, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblPlayerHeader)
						.addComponent(lblOpponentHeader))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayerWinner, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpponentWinner, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(opponentTeam, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(playerTeam, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		playerStarters.add(playerPG);
		playerStarters.add(playerSG);
		playerStarters.add(playerC);
		playerStarters.add(playerSF);
		playerStarters.add(playerPF);
		
		opponentStarters.add(opponentPG);
		opponentStarters.add(opponentSG);
		opponentStarters.add(opponentC);
		opponentStarters.add(opponentSF);
		opponentStarters.add(opponentPF);
		
		setPlayerLabels(playerStarters);
		setOpponentLabels(opponentStarters);
		setWinners(playerStarters, opponentStarters, lblPlayerWinner, lblOpponentWinner);
	}
}
