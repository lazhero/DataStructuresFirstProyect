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
    public void StarGame(){
        Stage primaryStage = new Stage();
        Parent Root= null;
        try {
            Root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(Root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public  Scene getGame() throws Exception{
        Parent Root= FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        return new Scene(Root);
    }
    @FXML
    public static void hello(){
        System.out.println("Proving");
    }
}
