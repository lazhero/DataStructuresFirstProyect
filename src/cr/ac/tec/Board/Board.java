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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;


public class Board extends Application {
    public static GraphicsContext graphicsContext;
    public static HashMap<String, Image> images;

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage MainWindow) {
        images = new HashMap<>();
        Canvas canvas = new Canvas(1000,700);
        graphicsContext = canvas.getGraphicsContext2D();
        loadImages();
        drawImages();
        AnchorPane FirstLevelAnchorPane = LayoutCreation.Anchor(1000, 700);
        Scene scene =new Scene(FirstLevelAnchorPane,1000,700, Color.RED);


        FirstLevelAnchorPane.setStyle("-fx-background-color: #0078d7");
        TextField b = new TextField();
        b.setText("0");
        FirstLevelAnchorPane.setTopAnchor(b,155.0);
        GameManager gameManager=GameManager.getInstance(4,25,50,"src/Images/Piece","src/Images/MarioStar",".png");
        Button btn=WidgetCreation.CreateButton("Hola");
        Button btn1=new Button("Comprobar");
        btn1.setOnAction(e->gameManager.confirm());
        Button btn2=new Button("Teleport");
        btn2.setOnAction(e->gameManager.example(Integer.parseInt(b.getText())));
        Button btn3=new Button("Intercambio ");
        btn3.setOnAction(e->gameManager.prove(Integer.parseInt(b.getText())));
        FirstLevelAnchorPane.setTopAnchor(btn1,400.0);
        FirstLevelAnchorPane.setTopAnchor(btn2,500.0);
        FirstLevelAnchorPane.setTopAnchor(btn3,600.0);
        gameManager.Draw(FirstLevelAnchorPane);
        btn.setOnAction(e->gameManager.StartTurn(Integer.parseInt(b.getText())));

        CustomButton customButton = new CustomButton(images.get("HandRollingDice"),800,525,140,120);

        FirstLevelAnchorPane.getChildren().addAll(canvas,btn,b,btn1,btn2,btn3,customButton);
        MainWindow.setScene(scene);
        MainWindow.show();
    }

    public void drawImages(){
        Image background = new Image("Images/topViewBackground.png");
        graphicsContext.drawImage(background,0,0,1000,700);
    }

    public void loadImages(){
        images.put("HandRollingDice", new Image("Images/HandRollingDice.png"));
    }
}
