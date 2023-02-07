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
	private int rows, cols;
	private int[][] arr;
	private int blankX; 
	private int blankY; 
	private final int CELL_SIZE = 110;

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
				case 38 :
				case 87 :
					moveSet('U');
					break;
				case 40 :
				case 83 :
					moveSet('D');
					break;
				case 37 :
				case 65 :
					moveSet('L');
					break;
				case 39 :
				case 68 :
					moveSet('R');
					break;
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked");
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
		int width = 80;
		int height = 80;
		for (int i=0; i < rows ; i++) {
			int gap = 10;
			for (int j=0; j< cols ; j++) {
				int recX = gap + ( j * CELL_SIZE ); 
				int recY = gap + ( i * CELL_SIZE );
				g.setColor(new Color(102,51,0));
				g.drawRect(recX,recY,width,height);
				g.fillRect(recX+1,recY+1,width-1,height-1);
				if ( arr[i][j] != 0 ) {
					String num = String.valueOf(arr[i][j]);
					int stringX = (int) ((CELL_SIZE-10) - g.getFontMetrics().stringWidth(num)) / 2 + ( j *  CELL_SIZE);
					int stringY = (int) ((CELL_SIZE-10) + g.getFontMetrics().getAscent()) / 2 + ( i * CELL_SIZE);
					drawNum(num,g,stringX,stringY);
				}
				if ( arr[i][j] == 0) {
					g.setColor(new Color(153,102,0));
					g.fillRect(recX,recY,width,height);
				}
			}
		}
	}

	public void drawNum(String num, Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(num,x,y);
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

	public static void main(String[] args) {
		JFrame frame = new JFrame("Puzzle Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Game game = new Game(4,3);
		frame.setContentPane(game);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}