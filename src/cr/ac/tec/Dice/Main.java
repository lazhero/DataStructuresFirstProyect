package cr.ac.tec.Dice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static cr.ac.tec.Dice.Animation.dice;
import static cr.ac.tec.Dice.Dice.rollDice;

public class Main extends Application {

    public static void main(String[] args) {
        rollDice();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(dice,169,169));
        primaryStage.show();
    }
}
