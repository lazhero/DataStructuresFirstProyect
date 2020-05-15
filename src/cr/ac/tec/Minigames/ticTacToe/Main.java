package cr.ac.tec.Minigames.ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.ticTacToe.TicTacToe.createContent;


public class Main  {
    public void StartGame(){
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
}
