package breakout5;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GameOver extends JDialog {

	private static final long serialVersionUID = -2436768959537581657L;

	// creates buttons and a label
	JButton restart = new JButton("Restart Game!");
	JButton exit = new JButton("Exit Game!");
	JLabel tx = new JLabel("You Lose!");

	/**
	 * Makes a window that contains a text information a restart button and an
	 * exit button pop up.
	 */
	protected GameOver() {

		Container c = this.getContentPane();
		c.setLayout(null);

		setTitle("You are 2 bad 4 this Game!");
		setSize(400, 200);
		setVisible(true);
		setLocation(800, 450);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		restart.setFocusPainted(false);
		restart.setBounds(210, 110, 150, 50);
		restart.addActionListener((evt) -> restartGameButtonPressed(evt));
		exit.setFocusPainted(false);
		exit.setBounds(30, 110, 150, 50);
		exit.addActionListener((evt) -> exitGameButtonPressed(evt));
		tx.setBounds(125, 35, 150, 50);
		tx.setFont(new Font("Serif", Font.BOLD, 30));

		c.add(tx);
		c.add(exit);
		c.add(restart);
	}

	/**
	 * Makes this window disappear and starts a new game when the restart button
	 * is pressed.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void restartGameButtonPressed(ActionEvent e) {
		dispose();
		new Thread(() -> new BreakoutController().startController(BreakoutModel.level)).start();
	}

	/**
	 * Closes the whole thing if the exit button is pressed.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void exitGameButtonPressed(ActionEvent e) {
		System.exit(0);
	}
}
