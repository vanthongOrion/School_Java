import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GameExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    JPanel gamePanel = new JPanel();
    JButton playButton = new JButton("Play");
    playButton.addActionListener(new PlayActionListener(frame));
    gamePanel.add(playButton);

    JPanel winPanel = new JPanel();
    JButton restartButton = new JButton("Restart");
    restartButton.addActionListener(new RestartActionListener(frame));
    winPanel.add(restartButton);

    CardLayout cardLayout = new CardLayout();
    JPanel contentPane = new JPanel(cardLayout);
    contentPane.add(gamePanel, "Game");
    contentPane.add(winPanel, "Win");

    frame.setContentPane(contentPane);
    frame.setVisible(true);
  }
}

class PlayActionListener implements ActionListener {
  private JFrame frame;

  public PlayActionListener(JFrame frame) {
    this.frame = frame;
  }

  public void actionPerformed(ActionEvent e) {
    CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
    cardLayout.show(frame.getContentPane(), "Win");
  }
}

class RestartActionListener implements ActionListener {
  private JFrame frame;

  public RestartActionListener(JFrame frame) {
    this.frame = frame;
  }

  public void actionPerformed(ActionEvent e) {
    CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
    cardLayout.show(frame.getContentPane(), "Game");
  }
}
