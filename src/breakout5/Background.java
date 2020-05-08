package breakout5;

import java.awt.Graphics;
import java.awt.Toolkit;

public class Background {

	/**
	 * The background gif changes with the level.
	 */
	protected Background() {

		if (BreakoutModel.level == 1) {
			BreakoutModel.image = Toolkit.getDefaultToolkit().createImage("background/giphy.gif");
		}
		if (BreakoutModel.level == 2) {
			BreakoutModel.image = Toolkit.getDefaultToolkit().createImage("background/giphy2.gif");
		}
		if (BreakoutModel.level == 3) {
			BreakoutModel.image = Toolkit.getDefaultToolkit().createImage("background/giphy3.gif");
		}
	}

	/**
	 * Draws the image onto the given Graphics object.
	 * 
	 * @param gr
	 *            - the Graphics object, on which the image is supposed to be
	 *            drawn.
	 */
	protected void paint(Graphics gr) {
		gr.drawImage(BreakoutModel.image, 0, 0, 800, 770, null);
	}
}
