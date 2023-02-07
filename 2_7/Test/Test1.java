import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setFocusable(true);
		panel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 38 || e.getKeyCode() == 87 ) {
					System.out.println("up");
				}
				if (e.getKeyCode() == 40 || e.getKeyCode() == 83 ) {
					System.out.println("down");
				}
				if (e.getKeyCode() == 37 || e.getKeyCode() == 65 ) {
					System.out.println("left");
				}
				if (e.getKeyCode() == 39 || e.getKeyCode() == 68 ) {
					System.out.println("right");
				}
			}
		});
		frame.add(panel);

		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}