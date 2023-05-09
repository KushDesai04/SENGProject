package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

public class TeamSetupScreen {

	private JFrame frame;

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
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Player1");
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Player1");
		tglbtnNewToggleButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Player1");
		tglbtnNewToggleButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Player1");
		tglbtnNewToggleButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_1_1 = new JToggleButton("Player1");
		tglbtnNewToggleButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglbtnNewToggleButton_2_1 = new JToggleButton("Player1");
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
