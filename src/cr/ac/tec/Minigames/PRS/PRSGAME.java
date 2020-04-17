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

public class PRSGAME extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent Root= FXMLLoader.load(getClass().getResource("GameScene.fxml"));
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
