import java.awt.FlowLayout;
import javax.swing.*;

public class FlowLayoutTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flow Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);

		frame.setLayout(new FlowLayout());
		JLabel label = new JLabel("Hello World!");
		frame.add(label);
		JButton button = new JButton("Click here");
		frame.add(button);

		frame.setVisible(true);
		System.out.println("Show frame");
	}
}