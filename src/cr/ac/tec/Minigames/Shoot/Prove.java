package cr.ac.tec.Minigames.Shoot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Prove  {
    private Stage stage;
    public void StartGame(int dato1, int dato2){
        Stage stage = new Stage();
        Scene scene=new GetGame().getScene(dato1,dato2);
        stage.setScene(scene);
        this.stage=stage;
        stage.show();

    }
    public Stage getStage(){
        return this.stage;
    }

}
