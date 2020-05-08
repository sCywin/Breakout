package breakout5;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

public class Winner extends JDialog {

	private static final long serialVersionUID = -2389962400429412756L;
	
	// creates a new button
	private JButton chooseLevelButton = new JButton("Choose Level!");

	/**
	 * Makes a window with a level selection button pop up.
	 */
	protected Winner() {

		Container c = this.getContentPane();
		c.setLayout(null);

		setTitle("You are 2 good 4 this Game!");
		setSize(400, 200);
		setVisible(true);
		setLocation(800, 450);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		chooseLevelButton.setFocusPainted(false);
		chooseLevelButton.setBounds(120, 110, 150, 50);
		chooseLevelButton.addActionListener((evt) -> chooseLevelButtenPressed(evt));

		c.add(chooseLevelButton);
	}

	/**
	 * Opens the level selection window and closes this window if the button is pressed.
	 * @param e - the button is pressed.
	 */
	private void chooseLevelButtenPressed(ActionEvent e) {
		dispose();
		EventQueue.invokeLater(() -> new LevelSelect());
	}

}