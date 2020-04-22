package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.*;

public class Main extends Application {

    public static void game(){
        if (playable){
            if (player1Turn) {
                text.setText("Player 1, enter\n your number");
                button.setOnMouseClicked(e -> {
                    numberPlayer1 = Double.parseDouble(getNumber());
                    player1Turn = false;
                    game();
                });
            }
            if (!player1Turn){
                text.setText("Player 2, enter\n your number");
                button.setOnMouseClicked(e ->{
                    numberPlayer2 = Double.parseDouble(getNumber());
                    player1Turn = true;
                    checkDraw();
                    //verifyIfPlayable();
                });
            }
        }
    }

    public static void main(String[] args){
        generateRand(0,5);
        System.out.println(randomNumber);
        game();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
}
