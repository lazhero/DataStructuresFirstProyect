import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(1);
    }
}
