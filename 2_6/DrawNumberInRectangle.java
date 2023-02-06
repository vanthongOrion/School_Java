import java.awt.*;
import javax.swing.*;

public class DrawNumberInRectangle extends JComponent {

    private int number;

    public DrawNumberInRectangle(int number) {
        this.number = number;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 50));
        g2d.drawString(String.valueOf(number), (width - g2d.getFontMetrics().stringWidth(String.valueOf(number))) / 2, (height + g2d.getFontMetrics().getAscent()) / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new DrawNumberInRectangle(123));
        frame.setVisible(true);
    }
}
