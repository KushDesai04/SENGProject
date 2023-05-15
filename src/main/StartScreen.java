package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.w3c.dom.html.HTMLFrameSetElement;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;

import javax.swing.JPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the Start Screen class. The start screen
 * is the first screen that opens when the game begins.
 * The only options are to start the game, or quit.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class StartScreen {

	private JFrame frame;
	private GameManager manager;
	
	public StartScreen(GameManager gameManager) {
		// TODO Auto-generated constructor stub
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
					StartScreen window = new StartScreen();
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
	public StartScreen() {
		initialize();
	}

	
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeStartScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Basketball Manager");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(451)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addGap(451))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(146)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(146))
		);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_1_1 = new JPanel();
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnQuit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnQuit.setAlignmentX(0.5f);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addGap(45))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(107)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(108))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(107)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
					.addGap(108))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel)
					.addGap(38)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(23))
		);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1_1.createSequentialGroup()
					.addGap(14)
					.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}
