import cr.ac.tec.Dice.Classes.Dice;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static DoubleList<Integer> dl;


    public static void main(String[] args){
        dl = new DoubleList<Integer>();
        dl.AddHead(1);
        dl.AddHead(2);
        dl.AddHead(3);
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(dl);
    }
}
