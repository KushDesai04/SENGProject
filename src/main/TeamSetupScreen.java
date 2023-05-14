package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.naming.ldap.ManageReferralControl;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.junit.validator.PublicClassValidator;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.desktop.AboutHandler;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class TeamSetupScreen {

	private JFrame frame;
	private GameManager manager;
	
	public TeamSetupScreen(GameManager gameManager) {
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
					TeamSetupScreen window = new TeamSetupScreen();
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
	public TeamSetupScreen() {
		initialize();
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeTeamSetupScreen(this);
	}
	public boolean maxSize() {
		return manager.getTeam().getPlayers().size() == 5;
	}
	public boolean lessThanMax() {
		return manager.getTeam().getPlayers().size() < 5;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JButton btnStart = new JButton("Start");
		btnStart.setEnabled(false);
		if (manager.getTeam().getPlayers().size() == 5) {
			btnStart.setEnabled(true);
		}
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnStart.isEnabled()) {
					finishedWindow();
				}		
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
					.addGap(138)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(btnStart, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(158)
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
					.addGap(18))
		);
		
		JLabel nameLabel = new JLabel("Click a player to add them into your team");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel positionLabel = new JLabel("and see their stats.");
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel offLabel = new JLabel("Offence: ");
		offLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		
		JLabel defLabel = new JLabel("Defence: ");
		defLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel stamLabel = new JLabel("Stamina: ");
		stamLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel agilLabel = new JLabel("Agility: ");
		agilLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel ovrLabel = new JLabel("");
		ovrLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel offValue = new JLabel("");
		offValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel defValue = new JLabel("");
		defValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel stamValue = new JLabel("");
		stamValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel agilValue = new JLabel("");
		agilValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(stamLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(defLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(6)
							.addComponent(stamValue))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(agilLabel)
							.addGap(18)
							.addComponent(agilValue))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(offLabel)
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(defValue)
								.addComponent(offValue))))
					.addContainerGap(173, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(positionLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addComponent(ovrLabel))
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(181)
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(ovrLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(offLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(offValue))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(defLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(stamLabel)
								.addComponent(stamValue))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(agilLabel)
								.addComponent(agilValue)))
						.addComponent(defValue))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JToggleButton tglbtnPlayer1 = new JToggleButton("Player1");
		if (!tglbtnPlayer1.isSelected() && maxSize()) {
			tglbtnPlayer1.setEnabled(false);
		}
		else {
			tglbtnPlayer1.setEnabled(true);
		}
		tglbtnPlayer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer1.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(0)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(0).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(0).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(0).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(0).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(0).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(0).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer1.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnPlayer2 = new JToggleButton("Player1");
		if (!tglbtnPlayer2.isSelected() && maxSize()) {
			tglbtnPlayer2.setEnabled(false);
		}
		else {
			tglbtnPlayer2.setEnabled(true);
		}
		tglbtnPlayer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer2.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(1)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(1).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(1).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(1).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(1).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(1).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(1).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer2.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnPlayer3 = new JToggleButton("Player1");
		if (!tglbtnPlayer3.isSelected() && maxSize()) {
			tglbtnPlayer3.setEnabled(false);
		}
		else {
			tglbtnPlayer3.setEnabled(true);
		}
		tglbtnPlayer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer3.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(2)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(2).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(2).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(2).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(2).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(2).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(2).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer3.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnPlayer4 = new JToggleButton("Player1");
		if (!tglbtnPlayer4.isSelected() && maxSize()) {
			tglbtnPlayer4.setEnabled(false);
		}
		else {
			tglbtnPlayer4.setEnabled(true);
		}
		tglbtnPlayer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer4.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(3)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(3).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(3).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(3).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(3).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(3).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(3).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer4.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnPlayer5 = new JToggleButton("Player1");
		if (!tglbtnPlayer5.isSelected() && maxSize()) {
			tglbtnPlayer5.setEnabled(false);
		}
		else {
			tglbtnPlayer5.setEnabled(true);
		}
		tglbtnPlayer5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer5.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(4)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(4).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(4).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(4).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(4).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(4).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(4).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer5.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnPlayer6 = new JToggleButton("Player1");
		if (!tglbtnPlayer6.isSelected() && maxSize()) {
			tglbtnPlayer6.setEnabled(false);
		}
		else {
			tglbtnPlayer6.setEnabled(true);
		}
		tglbtnPlayer6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlayer6.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(manager.getMarket().getPurchasableAthletes().get(5)); //Add player from array to starters
					nameLabel.setText(manager.getMarket().getPurchasableAthletes().get(5).getName()); //Set name label to athlete name
					ovrLabel.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(5).getRating()));
					offValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(5).getStat(STATS.O)));
					defValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(5).getStat(STATS.D)));
					stamValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(5).getStat(STATS.S)));
					agilValue.setText(String.valueOf(manager.getMarket().getPurchasableAthletes().get(5).getStat(STATS.A)));
				}
				else if (!tglbtnPlayer6.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnPlayer6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Select 5 Players");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(tglbtnPlayer4, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(tglbtnPlayer1, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addGap(3)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnPlayer5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnPlayer2, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnPlayer3, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(tglbtnPlayer6, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(274)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(265)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPlayer1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnPlayer2, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnPlayer3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(84)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPlayer4, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnPlayer5, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnPlayer6, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(27))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}