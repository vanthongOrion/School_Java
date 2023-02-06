import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    JPanel panel = new JPanel();
    panel.setFocusable(true);
    panel.addKeyListener(new MyKeyListener());

    frame.add(panel);
    frame.setVisible(true);
  }
}

class MyKeyListener implements KeyListener {
  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      System.out.println("Up arrow key pressed");
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      System.out.println("Down arrow key pressed");
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      System.out.println("Left arrow key pressed");
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      System.out.println("Right arrow key pressed");
    }
  }

  public void keyReleased(KeyEvent e) {
  }
}
