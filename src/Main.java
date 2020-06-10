import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static DoubleList<Integer> dl;


    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        TicTacToe xd = new TicTacToe();
        xd.StartGame(1,2);
    }

}
