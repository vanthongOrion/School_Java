import javax.swing.*;

public class SetLayoutTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame("set Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200); //width = 400 , height = 200

		frame.setLayout(null);
		JLabel label = new JLabel("Hello World!");
		label.setLocation(10,10);
		label.setSize(200,20);
		frame.add(label);

		JButton button = new JButton("Click here");
		button.setLocation(250, 100);
		button.setSize(100, 20);
		frame.add(button);

		frame.setVisible(true);
	}
}