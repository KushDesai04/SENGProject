package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.GameManager;

/**
 * Launches a dialogue box to provide information about random events.
 * 
 * @author Yunu Cho
 * @author Kush Desai
 * 
 */
public class DialogueBox {
	/**
	 * The frame of the DialogueBox.
	 */
	private JFrame frame;
	/**
	 * The message that will be passed onto the player.
	 */
	private String message;
	/**
	 * The current instance of the GameManager object.
	 */
	private GameManager manager;

	/**
	 * Launch the application.
	 * @param args Command line args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogueBox window = new DialogueBox();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructs a new DialogueBox object with the given GameManager.
	 * 
	 * @param gameManager the current instance of the GameManager object
	 * @param tempMessage the message that is displayed on the DialogueBox
	 */
	public DialogueBox(GameManager gameManager, String tempMessage) {
		manager = gameManager;
		message = tempMessage;
		initialize();

	}

	/**
	 * Create the application.
	 */
	public DialogueBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);

	}

}
