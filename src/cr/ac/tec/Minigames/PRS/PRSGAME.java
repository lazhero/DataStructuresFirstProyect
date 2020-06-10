package cr.ac.tec.Minigames.PRS;

import cr.ac.tec.Board.LayoutCreation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class PRSGAME  {
    private Stage stage;

    public void StarGame(int dato1, int dato2){
        Stage primaryStage = new Stage();
        Scene scene=null;
        try {
            scene=new GetGame().getScene(dato1,dato2,primaryStage);

        }
        catch (Exception e){}
        primaryStage.setScene(scene);
        this.stage=primaryStage;
        primaryStage.show();


    }
    public Stage getStage(){
        return stage;
    }


}
