package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JList;
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
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtTeamName = new JTextField();
		txtTeamName.setForeground(new Color(0, 0, 0));
		txtTeamName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select Team Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setTeamName(txtTeamName.getText());
				finishedWindow();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(481)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(481))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(295)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
						.addComponent(txtTeamName, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
					.addGap(80)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(txtTeamName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(490, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		
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
		difficultyComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Easy", "Hard"}));
		
		JLabel lblSeasonLength = new JLabel("Season Length (weeks):");
		lblSeasonLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeasonLength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JSlider slider = new JSlider();
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
		slider.setMaximum(30);
		slider.setValue(30);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(230)
							.addComponent(lblSeasonLength, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(31))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(198)
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(256)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(difficultyComboBox, 0, 75, Short.MAX_VALUE))
								.addComponent(lblDifficulty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(57)))
					.addGap(198))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(lblDifficulty)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(difficultyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblSeasonLength)
					.addGap(9)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
}
