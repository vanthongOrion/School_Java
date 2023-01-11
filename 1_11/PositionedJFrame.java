import javax.swing.*;

public class PositionedJFrame {
    public static void main(String[] args) {
        // Create a new JFrame container
        JFrame frame = new JFrame("Positioned JFrame");

        // Set the size of the frame
        frame.setSize(300, 200);

        // Set the position of the frame
        frame.setLocation(200, 200);

        //center the window on the center of screen
        frame.setLocationRelativeTo(null);

        // x-coordinate, y-coordinate, width and height, 
        //in this way you can set the size and position of the frame at once.
        frame.setBounds(0,0,200,300);

        // Terminate the program when the user closes the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
