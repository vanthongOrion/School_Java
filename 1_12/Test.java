
public class Test {
	public static void main(String[] args){

    for (int x = 0; x < 800; x++) {
      //iterate through every y pixel of the window
      for (int y = 0; y < 800; y++) {
      	System.out.println("x= " + x + "\n y= " + y);
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

		}
	}
}
}