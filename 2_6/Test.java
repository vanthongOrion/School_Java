import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {
	private int cols = 3;
	private int rows = 3;
	private int[][] arr = new int[cols][rows];
	private final int CELL_SIZE = 100;

	public Test() {
		setPreferredSize(new Dimension(300, 300));
		init();
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (!(x<10 || y<10 || (x>90 && x<110) || (y>90 && y<110)|| 
					(x>190 && x<210) || (y>190 && y<210) || x>290 || y>290)) {
					int col = (int) (x/CELL_SIZE);
					int row = (int) (y/CELL_SIZE);
					moveCheck(row,col);
					repaint();
					if(isWon()) {
						setVisible(false);
					}
				}
			}
		});
	}       

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintMap(g);
	}      

	public void init() {
		Random rnd = new Random();
		for (int i=0; i < cols*rows ; i++) {
			int x = rnd.nextInt(cols);
			int y = rnd.nextInt(rows);

			while(arr[x][y] != 0) {
				x = rnd.nextInt(cols);
				y = rnd.nextInt(rows);
			}
			arr[x][y] = i;
		}
	}   

	public void paintMap(Graphics g) {
		int width = 80;
		int height = 80;
		for (int i=0; i < cols ; i++) {
			int gap = 10;
			for (int j=0; j< rows ; j++) {
				int recX = gap + ( j * CELL_SIZE ); 
				int recY = gap + ( i * CELL_SIZE );
				g.setColor(Color.magenta);
				g.drawRect(recX,recY,width,height);
				g.setColor(new Color(102,51,0));
				g.fillRect(recX,recY,width,height);
				if( arr[i][j] != 0 ) {
					String num = String.valueOf(arr[i][j]);
					int stringX = (int) (95 - g.getFontMetrics().stringWidth(num)) / 2 + ( j *  CELL_SIZE);
					int stringY = (int) (95 + g.getFontMetrics().getAscent()) / 2 + ( i * CELL_SIZE);
					drawNum(num,g,stringX,stringY);
				}
				if( arr[i][j] == 0) {
					g.setColor(new Color(153,102,0));
					g.fillRect(recX,recY,width,height);
				}
			}
		}
	}

	public void drawNum(String num, Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		g.drawString(num,x,y);
	}

	public void moveCheck(int row, int col) {
		if (row-1>=0) {
			if (arr[row-1][col] == 0) {
				arr[row-1][col] = arr[row][col];
				arr[row][col] = 0;
			}
		}
		if (row+1<rows) {
			if (arr[row+1][col] == 0) {
				arr[row+1][col] = arr[row][col];
				arr[row][col] = 0;
			}
		}
		if (col-1>=0) {
			if (arr[row][col-1] == 0) {
				arr[row][col-1] = arr[row][col];
				arr[row][col] = 0;
			}
		}
		if (col+1<cols) {
			if (arr[row][col+1] == 0) {
				arr[row][col+1] = arr[row][col];
				arr[row][col] = 0;
			}
		}
	}

	public boolean isWon() {
		int checkHor = (rows*cols) - 1;
		int checkVer = (rows*cols) - 1;
		int count = 1 ;
		for (int i=0; i < rows ;i++) {
			for (int j=0; j < cols ;j++) {
				if (arr[i][j] == count) {
					checkHor --;
				}

				if (arr[j][i] == count) {
					checkVer --;
				}
				count ++;
			}
		}
		if (checkHor == 0 || checkVer == 0) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Test());
		frame.pack();
		frame.setVisible(true);
	}
}