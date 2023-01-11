import javax.swing.*;

public class TestJFrame2 {
	public static void main(String[] args) {
		//Create frame container
		JFrame frame = new JFrame("TestJFrame2");

		//Create size of frame
		frame.setSize(400,200);

		//Set the position of the frame
		// frame.setLocationRelativeTo(null);

		frame.setLayout(null);
		JLabel label = new JLabel("Hello World");
		label.setSize(200,20);
		label.setLocation(10,10);
		frame.add(label);

		JButton button = new JButton("Click here!");
		button.setSize(100,20);
		button.setLocation(250,100);
		frame.add(button);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
} 