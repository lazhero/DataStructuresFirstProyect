import cr.ac.tec.Dice.Classes.Dice;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Dice dice = new Dice();
        dice.start();
    }
}
