package cr.ac.tec.Board.Other;


import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainMenu extends Application {
    private Stage stage = new Stage();
    private TextField player1Tf;
    private TextField player2Tf;
    private TextField player3Tf;
    private TextField player4Tf;
    private int numberOfPlayers=0;
    private DoubleList<String> playerNames = new DoubleList<>();

    public static void main(String[] args){
        launch(args);
    }

    /**
     * Creates the main menu page with respective buttons and text fields
     */
    public void createContent(){
        Canvas canvas = new Canvas(960,600);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        player1Tf = new TextField();
        player1Tf.setTranslateX(743);
        player1Tf.setTranslateY(270);

        player2Tf = new TextField();
        player2Tf.setTranslateX(743);
        player2Tf.setTranslateY(310);

        player3Tf = new TextField();
        player3Tf.setTranslateX(743);
        player3Tf.setTranslateY(350);

        player4Tf = new TextField();
        player4Tf.setTranslateX(743);
        player4Tf.setTranslateY(390);

        Image play = new Image("Resources/Images/PlayButton.png");
        Image about = new Image("Resources/Images/AboutButton.png");

        Rectangle aboutButton = new Rectangle(20,560,70,32);
        aboutButton.setFill(Color.TRANSPARENT);
        aboutButton.setOnMouseClicked(e -> aboutInformation());


        Rectangle playButton = new Rectangle(720,520,150,57);
        playButton.setFill(Color.TRANSPARENT);
        playButton.setOnMouseClicked(e -> {
            numberOfPlayers();
            Board xd = new Board();
            Stage MainBoard = new Stage();
            xd.startBoard(MainBoard,numberOfPlayers);
            String[] temp={player1Tf.getText(),player2Tf.getText(),player3Tf.getText(),player4Tf.getText()};
            stage.close();
        });

        Group root = new Group();
        Scene scene = new Scene(root,960,600);
        root.getChildren().addAll(canvas,player1Tf,player2Tf,player3Tf,player4Tf,playButton,aboutButton);
        Image background = new Image("Resources/Images/DatosPartyBackground.png");
        graphicsContext.drawImage(background,0,0);
        graphicsContext.drawImage(play,720,520,150,57);
        graphicsContext.drawImage(about,20,560,70,32);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * An about page with information about the developers and some credits.
     */
    public void aboutInformation(){
        Group root = new Group();
        Scene scene = new Scene(root,500,550);
        Text text = new Text();
        text.setText("Datos party is a virtual board game designed to satisfy the\n"+"need to have a game with which you can play with your family\n"+ "and friends at home, now more than ever that we can't go outside\n" +"due to COVID-19.\n" +
                "\n" +
                "Objective\n" +
                "The objective of the game is to become the player with most\n"+"stars and coins through winning duels and collecting randomly\n"+ "placed stars around the map.\n" +
                "\n" +
                "Our Mission\n" +
                "Make quarantine a little less boring.\n" +
                "Trust us, we know how frustrating it can be to have to stay\n"+ "home all day, we believe in the idea of having fun to make\n"+ "your day go faster because while you're having fun\n"+ "you're never aware of time.\n" +
                "\n" +
                "Our Vission\n" +
                "Get as many families as possible to play our\n"+ "game and cause a positive impact on society."+
                "\n"+"\n" +"Created and Designed by:\n"+"Andrey Zuniga\n"+"Gabriel Solano\n"+"Miguel Mesen"
        );
        text.setX(15);
        text.setY(25);
        text.setFont(Font.font(16));
        Stage aboutStage = new Stage();
        root.getChildren().addAll(text);
        aboutStage.setTitle("About");
        aboutStage.setScene(scene);
        aboutStage.show();
    }


    /**
     * Calculates the number of players who input their names.
     */
    public void numberOfPlayers(){
        DoubleList<TextField> tfList = new DoubleList<>();
        tfList.AddHead(player1Tf);
        tfList.AddHead(player2Tf);
        tfList.AddHead(player3Tf);
        tfList.AddHead(player4Tf);
        for (int i = 0; i< tfList.getLength(); i++){
            if (!tfList.get(i).getText().equals("")){
                numberOfPlayers+=1;
                playerNames.AddTail(tfList.get(i).getText());
            }
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        createContent();
    }
}
