package cr.ac.tec.Minigames.PRS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetGame {
    /**
     *
     * @param player1
     * @param player2
     * @param primaryStage
     * @return
     */
    public Scene getScene(int player1,int player2,Stage primaryStage) {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("GameScene.fxml"));
            Parent Root = loader.load();
            PRSController Controller=loader.getController();
            Controller.setName1(Integer.toString(player1));
            Controller.setName2(Integer.toString(player2));
            Controller.setPrimaryStage(primaryStage);
            Controller.setPlayer1(player1);
            Controller.setPlayer2(player2);
            return new Scene(Root);
        }
        catch (Exception e){return null;}
    }
}
