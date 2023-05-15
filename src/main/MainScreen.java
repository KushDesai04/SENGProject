package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

/**
 * This is the Main Screen class. The main screen will 
 * allow players to access the stadium, shop, and their their
 * Team of players (as well as quit the game)
 * 
 * @author Kush Desai
 * @author Yunu Cho
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
	public void finishedWindow(GOTOSCREEN screen) {
		manager.closeMainScreen(this, screen);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GOTOSCREEN.SHOP);
			}
		});
		btnShop.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GOTOSCREEN.STADIUM);
			}
		});
		btnStadium.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnTeam = new JButton("Team");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TEAM");
				finishedWindow(GOTOSCREEN.TEAM);
			}
		});
		btnTeam.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnBack = new JButton("Quit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(GOTOSCREEN.QUIT);
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(262)
					.addComponent(btnShop, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStadium, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(210))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(1133))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShop, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(btnStadium, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addGap(81))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
