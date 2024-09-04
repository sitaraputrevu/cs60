package com.gradescope.spampede;

import java.awt.event.KeyEvent;

/**
 * The "controller" in MVC that is responsible for the logic of the game, e.g.
 * deciding how to move the snake, as well as handling keystrokes and
 * controlling the timesteps that move the snake forward.
 * 
 * @author CS60 instructors
 */
public class SpampedeBrain extends SpampedeBrainParent {

	/** The "view" in MVC. */
	private SpampedeDisplay theDisplay;

	/** The "model" in MVC. */
	private SpampedeData theData;

	/** The number of animated frames displayed so far. */
	private int cycleNum = 0;

	/** The mappings between direction (names) and keys. */
	private static final char REVERSE = 'r';
	private static final char UP = 'i';
	private static final char DOWN = 'k';
	private static final char LEFT = 'j';
	private static final char RIGHT = 'l';
	private static final char AI_MODE = 'a';
	private static final char PLAY_SPAM_NOISE = 's';

	/** Starts a new game. */
	public void startNewGame() {
		theData = new SpampedeData();
		theData.placeSnakeAtStartLocation();
		theData.setStartDirection();

		theDisplay = new SpampedeDisplay(theData, screen, getSize().width, getSize().height);
		theDisplay.updateGraphics();

		playSound_spam();

		/**
		 * Hack because pictures have a delay in loading, and we do not redraw the
		 * screen again until the game actually starts, which means we would not see the
		 * image until the game does start. Wait a fraction of a second (200 ms), by
		 * which time the picture should have been fetched from disk, and redraw.
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		;

		theDisplay.updateGraphics();
	}

	/** Declares the game over. */
	public void gameOver() {
		super.pause(); // pause the game
		theData.setGameOver(); // tell the model that the game is over
		if (audioMeow != null) {
			audioMeow.play(); // play a sound
		}
	}

	/* -------- */
	/* Gameplay */
	/* -------- */

	/**
	 * Moves the game forward one step.
	 * 
	 * One step is one frame of animation, which occurs every Preferences.SLEEP_TIME
	 * milliseconds.
	 */
	public void cycle() {
		// move the snake
		updateSnake();

		// update the list of spam
		updateSpam();

		// draw the board
		theDisplay.updateGraphics();

		// send the new drawing to the screen
		repaint();

		// update the cycle counter
		cycleNum++;
	}

	/**
	 * Reacts to characters typed by the user.
	 * 
	 * <p>
	 * SpampedeBrainParent registers SpampedeBrain as an "observer" for key presses
	 * on the keyboard. So, whenever the user presses a key, Java automatically
	 * calls this keyPressed method and passes it a KeyEvent describing the specific
	 * key press.
	 * </p>
	 */
	public void keyPressed(KeyEvent evt) {

		switch (evt.getKeyChar()) { // get the char of the pressed key
		// TODO: Add cases to handle other keys (set the direction!)
		case PLAY_SPAM_NOISE:
			playSound_spam();
			break;
		default:
			theData.setDirectionEast();
		}
	}

	/**
	 * Moves the snake.
	 * 
	 * <p>
	 * This method is called once every REFRESH_RATE cycles, either in the current
	 * direction, or as directed by the AI's breadth-first search.
	 * <p>
	 */
	public void updateSnake() {
		if (cycleNum % Preferences.REFRESH_RATE == 0) {
			BoardCell nextCell;
			if (theData.inAImode()) {
				nextCell = theData.getNextCellFromBFS();
			} else {
				nextCell = theData.getNextCellInDir();
			}
			advanceTheSnake(nextCell);
		}
	}

	/**
	 * Moves the snake to the next cell (and possibly eat spam).
	 * 
	 * @param nextCell - the new location of the snake head (which must be
	 *                 horizontally or vertically adjacent to the old location of
	 *                 the snake head)
	 */
	private void advanceTheSnake(BoardCell nextCell) {
    // oops...we hit something
    if (nextCell.isWall() || nextCell.isBody()) {
      gameOver();
      return;
    } 
    
    // the snake ate spam!
    if (nextCell.isSpam()) {
      playSound_spamEaten();
    } 

    theData.moveSnakeForward(nextCell);
  }

	/**
	 * Adds more spam every SPAM_ADD_RATE cycles.
	 */
	void updateSpam() {
		if (theData.noSpam()) {
			theData.addSpam();
		} else if (cycleNum % Preferences.SPAM_ADD_RATE == 0) {
			theData.addSpam();
		}
	}

	/* ------ */
	/* Sounds */
	/* ------ */

	/** Plays crunch noise. */
	public void playSound_spamEaten() {
		if (audioCrunch != null) {
			audioCrunch.play();
		}
	}

	/** Plays spam noise. */
	public void playSound_spam() {
		if (audioSpam != null) {
			audioSpam.play();
		}
	}

	/** Plays meow noise. */
	public void playSound_meow() {
		if (audioMeow != null) {
			audioMeow.play();
		}
	}

	/** Added to avoid a warning - not used! */
	private static final long serialVersionUID = 1L;

	/* ---------------------- */
	/* Testing Infrastructure */
	/* ---------------------- */

	public static SpampedeBrain getTestGame(TestGame gameNum) {
		SpampedeBrain brain = new SpampedeBrain();
		brain.theData = new SpampedeData(gameNum);
		return brain;
	}

	public String testing_toStringParent() {
		return theData.toStringParents();
	}

	public BoardCell testing_getNextCellInDir() {
		return theData.getNextCellInDir();
	}

	public String testing_toStringSpampedeData() {
		return theData.toString();
	}
}
