package cr.ac.tec.Minigames.Shoot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Prove  {
    /**
     *
     * @param dato1
     * @param dato2
     */
    public void StartGame(int dato1, int dato2){
        Stage stage = new Stage();
        GameController controller=new GameController();
        Parent Root= null;
        try {
            Root = FXMLLoader.load(getClass().getResource("ShootInterface.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
