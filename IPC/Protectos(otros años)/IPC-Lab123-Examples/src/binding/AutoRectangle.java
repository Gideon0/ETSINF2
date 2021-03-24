package binding;

import javafx.application.*;
import javafx.beans.binding.Bindings;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

public class AutoRectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle(100, 100);
        StackPane p = new StackPane();
        p.setPrefWidth(200);
        p.setPrefHeight(200);
        p.getChildren().add(r);
        r.widthProperty().bind(
                Bindings.divide(
                        p.widthProperty(), 2));
        r.heightProperty().bind(
                Bindings.divide(
                        p.heightProperty(), 2));
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Rectangle");
        primaryStage.show();
    }
}
