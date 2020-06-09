package cr.ac.tec.Minigames.PRS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetGame {
    /**
     *
     * @param text1
     * @param text2
     * @return
     */
    public Scene getScene(String text1,String text2) {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("GameScene.fxml"));
            Parent Root = loader.load();
            PRSController Controller=loader.getController();
            Controller.setName1(text1);
            Controller.setName2(text2);
            return new Scene(Root);
        }
        catch (Exception e){return null;}
    }
}
