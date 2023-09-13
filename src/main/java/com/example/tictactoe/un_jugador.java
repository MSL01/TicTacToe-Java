package com.example.tictactoe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

public class un_jugador extends Application{
    public boolean turn = true;
    public boolean pc = true;
    public boolean end = true;
    public boolean end2 = true;
    public int turno = 0;
    public int cont1 = 0, cont2 = 0;
    private Button A1;
    private Button A2;
    private Button A3;
    private Button B1;
    private Button B2;
    private Button B3;
    private Button C1;
    private Button C2;
    private Button C3;
    private TextField jugador;
    private TextField pc_p;
    private final String Player_name;
    private Label player_name;
    public un_jugador(String Player_name){
        this.Player_name = Player_name;
    }

    @Override
    public void start(Stage un_p){
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        MenuBar menuBar = new MenuBar();
        // Crear menú

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
        jugador = new TextField();
        jugador.setLayoutX(500);
        jugador.setLayoutY(200);
        jugador.setDisable(true);
        jugador.setPrefWidth(50);
        pc_p = new TextField();
        pc_p.setLayoutX(500);
        pc_p.setLayoutY(250);
        pc_p.setDisable(true);
        pc_p.setPrefWidth(50);

        Label pc_player = new Label("PC");
        pc_player.setLayoutX(400);
        pc_player.setLayoutY(250);
        pc_player.setFont(font2);
        player_name = new Label(Player_name);
        System.out.println(Player_name);
        player_name.setLayoutX(400);
        player_name.setLayoutY(200);
        player_name.setFont(font2);
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
        A1.setOnAction(this::button_click);
        A2.setOnAction(this::button_click);
        A3.setOnAction(this::button_click);
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
        B1.setOnAction(this::button_click);
        B2.setOnAction(this::button_click);
        B3.setOnAction(this::button_click);
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
        C1.setOnAction(this::button_click);
        C2.setOnAction(this::button_click);
        C3.setOnAction(this::button_click);
        //------------------botones-----------------------------
        Button reiniciar = new Button();
        reiniciar.setText("Reiniciar");
        reiniciar.setLayoutX(600);
        reiniciar.setLayoutY(300);
        reiniciar.setOnAction(actionEvent -> reiniciar());

        pane.getChildren().addAll(title, reiniciar,A1,A2,A3,B1,B2,B3,C1,C2,C3, jugador, pc_p, pc_player, player_name);
        root.setCenter(pane);
        root.setTop(menuBar);

        un_p.setScene(new Scene(root, 700, 400));
        un_p.setTitle("Tic Tac Toe, un jugador");
        un_p.show();
    }

    private void informacion(String mensje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información sobre el juego");
        alert.setHeaderText(null);
        alert.setContentText(mensje);
        alert.showAndWait();
    }

    private void button_click(ActionEvent event) {
        Button b = (Button)event.getSource();
        if (turn) {
            b.setText("X");
        } else {
            b.setText("O");
        }
        turn = !turn;
        b.setDisable(true);
        turno++;
        ganador();

        if (!turn && pc) {
            PC_Move();
        }
    }
    private void PC_Move() {
        Button move;
        move = buscarGanar("0");
        if (move == null) {
            move = buscarGanar("X");
            if (move == null) {
                move = buscarEs();
                if (move == null) {
                    move = buscarEspacio();
                }
            }
        }
        if (move != null) {
            move.fire();
        }
    }


    private Button buscarEspacio() {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setScene(scene);
        Parent root = scene.getRoot();
        Button b;
        for (Node c : root.getChildrenUnmodifiable()) {
            if (c instanceof Button) {
                b = (Button) c;
                if (b.getText().isEmpty()) {
                    return b;
                }
            }
        }
        return null;
    }





    private Button buscarEs(){
        if (A1.getText().equals("O")) {
            if (A3.getText().isEmpty()) {
                return A3;
            } else if (C3.getText().isEmpty()) {
                return C3;
            } else if (C1.getText().isEmpty()) {
                return C1;
            }
        }

        if (A3.getText().equals("O")) {
            if (A1.getText().isEmpty()) {
                return A1;
            } else if (C3.getText().isEmpty()) {
                return C3;
            } else if (C1.getText().isEmpty()) {
                return C1;
            }
        }

        if (C3.getText().equals("O")) {
            if (A1.getText().isEmpty()) {
                return A3;
            } else if (A3.getText().isEmpty()) {
                return A3;
            } else if (C1.getText().isEmpty()) {
                return C1;
            }
        }

        if (C1.getText().equals("O")) {
            if (A1.getText().isEmpty()) {
                return A3;
            } else if (A3.getText().isEmpty()) {
                return A3;
            } else if (C3.getText().isEmpty()) {
                return C3;
            }
        }

        if (A1.getText().isEmpty()) {
            return A1;
        } else if (A3.getText().isEmpty()) {
            return A3;
        } else if (C1.getText().isEmpty()) {
            return C1;
        } else if (C3.getText().isEmpty()) {
            return C3;
        }
        return null;
    }
    private Button buscarGanar(String mark) {
        // Horizontal Busqueda
        if ((A1.getText().equals(mark)) && (A2.getText().equals(mark)) && (A3.getText().isEmpty()))
            return A3;
        if ((A2.getText().equals(mark)) && (A3.getText().equals(mark)) && (A1.getText().isEmpty()))
            return A1;
        if ((A1.getText().equals(mark)) && (A3.getText().equals(mark)) && (A2.getText().isEmpty()))
            return A2;

        if ((B1.getText().equals(mark)) && (B2.getText().equals(mark)) && (B3.getText().isEmpty()))
            return B3;
        if ((B2.getText().equals(mark)) && (B3.getText().equals(mark)) && (B1.getText().isEmpty()))
            return B1;
        if ((B1.getText().equals(mark)) && (B3.getText().equals(mark)) && (B2.getText().isEmpty()))
            return B2;

        if ((C1.getText().equals(mark)) && (C2.getText().equals(mark)) && (C3.getText().isEmpty()))
            return C3;
        if ((C2.getText().equals(mark)) && (C3.getText().equals(mark)) && (C1.getText().isEmpty()))
            return C1;
        if ((C1.getText().equals(mark)) && (C3.getText().equals(mark)) && (C2.getText().isEmpty()))
            return C2;

        // Vertical Busqueda
        if ((A1.getText().equals(mark)) && (B1.getText().equals(mark)) && (C1.getText().isEmpty()))
            return C1;
        if ((B1.getText().equals(mark)) && (C1.getText().equals(mark)) && (A1.getText().isEmpty()))
            return A1;
        if ((A1.getText().equals(mark)) && (C1.getText().equals(mark)) && (B1.getText().isEmpty()))
            return B1;

        if ((A2.getText().equals(mark)) && (B2.getText().equals(mark)) && (C2.getText().isEmpty()))
            return C2;
        if ((B2.getText().equals(mark)) && (C2.getText().equals(mark)) && (A2.getText().isEmpty()))
            return A2;
        if ((A2.getText().equals(mark)) && (C2.getText().equals(mark)) && (B2.getText().isEmpty()))
            return B2;

        if ((A3.getText().equals(mark)) && (B3.getText().equals(mark)) && (C3.getText().isEmpty()))
            return C3;
        if ((B3.getText().equals(mark)) && (C3.getText().equals(mark)) && (A3.getText().isEmpty()))
            return A3;
        if ((A3.getText().equals(mark)) && (C3.getText().equals(mark)) && (B3.getText().isEmpty()))
            return B3;

        // Diagonal Busqueda
        if ((A1.getText().equals(mark)) && (B2.getText().equals(mark)) && (C3.getText().isEmpty()))
            return C3;
        if ((B2.getText().equals(mark)) && (C3.getText().equals(mark)) && (A1.getText().isEmpty()))
            return A1;
        if ((A1.getText().equals(mark)) && (C3.getText().equals(mark)) && (B2.getText().isEmpty()))
            return B2;

        if ((A3.getText().equals(mark)) && (B2.getText().equals(mark)) && (C1.getText().isEmpty()))
            return C1;
        if ((B2.getText().equals(mark)) && (C1.getText().equals(mark)) && (A3.getText().isEmpty()))
            return A3;
        if ((A3.getText().equals(mark)) && (C1.getText().equals(mark)) && (B2.getText().isEmpty()))
            return B2;

        return null;
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
            informacion(player_name.getText() + " Ha ganado la partida!");
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
            jugador.setText(String.valueOf(cont1));
            turn = true;
            pc = true;
        }

        if(end2){
            informacion("PC Ha ganado la partida!");
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
            pc_p.setText(String.valueOf(cont2));
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

    public static void main(String[] args){
        launch();
    }
}
