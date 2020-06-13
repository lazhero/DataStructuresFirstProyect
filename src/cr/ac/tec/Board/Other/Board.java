package cr.ac.tec.Board.Other;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Board.PlayerPrueba;
import cr.ac.tec.Dice.Classes.Dice;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * The main window is defined and elements are added
 */
public class Board{
    public static GraphicsContext graphicsContext;
    public static HashMap<String, Image> images;
    public static Dice dice = new Dice();
    private AnchorPane FirstLevelAnchorPane = LayoutCreation.Anchor(1000, 700);
    public Rectangle handButton;
    public static GameManager gameManager;
    private TextField textField;
    public static boolean displayHandImage=true;
    public Rectangle goButton;
    private Rectangle scoreButton;
    private Rectangle endButton;
    public static DoubleList<PlayerPrueba> playerList;

    /**
     * Start the main window
     * @author Miguel Mesen
     * @param MainWindow
     */
    public void startBoard(Stage MainWindow, int numberOfPlayers){
        images = new HashMap<>();
        Canvas canvas = new Canvas(1000,700);
        graphicsContext = canvas.getGraphicsContext2D();

        textField = new TextField();
        textField.setTranslateY(80);
        textField.setTranslateX(280);

        drawImages();
        Scene scene =new Scene(FirstLevelAnchorPane,1000,700, Color.RED);
        boardButtons();
        gameCycle();
        FirstLevelAnchorPane.setStyle("-fx-background-color: #0078d7");
        gameManager= GameManager.getInstance(numberOfPlayers,25,50,"src/Resources/Images/Piece","src/Resources/Images/MarioStar",".png");
        gameManager.Draw(FirstLevelAnchorPane);
        FirstLevelAnchorPane.getChildren().addAll(canvas, handButton, goButton, scoreButton, endButton);
        MainWindow.setScene(scene);
        MainWindow.show();
    }

    /**
     * Create the buttons on the board
     * @author Miguel Mesen
     */
    public void boardButtons(){
        PlayerPrueba player0 = new PlayerPrueba("Juan");
        PlayerPrueba player1 = new PlayerPrueba("Ana");
        PlayerPrueba player2 = new PlayerPrueba("Pedro");

        player1.setCoins(3);
        player1.setStars(2);

        player0.setStars(3);

        playerList = new DoubleList<>();
        playerList.AddHead(player0);
        playerList.AddHead(player1);
        playerList.AddHead(player2);

        endButton = new Rectangle(25,610,90,65);
        endButton.setFill(Color.TRANSPARENT);
        endButton.setOnMouseClicked(e -> {
            winnerScreen(calculateWinner());
        });

        scoreButton = new Rectangle(30,30,110,50);
        scoreButton.setFill(Color.TRANSPARENT);
        scoreButton.setOnMouseClicked(e -> scoreBoard(playerList));

        handButton = new Rectangle(770,510,240,206);
        handButton.setFill(Color.TRANSPARENT);
        handButton.setOnMouseClicked(e -> {
            //Board.gameManager.StartTurn(Integer.parseInt(textField.getText()));
            ThrowDice xd = new ThrowDice();
            xd.start();
        });


        goButton = new Rectangle(824,85,50,40);
        goButton.setFill(Color.TRANSPARENT);
        goButton.setOnMouseClicked(e ->{
            Dice xd = new Dice();
            Board.gameManager.StartTurn(Dice.finalNumber);
            Board.displayHandImage = true;
        });
    }

    public void scoreBoard(DoubleList<PlayerPrueba> playerList){
        int posy=125;
        int posxName=48;
        int posxCoins=260;
        int posxStars=372;
        Canvas canvas = new Canvas(480,400);
        GraphicsContext scoreGraphicsContext = canvas.getGraphicsContext2D();
        Image scoreBackground = new Image("Resources/Images/scoreBackground.png");
        scoreGraphicsContext.drawImage(scoreBackground,0,-50);
        Group root2 = new Group();
        Scene scene = new Scene(root2,480,400);
        Stage aboutStage = new Stage();
        root2.getChildren().addAll(canvas);
        for (int i=0; i<playerList.getLength(); i++){
            Text name = new Text();
            Text coins = new Text();
            Text stars = new Text();

            name.setText(playerList.get(i).getName());
            name.setFont(Font.font(50));
            name.setStroke(Color.BLACK);
            name.setFill(Color.WHITE);
            name.setX(posxName);
            name.setY(posy);

            coins.setText(String.valueOf(playerList.get(i).getCoins()));
            coins.setFont(Font.font(50));
            coins.setStroke(Color.BLACK);
            coins.setFill(Color.WHITE);
            coins.setX(posxCoins);
            coins.setY(posy);

            stars.setText(String.valueOf(playerList.get(i).getStars()));
            stars.setFont(Font.font(50));
            stars.setStroke(Color.BLACK);
            stars.setFill(Color.WHITE);
            stars.setX(posxStars);
            stars.setY(posy);

            posy+=50;
            root2.getChildren().addAll(name,coins,stars);
        }
        aboutStage.setTitle("Scoreboard");
        aboutStage.setScene(scene);
        aboutStage.show();
    }

    public PlayerPrueba calculateWinner(){
        PlayerPrueba winner = playerList.get(0);
        for (int i=0; i<playerList.getLength(); i++){
            if (winner.finalCoins() < playerList.get(i).finalCoins()){
                winner=playerList.get(i);
            }
        }
        System.out.println(winner.getName());
        return winner;
    }

    public void winnerScreen(PlayerPrueba player){
        Canvas canvas = new Canvas(500,550);
        GraphicsContext graphicsContext1 = canvas.getGraphicsContext2D();
        Image winnerBackground = new Image("Resources/Images/winnerBackground.jpg");
        graphicsContext1.drawImage(winnerBackground,50,100,400,450);
        Group root = new Group();
        Scene scene = new Scene(root,500,550);
        Text text = new Text();
        text.setText("Congratulations " + player.getName() + "!\n" + "You're the winner of Datos party game!\n" + "With a total amount of " + player.getCoins() + " coins and " + player.getStars() + " stars!");
        text.setFont(Font.font(25));
        text.setX(15);
        text.setY(25);
        Stage aboutStage = new Stage();
        root.getChildren().addAll(text,canvas);
        aboutStage.setTitle("Winner winner chicken dinner!");
        aboutStage.setScene(scene);
        aboutStage.show();
    }


    /**
     * Draws pictures on the board
     * @author Miguel Mesen
     */
    public void drawImages(){
        Image background = new Image("Resources/Images/topViewBackground.png");
        Image singleHand = new Image("Resources/Images/SingleHand.png");
        Image go = new Image("Resources/Images/goButton.png");
        Image score = new Image("Resources/Images/scoreButton.png");
        Image end = new Image("Resources/Images/endButton.png");

        graphicsContext.drawImage(background,0,0,1000,700);
        graphicsContext.drawImage(score,30,30,110,50);
        graphicsContext.drawImage(go,824,85,50,40);
        graphicsContext.drawImage(end,25,610,90,65);
        if (displayHandImage){
            graphicsContext.drawImage(singleHand,770,510,240,206);
        }
    }

    /**
     * @author
     */
    public void gameCycle(){
        long initialTime = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {

            //Este metodo se ejecuta aproximadamente unas 60 veces por segundo 60FPS.
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - initialTime) / 1000000000.0;
                drawImages();
            }
        };
        animationTimer.start();
    }
}
