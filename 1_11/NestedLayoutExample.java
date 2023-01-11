import java.awt.*;
import javax.swing.*;

public class NestedLayoutExample {
    public static void main(String[] args) {
        // Create a new JFrame container
        JFrame frame = new JFrame("Nested Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        // Create a JPanel container
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Create a JPanel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(600, 80));
        JLabel headerLabel = new JLabel("Welcome to Nested Layout Example");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(headerLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Create a JPanel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        contentPanel.add(button1);
        contentPanel.add(button2);
        contentPanel.add(button3);
        contentPanel.add(button4);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Create a JPanel for the footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setPreferredSize(new Dimension(600, 80));
        JLabel footerLabel = new JLabel("Copyright (c) 2022");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerPanel.add(footerLabel);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

