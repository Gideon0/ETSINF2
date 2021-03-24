package events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventHandlerSample2 extends Application {

    Label label = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Creamos los controles  

        label.setFont(Font.font("Times New Roman", 22));
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        button1.setId("button1");
        button2.setId("button2");
        button1.setOnAction(this::buttonClicked);
        button2.setOnAction((ActionEvent e) -> buttonClicked(e));

        // Creamos contenedor (VBox) y añadimos controles        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.getChildren().add(button1);
        vbox.getChildren().add(button2);
        vbox.getChildren().add(label);

// Creamos escena usando el vbox como nodo raíz y dándole un tamaño 
        Scene scene = new Scene(vbox, 250, 200);

        //Evento de teclado
        scene.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode() == KeyCode.ESCAPE) {
                System.out.println("Key Pressed: " + ke.getCode());
                stage.close();
            }
        });

        // Establecemos propiedades del stage (ventana principal)
        stage.setTitle("Eventos");
        // Establecemos la escena actual del stage y mostramos
        stage.setScene(scene);
        stage.show();
    }

    void buttonClicked(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        Button button = (Button) event.getSource();
        label.setText(button.getText());
    }

    void buttonClicked2(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        if (id.equals("button1")) {
            label.setText("Button 1");
        } else {
            label.setText("Button 2");
        }
    }
}
