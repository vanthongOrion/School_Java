import javax.swing.*;
import java.awt.FlowLayout;

public class TestJframe {
	public static void main(String[] args){
		JFrame frame = new JFrame("The first of Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);

		//add layout into frame
		frame.setLayout(new FlowLayout());

		//instance and add label into frame
		JLabel label = new JLabel("Hello World");
		frame.add(label);

		//instance and add button into frame
		JButton button = new JButton("click here");
		frame.add(button);


		frame.setVisible(true);
		System.out.println("show Frame");
	}
}