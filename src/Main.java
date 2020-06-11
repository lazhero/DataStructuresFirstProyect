import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static DoubleList<Integer> lista;


    public static void main(String[] args){
        lista = new DoubleList<>();
        lista.AddHead(1);
        lista.AddHead(2);
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(lista);
    }

}
