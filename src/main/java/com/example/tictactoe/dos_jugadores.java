package com.example.tictactoe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


public class dos_jugadores extends Application {
    public boolean turn = true;
    public boolean end =  true;
    public boolean end2 = true;
    public int cont1 = 0;
    public int cont2 = 0;

    private Button A1;
    private Button A2;
    private Button A3;
    private Button B1;
    private Button B2;
    private Button B3;
    private Button C1;
    private Button C2;
    private Button C3;
    private TextField jugador1;
    private TextField jugador2;
    private final String player_name1;
    private Label playerName1;
    private final String player_name2;
    private Label playerName2;
    private final int setRadioB1;
    private final int setRadioB2;
    private RadioButton radio_p1;
    private RadioButton radio_p2;
    public dos_jugadores(String player_name1, String player_name2, int setRadio1, int setRadio2){
        this.player_name1 = player_name1;
        this.player_name2 = player_name2;
        this.setRadioB1 = setRadio1;
        this.setRadioB2 = setRadio2;
    }


    @Override
    public void start(Stage two_p){
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("Inicio");
        Menu help = new Menu("Ayuda");

        // Crear items
        MenuItem salir = new MenuItem("Salir");
        MenuItem reiniciar_juego = new MenuItem("Reiniciar el juego");
        MenuItem regresar = new MenuItem("Regresar al menú principal");
        MenuItem info = new MenuItem("Información");

        menuArchivo.getItems().addAll(reiniciar_juego,regresar,salir);
        help.getItems().addAll(info);

        salir.setOnAction(actionEvent -> Platform.exit());
        info.setOnAction(actionEvent -> informacion("El tres en línea, también conocido como Ceros y Cruces, tres en raya\\nes un juego de lápiz y papel entre dos jugadores: O y X, que marcan los espacios de un tablero de 3×3 alternadamente. Un jugador gana si consigue tener una línea de tres de sus símbolos: la línea puede ser horizontal, vertical o diagonal."));
        menuBar.getMenus().addAll(menuArchivo, help);

        // Titulo-----------------------------------------------
        Label title = new Label();
        title.setText("Puntuaciones");
        title.setLayoutX(500);
        title.setLayoutY(20);
        title.setTextFill(Color.RED);
        Font font = new Font("Arial", 25);
        Font font2 = new Font("Arial", 18);
        title.setFont(font);
        //--------------------------------Resultados----------------
        jugador1 = new TextField();
        jugador1.setLayoutX(500);
        jugador1.setLayoutY(200);
        jugador1.setDisable(true);
        jugador1.setPrefWidth(50);
        jugador2 = new TextField();
        jugador2.setLayoutX(500);
        jugador2.setLayoutY(250);
        jugador2.setDisable(true);
        jugador2.setPrefWidth(50);

        playerName1 = new Label(player_name1);
        playerName1.setLayoutX(400);
        playerName1.setLayoutY(200);
        playerName1.setFont(font2);

        playerName2 = new Label(player_name2);
        playerName2.setLayoutX(400);
        playerName2.setLayoutY(250);
        playerName2.setFont(font2);
        //------------------------A-----------------------------
        A1 = new Button();
        A1.setLayoutX(50);
        A1.setLayoutY(70);
        A1.setPrefWidth(80);
        A1.setPrefHeight(80);
        Font newFont = new Font("Microsoft Sans Serif", 40);
        A1.setFont(newFont);
        A2 = new Button();
        A2.setLayoutX(140);
        A2.setLayoutY(70);
        A2.setPrefWidth(80);
        A2.setPrefHeight(80);
        A2.setFont(newFont);
        A3 = new Button();
        A3.setLayoutX(230);
        A3.setLayoutY(70);
        A3.setPrefWidth(80);
        A3.setPrefHeight(80);
        A3.setFont(newFont);
        //------------------------B-----------------------------
        B1 = new Button();
        B1.setLayoutX(50);
        B1.setLayoutY(160);
        B1.setPrefWidth(80);
        B1.setPrefHeight(80);
        B1.setFont(newFont);
        B2 = new Button();
        B2.setLayoutX(140);
        B2.setLayoutY(160);
        B2.setPrefWidth(80);
        B2.setPrefHeight(80);
        B2.setFont(newFont);
        B3 = new Button();
        B3.setLayoutX(230);
        B3.setLayoutY(160);
        B3.setPrefWidth(80);
        B3.setPrefHeight(80);
        B3.setFont(newFont);

        //-------------------------C----------------------------
        C1 = new Button();
        C1.setLayoutX(50);
        C1.setLayoutY(250);
        C1.setPrefWidth(80);
        C1.setPrefHeight(80);
        C1.setFont(newFont);
        C2 = new Button();
        C2.setLayoutX(140);
        C2.setLayoutY(250);
        C2.setPrefWidth(80);
        C2.setPrefHeight(80);
        C2.setFont(newFont);
        C3 = new Button();
        C3.setLayoutX(230);
        C3.setLayoutY(250);
        C3.setPrefWidth(80);
        C3.setPrefHeight(80);
        C3.setFont(newFont);


        //--------------------RadioButton--------------------------------
        Label turn = new Label("Turno:");
        turn.setLayoutX(500);
        turn.setLayoutY(80);
        turn.setFont(font2);
        radio_p1 = new RadioButton(player_name1);
        radio_p1.setLayoutX(500);
        radio_p1.setLayoutY(120);
        radio_p2 = new RadioButton(player_name2);
        radio_p2.setLayoutX(500);
        radio_p2.setLayoutY(150);
        radio_p1.setDisable(true);
        radio_p2.setDisable(true);

        if(setRadioB1 == 1){
            A1.setOnAction(this::button_click1);
            A2.setOnAction(this::button_click1);
            A3.setOnAction(this::button_click1);
            B1.setOnAction(this::button_click1);
            B2.setOnAction(this::button_click1);
            B3.setOnAction(this::button_click1);
            C1.setOnAction(this::button_click1);
            C2.setOnAction(this::button_click1);
            C3.setOnAction(this::button_click1);
            radio_p1.setOnAction(this::button_click1);
            radio_p2.setOnAction(this::button_click1);
        }

        if(setRadioB2 == 1){
            A1.setOnAction(this::button_click2);
            A2.setOnAction(this::button_click2);
            A3.setOnAction(this::button_click2);
            B1.setOnAction(this::button_click2);
            B2.setOnAction(this::button_click2);
            B3.setOnAction(this::button_click2);
            C1.setOnAction(this::button_click2);
            C2.setOnAction(this::button_click2);
            C3.setOnAction(this::button_click2);
            radio_p1.setOnAction(this::button_click2);
            radio_p2.setOnAction(this::button_click2);
        }

        if(setRadioB1 == 1){
            radio_p1.setSelected(true);
        }
        if(setRadioB2 == 1){
            radio_p2.setSelected(true);
        }
        //------------------botones-----------------------------
        Button reiniciar = new Button();
        reiniciar.setText("Reiniciar");
        reiniciar.setLayoutX(600);
        reiniciar.setLayoutY(300);
        reiniciar.setOnAction(actionEvent -> reiniciar());

        pane.getChildren().addAll(title, reiniciar,A1,A2,A3,B1,B2,B3,C1,C2,C3,
                jugador1, jugador2, playerName1, playerName2, radio_p1, radio_p2, turn);
        root.setCenter(pane);
        root.setTop(menuBar);

        two_p.setScene(new Scene(root, 700, 400));
        two_p.setTitle("Tic Tac Toe, dos jugadores");
        two_p.show();
    }

    private void button_click1(ActionEvent event) {
        Button b = (Button)event.getSource();
        if(turn){
            radio_p2.setSelected(true);
            radio_p1.setSelected(false);
            b.setText("X");
        }
        else {
            radio_p2.setSelected(false);
            radio_p1.setSelected(true);
            b.setText("O");
        }

        turn = !turn;
        b.setDisable(true);
        ganador();
    }
    private void button_click2(ActionEvent event){
        Button b = (Button)event.getSource();
        if(turn){
            radio_p2.setSelected(false);
            radio_p1.setSelected(true);
            b.setText("O");
        }
        else {
            radio_p2.setSelected(true);
            radio_p1.setSelected(false);
            b.setText("X");
        }
        turn = !turn;
        b.setDisable(true);
        ganador();
    }

    public void ganador(){
        end = false;
        end2 = false;
        //----------------diagonales--------------------------------------------
        if (A1.getText().equals("X") && B2.getText().equals("X") && C3.getText().equals("X")){
            end = true;
        }
        if (A3.getText().equals("X") && B2.getText().equals("X") && C1.getText().equals("X")){
            end = true;
        }
        //-------------------------Horizontal-----------------------------------------
        if (A1.getText().equals("X") && B1.getText().equals("X") && C1.getText().equals("X")){
            end = true;
        }
        if (A2.getText().equals("X") && B2.getText().equals("X") && C2.getText().equals("X")){
            end = true;
        }
        if (A3.getText().equals("X") && B3.getText().equals("X") && C3.getText().equals("X")){
            end = true;
        }
        //---------------------------Vertcal------------------------------------------
        if (A1.getText().equals("X") && A2.getText().equals("X") && A3.getText().equals("X")){
            end = true;
        }
        if (B1.getText().equals("X") && B2.getText().equals("X") && B3.getText().equals("X")){
            end = true;
        }
        if (C1.getText().equals("X") && C2.getText().equals("X") && C3.getText().equals("X")){
            end = true;
        }

        //----------------------------GANA O--------------------------------------------------
        //----------------diagonales--------------------------------------------
        if (A1.getText().equals("O") && B2.getText().equals("O") && C3.getText().equals("O")){
            end2 = true;
        }
        if (A3.getText().equals("O") && B2.getText().equals("O") && C1.getText().equals("O")){
            end2 = true;
        }
        //-------------------------Horizontal-----------------------------------------
        if (A1.getText().equals("O") && B1.getText().equals("O") && C1.getText().equals("O")){
            end2 = true;
        }
        if (A2.getText().equals("O") && B2.getText().equals("O") && C2.getText().equals("O")){
            end2 = true;
        }
        if (A3.getText().equals("O") && B3.getText().equals("O") && C3.getText().equals("O")){
            end2 = true;
        }
        //---------------------------Vertcal------------------------------------------
        if (A1.getText().equals("O") && A2.getText().equals("O") && A3.getText().equals("O")){
            end2 = true;
        }
        if (B1.getText().equals("O") && B2.getText().equals("O") && B3.getText().equals("O")){
            end2 = true;
        }
        if (C1.getText().equals("O") && C2.getText().equals("O") && C3.getText().equals("O")){
            end2 = true;
        }

        if(end){
            informacion(playerName1.getText() + " Ha ganado la partida!");
            A1.setDisable(true);
            A2.setDisable(true);
            A3.setDisable(true);
            B1.setDisable(true);
            B2.setDisable(true);
            B3.setDisable(true);
            C1.setDisable(true);
            C2.setDisable(true);
            C3.setDisable(true);
            cont1++;
            jugador1.setText(String.valueOf(cont1));
            turn = true;
        }

        if(end2){
            informacion(playerName2.getText() + " Ha ganado la partida");
            A1.setDisable(true);
            A2.setDisable(true);
            A3.setDisable(true);
            B1.setDisable(true);
            B2.setDisable(true);
            B3.setDisable(true);
            C1.setDisable(true);
            C2.setDisable(true);
            C3.setDisable(true);
            cont2++;
            jugador2.setText(String.valueOf(cont2));
            turn = true;
        }

        if(A1.isDisabled() && A2.isDisabled() && A3.isDisabled()){
            if(B1.isDisabled() && B2.isDisabled() && B3.isDisabled()){
                if(C1.isDisabled() && C2.isDisabled() && C3.isDisabled()){
                    if(!end && !end2){
                        informacion("Empate!");
                        turn = true;
                    }
                }
            }
        }
    }

    private void reiniciar(){
        A1.setDisable(false);
        A1.setText("");
        A2.setDisable(false);
        A2.setText("");
        A3.setDisable(false);
        A3.setText("");

        B1.setDisable(false);
        B1.setText("");
        B2.setDisable(false);
        B2.setText("");
        B3.setDisable(false);
        B3.setText("");

        C1.setDisable(false);
        C1.setText("");
        C2.setDisable(false);
        C2.setText("");
        C3.setDisable(false);
        C3.setText("");

    }

    private void informacion(String mensje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información sobre el juego");
        alert.setHeaderText(null);
        alert.setContentText(mensje);
        alert.showAndWait();
    }

    public static void main(String[] args){
        launch();
    }
}
