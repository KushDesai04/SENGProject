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

import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNull;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private ArrayList<JButton> starters = new ArrayList<JButton>();
	private Athlete lastSelectedAthlete;
	private Athlete lastSelectedReserve;
	private Item lastSelectedItem;
	
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
	
	public void starterButtonEvent(JButton btn, Athlete.POSITION pos, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil, int index) {
        Athlete athlete = manager.getTeam().getPlayersMap().get(pos);
		name.setText(athlete.toString()); //Set name label to athlete name
		price.setText("$" + String.valueOf(athlete.getPrice()));
		off.setText("Offence: " + String.valueOf(athlete.getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(athlete.getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(athlete.getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(athlete.getStat(Athlete.STATS.A)));
		lastSelectedAthlete = athlete;
		for (JButton starterBtn : starters) {
			starterBtn.setForeground(Color.black);
		}
		btn.setForeground(Color.red);
	}
	public void refreshLabels(Athlete lastSelectedAthlete, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil) {
        Athlete athlete = manager.getTeam().getPlayersMap().get(lastSelectedAthlete.getPosition());
		name.setText(athlete.toString()); //Set name label to athlete name
		price.setText("$" + String.valueOf(athlete.getPrice()));
		off.setText("Offence: " + String.valueOf(athlete.getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(athlete.getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(athlete.getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(athlete.getStat(Athlete.STATS.A)));
	}
	public void setStarterButtons(ArrayList<JButton> btns) {
//		System.out.println(manager.getTeam().getPlayersMap());
		btns.get(0).setText(String.valueOf(manager.getTeam().getPlayersMap().get(Athlete.POSITION.PG).getName()));
		btns.get(1).setText(String.valueOf(manager.getTeam().getPlayersMap().get(Athlete.POSITION.SG).getName()));
		btns.get(2).setText(String.valueOf(manager.getTeam().getPlayersMap().get(Athlete.POSITION.C).getName()));
		btns.get(3).setText(String.valueOf(manager.getTeam().getPlayersMap().get(Athlete.POSITION.SF).getName()));
		btns.get(4).setText(String.valueOf(manager.getTeam().getPlayersMap().get(Athlete.POSITION.PF).getName()));
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
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JSeparator separator = new JSeparator();
		
		JLabel nameLabel = new JLabel("Click an item to see its description");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel priceLabel = new JLabel("");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel agilValue = new JLabel("");
		agilValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel offValue = new JLabel("");
		offValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel stamValue = new JLabel("");
		stamValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel defValue = new JLabel("");
		defValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		
		JScrollPane scrollPane = new JScrollPane();
		JList<Athlete> athleteList = new JList<Athlete>();
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setModel(new AbstractListModel<Athlete>() {
			ArrayList<Athlete> values = manager.getTeam().getReserves();
			public int getSize() {
				return values.size();
			}
			public Athlete getElementAt(int index) {
				return values.get(index);
			}
		});
		scrollPane.setViewportView(athleteList);
		
		JButton tglBtnPG_5 = new JButton("Make Starter");
		tglBtnPG_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglBtnPG_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete = athleteList.getSelectedValue();
				
				
//				System.out.println(athlete);
				try {
				manager.getTeam().replacePlayer(athlete, manager.getTeam().getPlayersMap().get(athlete.getPosition()));
				lastSelectedAthlete = athlete;
				JList<Athlete> athletelist = new JList<Athlete>();
				athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				athleteList.setModel(new AbstractListModel<Athlete>() {
					ArrayList<Athlete> values = manager.getTeam().getReserves();
					public int getSize() {
						return values.size();
					}
					public Athlete getElementAt(int index) {
						return values.get(index);
					}
				});
				athleteList.clearSelection();
				athleteList.revalidate();
				athleteList.repaint();
				scrollPane.revalidate();
				scrollPane.repaint();
				refreshLabels(lastSelectedAthlete, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue);
				setStarterButtons(starters);
				}
				catch (NullPointerException error) {
			    	String message = "Please select a Reserve Player first!";
			    	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		JList<Item> itemList = new JList<Item>();
		
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setModel(new AbstractListModel<Item>() {
			ArrayList<Item> values = manager.getTeam().getItems();
			public int getSize() {
				return values.size();
			}
			public Item getElementAt(int index) {
				return values.get(index);
			}
		});
		scrollPane_1.setViewportView(itemList);
		
		JButton btnSellAthlete = new JButton("Sell Athlete");
		btnSellAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
				    	lastSelectedReserve = athleteList.getSelectedValue();
				    	if (lastSelectedAthlete instanceof Athlete) {
					    	String message = "Are you sure? This cannot be undone!";
						    int result = JOptionPane.showConfirmDialog(new JFrame(), message, "Sell Athlete",
						        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						    if (result == JOptionPane.YES_OPTION) {
					    	manager.getTeam().sellPlayer(lastSelectedReserve);
					    	manager.changeMoney(lastSelectedReserve.getPrice()*3/4);
					    }
						
						else {
							throw new NullPointerException();
						}
			    	}
			    }
			    	
			    catch (NullPointerException error) {
			    	String message = "Please select an Athlete first!";
			    	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
		    }
		});
		
		btnSellAthlete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Are you sure? This cannot be undone!";
			    int result = JOptionPane.showConfirmDialog(new JFrame(), message, "Sell Item",
			        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			    if (result == JOptionPane.YES_OPTION) {
			    	lastSelectedItem = itemList.getSelectedValue();
			    	manager.getTeam().sellConsumable((lastSelectedItem));
			    	manager.changeMoney(lastSelectedItem.getPrice()*3/4);
			    }
			}
		});
		btnSellItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
							.addComponent(priceLabel)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(agilValue)
						.addComponent(offValue)
						.addComponent(stamValue)
						.addComponent(defValue))
					.addContainerGap(319, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSellItem, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSellAthlete, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
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
					.addGap(111)
					.addComponent(btnSellAthlete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSellItem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JButton tglBtnPG_5_2 = new JButton("Use Item");
		tglBtnPG_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tglBtnPG_5_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Item item = itemList.getSelectedValue();
				
				System.out.println(item);
				item.consume(lastSelectedAthlete);
				manager.getTeam().removeItem(item);
				
				JList<Item> itemList = new JList<Item>();
				itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				itemList.setModel(new AbstractListModel<Item>() {
					ArrayList<Item> values = manager.getTeam().getItems();
					public int getSize() {
						return values.size();
					}
					public Item getElementAt(int index) {
						return values.get(index);
					}
				});
				itemList.clearSelection();
				itemList.revalidate();
				itemList.repaint();
				scrollPane_1.revalidate();
				scrollPane_1.repaint();
				refreshLabels(lastSelectedAthlete, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue);
				setStarterButtons(starters);
			}
			}
		);
		
		JButton tglBtnPG_6 = new JButton("Back");
		tglBtnPG_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		tglBtnPG_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
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
		
		
		JLabel lblPointGuard = new JLabel("Point Guard");
		lblPointGuard.setForeground(new Color(255, 255, 255));
		lblPointGuard.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setForeground(new Color(255, 255, 255));
		lblStarters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStarters.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblShootingGuard = new JLabel("Shooting Guard");
		lblShootingGuard.setForeground(new Color(255, 255, 255));
		lblShootingGuard.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setForeground(new Color(255, 255, 255));
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSmallForward = new JLabel("Small Forward");
		lblSmallForward.setForeground(new Color(255, 255, 255));
		lblSmallForward.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPowerForward = new JLabel("Power Forward");
		lblPowerForward.setForeground(new Color(255, 255, 255));
		lblPowerForward.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnPG = new JButton("PG");
		btnPG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnPG, Athlete.POSITION.PG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 0);
			}
		});
		
		JButton btnSG = new JButton("SG");
		btnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnSG, Athlete.POSITION.SG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 1);
			}
		});
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnC, Athlete.POSITION.C, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 4);
			}
		});
		
		JButton btnSF = new JButton("SF");
		btnSF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnSF, Athlete.POSITION.SF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 2);
			}
		});
		
		JButton btnPF = new JButton("PF");
		btnPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnPF, Athlete.POSITION.PF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 3);
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(lblStarters, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPointGuard, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(btnPG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addGap(54)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSG, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addComponent(lblShootingGuard, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenter, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(btnC, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSmallForward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(btnSF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
							.addGap(50)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPowerForward, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(btnPF, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
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
						.addComponent(lblPointGuard, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(lblCenter, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(lblShootingGuard, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPG, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnSG, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnC, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblSmallForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSF, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPowerForward, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPF, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(123))
		);
		
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		
		starters.add(btnPG);
		starters.add(btnSG);
		starters.add(btnC);
		starters.add(btnSF);
		starters.add(btnPF);
		setStarterButtons(starters);


	}
}
