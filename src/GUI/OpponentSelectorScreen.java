package GUI;
import main.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OpponentSelectorScreen {

	private JFrame frame;
	private GameManager manager;
	
	public OpponentSelectorScreen(GameManager gameManager) {
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
					OpponentSelectorScreen window = new OpponentSelectorScreen();
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
	public OpponentSelectorScreen() {
		initialize();
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeOpponentSelectorScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchStadiumScreen();
				finishedWindow();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JList list = new JList();
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!manager.getTeam().canPlay()) {
					String message = "Not all starters are ready!";
					    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
				else {
					manager.launchGameScreen();
					finishedWindow();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("Choose a team to play against");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(955)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(29))
		);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblTeamName = new JLabel("team name");
		lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPlayer1 = new JLabel("name, position, ovr");
		lblPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPlayer2 = new JLabel("name, position, ovr");
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPlayer3 = new JLabel("name, position, ovr");
		lblPlayer3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPlayer4 = new JLabel("name, position, ovr");
		lblPlayer4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPlayer5 = new JLabel("name, position, ovr");
		lblPlayer5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTeamName, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(244))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(300))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer4, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(79)
					.addComponent(lblTeamName, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayer1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayer3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayer4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayer5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(158))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
