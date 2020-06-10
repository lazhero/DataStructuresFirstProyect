package cr.ac.tec.Minigames.RandomNumber;

import cr.ac.tec.Events.AfterGameEvent;
import cr.ac.tec.Random.Random;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.restart;

public class Interface{


    static TextField inputNumber;
    static Button button = new Button("Go!");
    static Button restartButton = new Button("Try again!");
    static Button Buttok = new Button("Ok!");
    public static Text text = new Text();
    static int victory;
    static int lose;



    /**
     * Creates the interface which the player interacts with.
     * @return root
     */
    public static Parent createContent(int player1,int player2, Stage primaryStage){
        Pane root = new Pane();
        root.setPrefSize(300,300);
        inputNumber = createTextField(100,100,200);
        button.setPrefSize(50,50);
        button.setFont(Font.font(16));
        button.setTranslateX(125);
        button.setTranslateY(230);
        //button.setOnMouseClicked(e -> getNumber());

        restartButton.setTranslateX(10);
        restartButton.setTranslateY(10);
        restartButton.setOnMouseClicked(e -> restart(player1,player2));

        text.setFont(Font.font(20));

        Button button = new Button("OK");
        button.setOnMouseClicked(event -> {
            System.out.println("lose " + lose);
            System.out.println("victory " + victory);
            new AfterGameEvent().AfterGameEventData(victory,lose);
            primaryStage.close();
        });
        root.getChildren().addAll(inputNumber, Interface.button,text,restartButton,button);
        return root;
    }

    /**
     * Getter that returns the number input in the text field.
     * @return Number input in the text field.
     */
    public static String getNumber(){
        return inputNumber.getText();
    }

    /**
     *
     * @param width
     * @param posx
     * @param posy
     * @return
     */
    static TextField createTextField(int width, int posx, int posy) {
        TextField temp = new TextField();
        temp.setPrefWidth(width);
        temp.setTranslateX(posx);
        temp.setTranslateY(posy);
        return temp;
    }

    /**
     *
     * @param victory
     */
    public static void setVictory(int victory) {
        Interface.victory = victory;
    }

    /**
     *
     * @return
     */
    public static int getVictory() {
        return victory;
    }

    /**
     *
     * @return
     */
    public static int getLose() {
        return lose;
    }

    /**
     *
     * @param lose
     */
    public static void setLose(int lose) {
        Interface.lose = lose;
    }
}
