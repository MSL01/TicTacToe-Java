package com.example.tictactoe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class panel2 extends Application{
    public TextField nameP1;
    public TextField nameP2;
    private RadioButton p1;
    private RadioButton p2;
    public int setRadioB1 = 0;
    public int setRadioB2 = 0;
    @Override
    public void start(Stage second){
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        Label title = new Label("Ingrese nombre de usuarios");
        Font font = new Font("Arial", 25);
        title.setLayoutX(50);
        title.setLayoutY(20);
        title.setFont(font);
        title.setStyle("-fx-text-fill: red;");

        Label name_p1 = new Label("Nombre P1");
        name_p1.setLayoutX(40);
        name_p1.setLayoutY(100);
        nameP1 = new TextField();
        nameP1.setLayoutX(130);
        nameP1.setLayoutY(100);

        Label name_p2 = new Label("Nombre P2");
        name_p2.setLayoutX(40);
        name_p2.setLayoutY(150);
        nameP2 = new TextField();
        nameP2.setLayoutX(130);
        nameP2.setLayoutY(150);

        Label selected = new Label("¿Qué jugador desea empezar primero?");
        selected.setLayoutX(100);
        selected.setLayoutY(250);

        p1 = new RadioButton();
        p1.setText("Jugador 1");
        p1.setLayoutX(80);
        p1.setLayoutY(300);
        p1.setOnAction(this::selected);

        p2 = new RadioButton();
        p2.setText("Jugador 2");
        p2.setLayoutX(250);
        p2.setLayoutY(300);
        p2.setOnAction(this::selected);

        Button start = new Button("Empezar el Juego");
        start.setLayoutX(150);
        start.setLayoutY(340);
        start.setOnAction(actionEvent -> startGame(second));

        pane.getChildren().addAll(title, name_p1, name_p2, selected, nameP1, nameP2, p1, p2, start);
        root.setCenter(pane);
        second.setScene(new Scene(root, 400, 400));
        second.setTitle("Ingreso de Jugadores");
        second.show();

    }

    private void selected(ActionEvent e){
        if (p1.isSelected()){
            p2.setSelected(false);
        } else if (p2.isSelected()) {
            p1.setSelected(false);
        }
    }

    private void startGame(Stage second){
        if(p1.isSelected() && !Objects.equals(nameP1.getText(), "") && !Objects.equals(nameP2.getText(), "")){
            setRadioB1 = 1;
            dos_jugadores playes2 = new dos_jugadores(nameP1.getText(), nameP2.getText(), setRadioB1, setRadioB2);
            Stage newStage = new Stage();
            playes2.start(newStage);
            second.close();
        }
        if(p2.isSelected() && !Objects.equals(nameP1.getText(), "") && !Objects.equals(nameP2.getText(), "")){
            setRadioB2 = 1;
            dos_jugadores playes2 = new dos_jugadores(nameP1.getText(), nameP2.getText(), setRadioB1, setRadioB2);
            Stage newStage = new Stage();
            playes2.start(newStage);
            second.close();
        }
        if (!p1.isSelected() && !p2.isSelected()) {
            info("Seleccione que jugador va a empezar!");
        }
        if(Objects.equals(nameP1.getText(), "") || Objects.equals(nameP2.getText(), "")){
            info("Debe ingresar el nombre de los jugadores!");
        }
    }

    private void info(String msge){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(msge);
        alert.showAndWait();
    }

    public static void main(String[] args){
        launch();
    }
}
