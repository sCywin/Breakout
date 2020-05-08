package breakout5;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

	/**
	 * Initializes the x-position of the paddle in the model class.
	 */
	protected Paddle() {
		BreakoutModel.paddelX = BreakoutModel.width / 2;
	}

	/**
	 * Changes the x-position of the paddle to the mouse x-position as long as
	 * the mouse is inside the bounds (which depend on the level).
	 * 
	 * @param x
	 *            - the x-position of the mouse.
	 */
	protected void setXmouse(int x) {
		if (BreakoutModel.level == 1) {
			if ((x > -10) && (x < 680)) {
				BreakoutModel.paddelX = x;
			}
		}
		if ((BreakoutModel.level == 2) || (BreakoutModel.level == 3)) {
			if ((x > -10) && (x < 720)) {
				BreakoutModel.paddelX = x;
			}
		}
	}

	/**
	 * Draws the paddle onto the Graphics object.
	 * @param gr - the Graphics object onto which the paddle shall be drawn.
	 */
	protected void paint(Graphics gr) {
		// color and size depend on level.
		if (BreakoutModel.level == 1) {
			gr.setColor(Color.BLUE.darker());
			gr.fillRect(BreakoutModel.paddelX, BreakoutModel.paddelY, 120, 10);
		}
		if (BreakoutModel.level == 2) {
			gr.setColor(Color.BLUE.darker());
			gr.fillRect(BreakoutModel.paddelX, BreakoutModel.paddelY, 80, 10);
		}
		if (BreakoutModel.level == 3) {
			BreakoutModel.r3 = BreakoutModel.random.nextFloat();
			BreakoutModel.g3 = BreakoutModel.random.nextFloat();
			BreakoutModel.b3 = BreakoutModel.random.nextFloat();

			Color randomColor = new Color(BreakoutModel.r3, BreakoutModel.g3, BreakoutModel.b3);
			gr.setColor(randomColor);
			gr.fillRect(BreakoutModel.paddelX, BreakoutModel.paddelY, 80, 10);
		}
	}
}
