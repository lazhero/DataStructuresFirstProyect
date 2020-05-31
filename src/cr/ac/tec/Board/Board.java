package cr.ac.tec.Board;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.PathGenerator.*;
import cr.ac.tec.Board.Square.BlueSquare;
import cr.ac.tec.Board.Square.*;
import cr.ac.tec.Dice.Classes.Dice;
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
    private Dice dice = new Dice();
    private AnchorPane FirstLevelAnchorPane = LayoutCreation.Anchor(1000, 700);
    public CustomButton customButton;
    public static GameManager gameManager;
    private TextField textField;

    public static void main(String[] args){
        launch(args);
    }
    @Override

    public void start(Stage MainWindow) {
        images = new HashMap<>();
        Canvas canvas = new Canvas(1000,700);
        graphicsContext = canvas.getGraphicsContext2D();

        textField = new TextField();
        textField.setTranslateY(80);
        textField.setTranslateX(280);

        loadImages();
        drawImages();
        Scene scene =new Scene(FirstLevelAnchorPane,1000,700, Color.RED);
        boardButtons();
        FirstLevelAnchorPane.setStyle("-fx-background-color: #0078d7");
        gameManager= GameManager.getInstance(4,25,50,"src/Images/Piece","src/Images/MarioStar",".png");
        gameManager.Draw(FirstLevelAnchorPane);
        FirstLevelAnchorPane.getChildren().addAll(canvas,customButton,textField);
        MainWindow.setScene(scene);
        MainWindow.show();
    }

    public void boardButtons(){
        customButton = new CustomButton(images.get("HandRollingDice"),5,5,140,120);
        customButton.setOnMouseClicked(e -> {
            Board.gameManager.StartTurn(Integer.parseInt(textField.getText()));
        });
        //customButton.setOnMouseClicked(e ->dice.start());
    }

    public void drawImages(){
        Image background = new Image("Images/topViewBackground.png");
        graphicsContext.drawImage(background,0,0,1000,700);
    }

    public void loadImages(){
        images.put("HandRollingDice", new Image("Images/HandRollingDice.png"));
    }
}
