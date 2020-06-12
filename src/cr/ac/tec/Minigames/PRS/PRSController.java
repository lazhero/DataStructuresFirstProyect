package cr.ac.tec.Minigames.PRS;

/**
 *
 */
import cr.ac.tec.Events.AfterGameEvent;
import cr.ac.tec.Images.GetImages;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.management.DescriptorRead;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.ls.LSOutput;


public class PRSController {
    @FXML
    private Button paper1;
    @FXML
    private Button paper2;
    @FXML
    private Button rock1;
    @FXML
    private Button rock2;
    @FXML
    private Button sccisors1;
    @FXML
    private Button sccisors2;
    @FXML
    private Button Match;
    @FXML
    private ImageView ImageRight;
    @FXML
    private ImageView ImageLeft;
    @FXML
    private Label Name1;
    @FXML
    private Label Name2;
    private Hand hand1;
    private Hand hand2;
    private Stage primaryStage;
    private int player1;
    private int player2;
    private Image winner= GetImages.getImage("src/Resources/Images/Winner.png");
    private Image loser= GetImages.getImage("src/Resources/Images/Loser.png");
    private Image tie= GetImages.getImage("src/Resources/Images/tie.png");
    private ExecuteButtonAction ScreenColorChanger=new ExecuteButtonAction();
    int rounds=3;
    private int[] scores={0,0};

    /**
     * This method changes the color of the player’s choice(rock)
     * @author Andrey Zuñiga
     */
    public void rock1Action(){
        hand1=Hand.getHand(0);
        ScreenColorChanger.setBtn1(rock1);
    }

    /**
     * This method changes the color of the player’s choice(rock)
     * @author Andrey Zuñiga
     */
    public void rock2Action(){
        hand2=Hand.getHand(0);
        ScreenColorChanger.setBtn2(rock2);
    }

    /**
     * This method changes the color of the player’s choice(sccisors)
     * @author Andrey Zuñiga
     */
    public void sccisors1Action(){
        hand1=Hand.getHand(1);
        ScreenColorChanger.setBtn1(sccisors1);
    }

    /**
     * This method changes the color of the player’s choice(sccisors)
     * @author Andrey Zuñiga
     */
    public void sccisors2Action(){
        hand2=Hand.getHand(1);
        ScreenColorChanger.setBtn2(sccisors2);
    }

    /**
     * This method changes the color of the player’s choice(Paper)
     * @author Andrey Zuñiga
     */
    public void paper1Action(){
        hand1=Hand.getHand(2);
        ScreenColorChanger.setBtn1(paper1);
    }

    /**
     *
     * @author Andrey Zuñiga
     * @param player1
     */

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    /**
     * @author Andrey Zuñiga
     * @param player2
     */
    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    /**
     * This method changes the color of the player’s choice(Paper)
     * @author Andrey Zuñiga
     */
    public void paper2Action(){
        hand2=Hand.getHand(2);
        ScreenColorChanger.setBtn2(paper2);
    }

    /**
     * Activate the Duel Event
     * @author Andrey Zuñiga
     */
    public void duelAction(){

        if(hand1!=null && hand2!=null && rounds>0){
            rounds--;
            EventHandler<ActionEvent> PauseAction=(event) -> {
                ImageRight.setImage(null);
                ImageLeft.setImage(null);
                ScreenColorChanger.turnoffBtn1();
                ScreenColorChanger.turnoffBtn2();
                hand1=null;
                hand2=null;
                ScreenColorChanger.setBtn1(null);
                ScreenColorChanger.setBtn2(null);
            };
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(PauseAction);
            ScreenColorChanger.illuminateBtn1();
            ScreenColorChanger.illuminateBtn2();
            int state =HandsDuel.winner(hand1,hand2);
            if(state==1){
                ImageRight.setImage(winner);
                ImageLeft.setImage(loser);
                scores[0]=scores[0]+1;
                pause.play();
            }
            else if(state==2){
                ImageRight.setImage(loser);
                ImageLeft.setImage(winner);
                pause.play();
                scores[1]=scores[1]+1;
            }
            else{
                ImageRight.setImage(tie);
                ImageLeft.setImage(tie);
                //PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(PauseAction);
                pause.play();
            }
        }
        else if(rounds==0){
            Match.setOnAction(e->closeGame());
        }
    }
    /**
     * @author Andrey Zuñiga
     * @param name1
     */
    public void setName1(String name1){
        Name1.setText("player "+name1);
        Name1.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
    }

    /**
     * @author Andrey Zuñiga
     * @param name2
     */
    public void setName2(String name2){
        Name2.setText("Player "+ name2);
        Name2.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
    }
    public void setRounds(int rounds){
        this.rounds=rounds;
    }

    /**
     * ethod that changes the scene
     * @author Gabriel Solano
     * @param primaryStage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     *This method closes the game
     * @author Andrey Zuñiga
     */
    public void closeGame(){
        primaryStage.close();
        if (scores[1]>scores[0]){
            new AfterGameEvent().AfterGameEventData(player2,player1);
        }else if(scores[1]<scores[0]){
            new AfterGameEvent().AfterGameEventData(player1,player2);
        }
    }
}
