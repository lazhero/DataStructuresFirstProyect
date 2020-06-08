import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static DoubleList<Integer> dl;


    public static void main(String[] args){
        dl = new DoubleList<Integer>();
        dl.AddHead(0);
        dl.AddHead(1);
        dl.AddHead(2);
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(dl);
    }
}
