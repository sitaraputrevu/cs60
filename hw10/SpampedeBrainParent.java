package com.gradescope.spampede;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

/**
 * Provides back-end for SpampedeBrain and SpampedeDisplay.
 * 
 * You do not have to understand this code.
 * 
 * DO NOT MODIFY.
 * 
 * @author CS60 instructors
 */
public abstract class SpampedeBrainParent extends JApplet implements ActionListener, KeyListener, Runnable {

	/** The off-screen buffer of image */
	public Image image;

	/** The buffer's graphical tools */
	public Graphics screen;

	/** Buttons */
	private JButton newGameButton;
	private JButton pauseButton;
	private JButton startButton;

	/** Drop-down menu */
	private JMenu gameMenu;
	private JMenuItem newGameItem;
	private JMenuItem pauseItem;
	private JMenuItem startItem;

	/** Fun sounds (optional) */
	public AudioClip audioSpam; // spam sound
	public AudioClip audioCrunch; // crunch sound
	public AudioClip audioMeow; // meow sound

	/* ---------------------------------------------------------------------------- */
	/* Methods to initialize the applet and register listeners for user interaction */
	/* ---------------------------------------------------------------------------- */
	
	/**
	 * Initializes this applet. This method is called when Spampede is started (not
	 * per game)!
	 */
	@Override
	public void init() {

		// register w/the applet (i.e. parent) so it calls our keyPressed method
		addKeyListener(this);

		// set positions
		setLayout(new BorderLayout());

		// initialize controls
		initializeButtons();
		initializeMenu();

		// set up the (off-screen) buffer for drawing, named image
		image = createImage(getSize().width, Preferences.GAMEBOARDHEIGHT);
		screen = image.getGraphics(); // screen holds the drawing routines

		// add a central panel which holds the buffer (the game board)
		add(new SpampedeImagePanel(image), BorderLayout.CENTER);

		// example of loading images and audio
		try {
			URL url = getCodeBase();
			audioSpam = getAudioClip(url, "Spam.au");
			audioCrunch = getAudioClip(url, "crunch.au");
			audioMeow = getAudioClip(url, "cat.au");
			SpampedeDisplay.imageSpam = getImage(url, "spam.gif");
			System.out.println("successful loading of audio/images!");
		} catch (Exception e) {
			System.out.println("problem loading audio/images!");
			audioSpam = null;
			audioCrunch = null;
			audioMeow = null;
			SpampedeDisplay.imageSpam = null;
		}
		startNewGame(); // set up the game internals!
		super.repaint(); // re-render the environment to the screen
	}

	/**
	 * Initializes all buttons.
	 */
	private void initializeButtons() {
		// add a panel for buttons
		JPanel buttonPane = new JPanel(new FlowLayout());
		buttonPane.setBackground(Preferences.COLOR_BACKGROUND);
		add(buttonPane, BorderLayout.PAGE_START);

		newGameButton = new JButton("New Game"); // the text in the button
		newGameButton.addActionListener(this); // watch for button presses
		newGameButton.addKeyListener(this); // listen for key presses here
		buttonPane.add(newGameButton); // add button to the panel

		pauseButton = new JButton("Pause"); // a second button
		pauseButton.addActionListener(this);
		pauseButton.addKeyListener(this);
		buttonPane.add(pauseButton);

		startButton = new JButton("Start"); // a third button
		startButton.addActionListener(this);
		startButton.addKeyListener(this);
		buttonPane.add(startButton);
	}

	/**
	 * Initializes all menu items.
	 */
	private void initializeMenu() {
		// set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// add a menu to contain items
		gameMenu = new JMenu("Game"); // the menu name
		menuBar.add(gameMenu); // add the menu to the menu bar

		newGameItem = new JMenuItem("New Game"); // the text in the menu
		newGameItem.addActionListener(this); // watch for button presses
		newGameItem.addKeyListener(this); // listen for key presses here
		gameMenu.add(newGameItem); // add the item to the menu

		pauseItem = new JMenuItem("Pause"); // a second menu item
		pauseItem.addActionListener(this);
		pauseItem.addKeyListener(this);
		gameMenu.add(pauseItem);

		startItem = new JMenuItem("Start"); // a third menu item
		startItem.addActionListener(this);
		startItem.addKeyListener(this);
		gameMenu.add(startItem);
	}
	
	/**
	 * Processes buttons and menu items.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == newGameButton || source == newGameItem) {
			startNewGame();
			go();
		}
		if (source == pauseButton || source == pauseItem) {
			pause();
		}
		if (source == startButton || source == startItem) {
			go();
		}
		requestFocus(); // makes sure this applet keeps keyboard focus
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// Not used
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// Not used
	}

	/* --------------------------------------------------------------- */
	/* Fields and methods are used to implement the Runnable interface */
	/* and to support pausing and resuming the applet. */
	/* --------------------------------------------------------------- */

	Thread thread; // the thread controlling the updates
	boolean threadSuspended; // whether or not the thread is suspended
	boolean running; // whether or not the thread is stopped

	/**
	 * Called to run this applet.
	 */
	@Override
	public void run() {
		// calls the "cycle()" method every so often (every sleepTime milliseconds)
		while (running) {
			try {
				if (thread != null) {
					Thread.sleep(Preferences.SLEEP_TIME);
					synchronized (this) {
						while (threadSuspended) {
							wait(); // sleeps until notify() wakes it up
						}
					}
				}
			} catch (InterruptedException e) {
				;
			}

			cycle(); // this represents 1 update cycle for the environment
		}
		thread = null;
	}

	/**
	 * Called when the "Start" button is pressed.
	 */
	public synchronized void go() {
		if (thread == null) {
			thread = new Thread(this);
			running = true;
			thread.start();
			threadSuspended = false;
		} else {
			threadSuspended = false;
		}
		notify(); // wakes up the call to wait(), above
	}

	/**
	 * Called when the "Pause" button is pressed.
	 */
	void pause() {
		if (thread == null) {
			;
		} else {
			threadSuspended = true;
		}
	}

	/**
	 * Called when the user leaves the page that contains the applet. It stops the
	 * thread altogether.
	 */
	public synchronized void stop() {
		running = false;
		notify();
	}

	/* ----------------------------------------------------------------- */
	/* Methods that will be overridden to provide Spampede functionality */
	/* ----------------------------------------------------------------- */

	/** Cycles a game through one "step" */
	abstract void cycle();

	/** Starts a new game */
	abstract void startNewGame();

	@Override
	public abstract void keyPressed(KeyEvent evt);

	private static final long serialVersionUID = 1L;
}
