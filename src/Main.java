import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static DoubleList<String> playerList;

    public static void main(String[] args){
        playerList = new DoubleList<>();
        playerList.AddHead("Juan");
        playerList.AddHead("Pedro");
        playerList.AddHead("Ana");
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(playerList);
    }
}
