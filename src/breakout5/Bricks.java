package breakout5;

import java.awt.Color;
import java.awt.Graphics;

public class Bricks {

	/**
	 * Creates bricks with the given amount of columns and rows.
	 * 
	 * @param row
	 *            - the amount of rows.
	 * @param col
	 *            - the amount of columns.
	 */
	protected Bricks(int row, int col) {

		// initializes those model variables
		BreakoutModel.brickWidth = (BreakoutModel.width - 2 * BreakoutModel.hPad) / col;
		BreakoutModel.brickHeight = (BreakoutModel.height / 2 - BreakoutModel.vPad) / row;

		// creates some random colors
		BreakoutModel.r1 = BreakoutModel.random.nextFloat();
		BreakoutModel.g1 = BreakoutModel.random.nextFloat();
		BreakoutModel.b1 = BreakoutModel.random.nextFloat();
		BreakoutModel.r2 = BreakoutModel.random.nextFloat();
		BreakoutModel.g2 = BreakoutModel.random.nextFloat();
		BreakoutModel.b2 = BreakoutModel.random.nextFloat();

		// calls the next method
		initBricks(row, col);
	}

	/**
	 * Initializes the bricksArray field in the model class.
	 * 
	 * @param row
	 *            - the amount of rows.
	 * @param col
	 *            - the amount of columns.
	 */
	private void initBricks(int row, int col) {

		BreakoutModel.bricksArray = new int[row][col];

		for (int i = 0; i < BreakoutModel.bricksArray.length; i++) {
			for (int j = 0; j < BreakoutModel.bricksArray[0].length; j++) {
				BreakoutModel.bricksArray[i][j] = 1;
			}
		}
	}

	/**
	 * Draws the bricks onto the given Graphics object depending on the level.
	 * 
	 * @param gr
	 *            - the Graphics object onto which the bricks are supposed to be
	 *            drawn.
	 */
	protected void paint(Graphics gr) {

		// it is important that only bricks with a value that is greater than 0 are drawn, because destroyed bricks get a value of 0.
		
		if (BreakoutModel.level == 1) {
			for (int row = 0; row < BreakoutModel.bricksArray.length; row++) {
				for (int col = 0; col < BreakoutModel.bricksArray[0].length; col++) {
					if (BreakoutModel.bricksArray[row][col] > 0) {
						Color randomColor1 = new Color(BreakoutModel.r1, BreakoutModel.g1, BreakoutModel.b1);
						gr.setColor(randomColor1.darker());
						gr.fillRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad + col,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad + row, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
						Color randomColor2 = new Color(BreakoutModel.r2, BreakoutModel.g2, BreakoutModel.b2);
						gr.setColor(randomColor2.darker());
						gr.drawRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad + col,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad + row, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
					}
				}
			}
		}
		if (BreakoutModel.level == 2) {
			for (int row = 0; row < BreakoutModel.bricksArray.length; row++) {
				for (int col = 0; col < BreakoutModel.bricksArray[0].length; col++) {
					if (BreakoutModel.bricksArray[row][col] > 0) {
						Color randomColor1 = new Color(BreakoutModel.r1, BreakoutModel.g1, BreakoutModel.b1);
						gr.setColor(randomColor1.darker());
						gr.fillRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad + col,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad + row, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
						Color randomColor2 = new Color(BreakoutModel.r2, BreakoutModel.g2, BreakoutModel.b2);
						gr.setColor(randomColor2.darker());
						gr.drawRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad + col,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad + row, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
					}
				}
			}
		}
		if (BreakoutModel.level == 3) {
			for (int row = 0; row < BreakoutModel.bricksArray.length; row++) {
				for (int col = 0; col < BreakoutModel.bricksArray[0].length; col++) {
					if (BreakoutModel.bricksArray[row][col] > 0) {
						BreakoutModel.r1 = BreakoutModel.random.nextFloat();
						BreakoutModel.g1 = BreakoutModel.random.nextFloat();
						BreakoutModel.b1 = BreakoutModel.random.nextFloat();
						BreakoutModel.r2 = BreakoutModel.random.nextFloat();
						BreakoutModel.g2 = BreakoutModel.random.nextFloat();
						BreakoutModel.b2 = BreakoutModel.random.nextFloat();
						Color randomColor1 = new Color(BreakoutModel.r1, BreakoutModel.g1, BreakoutModel.b1);
						gr.setColor(randomColor1.darker());
						gr.fillRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
						Color randomColor2 = new Color(BreakoutModel.r2, BreakoutModel.g2, BreakoutModel.b2);
						gr.setColor(randomColor2.darker());
						gr.drawRect(col * BreakoutModel.brickWidth + BreakoutModel.hPad,
								row * BreakoutModel.brickHeight + BreakoutModel.vPad, BreakoutModel.brickWidth,
								BreakoutModel.brickHeight);
					}
				}
			}
		}
	}

	/**
	 * Saves that a specific brick was hit by the ball and therefore shall not be drawn anymore.
	 * @param row - the row of the brick that was hit.
	 * @param col - the column of the brick that was hit.
	 * @param k - was the brick destroyed (k = 0) or not (k != 0)
	 */
	protected void setBricks(int row, int col, int k) {
		if (k == 0) {
			// increments the destroyed-brick-counter
			BreakoutModel.counter ++;
		}
		// saves the information of destruction
		BreakoutModel.bricksArray[row][col] = k;
	}
}