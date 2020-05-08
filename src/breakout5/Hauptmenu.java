package breakout5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Hauptmenu extends JFrame {

	private static final long serialVersionUID = -7093835083172647755L;

	public static void main(String args[]) {

		EventQueue.invokeLater(() -> new Hauptmenu());

	}

	/**
	 * Creates the main menu, consisting of some buttons and a background.
	 */
	private Hauptmenu() {

		// sets the default value of level to 1
		BreakoutModel.level = 1;

		// background
		ImageIcon image = new ImageIcon("background/breakout2.gif");
		JLabel background = new JLabel(image);
		background.setLayout(null);

		// buttons
		JButton startButton = new JButton("Start Game!");
		startButton.setBounds(200, 400, 400, 50);
		startButton.setOpaque(false);
		startButton.setBackground(new Color(0, 0, 0, 0));
		startButton.setForeground(Color.YELLOW);
		startButton.setFocusPainted(false);
		startButton.addActionListener((evt) -> startGameButtonPressed(evt));
		background.add(startButton);

		JButton selectLevelButton = new JButton("Level Selection!");
		selectLevelButton.setBounds(200, 500, 400, 50);
		selectLevelButton.setOpaque(false);
		selectLevelButton.setBackground(new Color(0, 0, 0, 0));
		selectLevelButton.setForeground(Color.YELLOW);
		selectLevelButton.setFocusPainted(false);
		selectLevelButton.addActionListener((evt) -> levelSelectButtonPressed(evt));
		background.add(selectLevelButton);

		JButton exitButton = new JButton("Exit Game!");
		exitButton.setBounds(200, 600, 400, 50);
		exitButton.setOpaque(false);
		exitButton.setBackground(new Color(0, 0, 0, 0));
		exitButton.setForeground(Color.YELLOW);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener((evt) -> exitButtonPressed(evt));
		background.add(exitButton);

		// main window
		setTitle("Breakout");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(background);
	}

	/**
	 * Closes the window if the exit button is pressed.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void exitButtonPressed(ActionEvent e) {
		System.exit(0);
	}

	/**
	 * Starts a new game and closes the main menu if the start game button is
	 * pressed.
	 * 
	 * @param e
	 *            - the start game button is pressed.
	 */
	private void startGameButtonPressed(ActionEvent e) {
		dispose();
		new Thread(() -> new BreakoutController().startController(BreakoutModel.level)).start();
	}

	/**
	 * Opens the level selection window and closes the main menu if the level
	 * select button is pressed.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void levelSelectButtonPressed(ActionEvent e) {
		dispose();
		EventQueue.invokeLater(() -> new LevelSelect());
	}

}
