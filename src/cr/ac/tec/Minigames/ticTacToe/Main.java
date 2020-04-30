package cr.ac.tec.Minigames.ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.ticTacToe.TicTacToe.createContent;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }


}
