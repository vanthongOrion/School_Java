import java.util.Random;


public class Test2 {
    static int rows = 3;
    static int cols = 3;
    static int[][] arr = new int[rows][cols];
    static int blankX, blankY;
    public static void main(String[] args) {
        init();
        for (int i=0; i< rows; i++) {
            for (int j=0; j< cols; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        // System.out.println("x=" + blankX + ",y=" + blankY);
    }
    public static void init() {
        Random rnd = new Random();
        int[] allNumbers = new int[(rows * cols)-1];
        for (int i = 1; i < allNumbers.length; i++) {
            allNumbers[i] = i;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("x=" + i + ",y= " + j);
                int nextIndex = rnd.nextInt(allNumbers.length - (i * cols + j));
                System.out.println("nextInt= " + nextIndex);
                arr[i][j] = allNumbers[nextIndex];
                allNumbers[nextIndex] = allNumbers[allNumbers.length - (i * cols + j) - 1];
            }
        }
        blankX = rows - 1;
        blankY = cols - 1;
    }

}
