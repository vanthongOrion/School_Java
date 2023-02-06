import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {
  private Button[][] buttons = new Button[3][3];
  private boolean isX = true;

  @Override
  public void start(Stage primaryStage) {
    GridPane grid = new GridPane();
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        buttons[row][col] = new Button();
        buttons[row][col].setMinSize(100, 100);
        buttons[row][col].setOnAction(e -> handleMove(e));
        grid.add(buttons[row][col], col, row);
      }
    }
    Scene scene = new Scene(grid, 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void handleMove(javafx.event.ActionEvent event) {
    Button b = (Button) event.getSource();
    if (b.getText().isEmpty()) {
      if (isX) {
        b.setText("X");
      } else {
        b.setText("O");
      }
      isX = !isX;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
