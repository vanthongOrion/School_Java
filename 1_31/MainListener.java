import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainListener  {
	public static void main(String[] args) {
		JFrame frame = new JFrame("The first Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLayout(new FlowLayout());

		JLabel label = new JLabel("Hello World!");
		frame.add(label);
		JButton button = new JButton("Click here");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked");
			}
		});
		frame.add(button);

		frame.setVisible(true);
		System.out.println("Show Frame");

	}
}
