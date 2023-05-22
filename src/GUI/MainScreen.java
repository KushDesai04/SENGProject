package GUI;

import main.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.naming.ldap.ManageReferralControl;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * This is the Main Screen class. The main screen will allow players to access
 * the stadium, shop, and their their Team of players, as well as go back to the start screen
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class MainScreen {

	private JFrame frame;
	private GameManager manager;

	public MainScreen(GameManager gameManager) {
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
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow(GameManager.GOTOSCREEN screen) {
		manager.closeMainScreen(this, screen);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GameManager.GOTOSCREEN.SHOP);
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GameManager.GOTOSCREEN.STADIUM);
			}
		});
		btnStadium.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnTeam = new JButton("Team");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GameManager.GOTOSCREEN.TEAM);
			}
		});
		btnTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GameManager.GOTOSCREEN.MAIN);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblWeeksRemaining = new JLabel("Weeks Remaining: 10");
		lblWeeksRemaining.setText("Weeks Remaining: " + String.valueOf((manager.getNumWeeks() - manager.getCurrentWeek())));
		lblWeeksRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeeksRemaining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblWeeksRemaining, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(lblWeeksRemaining, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
					.addGap(8))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(262)
							.addComponent(btnShop, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStadium, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addGap(944)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShop, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
								.addComponent(btnStadium, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
								.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
							.addGap(81))))
		);
		
		JLabel lblCurrentWeek = new JLabel("Week: 30");
		lblCurrentWeek.setText("Week: " + String.valueOf(manager.getCurrentWeek()));
		lblCurrentWeek.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentWeek.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCurrentWeek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(lblCurrentWeek, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addGap(8))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
