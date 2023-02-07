import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardExample {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Keyboard Example");
      Container content = frame.getContentPane();

      JTextField textField = new JTextField();
      textField.setFocusable(true);

      content.add(textField, BorderLayout.NORTH);

      JTextArea textArea = new JTextArea();
      textArea.setFocusable(false);

      content.add(new JScrollPane(textArea), BorderLayout.CENTER);

      textField.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            textArea.append(String.valueOf(e.getKeyChar()));
         }
      });

      frame.setSize(400, 300);
      frame.setVisible(true);
   }
}
