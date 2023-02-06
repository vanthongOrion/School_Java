import java.awt.BorderLayout;
import javax.swing.*;

public class BorderLayoutTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Border Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200); //width= 400, height= 200

		frame.setLayout(new BorderLayout());

		JLabel label = new JLabel("Hello World");
		frame.add(label, BorderLayout.CENTER);
		JButton buttonN = new JButton("North Button");
		frame.add(buttonN, BorderLayout.NORTH);
		JButton buttonS = new JButton("Sorth Button");
		frame.add(buttonS, BorderLayout.SOUTH);
		JButton buttonW = new JButton("West Button");
		frame.add(buttonW, BorderLayout.WEST);
		JButton buttonE = new JButton("East Button");
		frame.add(buttonE, BorderLayout.EAST);

		frame.setVisible(true);

	}
}