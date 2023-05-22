package GUI;

import main.*;
import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

import org.junit.validator.PublicClassValidator;

import java.awt.event.ActionListener;
import java.util.concurrent.Flow.Publisher;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * This is the Setup Screen class. This screen will 
 * allow players to purchase their first 5 athletes so 
 * that they can start the game. Players are given an
 * option to choose 5 from 6 players and the players
 * are generated mostly randomly.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class SetupScreen {

	private JFrame frame;
	private JTextField txtTeamName;
	private GameManager manager;

	public SetupScreen(GameManager gameManager) {
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
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
		initialize();
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		manager.closeGameSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtTeamName = new JTextField();
		txtTeamName.setForeground(new Color(0, 0, 0));
		txtTeamName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Team Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTeamName.getText().length() >= 3 && txtTeamName.getText().length() <= 15) {
					manager.setTeamName(txtTeamName.getText());
					String name = txtTeamName.getText();
					if (!name.isBlank() && name.matches("([a-zA-Z]+[ ]*)+")) {
						finishedWindow();
					} else {
						String message = "No special characters are allowed in the team name"
								+ "\n and name should be between 3-15 characters long";
						JOptionPane.showMessageDialog(new JFrame(), message, "Name Selection Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				else {
					String message = "Please enter a team name that is between 3 and 15 characters long";
					JOptionPane.showMessageDialog(new JFrame(), message, "Name Selection Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(481)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE).addGap(481))
				.addGroup(groupLayout.createSequentialGroup().addGap(254)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(47).addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addGap(13))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(254)
						.addComponent(txtTeamName, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE).addGap(253)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(496).addComponent(btnNewButton,
								GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(112)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(53).addComponent(txtTeamName, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
								.addGap(79).addComponent(panel, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(14)));

		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox<String> difficultyComboBox = new JComboBox<String>();
		if (difficultyComboBox.getSelectedIndex() == -1) {
			manager.setDifficulty("Easy");
		}
		difficultyComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setDifficulty(difficultyComboBox.getSelectedItem().toString());
			}
		});
		difficultyComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Easy", "Hard" }));

		JLabel lblSeasonLength = new JLabel("Season Length (weeks):");
		lblSeasonLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeasonLength.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				manager.setNumWeeks(slider.getValue());
			}
		});
		slider.setMinimum(5);
		slider.setMajorTickSpacing(5);
		slider.setToolTipText("Weeks");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(15);
		slider.setValue(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(230)
										.addComponent(lblSeasonLength, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(31))
								.addGroup(
										gl_panel.createSequentialGroup().addGap(198).addComponent(
												slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addGap(256)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addGap(10)
														.addComponent(difficultyComboBox, 0, 75, Short.MAX_VALUE))
												.addComponent(lblDifficulty, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addGap(57)))
						.addGap(198)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(8).addComponent(lblDifficulty)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(difficultyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(39).addComponent(lblSeasonLength).addGap(9)
				.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
