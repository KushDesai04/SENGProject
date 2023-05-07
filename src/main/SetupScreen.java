package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;

public class SetupScreen {

	private JFrame frame;
	private JTextField txtTeamName;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTeamName = new JTextField();
		txtTeamName.setForeground(new Color(0, 0, 0));
		txtTeamName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamName.setText("name");
		txtTeamName.setBounds(290, 204, 596, 75);
		frame.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select Team Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(487, 160, 224, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDifficulty.setBounds(528, 342, 131, 34);
		frame.getContentPane().add(lblDifficulty);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Hard"}));
		comboBox.setBounds(538, 388, 117, 48);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(941, 485, 195, 48);
		frame.getContentPane().add(btnNewButton);
	}
}
