import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawStringExample extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawString("Hello, World!", 50, 50);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Draw String Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new DrawStringExample());
    frame.setSize(200, 100);
    frame.setVisible(true);
  }
}
