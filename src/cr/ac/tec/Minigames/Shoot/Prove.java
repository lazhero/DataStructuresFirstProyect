package cr.ac.tec.Minigames.Shoot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Prove extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        GameController controller=new GameController();
        Parent Root= FXMLLoader.load(getClass().getResource("ShootInterface.fxml"));
        Scene scene=new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
