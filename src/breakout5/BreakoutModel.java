package breakout5;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 * This class contains most model components of mine game and therefore stores
 * all the data required by the view.
 */
public class BreakoutModel {

	// various public and static variables, used by the other classes
	// pretty much all the data required by other parts of the program

	protected static int level; // the current level
	protected static final int fps = 60; // the fps the game runs at
	protected static int hit = 0; // variable used for collision with the paddle
	protected static int hit2 = 0; // variable used for collision with bricks
	protected static int[][] bricksArray; // bricks

	protected static Ball ball; // the current ball instance
	protected static Paddle paddle; // the current paddle instance
	protected static Bricks bricks; // the current bricks instance
	protected static Background background; // the current background instance

	protected static int ballX; // x-position of the ball
	protected static int ballY; // y-position of the ball
	protected static int width; // window width
	protected static int height; // window height
	protected static float radius; // ball radius
	protected static float speedY; // y-speed of the ball
	protected static float speedX; // x-speed of the ball
	protected static Random random = new Random(); // random instance for the
												// colors
	protected static float r; // red component of a color
	protected static float g; // green component of a color
	protected static float b; // blue component of a color

	protected static int counter = 0; // counter of destroyed bricks
	protected static int brickWidth; // width of the bricks
	protected static int brickHeight; // height of the bricks
	protected static final int hPad = 50; // some constant used for paddle
										// calculations
	protected static final int vPad = 30; // some constant used for paddle
										// calculations
	protected static float r1; // red component of a color
	protected static float g1; // green component of a color
	protected static float b1; // blue component of a color
	protected static float r2; // red component of a color
	protected static float g2; // green component of a color
	protected static float b2; // blue component of a color

	protected static float r3; // red component of a color
	protected static float g3; // green component of a color
	protected static float b3; // blue component of a color
	protected static int paddelX; // x-position of the paddle
	protected static final int paddelY = 740; // y-position of the paddle

	protected static Image image; // the current background image

	/**
	 * Shows if the game is lost or not. If it is lost, a GameOver instance is
	 * created.
	 * 
	 * @return - returns true if the ball doesn't move anymore (which happens
	 *         when it hits the ground) or false otherwise.
	 */
	protected static boolean gameOver() {
		if (speedX == 0 && speedY == 0) {

			// creates a GameOver instance
			EventQueue.invokeLater(() -> new GameOver());
			return true;
		}
		return false;
	}

	/**
	 * Shows if the game is won or not. If it is won, a Winner instance is
	 * created.
	 * 
	 * @return - returns true if the counter of destroyed blocks hits the total
	 *         amount of blocks.
	 */
	protected static boolean winner() {
		if (counter == 150) {

			// creates a Winner instance
			EventQueue.invokeLater(() -> new Winner());
			return true;

		}
		return false;
	}

	/**
	 * Changes the hit-variable depending on the position of the collision point
	 * between board and ball (that changes the angle accordingly). Only changes
	 * the hit-variable if there is a collision of paddle and ball.
	 */
	protected static void hitPad() {
		if (level == 1) {
			if (getBounds().intersects(getPaddleBounds())) {
				if (getBounds().contains(paddelX + 115, paddelY)) {
					hit = 1;
				}
				if (getBounds().contains(paddelX + 85, paddelY)) {
					hit = 2;
				}
				if (getBounds().contains(paddelX + 50, paddelY)) {
					hit = 3;
				}
				if (getBounds().contains(paddelX + 20, paddelY)) {
					hit = 4;
				}
			} else {
				hit = 0;
			}
		}
		if ((level == 2) || (level == 3)) {
			if (getBounds().intersects(getPaddleBounds())) {
				if (getBounds().contains(paddelX + 80, paddelY)) {
					hit = 1;
				}
				if (getBounds().contains(paddelX + 45, paddelY)) {
					hit = 2;
				}
				if (getBounds().contains(paddelX + 30, paddelY)) {
					hit = 3;
				}
				if (getBounds().contains(paddelX + 10, paddelY)) {
					hit = 4;
				}
			} else {
				hit = 0;
			}
		}
	}

	/**
	 * Changes the hit2-variable if there is a collision of the ball and a
	 * brick.
	 */
	protected static void hitBrick() {
		// goes through all bricks
		for (int row = 0; row < bricksArray.length; row++) {
			for (int col = 0; col < bricksArray[0].length; col++) {

				// calculates the parameters of the current brick
				int brickx = col * brickWidth + col;
				int bricky = row * brickHeight + row;
				int brickW = brickWidth;
				int brickH = brickHeight;

				// creates a Rectangle with the parameters that were just
				// calculated
				Rectangle brickRect = new Rectangle(brickx + 60, bricky + 25, brickW, brickH);

				// does stuff if the ball collides with the current brick and
				// that brick is visible
				if ((getBounds().intersects(brickRect)) && (bricksArray[row][col] != 0)) {
					// saves that this brick was hit (also removes that brick in
					// a chain-reaction of methods)
					bricks.setBricks(row, col, 0);
					hit2 = 1;
					update();
				} else {
					hit2 = 0;
				}
			}
		}
	}

	/**
	 * Moves the ball depending on the hit and hit2 variables.
	 */
	protected static void update() {
		ball.move(hit, hit2);
	}

	/**
	 * 
	 * @return - returns the hitbox of the ball.
	 */
	private static Rectangle getBounds() {

		return new Rectangle(ballX, ballY - 15, (int) radius * 2, (int) radius * 2);
	}

	/**
	 * 
	 * @return - returns the hitbox of the paddle.
	 */
	private static Rectangle getPaddleBounds() {
		return new Rectangle(paddelX + 20, paddelY, 100, 10);
	}
}