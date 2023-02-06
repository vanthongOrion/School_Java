import java.awt.*;
import javax.swing.*;

public class BoxLayoutExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("BoxLayout Example");
    Container content = frame.getContentPane();

    BoxLayout layout = new BoxLayout(content, BoxLayout.Y_AXIS);
    content.setLayout(layout);

    content.add(new JButton("Button 1"));
    content.add(new JButton("Button 2"));
    content.add(new JButton("Button 3"));

    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
