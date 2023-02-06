package sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class Test extends JPanel {
	int x = 0;
	int y = 0;
	int mode = 0;
	int mx = 5;
	int my = 5;
	int cr = 0;
	int cg = 0;
	int cb = 255;
	int ct = 5;
	Random rand = new Random();

	public Test() {
		setPreferredSize(new Dimension(1900,1000));
		addMouseListener(new OnClick());
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(new Color(cr,cg,cb));
		g.fillOval(x, y, 50, 50);	
	}

	class AnimeThread extends Thread {
		public void run() {
			while(mode == 1) {
				x = x + mx;
				y = y + my;

				if (x > 1850) {
					mx = -5;
					cr = rand.nextInt(255);
					cg = rand.nextInt(255);
					cb = rand.nextInt(255);
					ct = rand.nextInt(10) * 5;
				}
				if (x < 0) {
					mx = 5;
					cr = rand.nextInt(255);
					cg = rand.nextInt(255);
					cb = rand.nextInt(255);
					ct = rand.nextInt(10) * 5;
				}
				if (y > 950) {
					my = -5;
					cr = rand.nextInt(255);
					cg = rand.nextInt(255);
					cb = rand.nextInt(255);
					ct = rand.nextInt(10) * 5;
				}
				if (y < 0) {
					my = 5;
					cr = rand.nextInt(255);
					cg = rand.nextInt(255);
					cb = rand.nextInt(255);
					ct = rand.nextInt(10) * 5;
				}

				repaint();

				try {
					Thread.sleep(ct);
				} catch(Exception e) {
				}
			}
		}
	}

	class OnClick extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (mode == 0) {
				mode = 1;

				Thread th = new AnimeThread();
				th.start();
			} else {
				mode = 0;
			}
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(new Test());
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(1900, 1000);
		f.setVisible(true);
	}

}