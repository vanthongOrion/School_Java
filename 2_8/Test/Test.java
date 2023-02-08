import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				System.out.println(point);
			}
		});
		frame.setSize(400,300);
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}