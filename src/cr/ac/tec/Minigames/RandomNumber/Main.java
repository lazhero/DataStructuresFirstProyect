package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.*;

public class Main extends Application {

    /**
     * Collects each number input by a player.
     */
    public static void game(){
        if (playable){
            if (player1Turn) {
                text.setText("Player 1, enter\n your number");
                text.setTranslateX(85);
                text.setTranslateY(100);
                button.setOnMouseClicked(e -> {
                    numberPlayer1 = Double.parseDouble(getNumber());
                    player1Turn = false;
                    game(); //We call game() again but this time player1Turn is false, this way it enters the second if.
                });
            }
            if (!player1Turn){
                text.setText("Player 2, enter\n your number");
                button.setOnMouseClicked(e ->{
                    numberPlayer2 = Double.parseDouble(getNumber());
                    player1Turn = true;
                    checkDraw(); //Once we finish the second if it checks if the game has a draw.
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
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
}
