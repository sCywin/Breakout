package breakout5;

/**
 * This class contains most controller components of our game and therefore
 * connects view and model-parts of the program.
 */
public class BreakoutController {

	/**
	 * Starts the actual game.
	 * 
	 * @param level
	 *            - the current game level.
	 */
	protected void startController(int level) {
		// creates a GameScreen instance
		GameScreen gameWindow = new GameScreen();

		// initializes level, height and width in the model class
		BreakoutModel.level = level;
		BreakoutModel.width = (int) gameWindow.getWidth();
		BreakoutModel.height = (int) gameWindow.getHeight();

		// initializes ball, paddle, bricks and background, basically the whole
		// game field
		BreakoutModel.ball = new Ball(350, 700, 17);
		BreakoutModel.paddle = new Paddle();
		BreakoutModel.bricks = new Bricks(15, 10);
		BreakoutModel.background = new Background();

		// makes the field visible and paints it
		gameWindow.setVisible(true);
		gameWindow.update();

		long timer = System.currentTimeMillis();
		// as long as the is neither lost nor won, the game runs
		while (!BreakoutModel.gameOver() && !BreakoutModel.winner()) {
			BreakoutModel.hitBrick();
			BreakoutModel.hitPad();
			BreakoutModel.update();
			gameWindow.update();
			// prints the current fps to console every 1000 milliseconds
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + BreakoutModel.fps);
				timer = System.currentTimeMillis();
			}
			// pauses for 10 milliseconds (at 100 fps)
			try {
				Thread.sleep(1000 / BreakoutModel.fps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// closes the game if it is finished
		gameWindow.dispose();
	}
}
