package keyevents;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mario
 */
public class GridBoardController implements Initializable {

    private static final int GRID_SIZE = 5;
    @FXML
    private GridPane board;
    @FXML
    private Circle figure;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        board.widthProperty().addListener((observable, oldValue, newValue) -> {
            figure.setRadius((Math.min(newValue.doubleValue(), board.getWidth()) / GRID_SIZE) / 2);
        });
        board.heightProperty().addListener((observable, oldValue, newValue) -> {
            figure.setRadius((Math.min(newValue.doubleValue(), board.getHeight()) / GRID_SIZE) / 2);
        });
    }

    @FXML
    private void keyPressedAction(KeyEvent event) {
        if (null != event.getCode()) {
            switch (event.getCode()) {
                case UP:
                    if (GridPane.getRowIndex(figure) > 0) {
                        GridPane.setRowIndex(figure, GridPane.getRowIndex(figure) - 1);
                    }
                    break;
                case DOWN:
                    if (GridPane.getRowIndex(figure) + 1 < GRID_SIZE) {
                        GridPane.setRowIndex(figure, GridPane.getRowIndex(figure) + 1);
                    }
                    break;
                case LEFT:
                    if (GridPane.getColumnIndex(figure) > 0) {
                        GridPane.setColumnIndex(figure, GridPane.getColumnIndex(figure) - 1);
                    }
                    break;
                case RIGHT:
                    if (GridPane.getColumnIndex(figure) + 1 < GRID_SIZE) {
                        GridPane.setColumnIndex(figure, GridPane.getColumnIndex(figure) + 1);
                    }
                    break;
                default:
                    break;
            }
        }
        event.consume(); // no progagar mas
    }

}
