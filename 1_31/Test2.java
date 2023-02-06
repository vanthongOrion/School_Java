package sample;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test2 {
	public static void main(String[] args) {
		TestWindow gw = new TestWindow("TestWindow",400,300);
		gw.setVisible(true);
	}
}

class TestWindow extends JFrame implements MouseListener {
	public TestWindow(String title, int width, int height) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch( e.getButton() ) {
		case MouseEvent.BUTTON1 :
			System.out.println("left Click");
			break;
		case MouseEvent.BUTTON2 :
			System.out.println("wheel Click");
			break;
		case MouseEvent.BUTTON3 :
			System.out.println("right click");
			break;
		}
		System.out.println("Click Position" + e.getPoint());
	}

	@Override
	public void mousePressed(MouseEvent e){
		switch ( e.getButton()) {
		case MouseEvent.BUTTON1 :
			System.out.println("Left Clicked");
			break;
		case MouseEvent.BUTTON2 :
			System.out.println("Wheel Clicked");
			break;
		case MouseEvent.BUTTON3 :
			System.out.println("Right Clicked");
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch( e.getButton()) {
		case MouseEvent.BUTTON1 :
			System.out.println("Release Left");
			break;
		case MouseEvent.BUTTON2 :
			System.out.println("Release Wheel");
			break;
		case MouseEvent.BUTTON3 :
			System.out.println("Release Right");
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("window inner");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("out of window");
	}
}