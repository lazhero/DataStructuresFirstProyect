package cr.ac.tec.Board.Other;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Dice.Classes.Dice;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
    public Rectangle customButton;
    public static GameManager gameManager;
    private TextField textField;
    public static boolean displayHandImage=true;
    public Button button;
    private Rectangle phoneButton;

    /**
     * Start the main window
     * @author Miguel Mesen
     * @param MainWindow
     */
    public void startBoard(Stage MainWindow, int numberOfPlayers){
        System.out.println("el numero de jugadores es " +numberOfPlayers);
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
        FirstLevelAnchorPane.getChildren().addAll(canvas,customButton,button,phoneButton);
        MainWindow.setScene(scene);
        MainWindow.show();
    }

    /**
     * Create the buttons on the board
     * @author Miguel Mesen
     */
    public void boardButtons(){

        phoneButton = new Rectangle(5,5,50,50);
        phoneButton.setFill(Color.GREEN);
        phoneButton.setOnMouseClicked(e -> phoneIformation());

        customButton = new Rectangle(770,510,240,206);
        customButton.setFill(Color.TRANSPARENT);
        customButton.setOnMouseClicked(e -> {
            //Board.gameManager.StartTurn(Integer.parseInt(textField.getText()));
            ThrowDice xd = new ThrowDice();
            xd.start();
        });
        button = new Button("Ok!");
        button.setPrefSize(50,40);
        button.setTranslateY(85);
        button.setTranslateX(825);
        button.setFont(Font.font(14));
        button.setOnMouseClicked(e ->{
            Dice xd = new Dice();
            Board.gameManager.StartTurn(Dice.finalNumber);
            Board.displayHandImage = true;
        });
        //customButton.setOnMouseClicked(e ->dice.start());
    }

    public void phoneIformation(){
        Group root2 = new Group();
        Scene scene = new Scene(root2,500,550);
        Text text = new Text();
        text.setText(
                "Aquí irá la información"
        );
        text.setX(15);
        text.setY(25);
        text.setFont(Font.font(16));
        Stage aboutStage = new Stage();
        root2.getChildren().addAll(text);
        aboutStage.setTitle("Play on the run!");
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
        graphicsContext.drawImage(background,0,0,1000,700);
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
