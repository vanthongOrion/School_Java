import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginForm() {
        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panel.add(txtUsername);
        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);
        frame.add(panel, BorderLayout.CENTER);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                char[] password = txtPassword.getPassword();
                // Perform authentication here
                //...
                if(authenticate(username,password)) {
                  // success code
                }else {
                  // fail code
                }
            }
        });
        frame.add(btnLogin, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
