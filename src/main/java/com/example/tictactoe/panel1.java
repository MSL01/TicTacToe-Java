package com.example.tictactoe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;


public class panel1 extends Application{
    public Button one_player;
    private Stage newStage;
    private String Player_name;
    @Override
    public void start(Stage First){
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        MenuBar menuBar = new MenuBar();
        // Crear menú

        Menu menuArchivo = new Menu("Archivo");
        Menu help = new Menu("Ayuda");

        // Crear items
        MenuItem salir = new MenuItem("Salir");
        MenuItem info = new MenuItem("Información");

        menuArchivo.getItems().addAll(salir);
        help.getItems().addAll(info);

        salir.setOnAction(actionEvent -> Platform.exit());
        info.setOnAction(actionEvent -> informacion());
        menuBar.getMenus().addAll(menuArchivo, help);

        // Titulo-----------------------------------------------
        Label title = new Label();
        title.setText("Tres en raya");
        title.setLayoutX(150);
        title.setLayoutY(20);
        Font font = new Font("Arial", 20);
        title.setFont(font);

        //------------------botones-----------------------------
        one_player = new Button();
        one_player.setText("1 Jugador");
        one_player.setLayoutX(180);
        one_player.setLayoutY(100);
        one_player.setOnAction(actionEvent -> un_player_select(First));

        Button two_players = new Button();
        two_players.setText("2 Jugadores");
        two_players.setLayoutX(175);
        two_players.setLayoutY(150);
        two_players.setOnAction(actionEvent -> dos_player_select(First));

        Button exit = new Button();
        exit.setText("Salir");
        exit.setLayoutX(195);
        exit.setLayoutY(200);
        exit.setOnAction(actionEvent -> Platform.exit());

        pane.getChildren().addAll(title, one_player, two_players, exit);
        root.setCenter(pane);
        root.setTop(menuBar);

        First.setScene(new Scene(root, 400, 300));
        First.setTitle("Tic Tac Toe, Menú principal");
        First.show();

    }

    public void un_player_select(Stage First){

        TextInputDialog input_name = new TextInputDialog("");
        input_name.setTitle("Nombre del Jugador");
        input_name.setContentText("Ingrese el Nombre del Jugador");

        input_name.showAndWait().ifPresent(input_name_p -> {
            Player_name = input_name_p;
            un_jugador un_p = new un_jugador(Player_name);
            newStage = new Stage();
            un_p.start(newStage);
        });
        First.close();
    }

    private void dos_player_select(Stage First){
        newStage = new Stage();
        panel2 panel = new panel2();
        panel.start(newStage);
        First.close();
    }
    private void informacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información sobre el juego");
        alert.setHeaderText(null);
        alert.setContentText("El tres en línea, también conocido como Ceros y Cruces, tres en raya\\nes un juego de lápiz y papel entre dos jugadores: O y X, que marcan los espacios de un tablero de 3×3 alternadamente. Un jugador gana si consigue tener una línea de tres de sus símbolos: la línea puede ser horizontal, vertical o diagonal.");
        alert.showAndWait();
    }

    public static void main(String[] args){
        launch();
    }
}
