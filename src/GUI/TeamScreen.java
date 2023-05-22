package GUI;
import main.*;

import java.util.regex.*;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;

/**
 * This is the TeamScreen class. The team screen will 
 * allow players to access their Team and make changes such 
 * as: Selecting the starting lineup, selling players, and
 * using consumables to increase player stats.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class TeamScreen {
	/**
	 * The frame of the GameOverScreen.
	 */
	private JFrame frame;
	/**
	 * The current instance of the GameManager object.
	 */
	private GameManager manager;
	/**
	 * The list that contains the JButtons that correspond to the starting Athletes.
	 */
	private ArrayList<JButton> starters = new ArrayList<JButton>();
	/**
	 * The last selected starting Athlete.
	 */
	private Athlete lastSelectedAthlete;
	/**
	 * The last selected reserve Athlete.
	 */
	private Athlete lastSelectedReserve;
	/**
	 * The last selected Item.
	 */
	private Item lastSelectedItem;
	/**
	 * The JTextField to set an Athlete's nickname.
	 */
	private JTextField textNickname;
	
	/**
	 * Constructs a new TeamScreen object with the given GameManager.
	 * @param gameManager the current instance of the GameManager object
	 */
	public TeamScreen(GameManager gameManager) {
		manager = gameManager;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Calls closeTeamScreen within the GameManager object which opens the next window.
	 */
	public void finishedWindow() {
		manager.closeTeamScreen(this);
	}
	
	/**
	 * Displays the information of the selected Athlete in the starting lineup when its corresponding JButton 
	 * is pressed.
	 * @param btn    		the selected JButton
	 * @param pos    		the label displaying the position of the Athlete
	 * @param name   		the label displaying the name of the Athlete
	 * @param price	 		the label displaying the price of the Athlete
	 * @param off    		the label displaying the offence stat of the Athlete
	 * @param def    		the label displaying the defence stat of the Athlete
	 * @param stam   		the label displaying the stamina stat of the Athlete
	 * @param agil   		the label displaying the agility stat of the Athlete
	 * @param itemList 		the JList containing the items owned by the team
	 * @param reservesList 	the JList containing the reserve Athletes
	 * @param currStam		the label displaying the current stamina of the Athlete
	 */
	public void starterButtonEvent(JButton btn, Athlete.POSITION pos, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil, JList<Item> itemList, JList<Athlete> reserveList, JLabel currStam) {
        
		Athlete athlete = manager.getTeam().getPlayersMap().get(pos);
		name.setText(athlete.toString()); //Set name label to athlete name
		price.setText("$" + String.valueOf(athlete.getPrice()));
		off.setText("Offence: " + String.valueOf(athlete.getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(athlete.getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(athlete.getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(athlete.getStat(Athlete.STATS.A)));
		currStam.setText("Current Stamina: " + String.valueOf(athlete.getCurrentStamina()));
		lastSelectedAthlete = athlete;
		for (JButton starterBtn : starters) {
			starterBtn.setForeground(Color.black);
		}
		btn.setForeground(Color.red);
		itemList.clearSelection();
		reserveList.clearSelection();
		
	}
	
	/**
	 * Refreshes the labels to display the information of the given Athlete when its corresponding JButton 
	 * is pressed or its corresponding JList entry is selected.
	 * @param athlete		the Athlete whose information will be displayed
	 * @param name   		the label displaying the name of the Athlete
	 * @param price	 		the label displaying the price of the Athlete
	 * @param off    		the label displaying the offence stat of the Athlete
	 * @param def    		the label displaying the defence stat of the Athlete
	 * @param stam   		the label displaying the stamina stat of the Athlete
	 * @param agil   		the label displaying the agility stat of the Athlete
	 * @param itemList 		the JList containing the Items owned by the Team
	 * @param reservesList 	the JList containing the reserve Athletes
	 */
	public void refreshLabels(Athlete athlete, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil, JLabel currStam) {
		
		name.setText(athlete.toString()); //Set name label to athlete name
		price.setText("$" + String.valueOf(athlete.getPrice()));
		off.setText("Offence: " + String.valueOf(athlete.getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(athlete.getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(athlete.getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(athlete.getStat(Athlete.STATS.A)));
		currStam.setText("Current Stamina: " + String.valueOf(athlete.getCurrentStamina()));
	}
	
	/**
	 * Refreshes the labels to display the information of the given Item when its corresponding JList entry is selected.
	 * @param item		the Item which will have its information displayed
	 * @param name   	the label displaying the name of the Item
	 * @param price		the label displaying the price of the Item
	 * @param off    	the label displaying the offence stat of the Athlete, which will be set to display the description of the Item
	 * @param def    	the label displaying the defence stat of the Athlete, which will be set to blank
	 * @param stam   	the label displaying the stamina stat of the Athlete, which will be set to blank
	 * @param agil   	the label displaying the agility stat of the Athlete, which will be set to blank
	 * @param currStam 	the label displaying the current stamina of the Athlete, which will be set to blank
	 */
	public void refreshItemLabels(Item item, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam, JLabel agil, JLabel currStam) {
		
		name.setText(item.toString()); 
		price.setText("$" + String.valueOf(item.getPrice()));
		off.setText(item.getDescription());
		def.setText("");
		stam.setText("");
		agil.setText("");
		currStam.setText("");
	}
	
	/**
	 * Sets starter buttons to display the information of the current starting Athletes.
	 * @param btns list of buttons that need to be changed
	 */
	public void setStarterButtons(ArrayList<JButton> btns) {
		
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
		
		JLabel currStamValue= new JLabel("");
		currStamValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		
		JScrollPane scrollPane = new JScrollPane();
		JList<Athlete> reservesList = new JList<Athlete>();
		reservesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lastSelectedReserve = reservesList.getSelectedValue();
				if (lastSelectedReserve instanceof Athlete) {
				    refreshLabels(lastSelectedReserve, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, currStamValue);
				}
			}
			
		});
		reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservesList.setModel(new AbstractListModel<Athlete>() {
			ArrayList<Athlete> values = manager.getTeam().getReserves();
			public int getSize() {
				return values.size();
			}
			public Athlete getElementAt(int index) {
				return values.get(index);
			}
		});
		scrollPane.setViewportView(reservesList);
		
		JButton tglBtnPG_5 = new JButton("Make Starter");
		tglBtnPG_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tglBtnPG_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete = reservesList.getSelectedValue();
				lastSelectedReserve = athlete;
				
				try {
					manager.getTeam().replacePlayer(athlete, manager.getTeam().getPlayersMap().get(athlete.getPosition()));
					reservesList.clearSelection();
					reservesList.revalidate();
					reservesList.repaint();
					scrollPane.revalidate();
					scrollPane.repaint();
					setStarterButtons(starters);
				}
				catch (NullPointerException error) {

			    	String message = "Please select a Reserve Player first!";
			    	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Scroll pane with items in it
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
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lastSelectedItem = itemList.getSelectedValue();
				if (lastSelectedItem instanceof Item) {
				    refreshItemLabels(lastSelectedItem, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, currStamValue);
				}
			}
			
		});
		scrollPane_1.setViewportView(itemList);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
							.addComponent(priceLabel)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(agilValue)
						.addComponent(offValue)
						.addComponent(stamValue)
						.addComponent(defValue)
						.addComponent(currStamValue, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currStamValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton tglBtnPG_5_2 = new JButton("Use Item");
		tglBtnPG_5_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tglBtnPG_5_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Item item = itemList.getSelectedValue();
					item.consume(lastSelectedAthlete);
					manager.getTeam().removeItem(item);

					itemList.clearSelection();
					itemList.revalidate();
					itemList.repaint();
					scrollPane_1.revalidate();
					scrollPane_1.repaint();
					setStarterButtons(starters);
        		}
        		catch (NullPointerException error) {
        			String message = "Please select a starter first!";
			    	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
        		}
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
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lastSelectedItem = itemList.getSelectedValue();
					if (lastSelectedItem instanceof Item) {
						String message = "Are you sure? This cannot be undone!";
					    int result = JOptionPane.showConfirmDialog(new JFrame(), message, "Sell Item",
					        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					    if (result == JOptionPane.YES_OPTION) {
					    	lastSelectedItem = itemList.getSelectedValue();
					    	manager.getTeam().sellConsumable(lastSelectedItem);
					    	manager.changeMoney(lastSelectedItem.getPrice()*3/4);
					    	itemList.clearSelection();
							itemList.revalidate();
							itemList.repaint();
							scrollPane.revalidate();
							scrollPane.repaint();
					    }
					}
				}
				catch (NullPointerException error) {
					String message = "Please select an Item first!";
			    	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSellItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSellAthlete = new JButton("Sell Athlete");
		btnSellAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
				    lastSelectedReserve = reservesList.getSelectedValue();
				    if (lastSelectedReserve instanceof Athlete) {
					    String message = "Are you sure? This cannot be undone!";
						int result = JOptionPane.showConfirmDialog(new JFrame(), message, "Sell Athlete",
						    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
						    manager.getTeam().sellPlayer(lastSelectedReserve);
						    manager.changeMoney(lastSelectedReserve.getPrice()*3/4);
						    reservesList.clearSelection();
							reservesList.revalidate();
							reservesList.repaint();
							scrollPane.revalidate();
							scrollPane.repaint();
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
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		
		JButton btnSetName = new JButton("Set Name");
		btnSetName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSetName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textNickname.getText();
				if (lastSelectedAthlete instanceof Athlete) {
					if (name.length() == 0 | !name.matches("([a-zA-Z]+[ ]*)+")) {
						String message = "The name cannot be empty nor contain any special characters!";
			    	    JOptionPane.showMessageDialog(new JFrame(), message, "Name Change Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
					    lastSelectedAthlete.setNickname(name);
					    setStarterButtons(starters);
					    refreshLabels(lastSelectedAthlete, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, currStamValue);
				    }
				}
				
				else {
				    String message = "Please select a Starter Player first!";
		    	    JOptionPane.showMessageDialog(new JFrame(), message, "Name Change Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tglBtnPG_5, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSellAthlete, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tglBtnPG_5_2, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSellItem, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addComponent(tglBtnPG_6, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textNickname, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSetName)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tglBtnPG_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSellAthlete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSellItem, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(tglBtnPG_5_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textNickname)
								.addComponent(btnSetName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
							.addComponent(tglBtnPG_6))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
				starterButtonEvent(btnPG, Athlete.POSITION.PG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, itemList, reservesList, currStamValue);
			}
		});
		
		JButton btnSG = new JButton("SG");
		btnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnSG, Athlete.POSITION.SG, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, itemList, reservesList, currStamValue);
			}
		});
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnC, Athlete.POSITION.C, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, itemList, reservesList, currStamValue);
			}
		});
		
		JButton btnSF = new JButton("SF");
		btnSF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnSF, Athlete.POSITION.SF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, itemList, reservesList, currStamValue);
			}
		});
		
		JButton btnPF = new JButton("PF");
		btnPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starterButtonEvent(btnPF, Athlete.POSITION.PF, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, itemList, reservesList, currStamValue);
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
