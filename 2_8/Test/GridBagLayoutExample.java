import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("GridBagLayout Example");
                frame.add(new CenterButtonsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static class CenterButtonsPane extends JPanel {
        public CenterButtonsPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JButton("Button 1"), gbc);

            gbc.gridy = 1;
            add(new JButton("Button 2"), gbc);

            gbc.gridy = 2;
            add(new JButton("Button 3"), gbc);
        }
    }
}
