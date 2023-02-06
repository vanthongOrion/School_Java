
import java.util.*;

public class PuzzleGame {
	private int rows,cols;
	private int[][] map;
	private BlankCell blank;

	public PuzzleGame(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		map = new int[rows][cols];
		this.init();
		blank = new BlankCell(rows-1,cols-1);
	}

	public class BlankCell {
		int x;
		int y;
		public BlankCell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void update(int x, int y) {
		if (isBlankZone(x,y)) {
			map[blank.x][blank.y] = map[x][y];
			map[x][y] = 0;
			blank.x = x;
			blank.y = y;
			print();
			System.out.println();
		}else {
			System.out.println("is not blank zone");
		}
	}

	public boolean isBlankZone(int x, int y) {
		for (int i=x-1; i<= x+1; i++){
			if (i >= 0 && i < rows) {
				if (map[i][y]==0 && i != x){
					return true;
				}
			}
		}
		for (int j=y-1; j<= y+1; j++){
			if (j >= 0 && j < cols) {
				if (map[x][j]==0 && j != y){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isWon() {
		int w = 1;
		for (int i=0; i<rows ;i++) {
			for (int j=0; j<cols ;j++) {
				if (!(i == rows-1 && j == cols-1)){
					if (map[i][j] != w) return false;
					w++;					
				}
			}
		}

		return true;
	}

	public void print() {
		for (int i=0 ; i<rows ;i++) {
			for (int j=0 ; j<cols ;j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public void init() {
		Random ran = new Random();
		for (int i=0 ; i<rows ; i++) {
			for (int j=0 ; j<cols ; j++) {
				if (i == (rows-1) && j == (cols-1)) {
					break;
				}
				while(map[i][j] == 0){
					int num = ran.nextInt((rows*cols) - 1) + 1;
					if(!isContains(num)) {
						map[i][j] = num;
					}	
				}
			}
		}
	}

	public boolean isContains(int num) {
		for (int i=0 ; i<rows ; i++) {
			for (int j=0 ; j<cols ; j++) {
				if (map[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PuzzleGame game = new PuzzleGame(5,4);
		game.print();
		while(!game.isWon()){
			System.out.print("Select your position at x = ");
			int x = scn.nextInt();
			System.out.print("y= ");
			int y = scn.nextInt();
			game.update(x,y);
		}
		System.out.println("You are winner");
	}
}

