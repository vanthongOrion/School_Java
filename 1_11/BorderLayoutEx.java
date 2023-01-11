import javax.swing.*;
import java.awt.BorderLayout;


public class BorderLayoutEx {
	public static void main(String[] args){
		JFrame frame = new JFrame("BorderLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);

		//set layout by borderLayout
		frame.setLayout(new BorderLayout());

		JLabel label = new JLabel("Hello World!");
		frame.add(label, BorderLayout.CENTER);

		JButton buttonN = new JButton("North");
		frame.add(buttonN, BorderLayout.NORTH);

		JButton buttonS = new JButton("South");
		frame.add(buttonS, BorderLayout.SOUTH);

		JButton buttonW = new JButton("West");
		frame.add(buttonW, BorderLayout.WEST);

		JButton buttonE = new JButton("East");
		frame.add(buttonE, BorderLayout.EAST);

		frame.setVisible(true);
	}
}