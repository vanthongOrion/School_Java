

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class StartPanelTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));

		startPanel.add(new JButton("button 1"));
		startPanel.add(new JButton("button 2"));
		startPanel.add(new JButton("button 3"));
		frame.add(startPanel);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}