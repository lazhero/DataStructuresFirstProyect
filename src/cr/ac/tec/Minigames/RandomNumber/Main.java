package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.*;

/**
 *
 */
public class Main  {
    /**
     *
     * @param player1
     * @param player2
     */
    public void StartGame(int player1,int player2){
        Stage primaryStage=new Stage();
        primaryStage.setScene(new Scene(createContent(player1,player2,primaryStage)));
        primaryStage.show();
        generateRand(0,5);
        System.out.println(randomNumber);
        game(player1,player2);

    }
}
