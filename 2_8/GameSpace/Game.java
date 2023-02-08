import java.lang.InterruptedException;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "2D Space Game";

	private boolean runnning = false;
	private Thread thread;

	private synchronized void start() {
		if (runnning) 
			return;

		runnning = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!runnning) 
			return;

		runnning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	@Override
	public void run() {
		while (runnning) {
			//this would be game loop
			System.out.println("WORKING");			
		}
		stop();
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		game.start();
	}


}