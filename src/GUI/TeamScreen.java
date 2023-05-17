package GUI;
import main.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the Team Screen class. The team screen will 
 * allow players to access their team and make changes such 
 * as: selecting the starting lineup, selling players,
 * using consumables to boost player stats.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class TeamScreen {

	private JFrame frame;
	private GameManager manager;
	
	public TeamScreen(GameManager gameManager) {
		manager = gameManager;
		initialize();
		frame.setVisible(true);
	}
	/**
	 * Close window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Give control back to game manager
	 */
	public void finishedWindow() {
		manager.closeTeamScreen(this);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamScreen window = new TeamScreen();
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
	public TeamScreen() {
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
		panel.setBackground(Color.WHITE);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblClickAnItem = new JLabel("Click an item to see description");
		lblClickAnItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel ovrLabel = new JLabel("");
		ovrLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel agilValue = new JLabel("");
		agilValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel offValue = new JLabel("");
		offValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel stamValue = new JLabel("");
		stamValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel defValue = new JLabel("");
		defValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 391, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblClickAnItem, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
							.addComponent(ovrLabel)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(agilValue)
						.addComponent(offValue)
						.addComponent(stamValue)
						.addComponent(defValue))
					.addContainerGap(385, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 397, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(181)
					.addComponent(lblClickAnItem, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(ovrLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(offValue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(defValue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stamValue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(agilValue)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton_5 = new JButton("Make Starter");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_5_2 = new JButton("Use Item");
		btnNewButton_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addComponent(btnNewButton_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addComponent(btnNewButton_5_2, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_6)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnNewButton_5)
							.addGap(1)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_5_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_6))
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JToggleButton btnNewButton = new JToggleButton("New button");
		
		JToggleButton btnNewButton_1 = new JToggleButton("New button");
		
		JToggleButton btnNewButton_2 = new JToggleButton("New button");
		
		JToggleButton btnNewButton_3 = new JToggleButton("New button");
		
		JToggleButton btnNewButton_4 = new JToggleButton("New button");
		
		JLabel lblPointGuard = new JLabel("Point Guard");
		lblPointGuard.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStarters.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblShootingGuard = new JLabel("Shooting Guard");
		lblShootingGuard.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSmallForward = new JLabel("Small Forward");
		lblSmallForward.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPowerForward = new JLabel("Power Forward");
		lblPowerForward.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_5_1 = new JButton("Remove Starter");
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(lblStarters, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPointGuard, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addGap(54)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addComponent(lblShootingGuard, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenter, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_5_1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSmallForward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
									.addGap(50)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPowerForward, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
										.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
							.addGap(50)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStarters, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPointGuard, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblCenter, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblShootingGuard, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblSmallForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPowerForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(90)
					.addComponent(btnNewButton_5_1))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
