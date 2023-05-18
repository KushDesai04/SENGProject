package GUI;

import main.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * This is the Stadium Screen class. The stadium screen will allow players to
 * access the stadium which is where players can find and select matches to
 * play, or take a bye. Each week, the opponents will change and become more
 * difficult
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */

public class StadiumScreen {
	private JFrame frame;
	private GameManager manager;

	public StadiumScreen(GameManager gameManager) {
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
					StadiumScreen window = new StadiumScreen();
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
	public StadiumScreen() {
		initialize();
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		manager.closeStadiumScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnPlay = new JButton("Play Match");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.LaunchOpponentSelectorScreen();
				finishedWindow();
			}
		});
		// TODO: Implement gameplay and GUI
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnBye = new JButton("Take a Bye");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.incrementWeek();
				manager.launchMainScreen();
				finishedWindow();
			}
		});
		btnBye.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnBack = new JButton("<");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchMainScreen();
				finishedWindow();
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(875))
								.addGroup(groupLayout.createSequentialGroup().addGap(258)
										.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE).addGap(6)
										.addComponent(btnBye, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
						.addGap(121).addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnBack).addGap(151)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBye, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190,
												Short.MAX_VALUE)
										.addComponent(btnPlay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190,
												Short.MAX_VALUE))
								.addGap(187)))));

		JLabel lblCurrentWeek = new JLabel(String.format("Week: %d", manager.getCurrentWeek()));

		lblCurrentWeek.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblCurrentWeek, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblCurrentWeek,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
