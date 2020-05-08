package breakout5;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen extends JFrame {

	private static final long serialVersionUID = 754328803794438853L;

	// the JPanel onto which stuff is going to be added to.
	private JPanel panel;

	/**
	 * Creates a game window with a specific size.
	 */
	protected GameScreen() {

		// creates a MyCanvas instance and adds it to the JFrame
		panel = new MyCanvas();
		add(panel);

		this.setBounds(0, 0, 800, 800);

		setTitle("Breakout");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// adds mouse listeners to the panel
		panel.addMouseMotionListener(new MouseMotionListener() {

			// changes the paddle x-position if the mouse is moved
			@Override
			public void mouseMoved(MouseEvent e) {
				BreakoutModel.paddle.setXmouse(e.getX());
			}

			// or dragged
			@Override
			public void mouseDragged(MouseEvent e) {
				BreakoutModel.paddle.setXmouse(e.getX());
			}
		});
		this.requestFocusInWindow();
	}

	/**
	 * Updates the game field.
	 */
	protected void update() {
		panel.repaint();
	}
}

class MyCanvas extends JPanel {

	private static final long serialVersionUID = -7408656218848809851L;

	/**
	 * (Re)paints the whole game field, consisting of background, ball, paddle and bricks.
	 * @param gr - the Graphics object which is being updated
	 */
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		// only repaints this stuff if it is the first try (= there is no background yet)
		if (BreakoutModel.background != null) {
			BreakoutModel.background.paint(gr);
			BreakoutModel.ball.paint(gr);
			BreakoutModel.paddle.paint(gr);
			BreakoutModel.bricks.paint(gr);
		}
	}
}