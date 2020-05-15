package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.*;

public class Main  {
    public void StartGame(){
        Stage primaryStage=new Stage();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        generateRand(0,5);
        System.out.println(randomNumber);
        game();

    }

}
