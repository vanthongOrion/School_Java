import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FractalTest1 extends JFrame {

	public static void drawOrgFractal2 (Graphics g, int x, int y, int w , int h, int angle,int distance, int f) {
		if(f <=0 ) throw new IllegalArgumentException();
		int rw = w/2;
		int rh = h/2;
		int cx = x + rw;
		int r = x + w;
		int b = y + h;
		Color clr = g.getColor();

		drawOrgFractal2(g,cx,y,r,b,x,b,angle,distance,f,clr, new AffineTransform());
		g.setColor(clr);
	}

	public static void drawOrgFractal2(Graphics g , int x1, int y1, int x2, int y2,int x3, int y3, int angle, int distance, int f, Color clr, AffineTransform at){
		g.setColor(clr);

		int bcx = x2 + (x3-x2) / 2;
		int bcy = y2 + (y3-y2) / 2;

		int vx = bcx - x1;
		int vy = bcy - y1;

		double d = (int) Math.sqrt(vx*vx+vy*vy);

		double rad = Math.atan2(vy,vx);

		GeneralPath p = new GeneralPath();
		p.moveTo(x1, y1);
		p.lineTo(x2, y2);
		p.curveTo(x2, y2, bcx+Math.cos(rad) * (d*0.2),bcy+ Math.sin(rad)*(d*0.2), x3 , y3);
		p.closePath();
		Graphics2D g2 = (Graphics2D)g;
		g2.setTransform(at);
		g2.draw(p);

		g.drawOval(x1-2, y1-2,4 ,4);

		f--;
		if( f>=0 ) {
			int vx12 = x2 - x1;
			int vy12 = y2 - y1;

			int vx13 = x3 - x1;
			int vy13 = y3 - y1;

			int d12 = (int) Math.sqrt(vx12*vx12+vy12*vy12);

			double rad12 = Math.atan2(vy12,vx12);

			double rad13 = Math.atan2(vy13,vx13);

			double baseRad = Math.toRadians(angle);

			AffineTransform cat = new AffineTransform();
			cat.translate(bcx, bcy);
			cat.scale(at.getScaleX()*0.9, at.getScaleY()*0.9);
			cat.translate(-bcx, -bcy);

			double rrad = Math.toRadians(-180) + rad + baseRad;

			int rx1 = (int) (Math.cos(rrad) * distance + bcx);
			int ry1 = (int) (Math.sin(rrad) * distance + bcy);

			int rx2 = (int) (Math.cos(baseRad+rad12) * d12 + rx1);

			int ry2 = (int) (Math.sin(baseRad + rad12) * d12 + ry1);

			int rx3 = (int) (Math.cos(baseRad+rad13) * d12 + rx1);
			int ry3 = (int) (Math.sin(baseRad+rad13) * d12 + ry1);

			drawOrgFractal2(g,rx1,ry1,rx2,ry2,rx3,ry3,angle,distance,f,clr.brighter(),cat);

			cat.setToIdentity();
			cat.translate(bcx,bcy);
			cat.scale(at.getScaleX()*0.9, at.getScaleY() *0.9);
			cat.translate(-bcx , -bcy);

			double lrad = Math.toRadians(180) + rad - baseRad;

			int lx1 = (int) (Math.cos(lrad) * distance + bcx);
			int ly1 = (int) (Math.sin(lrad) * distance + bcy);

			int lx2 = (int) (Math.cos(-baseRad + rad12) * d12 +lx1);
			int ly2 = (int) (Math.sin(-baseRad + rad12) * d12 +ly1);

			int lx3 = (int) (Math.cos(-baseRad + rad13) * d12 + lx1); 
			int ly3 = (int) (Math.sin(-baseRad + rad13) * d12 + ly1); 

			drawOrgFractal2(g,lx1,ly1,lx2,ly2,lx3,ly3,angle,distance,f,clr.brighter(),cat);

		}
	}
	public static void main(String[] args){
		new FractalTest1();
	}

	FractalTest1(){
		add(new JPanel(){
			public void paint(Graphics g) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 1160, 1000);
				g.setColor(new Color(50,70,10));
				drawOrgFractal2(g,565,580,60,80,20,130,12);
			}
		});
		setSize(1160,1600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
