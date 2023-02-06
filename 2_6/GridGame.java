import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridGame extends JPanel {
  private int[][] grid = new int[3][3];
  private final int CELL_SIZE = 100;

  public GridGame() {
    setPreferredSize(new Dimension(300, 300));
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int col = e.getX() / CELL_SIZE;
        int row = e.getY() / CELL_SIZE;
        System.out.println("x=" + e.getX() + ",y= " + e.getY());
        grid[row][col] = 1;
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        int x = col * CELL_SIZE;
        int y = row * CELL_SIZE;
        if (grid[row][col] == 1) {
          g.setColor(Color.RED);
          g.fillRect(x + 10, y + 10, CELL_SIZE - 20, CELL_SIZE - 20);
        } else {
          g.setColor(Color.BLACK);
          g.drawRect(x + 10, y + 10, CELL_SIZE - 20, CELL_SIZE - 20);
        }
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Grid Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new GridGame());
    frame.pack();
    frame.setVisible(true);
  }
}
