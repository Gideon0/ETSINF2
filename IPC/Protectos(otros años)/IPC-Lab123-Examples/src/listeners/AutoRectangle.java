package listeners;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.*;

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
        p.widthProperty().addListener(
                (observable, oldvalue, newvalue)
                -> r.setWidth((Double) newvalue / 2)
        );
        p.heightProperty().addListener(
                (observable, oldvalue, newvalue)
                -> r.setHeight((Double) newvalue / 2)
        );
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Rectangle");
        primaryStage.show();
    }
}
