package listeners;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextSliderLabel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Creamos los controles  

        Label label = new Label();
        label.setFont(Font.font("Times New Roman", 22));
        TextField textField = new TextField();
        textField.setMaxWidth(100);
        Slider slider = new Slider(0, 5, 0);
        slider.setBlockIncrement(0.5);
        slider.setMaxWidth(150);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(newValue + "");
        });

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(newValue + "");
        });

        // Creamos contenedor (VBox) y añadimos controles        
        VBox vbox = new VBox();
        vbox.setPrefWidth(250);
        vbox.setPrefHeight(150);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.getChildren().add(textField);
        vbox.getChildren().add(slider);
        vbox.getChildren().add(label);

        // Creamos un nodo raíz para la escena, de tipo Group
        // y le añadimos el contenedor 
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(vbox);

        //Evento de teclado
        scene.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode() == KeyCode.ESCAPE) {
                System.out.println("Key Pressed: " + ke.getCode());
                stage.close();
            }
        });

        // Establecemos propiedades del stage (ventana principal)
        stage.setTitle("Oyentes");
        stage.setWidth(250);
        stage.setHeight(200);
        // Establecemos la escena actual del stage y mostramos
        stage.setScene(scene);
        stage.show();
    }

}
