package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import main.GameManager;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * This is the GameOverScreen class. This GUI class is the final window shown to
 * the player, and only opens once the player finishes all weeks. The screen
 * shows the players points, money, team name, and duration of the season.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class GameOverScreen {
	/**
	 * The frame of the GameOverScreen.
	 */
	private JFrame frame;
	/**
	 * The current instance of the GameManager object.
	 */
	private GameManager manager;

	/**
	 * Constructs a new GameOverScreen object with the given GameManager.
	 * 
	 * @param gameManager the current instance of the GameManager object
	 */
	public GameOverScreen(GameManager gameManager) {
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
					GameOverScreen window = new GameOverScreen();
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
	public GameOverScreen() {
		initialize();
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Calls closeGameOverScreen within the GameManager object which terminates the
	 * program.
	 */
	public void finishedWindow() {
		manager.closeGameOverScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setForeground(new Color(255, 255, 255));
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblScore = new JLabel("Score: 1");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setText("Score: " + String.valueOf(manager.getScore()));
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMoney = new JLabel("Money: 0");
		lblMoney.setText("Money: " + String.valueOf(manager.getMoney()));
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblTeamname = new JLabel("TeamName");
		lblTeamname.setText(manager.getTeamName());
		lblTeamname.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamname.setForeground(Color.WHITE);
		lblTeamname.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblDurationWeeks = new JLabel("Duration: 7 Weeks");
		lblDurationWeeks.setText("Duration: " + String.valueOf(manager.getNumWeeks()) + " Weeks");
		lblDurationWeeks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDurationWeeks.setForeground(Color.WHITE);
		lblDurationWeeks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(527)
						.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE).addGap(526))
				.addGroup(groupLayout.createSequentialGroup().addGap(547)
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE).addGap(546))
				.addGroup(groupLayout.createSequentialGroup().addGap(527)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTeamname, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(526, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(501)
						.addComponent(lblDurationWeeks, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(501, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(87).addComponent(lblGameOver)
						.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
						.addComponent(lblTeamname, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(lblDurationWeeks, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(108).addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(97)));
		frame.getContentPane().setLayout(groupLayout);
	}

}
