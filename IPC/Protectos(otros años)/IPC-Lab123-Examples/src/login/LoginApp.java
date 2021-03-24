package login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Login screen example. This version uses HBox and VBox as containers to layout
 * the graphical components. Resizable propery is set to false so the user cannot
 * change the dimensions of the window.
 * @author Mario Gómez
 */
public class LoginApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Login example");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
