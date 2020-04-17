package cr.ac.tec.Minigames.PRS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetGame {
    public  Scene getScene() {
        try {
            Parent Root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
            return new Scene(Root);
        }
        catch (Exception e){return null;}
    }

}
