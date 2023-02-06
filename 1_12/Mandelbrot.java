import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Mandelbrot extends JFrame {

  public Mandelbrot() {
    // The super constructor call creates a JFrame with the title "Mandelbrot Set"
    super("Mandelbrot Set");
    // Set the size and location of the window on the screen
    setBounds(100, 100, 800, 800);
    // Allow the user to resize the window
    setResizable(false);
    // Exit the program when the user closes the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void paint(Graphics g) {
    // iterate through every x pixel of the window
    for (int x = 0; x < getWidth(); x++) {
      //iterate through every y pixel of the window
      for (int y = 0; y < getHeight(); y++) {
        // converting pixel coordinate to the corresponding point in the complex plain 
        double a = (x - 400) / 200.0;
        double b = (y - 400) / 200.0;
        // initial value of z0
        double x1 = 0;
        double y1 = 0;
        // counter to keep track of the number of iterations
        int iteration = 0;
        // maximum number of iterations 
        int max_iteration = 1000;
        /*
          Iterating the function f(z) = z^2 + c,
          where c is the point in the complex plain represented by the current pixel
        */
        while (x1 * x1 + y1 * y1 <= 4 && iteration < max_iteration) {
          double x2 = x1 * x1 - y1 * y1 + a;
          double y2 = 2 * x1 * y1 + b;
          x1 = x2;
          y1 = y2;
          iteration++;
        }
        // checking if the point is inside the mandelbrot set or not
        if (iteration < max_iteration) {
          // color of the point based on the number of iterations
          g.setColor(Color.getHSBColor(iteration / 256f, 1, iteration / (iteration + 8f)));
          //drawing the point
          g.drawLine(x, y, x, y);
        }
      }
    }
  }

  public static void main(String[] args) {
    // creating an instance of the class
    new Mandelbrot().setVisible(true);
  }
}
