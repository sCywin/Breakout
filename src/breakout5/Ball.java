package breakout5;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	/**
	 * Creates a ball with the given parameters.
	 * 
	 * @param x
	 *            - the x-position of the ball
	 * @param y
	 *            - the y-position of the ball
	 * @param radius
	 *            - the radius of the ball
	 */
	protected Ball(int x, int y, float radius) {

		// speed changes with the level
		if (BreakoutModel.level == 1) {
			BreakoutModel.speedY = -6.3f;
			BreakoutModel.speedX = 4.2f;
		}
		if (BreakoutModel.level == 2) {
			BreakoutModel.speedY = -8.6f;
			BreakoutModel.speedX = 7.2f;
		}
		if (BreakoutModel.level == 3) {
			BreakoutModel.speedY = -8.3f;
			BreakoutModel.speedX = 7.0f;
		}

		// initializes the variables in the model
		BreakoutModel.ballX = x;
		BreakoutModel.ballY = y;
		BreakoutModel.radius = radius;
	}

	/**
	 * Moves the ball depending on the values of the parameters.
	 * 
	 * @param hit
	 *            - collision with paddle?
	 * @param hit2
	 *            - collision with bricks?
	 */
	protected void move(int hit, int hit2) {

		// moves the ball with the current speed values
		BreakoutModel.ballX += BreakoutModel.speedX;
		BreakoutModel.ballY += BreakoutModel.speedY;

		// the ball hits the paddle and changes direction accordingly
		if (hit == 1) {
			BreakoutModel.speedY *= -1;
			BreakoutModel.ballY = BreakoutModel.ballY - 20;
			// even if the ball comes from the right side, it bounces back to
			// the right
			if (BreakoutModel.speedX < 0) {
				BreakoutModel.speedX *= -1;
				BreakoutModel.ballX = BreakoutModel.ballX + 10;
				if (BreakoutModel.speedX < 6.2f) {
					BreakoutModel.speedX = 4.5f;
				}
			}
		}
		// the ball hits the paddle and changes direction accordingly
		if (hit == 2) {
			BreakoutModel.speedY *= -1;
			BreakoutModel.ballY = BreakoutModel.ballY - 20;
			// speed management
			if (BreakoutModel.speedX >= 6.2f) {
				BreakoutModel.speedX = 5.6f;
			}
			// even if the ball comes from the right side, it bounces back to
			// the right
			if (BreakoutModel.speedX < 0) {
				BreakoutModel.speedX *= -1;
				BreakoutModel.ballX = BreakoutModel.ballX + 10;
			}
		}
		// the ball hits the paddle and changes direction accordingly
		if (hit == 3) {
			BreakoutModel.speedY *= -1;
			BreakoutModel.ballY = BreakoutModel.ballY - 20;
			// speed management
			if (BreakoutModel.speedX > -6.2f) {
				BreakoutModel.speedX = -4.4f;
			}
			if (BreakoutModel.speedX > 0) {
				BreakoutModel.speedX *= -1;
				BreakoutModel.ballX = BreakoutModel.ballX - 10;
			}
		}
		if (hit == 4) {
			BreakoutModel.speedY *= -1;
			BreakoutModel.ballY = BreakoutModel.ballY - 20;
			// speed management
			if (BreakoutModel.speedX > 0) {
				BreakoutModel.speedX *= -1;
				BreakoutModel.ballX = BreakoutModel.ballX - 10;
				if (BreakoutModel.speedX > -6.2f) {
					BreakoutModel.speedX = -5.1f;
				}
			}
		}
		// the ball hits a brick and changes y-direction
		if (hit2 == 1) {
			BreakoutModel.speedY *= -1;
			// some minor tweaks
			if (BreakoutModel.speedX > 0) {
				BreakoutModel.ballX = BreakoutModel.ballX - 10;
				BreakoutModel.speedX *= 1.01;
				BreakoutModel.ballY = BreakoutModel.ballY + 20;
			}
			if (BreakoutModel.speedX < 0) {
				BreakoutModel.ballX = BreakoutModel.ballX + 10;
				BreakoutModel.speedX *= 1.01;
				BreakoutModel.ballY = BreakoutModel.ballY + 20;
			}
		}

		// the ball hits the left side of the window
		if (BreakoutModel.ballX < 0) {
			BreakoutModel.speedX *= -1;
		}
		// the ball hits the top side of the window
		if (BreakoutModel.ballY < 0) {
			BreakoutModel.speedY *= -1;
		}

		// the ball hits the bottom side of the window, gets stopped and the
		// game is over
		if (BreakoutModel.ballY + BreakoutModel.radius * 2 > BreakoutModel.height - 20) {
			BreakoutModel.ballX = 400;
			BreakoutModel.ballY = 740;
			BreakoutModel.speedY = 0;
			BreakoutModel.speedX = 0;
		}
		// the ball hits the right side of the window
		if (BreakoutModel.ballX + BreakoutModel.radius * 2 > BreakoutModel.width) {
			BreakoutModel.speedX *= -1;
		}
	}

	/**
	 * Draws the ball onto the given Graphics object.
	 * 
	 * @param gr
	 *            - the Graphics object onto which the ball shall be drawn.
	 */
	protected void paint(Graphics gr) {

		// random colors
		BreakoutModel.r = BreakoutModel.random.nextFloat();
		BreakoutModel.g = BreakoutModel.random.nextFloat();
		BreakoutModel.b = BreakoutModel.random.nextFloat();
		Color randomColor = new Color(BreakoutModel.r, BreakoutModel.g, BreakoutModel.b);

		// some special stuff for people who want to play level 3
		if (BreakoutModel.level == 3) {
			gr.setColor(randomColor);
		} else {
			gr.setColor(Color.red.brighter());
		}

		// draws the actual ball
		gr.fillOval(BreakoutModel.ballX, BreakoutModel.ballY, (int) BreakoutModel.radius, (int) BreakoutModel.radius);
	}
}