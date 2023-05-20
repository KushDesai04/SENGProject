package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.GameManager;

public class DialogueBox {

	private JFrame frame;
	private String message;
	private GameManager manager;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public DialogueBox(GameManager gameManager, String tempMessage) {
		manager = gameManager;
		message = tempMessage;
		initialize();
		
	}
	
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
