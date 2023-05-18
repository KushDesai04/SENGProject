package GUI;
import main.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.naming.ldap.ManageReferralControl;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.junit.validator.PublicClassValidator;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.desktop.AboutHandler;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale.Category;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

/**
 * This is the Team Setup Screen class. This screen will 
 * allow players to purchase their first 5 athletes so 
 * that they can start the game. Players are given an
 * option to choose 5 from 6 players and the players
 * are generated mostly randomly.
 * 
 * @author Kush Desai
 * @author Yunu Cho
 * 
 */
public class ShopScreen {

	private JFrame frame;
	private GameManager manager;
	private Object consumable;
	private JButton bought;
	private ArrayList<JButton> athleteBtns = new ArrayList<JButton>();
	private ArrayList<JButton> itemBtns = new ArrayList<JButton>();
	
	/**
	 * Constructor
	 * @param gameManager    The GameManager object that controls the game logic
	 */
	public ShopScreen(GameManager gameManager) {
		manager = gameManager;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 * @param args args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen window = new ShopScreen();
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
	public ShopScreen() {
		initialize();
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
		manager.closeShopScreen(this);
	}
	
	/**
	 * When a toggle button is pressed to select a player, this method is run
	 * The method displays the information of the selected player in a panel.
	 * 
	 * If the toggle button is deselected, the player is removed from the team
	 * 
	 * @param btn    the toggled button
	 * @param pos    the position of the player
	 * @param name   the name of the player
	 * @param ovr    the overall stat of the player
	 * @param off    the offence stat of the player
	 * @param def    the defence stat of the player
	 * @param stam   the stamina stat of the player
	 * @param agil   the agility stat of the player
	 * @param index  the index of the player in the team
	 */
	public void athleteButtonEvent(JButton btn, JLabel name, JLabel ovr, JLabel off, JLabel def, JLabel stam, JLabel agil, int index) {
		name.setText(manager.getMarket().getPurchasableAthletes().get(index).toString()); //Set name label to athlete name
		ovr.setText("$" + String.valueOf(manager.getMarket().getPurchasableAthletes().get(index).getPrice()));
		off.setText("Offence: " + String.valueOf(manager.getMarket().getPurchasableAthletes().get(index).getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(manager.getMarket().getPurchasableAthletes().get(index).getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(manager.getMarket().getPurchasableAthletes().get(index).getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(manager.getMarket().getPurchasableAthletes().get(index).getStat(Athlete.STATS.A)));
		consumable = manager.getMarket().getPurchasableAthletes().get(index);
		bought = btn;
		for (JButton athleteBtn: athleteBtns) {
			athleteBtn.setForeground(Color.black);
		}
		
		for (JButton itemBtn: itemBtns) {
			itemBtn.setForeground(Color.black);
		}
		
		btn.setForeground(Color.red);
	}
	
	public void itemButtonEvent(JButton btn, JLabel name, JLabel ovr, JLabel off, JLabel def, JLabel stam, JLabel agil, int index) {
		
		name.setText(manager.getMarket().getPurchasableItems().get(index).getName()); //Set name label to athlete name
		ovr.setText("$" + String.valueOf(manager.getMarket().getPurchasableItems().get(index).getPrice()));
		off.setText(String.valueOf(manager.getMarket().getPurchasableItems().get(index).getDescription()));
		def.setText("");
		stam.setText("");
		agil.setText("");
		consumable = manager.getMarket().getPurchasableItems().get(index);
		bought = btn;
		
		for (JButton athleteBtn: athleteBtns) {
			athleteBtn.setForeground(Color.black);
		}
		
		for (JButton itemBtn: itemBtns) {
			itemBtn.setForeground(Color.black);
		}
		btn.setForeground(Color.red);
	}

	public Athlete returnAthlete(int index) {
		return manager.getMarket().getPurchasableAthletes().get(index);
	}
	
	public Item returnItem(int index) {
		return manager.getMarket().getPurchasableItems().get(index);
	}
	
	public void setAthleteButtons(ArrayList<JButton> btns) {
		for (int i=0; i < btns.size();i++) {
			Athlete athlete = manager.getMarket().getPurchasableAthletes().get(i);
			btns.get(i).setText(athlete.getName());
			if (manager.getMarket().getWeeklyPurchasedAthletes().contains(athlete)) {
				btns.get(i).setEnabled(false);
			}
			
		}
	}
	
	public void setItemButtons(ArrayList<JButton> btns) {
		for (int i=0; i < btns.size();i++) {
			Item item = manager.getMarket().getPurchasableItems().get(i);
			btns.get(i).setText(item.getName());
			if (manager.getMarket().getWeeklyPurchasedItems().contains(item)) {
				btns.get(i).setEnabled(false);
			}
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblMoney = new JLabel("Money: ");
		lblMoney.setText("Money: " +String.valueOf(manager.getMoney()));
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnBuy = new JButton("Buy");

		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (consumable instanceof Athlete) {
					if (manager.getMoney() < ((Athlete) consumable).getPrice()){
						String message = "You broke!";
					    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
					}
					else {
					manager.getTeam().buyPlayer((Athlete) consumable);
					manager.changeMoney(-((Athlete) consumable).getPrice());
					lblMoney.setText("Money: " +String.valueOf(manager.getMoney()));
					bought.setEnabled(false);
					manager.getMarket().addWeeklyPurchasedAthletes((Athlete) consumable);
					consumable = null;
					
					}
				}
				else {
					if (manager.getMoney() < ((Item) consumable).getPrice()){
						String message = "You broke!";
					    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
					    }
					else {
					manager.getTeam().buyConsumable((Item) consumable);
					manager.changeMoney(-((Item) consumable).getPrice());
					lblMoney.setText("Money: " +String.valueOf(manager.getMoney()));
					bought.setEnabled(false);
					manager.getMarket().addWeeklyPurchasedItems((Item) consumable);
					consumable = null;
					}
				}
			}
		});
		
		btnBuy.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18))
		);
		
		JLabel nameLabel = new JLabel("Click an item to see its description");
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		JSeparator separator = new JSeparator();
		
		JLabel priceLabel = new JLabel("");
		priceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel offValue = new JLabel("");
		offValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel defValue = new JLabel("");
		defValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel stamValue = new JLabel("");
		stamValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JLabel agilValue = new JLabel("");
		agilValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
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
					.addContainerGap(355, Short.MAX_VALUE))
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
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnPlayer1 = new JButton("Player1");
		btnPlayer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButtonEvent(btnPlayer1, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 0);
			}
		});
		btnPlayer1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnPlayer2 = new JButton("Player2");
		
		btnPlayer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButtonEvent(btnPlayer2, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 1);
			}
		});
		btnPlayer2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnPlayer3 = new JButton("Player3");
		btnPlayer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButtonEvent(btnPlayer3, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 2);
			}
		});
		btnPlayer3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnItem1 = new JButton("Item1");
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemButtonEvent(btnItem1, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 0);
			}
		});
		btnItem1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnItem2 = new JButton("Item2");
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemButtonEvent(btnItem2, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 1);
			}
		});
		btnItem2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnItem3 = new JButton("Item3");
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemButtonEvent(btnItem3, nameLabel, priceLabel, offValue, defValue, stamValue, agilValue, 2);
			}
		});
		btnItem3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Athletes");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnItem1, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnPlayer1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
									.addGap(3)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPlayer2, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(btnItem2, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPlayer3, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(btnItem3, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addGap(238)
							.addComponent(lblShop, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(73)
							.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblItems, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblShop))))
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlayer1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(btnPlayer2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPlayer3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(26)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblItems, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnItem1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(btnItem2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(btnItem3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(27))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		
		
		athleteBtns.add(btnPlayer1);
		athleteBtns.add(btnPlayer2);
		athleteBtns.add(btnPlayer3);
		
		itemBtns.add(btnItem1);
		itemBtns.add(btnItem2);
		itemBtns.add(btnItem3);

		setAthleteButtons(athleteBtns);
		setItemButtons(itemBtns);
	}
}