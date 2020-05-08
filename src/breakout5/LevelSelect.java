package breakout5;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

public class LevelSelect extends JDialog {

	private static final long serialVersionUID = -920440894697972148L;

	// some buttons
	JButton lv1 = new JButton("Level 1");
	JButton lv2 = new JButton("Level 2");
	JButton lv3 = new JButton("Level 3");

	/**
	 * Opens a window with three buttons, one for each level.
	 */
	protected LevelSelect() {
		Container c = this.getContentPane();
		c.setLayout(null);

		setTitle("Level Selection");
		setSize(600, 150);
		setVisible(true);
		setLocation(getWidth() + 100, getHeight() + 100);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		lv1.setFocusPainted(false);
		lv1.setBounds(20, 30, 150, 50);
		lv1.addActionListener((evt) -> lvl1Selected(evt));
		lv2.setFocusPainted(false);
		lv2.setBounds(220, 30, 150, 50);
		lv2.addActionListener((evt) -> lvl2Selected(evt));
		lv3.setFocusPainted(false);
		lv3.setBounds(420, 30, 150, 50);
		lv3.addActionListener((evt) -> lvl3Selected(evt));

		c.add(lv1);
		c.add(lv2);
		c.add(lv3);
	}

	/**
	 * Starts the game with level = 1 and closes the level select window.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void lvl1Selected(ActionEvent e) {
		dispose();
		new Thread(() -> new BreakoutController().startController(1)).start();
	}

	/**
	 * Starts the game with level = 2 and closes the level select window.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void lvl2Selected(ActionEvent e) {
		dispose();
		new Thread(() -> new BreakoutController().startController(2)).start();
	}

	/**
	 * Starts the game with level = 3 and closes the level select window.
	 * 
	 * @param e
	 *            - the button is pressed.
	 */
	private void lvl3Selected(ActionEvent e) {
		dispose();
		new Thread(() -> new BreakoutController().startController(3)).start();
	}
}
