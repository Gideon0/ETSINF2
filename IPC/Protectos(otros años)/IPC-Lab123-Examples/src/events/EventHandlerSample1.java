package events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventHandlerSample1 extends Application {

    Label label;

    @Override
    public void start(Stage stage) {
        // Creamos los controles  
        label = new Label();
        label.setFont(Font.font("Times New Roman", 22));
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

//        button1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                label.setText("Button 1");
//            }
//        });
        button1.setOnAction((ActionEvent e) -> {
            label.setText("Button 1");
        });

        button2.setOnAction((ActionEvent e) -> {
            label.setText("Button 2");
        });
// Eventos de ratón
        DropShadow shadow = new DropShadow();
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            button2.setEffect(shadow);
        });

        button2.setOnMouseExited((MouseEvent e) -> {
            button2.setEffect(null);
        });

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

    class ButtonActionHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            label.setText("Button 1");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
