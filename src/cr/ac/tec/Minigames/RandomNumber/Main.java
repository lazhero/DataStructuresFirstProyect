package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.*;

public class Main extends Application {

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
