package cr.ac.tec.Board;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.PathGenerator.*;
import cr.ac.tec.Board.Square.BlueSquare;
import cr.ac.tec.Board.Square.*;
import cr.ac.tec.Images.GetImages;
import cr.ac.tec.Minigames.PRS.GetGame;
import cr.ac.tec.Minigames.PRS.PRSGAME;
import cr.ac.tec.Random.Random;
import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.DoubleRoundList;
import cr.ac.tecLinkedList.List.List;
import cr.ac.tecLinkedList.List.SingleList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage MainWindow) {
        AnchorPane FirstLevelAnchorPane = LayoutCreation.Anchor(1300, 700);
        FirstLevelAnchorPane.setStyle("-fx-background-color: #0078d7");
        TextField b = new TextField();
        b.setText("0");
        FirstLevelAnchorPane.setTopAnchor(b,155.0);
        GameManager gameManager=GameManager.getInstance(4,5);
        Button btn=WidgetCreation.CreateButton("Hola");
        Button btn1=new Button("Comprobar");
        btn1.setOnAction(e->gameManager.confirm());
        FirstLevelAnchorPane.setTopAnchor(btn1,400.0);
        gameManager.Draw(FirstLevelAnchorPane);
        btn.setOnAction(e->gameManager.StartTurn(Integer.parseInt(b.getText())));
        FirstLevelAnchorPane.getChildren().addAll(btn,b,btn1);
        Scene scene =new Scene(FirstLevelAnchorPane,1300,700, Color.RED);
        MainWindow.setScene(scene);
        MainWindow.show();


    }
}
