package edu.fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PantallaFinal extends VBox {

    Stage stage;

    public PantallaFinal(Stage stage) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding((new Insets(25)));

        Image imagen = new Image("file:src/main/resources/images/background-final.png", 1950, 1100, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label etiqueta = new Label();
        etiqueta.setText("¡Felicitaciones ganaste el juego!");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiqueta.setTextFill(Color.web("#ffffff"));

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStyleClass().add("btn");

        botonSalir.setOnAction(e -> Platform.exit());

        this.getChildren().addAll(etiqueta, botonSalir);
    }
}
