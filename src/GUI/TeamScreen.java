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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.List;

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
	
	public void starterButtonEvent(JToggleButton btn, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil, int index) {
		name.setText(manager.getTeam().getPlayers().get(index).toString()); //Set name label to athlete name
		price.setText("$" + String.valueOf(manager.getTeam().getPlayers().get(index).getPrice()));
		off.setText("Offence: " + String.valueOf(manager.getTeam().getPlayers().get(index).getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(manager.getTeam().getPlayers().get(index).getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(manager.getTeam().getPlayers().get(index).getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(manager.getTeam().getPlayers().get(index).getStat(Athlete.STATS.A)));
	}
	
	public void setStarterButtons(ArrayList<JToggleButton> btns) {
		for (int i=0; i < btns.size();i++) {
			btns.get(i).setText(manager.getMarket().getStarterAthletes().get(i).getName());
		}
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
		
		JLabel nameLabel = new JLabel("Click an item to see description");
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		JLabel priceLabel = new JLabel("");
		priceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
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
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
							.addComponent(priceLabel)
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
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(priceLabel)
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
		
		JPanel panel_1 = new JPanel();
		
		JButton tglBtnPG_5 = new JButton("Make Starter");
		tglBtnPG_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton tglBtnPG_5_2 = new JButton("Use Item");
		tglBtnPG_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton tglBtnPG_6 = new JButton("Back");
		tglBtnPG_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		tglBtnPG_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tglBtnPG_5_2, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addComponent(tglBtnPG_5, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tglBtnPG_6)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(tglBtnPG_5)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tglBtnPG_5_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(tglBtnPG_6))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JList<Athlete> list = new JList<Athlete>();
		list.setModel(new AbstractListModel<Athlete>() {
			ArrayList<Athlete> values = manager.getTeam().getReserves();
			public int getSize() {
				return values.size();
			}
			public Athlete getElementAt(int index) {
				return values.get(index);
			}
		});
		scrollPane.setViewportView(list);
		
		
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
		
		JButton tglBtnPG_5_1 = new JButton("Remove Starter");
		tglBtnPG_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JToggleButton tglBtnPG = new JToggleButton("PG");
		tglBtnPG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(tglBtnPG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 0);
			}
		});
		
		JToggleButton tglBtnSG = new JToggleButton("SG");
		tglBtnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(tglBtnSG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 1);
			}
		});
		
		JToggleButton tglBtnC = new JToggleButton("C");
		tglBtnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(tglBtnC, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 4);
			}
		});
		
		JToggleButton tglBtnSF = new JToggleButton("SF");
		tglBtnSF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(tglBtnSF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 2);
			}
		});
		
		JToggleButton tglBtnPF = new JToggleButton("PF");
		tglBtnPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(tglBtnPF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 3);
			}
		});
		
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
								.addComponent(tglBtnPG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addGap(54)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(tglBtnSG, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addComponent(lblShootingGuard, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenter, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(tglBtnC, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tglBtnPG_5_1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSmallForward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(tglBtnSF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
									.addGap(50)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPowerForward, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
										.addComponent(tglBtnPF, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
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
						.addComponent(tglBtnPG, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(tglBtnSG, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(tglBtnC, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblSmallForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tglBtnSF, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPowerForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tglBtnPF, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(90)
					.addComponent(tglBtnPG_5_1))
		);
		
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		
		ArrayList<JToggleButton> starters = new ArrayList<JToggleButton>();
		starters.add(tglBtnPG);
		starters.add(tglBtnSG);
		starters.add(tglBtnSF);
		starters.add(tglBtnPF);
		starters.add(tglBtnC);
		setStarterButtons(starters);


	}
}
