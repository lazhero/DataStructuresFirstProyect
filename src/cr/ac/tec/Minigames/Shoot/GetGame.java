package cr.ac.tec.Minigames.Shoot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetGame {
    public Scene getScene(int a, int b){
        Scene scene=null;
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ShootInterface.fxml"));
            scene=new Scene(fxmlLoader.load());
            GameController controller=fxmlLoader.getController();
            controller.setName1(Integer.toString(a));
           controller.setName2(Integer.toString(b));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return scene;
    }
}
