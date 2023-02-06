import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridGame2 extends JPanel {
  private int[][] grid = new int[3][3];
  private final int CELL_SIZE = 100;

  public GridGame2() {
    setPreferredSize(new Dimension(300, 300));
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int col = e.getX() / CELL_SIZE;
        int row = e.getY() / CELL_SIZE;
        grid[row][col] = (grid[row][col] + 1) % 10;
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
        if (grid[row][col] > 0) {
          g.setColor(Color.RED);
          g.fillRect(x + 10, y + 10, CELL_SIZE - 20, CELL_SIZE - 20);
          g.setColor(Color.WHITE);
          String number = Integer.toString(grid[row][col]);
          FontRenderContext frc = new FontRenderContext(null, true, true);
          Rectangle2D bounds = g.getFont().getStringBounds(number, frc);
          System.out.println("x = " + x + "\ny = " + y + "\n bound_y= " + bounds.getY());
          int stringX = (int)(x + CELL_SIZE / 2 - bounds.getWidth() / 2);
          int stringY = (int)(y + CELL_SIZE / 2 - bounds.getHeight() / 2 + bounds.getY());
          System.out.println("StringX= " + stringX + "\n StringY=" + stringY);
          g.drawString(number, stringX, stringY);
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
    frame.setContentPane(new GridGame2());
    frame.pack();
    frame.setVisible(true);
  }
}
