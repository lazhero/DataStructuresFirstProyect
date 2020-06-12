package cr.ac.tec.Minigames.Shoot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */
public class GetGame {
    /**
     * This method is to get the scene
     * @author Andrey Zuñiga
     * @param player1
     * @param player2
     * @param stage
     * @return
     */
    public Scene getScene(int player1, int player2, Stage stage){
        Scene scene=null;
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ShootInterface.fxml"));
            scene=new Scene(fxmlLoader.load());
            GameController controller=fxmlLoader.getController();
            controller.setName1(Integer.toString(player1));
            controller.setName2(Integer.toString(player2));
            controller.setPlayer1(player1);
            controller.setPlayer2(player2);
            controller.setPrimaryStage(stage);
        }
        catch (Exception e){

        }
        return scene;
    }
}
