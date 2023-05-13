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
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setEnabled(false);
		if (manager.getTeam().getPlayers().size() == 5) {
			btnNewButton.setEnabled(true);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.isEnabled()) {
					finishedWindow();
				}		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
					.addGap(138)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
					.addGap(18))
		);
		
		JLabel nameLabel = new JLabel("placeholder text for name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel positionLabel = new JLabel("placeholder for position ");
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel offLabel = new JLabel("Offence:");
		offLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		
		JLabel defLabel = new JLabel("Defence:");
		defLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel stamLabel = new JLabel("Stamina:");
		stamLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel agilLabel = new JLabel("Agility: ");
		agilLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(offLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(defLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(stamLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(agilLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(181)
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(offLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(defLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stamLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(agilLabel)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton.isSelected() && maxSize()) {
			tglbtnNewToggleButton.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton.setEnabled(true);
		}
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null); //Add player from array to starters
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton_1.isSelected() && maxSize()) {
			tglbtnNewToggleButton_1.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton_1.setEnabled(true);
		}
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_1.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null);
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton_1.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton_2.isSelected() && maxSize()) {
			tglbtnNewToggleButton_2.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton_2.setEnabled(true);
		}
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_2.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null);
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton_2.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton_3.isSelected() && maxSize()) {
			tglbtnNewToggleButton_3.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton_3.setEnabled(true);
		}
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_3.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null);
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton_3.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_1_1 = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton_1_1.isSelected() && maxSize()) {
			tglbtnNewToggleButton_1_1.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton_1_1.setEnabled(true);
		}
		tglbtnNewToggleButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_1_1.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null);
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton_1_1.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_2_1 = new JToggleButton("Player1");
		if (!tglbtnNewToggleButton_2_1.isSelected() && maxSize()) {
			tglbtnNewToggleButton_2_1.setEnabled(false);
		}
		else {
			tglbtnNewToggleButton_2_1.setEnabled(true);
		}
		tglbtnNewToggleButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_2_1.isSelected() && lessThanMax()) {
					manager.getTeam().addPlayer(null);
					nameLabel.setText(null); //Set name label to athlete name
					offLabel.setText(null);
					defLabel.setText(null);
					stamLabel.setText(null);
					agilLabel.setText(null);
				}
				else if (!tglbtnNewToggleButton_2_1.isSelected()) {
					manager.getTeam().removePlayer(null);
				}
			}
		});
		tglbtnNewToggleButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
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
									.addComponent(tglbtnNewToggleButton_3, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(tglbtnNewToggleButton, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addGap(3)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnNewToggleButton_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnNewToggleButton_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnNewToggleButton_2, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(tglbtnNewToggleButton_2_1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
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
						.addComponent(tglbtnNewToggleButton, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnNewToggleButton_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnNewToggleButton_2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(84)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnNewToggleButton_3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnNewToggleButton_1_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(tglbtnNewToggleButton_2_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(27))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
	
}