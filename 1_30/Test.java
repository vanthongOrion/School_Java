import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    int[][] puzzle = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int x = 2, y = 2;
    
    Scanner in = new Scanner(System.in);
    while (true) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          System.out.print(puzzle[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println("Move (U)p, (D)own, (L)eft, (R)ight: ");
      String move = in.nextLine();
      if (move.equals("U") && x > 0) {
        puzzle[x][y] = puzzle[x - 1][y];
        puzzle[--x][y] = 0;
      } else if (move.equals("D") && x < 2) {
        puzzle[x][y] = puzzle[x + 1][y];
        puzzle[++x][y] = 0;
      } else if (move.equals("L") && y > 0) {
        puzzle[x][y] = puzzle[x][y - 1];
        puzzle[x][--y] = 0;
      } else if (move.equals("R") && y < 2) {
        puzzle[x][y] = puzzle[x][y + 1];
        puzzle[x][++y] = 0;
      }
      System.out.println("x= " + x);
    }
  }
}
