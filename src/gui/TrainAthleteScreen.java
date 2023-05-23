package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Athlete;
import main.GameManager;
import main.Item;

/**
 * This is the TrainAthlete screen. This screen is opened when the player
 * takes a bye. This screen allows a player to specially train one athlete,
 * and that Athletes stats are all increased by 10.
 */
public class TrainAthleteScreen {

	/**
	 * Frame of the GameScreen.
	 */
	private JFrame frame;
	/**
	 * The current instance of the GameManager object.
	 */
	private GameManager manager;
	/**
	 * The last selected Athlete.
	 */
	private Athlete lastSelectedAthlete;

	/**
	 * Constructs a new TrainAthleteScreen object with the given GameManager.
	 * 
	 * @param gameManager the current instance of the GameManager object
	 */
	public TrainAthleteScreen(GameManager gameManager) {
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
	 * Calls closeTeamSetupScreen within the GameManager object which opens the next
	 * window.
	 */
	public void finishedWindow() {
		manager.closeTrainAthleteScreen(this);
	}

	/**
	 * Refreshes the labels to display the information of the given Athlete when its
	 * corresponding JList entry is selected.
	 * 
	 * @param athlete the Athlete whose information will be displayed
	 * @param name    the label displaying the name of the Athlete
	 * @param price   the label displaying the price of the Athlete
	 * @param off     the label displaying the offence stat of the Athlete
	 * @param def     the label displaying the defence stat of the Athlete
	 * @param stam    the label displaying the stamina stat of the Athlete
	 * @param agil    the label displaying the agility stat of the Athlete
	 */
	public void refreshLabels(Athlete athlete, JLabel name, JLabel price, JLabel off, JLabel def, JLabel stam,
			JLabel agil) {
		name.setText(athlete.toString()); // Set name label to athlete name
		price.setText("$" + String.valueOf(athlete.getPrice()));
		off.setText("Offence: " + String.valueOf(athlete.getStat(Athlete.STATS.O)));
		def.setText("Defence: " + String.valueOf(athlete.getStat(Athlete.STATS.D)));
		stam.setText("Stamina: " + String.valueOf(athlete.getStat(Athlete.STATS.S)));
		agil.setText("Agility: " + String.valueOf(athlete.getStat(Athlete.STATS.A)));
	}

	/**
	 * Launch the application.
	 * @param args Command line args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainAthleteScreen window = new TrainAthleteScreen();
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
	public TrainAthleteScreen() {
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

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10).addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE).addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
								.addComponent(priceLabel).addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup().addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(agilValue)
								.addComponent(offValue).addComponent(stamValue).addComponent(defValue))
						.addContainerGap(311, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(181)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(priceLabel).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(9).addComponent(offValue).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(defValue).addPreferredGap(ComponentPlacement.RELATED).addComponent(stamValue)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(agilValue)
						.addContainerGap(195, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JButton tglBtnPG_6 = new JButton("<");
		tglBtnPG_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		tglBtnPG_6.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton trainAthleteBtn = new JButton("Train Athlete");
		trainAthleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lastSelectedAthlete.changeStat(10, Athlete.STATS.O);
					lastSelectedAthlete.changeStat(10, Athlete.STATS.D);
					lastSelectedAthlete.changeStat(10, Athlete.STATS.S);
					lastSelectedAthlete.changeStat(10, Athlete.STATS.A);
					String message = lastSelectedAthlete.getName() + " has been trained!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
					finishedWindow();
				}

				catch (NullPointerException error) {
					String message = "Please select an Athlete!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Training Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		trainAthleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblTrainingRoom = new JLabel("Training Room");
		lblTrainingRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainingRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingRoom.setForeground(new Color(255, 255, 255));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
								.addGap(43)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
								.addGap(137))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(tglBtnPG_6)
										.addPreferredGap(ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
										.addComponent(lblTrainingRoom, GroupLayout.PREFERRED_SIZE, 190,
												GroupLayout.PREFERRED_SIZE)
										.addGap(146)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(trainAthleteBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 342,
								Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(39).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 467,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(trainAthleteBtn,
												GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblTrainingRoom, GroupLayout.PREFERRED_SIZE, 45,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 387,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 387,
																GroupLayout.PREFERRED_SIZE))
												.addGap(39))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(tglBtnPG_6)))
				.addContainerGap(18, Short.MAX_VALUE)));

		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStarters.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblStarters);

		JList<Athlete> startersList = new JList<Athlete>();
		JList<Athlete> reservesList = new JList<Athlete>();

		startersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		startersList.setModel(new AbstractListModel<Athlete>() {
			ArrayList<Athlete> values = manager.getTeam().getPlayersArray();

			public int getSize() {
				return values.size();
			}

			public Athlete getElementAt(int index) {
				return values.get(index);
			}
		});
		startersList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lastSelectedAthlete = startersList.getSelectedValue();
				if (lastSelectedAthlete instanceof Athlete) {
					reservesList.clearSelection();
					try {
						refreshLabels(lastSelectedAthlete, nameLabel, priceLabel, offValue, defValue, stamValue,
								agilValue);

					} catch (NullPointerException error) {
						// Don't do anything
					}
				}
			}

		});
		scrollPane_1.setViewportView(startersList);

		JLabel lblReserves = new JLabel("Reserves");
		lblReserves.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setColumnHeaderView(lblReserves);

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
		reservesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lastSelectedAthlete = reservesList.getSelectedValue();
				if (lastSelectedAthlete instanceof Athlete) {
					startersList.clearSelection();
					try {
						refreshLabels(lastSelectedAthlete, nameLabel, priceLabel, offValue, defValue, stamValue,
								agilValue);
					} catch (NullPointerException error) {
						// Don't do anything
					}
				}
			}

		});

		scrollPane.setViewportView(reservesList);

		frame.getContentPane().setLayout(groupLayout);
	}
}
