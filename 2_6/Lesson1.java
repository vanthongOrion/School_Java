import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Lesson1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,800);

		JPanel mainPanel = new JPanel();
		BoxLayout mainBoxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainBoxLayout);

		JPanel radioButtonPanel = new JPanel();
		BoxLayout radioButtonLayout = new BoxLayout(radioButtonPanel, BoxLayout.X_AXIS);
		radioButtonPanel.setLayout(radioButtonLayout);

		JRadioButton httpButton = new JRadioButton("HTTPS");
		JRadioButton sshButton = new JRadioButton("SSH");

		radioButtonPanel.add(httpButton);
		radioButtonPanel.add(sshButton);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());

		JLabel userLabel = new JLabel("User ID:");
		inputPanel.add(userLabel, BorderLayout.WEST);

		JTextField textField = new JTextField();
		inputPanel.add(textField, BorderLayout.CENTER);

		JPanel inputPass = new JPanel();
		inputPass.setLayout(new BorderLayout());

		JLabel passwordLabel = new JLabel("PassWord:");
		inputPass.add(passwordLabel, BorderLayout.WEST);

		JPasswordField  password = new JPasswordField();
		inputPass.add(password, BorderLayout.CENTER);

		JPanel checkBoxPanel = new JPanel();
		BoxLayout checkBoxLayout = new BoxLayout(checkBoxPanel,BoxLayout.X_AXIS);
		checkBoxPanel.setLayout(checkBoxLayout);

		JCheckBox checkBox = new JCheckBox();
		JLabel hideLabel = new JLabel("Show Password");
		checkBoxPanel.add(checkBox);
		checkBoxPanel.add(hideLabel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton loginButton = new JButton("Login");
		JButton clearButton = new JButton("Clear");
		buttonPanel.add(loginButton);
		buttonPanel.add(clearButton);

		mainPanel.add(radioButtonPanel);
		mainPanel.add(inputPanel);
		mainPanel.add(inputPass);
		mainPanel.add(checkBoxPanel);
		mainPanel.add(buttonPanel);

		frame.add(mainPanel);
		frame.setSize(450,200);


		frame.setVisible(true);
	}
}