import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Game extends JPanel {
	private static final int CELL_WIDTH = 80;
	private static final int CELL_HEIGHT = 80;
	private static final int CELL_SIZE = 110;
	private static final int CELL_GAP = 10;
	private static final Color CELL_COLOR = new Color(102,51,0);
	private static final Color BLANK_COLOR = new Color(153,102,0);

	private int rows, cols;
	private int[][] arr;
	private int blankX; 
	private int blankY; 

	public Game(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		arr = new int[rows][cols];
		blankX = rows-1;
		blankY = cols-1;
		setPreferredSize(new Dimension(CELL_SIZE*cols,CELL_SIZE*rows));
		init();
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP :
				case KeyEvent.VK_W :
					moveSet('U');
					break;
				case KeyEvent.VK_DOWN :
				case KeyEvent.VK_S :
					moveSet('D');
					break;
				case KeyEvent.VK_LEFT :
				case KeyEvent.VK_A :
					moveSet('L');
					break;
				case KeyEvent.VK_RIGHT :
				case KeyEvent.VK_D :
					moveSet('R');
					break;
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int pointX = e.getX();
				int pointY = e.getY();
				if (!isGapArea(pointX, pointY)) {
					int col = (int) (pointX / CELL_SIZE);
					int row = (int) (pointY / CELL_SIZE);
					moveCheck(row, col);
				}
			}
		});

	}

	public void init() {
		Random rnd = new Random();
		for (int i=1; i < rows * cols; i++) {			
			int x = rnd.nextInt(rows);
			int y = rnd.nextInt(cols);
				while (arr[x][y] != 0 || (arr[x][y] == 0 && x == blankX && y == blankY)) {
					x = rnd.nextInt(rows);
					y = rnd.nextInt(cols);
				}
				arr[x][y] = i;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCell(g);
	}

	public void drawCell(Graphics g) {
		for (int i=0; i < rows ; i++) {
			for (int j=0; j< cols ; j++) {
				int recX = CELL_GAP + ( j * CELL_SIZE ); 
				int recY = CELL_GAP + ( i * CELL_SIZE );
				if (blankX == i && blankY == j) {
					g.setColor(BLANK_COLOR);
					g.fillRect(recX, recY, CELL_WIDTH, CELL_HEIGHT);
				} else {
					g.setColor(CELL_COLOR);
					g.fillRect(recX, recY, CELL_WIDTH, CELL_HEIGHT);
					String num = String.valueOf(arr[i][j]);
					int stringX = (int) ((CELL_SIZE-10) - g.getFontMetrics().stringWidth(num)) / 2 + ( j *  CELL_SIZE);
					int stringY = (int) ((CELL_SIZE-10) + g.getFontMetrics().getAscent()) / 2 + ( i * CELL_SIZE);
					drawNum(num,g,stringX,stringY);
				}
			}
		}
	}

	public void drawNum(String num, Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(num,x,y);
	}

	public void moveCheck(int row, int col) {
		if (row - 1 == blankX && col == blankY) {
			moveSet('D');
		}

		if (row + 1 == blankX && col == blankY) {
			moveSet('U');
		}

		if (row == blankX && col -1 == blankY) {
			moveSet('R');
		}

		if (row == blankX && col + 1 == blankY) {
			moveSet('L');
		}
	}

	public void moveSet(char direc) {
		switch(direc) {
		case 'U' :
			if (blankX -1 >= 0) {
				arr[blankX][blankY] = arr[blankX-1][blankY];
				arr[blankX-1][blankY] = 0;
				blankX--;
				repaint();
			}
			break;
		case 'D' :
			if (blankX < rows-1) {
				arr[blankX][blankY] = arr[blankX+1][blankY];
				arr[blankX+1][blankY] = 0;
				blankX++;
				repaint();
			}
			break;
		case 'L' :
			if (blankY -1 >= 0) {
				arr[blankX][blankY] = arr[blankX][blankY-1];
				arr[blankX][blankY-1] = 0;
				blankY--;
				repaint();
			}
			break;
		case 'R' :
			if (blankY < cols-1) {
				arr[blankX][blankY] = arr[blankX][blankY+1];
				arr[blankX][blankY+1] = 0;
				blankY++;
				repaint();
			}
			break;
		}
	} 

	public boolean isGapArea(int pointX, int pointY) {
		if (pointX < CELL_GAP || pointY < CELL_GAP) return true;
		for (int i = 0; i<cols; i++){
			if (pointX > (CELL_SIZE - CELL_GAP) * i && pointX < (CELL_SIZE + CELL_GAP) * i ) {
				return true;
			}
		}

		for (int j=0; j<rows; j++) {
			if (pointY > (CELL_SIZE - CELL_GAP) * j && pointY < (CELL_SIZE + CELL_GAP) * j) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Puzzle Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Game game = new Game(5,4);
		frame.setContentPane(game);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}