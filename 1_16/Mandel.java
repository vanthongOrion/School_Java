package lesson1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mandel extends JPanel {
	public int xs = 500, ys = 500;
	public static double yr, yi;

	public Mandel(){
		//set Background

	    // super("Mandelbrot Set");

		setBackground(Color.white);
		//set xs-ys 
		setPreferredSize(new Dimension(xs,ys));

	}

	protected void paintComponent(Graphics g){
		//paint background
		super.paintComponent(g);

		double X[] = new double[2];
		double Y[] = new double[2];
		double Z[] = new double[2];

		//set zoom ratio
		double Scl = 1.3 , VL = 1.0e100;
		double XP = 0.0 , YP = 0.0;

		//set measure of Red, Green, Blue
		double sR = 0.5, sG = 1.0 , sB = 0.7;
		double Xsl = 2.0/Scl;
		double Ysl = Xsl*ys/xs;
		Cmult PW = new Cmult();
		Y[0] = yr; Y[1] = 0;
		VL = Math.exp(Math.log(VL)*2.0/yr);
		for (int y=0; y<ys ; y++){
			for( int x=0 ; x<xs ; x++){
				double CR = Xsl * (2.0*x - xs)/xs + XP;
				double CI = Ysl * (2.0*y - ys)/ys - YP;
				double XR = 0.0; double XI = 0.0;

				X[0] = XR; X[1] = XI;

				for (int k=0; k<100 ; k++){
					PW.CPOWER(X, Y, Z);
					XR = X[0] = Z[0] + CR;
					XI = X[1] = Z[1] + CI;
					if( Math.abs(XR) + Math.abs(XI) > VL) break;
				} 

				double AR = Math.abs(XR);
				double AI = Math.abs(XI);
				int b = 0, r = 0, gr = 0;

				if (AR > 1.0) {
					b = (int) (sB*Math.log(AR)) + 1;
				} 
				if (AI > 1.0) {
					r = (int) (sR*Math.log(AI)) + 1;
				} 
				if (XR < -1.0) {
					gr += b;
					b = b/2;
				} 
				if (XI < -1.0) {
					gr += r;
					r = r/2;
				} 
				gr = (int) (sG*gr);
				if(b > 255) b = 255;
				if(r > 255) r = 255;
				if(gr > 255) gr = 255;
				g.setColor(new Color(r,gr,b));
				g.drawLine(x,y,x,y);
			}
		} 
		g.setColor(new Color(255,255,255));

		g.fillOval((xs-4)/2,(ys-4)/2,4,4);
	}

	public static void main(String[] args) throws Exception{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		System.out.println("input pair key:");
		String s1 = br.readLine();
		yr = Double.parseDouble(s1);
		JFrame frame = new JFrame("Draw Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Mandel h = new Mandel() ;
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
