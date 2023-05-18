package GUI;
import main.*;
import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GameManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GameScreen {

	private JFrame frame;
	private GameManager manager;
	public GameScreen(GameManager gameManager) {
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
					GameScreen window = new GameScreen();
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
	public GameScreen() {
		initialize();
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeGameScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_3 = new JLabel("New label");
		lblNewLabel_3_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		lblNewLabel_3_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_5 = new JLabel("New label");
		lblNewLabel_3_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_6 = new JLabel("New label");
		lblNewLabel_3_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_7 = new JLabel("New label");
		lblNewLabel_3_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_8 = new JLabel("New label");
		lblNewLabel_3_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_9 = new JLabel("New label");
		lblNewLabel_3_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(411)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3_8, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3_9, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3_6, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3_7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(134)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(411))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(1131))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_7, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_8, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_9, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(525, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Player");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Opponent");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(142)
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
							.addGap(224)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
