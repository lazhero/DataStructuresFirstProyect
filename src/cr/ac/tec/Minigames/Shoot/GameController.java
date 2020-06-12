package cr.ac.tec.Minigames.Shoot;

import cr.ac.tec.Controls.IntHolder;
import cr.ac.tec.Events.AfterGameEvent;
import cr.ac.tec.Images.GetImages;
import cr.ac.tec.Random.Random;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

/**
 *
 */
public class GameController {
    @FXML
    private AnchorPane FirstLevelAnchorPane;
    @FXML
    private ImageView BackGround;
    @FXML
    private ImageView Character1;
    @FXML
    private ImageView Character2;
    @FXML
    private ImageView BalaIzquierda;
    @FXML
    private ImageView BalaDerecha;
    @FXML
    private ImageView RewardRight;
    @FXML
    private ImageView RewardLeft;
    @FXML
    private Button button1;
    @FXML
    private Label MyLabel;
    @FXML
    private Label Name1;
    @FXML
    private Label Name2;
    private Timeline time;
    private int player1;
    private int player2;
    private int scoreplayer1;
    private int scoreplayer2;
    private boolean signal=false;
    private boolean pressed=false;
    private boolean ReadytoShoot=true;
    private IntHolder turns;
    private MediaPlayer mediaPlayer;
    private int rounds=3;
    private Stage primaryStage;

    /**
     * Method to change the stage
     * @author Andrey Zuñiga
     * @param primaryStage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
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
     * Define the start of the game
     *@author Andrey Zuñiga
     */
    public void start(){
        if(signal)return;
        if(rounds==1){
            button1.setOnAction(e->stopGame());

        }
        if (rounds<=0)return;

        rounds--;
        try{
            mediaPlayer.stop();
        }
        catch (Exception e){}
        String path="src/Resources/Music/DarkCity.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MyLabel.setVisible(true);
        signal=true;
        pressed=false;
        RewardLeft.setImage(null);
        RewardRight.setImage(null);
        ArrayList<String> List=new ArrayList<>();
        List.add("bung");
        List.add("Hop");
        List.add("bump");
        List.add("Hang");
        List.add("pop");
        List.add("sat");
        List.add("bang");
        List.add("shot");
        List.add("prank");
        List.add("Wop");
        List.add("zaz");
        List.add("bank");
        List.add("bazz");
        List.add("bamg");
        List.add("bat");
        List.add("buz");
        List.add("crack");
        List.add("yooru");
        List.add("naneru");
        List.add("yume");
        int Rigtpos=6;
        turns= new IntHolder(Random.RandomNumber(8)+5);
        StringInterpolator interpolator0=new StringInterpolator(List,Rigtpos,turns,400);
        ImageInterpolator interpolator=new ImageInterpolator("src/Resources/Images/Enemigo1",".png",2,1000);
        ImageInterpolator interpolator2=new ImageInterpolator("src/Resources/Images/Enemigo2",".png",2,1000);
        KeyValue key0=new KeyValue(MyLabel.textProperty(),"", interpolator0);
        KeyValue key1=new KeyValue(Character1.imageProperty(),Character1.getImage(),interpolator);
        KeyValue key2=new KeyValue(Character2.imageProperty(),Character2.getImage(),interpolator2);
        KeyFrame keyFrame0=new KeyFrame(Duration.seconds(0.4),key0);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(0.5),key1,key2);
        PauseTransition pause=new PauseTransition(Duration.ZERO);
        pause.setOnFinished(new EventHandler<ActionEvent>() {
            /**
             * This method defines the shooting event
             * @author Andrey Zuñiga
             * @param actionEvent
             */
            @Override
            public void handle(ActionEvent actionEvent) {
               // button1.setVisible(false);
                time=new Timeline(keyFrame,keyFrame0);
                time.setCycleCount(Timeline.INDEFINITE);
                time.play();
            }
        });
        pause.play();
    }

    /**
     * @author Andrey Zuñiga
     * @param mouseEvent
     */
    public void hide(MouseEvent mouseEvent){
    }

    /**
     *
     */
    public void stop(){
        time.stop();
    }

    /**
     * This method activates the shot
     * @author Andrey Zuñiga
     * @param keyEvent
     */
    public void shoot(KeyEvent keyEvent) {
        if(signal && !pressed) {
            pressed=true;
            if (keyEvent.getCode() == KeyCode.D) {
                if(turns.getSaved()<=0) {
                    time.stop();
                    Character1.setImage(GetImages.getImage("src/Resources/Images/Enemigo12.png"));
                    Character2.setImage(GetImages.getImage("src/Resources/Images/Enemigo21.png"));
                    RewardRight.setImage(GetImages.getImage("src/Resources/Images/Premio1.png"));
                    RewardLeft.setImage(GetImages.getImage("src/Resources/Images/Premio2.png"));
                    scoreplayer1+=1;
                    shooting(true);
                    MyLabel.setVisible(false);
                    signal=false;
                    turns.setSaved(15);
                }
                else {
                    RewardRight.setImage(GetImages.getImage("src/Resources/Images/Premio2.png"));
                    RewardLeft.setImage(GetImages.getImage("src/Resources/Images/Premio1.png"));
                    scoreplayer2+=1;
                    time.stop();
                    signal=false;
                }
            } else if (keyEvent.getCode() == KeyCode.K) {
                if(turns.getSaved()<=0) {
                    time.stop();
                    Character1.setImage(GetImages.getImage("src/Resources/Images/Enemigo11.png"));
                    Character2.setImage(GetImages.getImage("src/Resources/Images/Enemigo22.png"));
                    shooting(false);
                    MyLabel.setVisible(false);
                    scoreplayer2+=1;
                    signal=false;
                    turns.setSaved(15);
                    RewardRight.setImage(GetImages.getImage("src/Resources/Images/Premio2.png"));
                    RewardLeft.setImage(GetImages.getImage("src/Resources/Images/Premio1.png"));
                }
                else {
                    time.stop();
                    RewardRight.setImage(GetImages.getImage("src/Resources/Images/Premio1.png"));
                    RewardLeft.setImage(GetImages.getImage("src/Resources/Images/Premio2.png"));
                    scoreplayer1+=1;
                    signal=false;

                }
            }
        }
        else{

            pressed=false;
        }
    }

    /**
     * This method makes the animation when it is shooting
     * @author Andrey Zuñiga
     * @param condition
     */
    public void shooting(boolean condition){
        if(condition){
           ImageInterpolator ImageInterpolator=new ImageInterpolator("src/Resources/Images/BD",".png",2,50);
            BalaIzquierda.setImage(GetImages.getImage("src/Resources/Images/BD2.png"));
            double AxisX=BalaIzquierda.getX();
            KeyValue key0=new KeyValue(BalaIzquierda.imageProperty(),BalaIzquierda.getImage(),ImageInterpolator);
            KeyFrame keyFrame0=new KeyFrame(Duration.ZERO,key0);
            KeyValue key1=new KeyValue(BalaIzquierda.xProperty(),320,Interpolator.LINEAR);
            KeyFrame keyFrame1=new KeyFrame(Duration.millis(1000),key1);
            time=new Timeline(keyFrame0,keyFrame1);
            time.setCycleCount(1);
            time.setAutoReverse(false);
            time.setOnFinished(e->{
                BalaIzquierda.setX(AxisX);
                BalaIzquierda.setImage(null);
                pressed=false;
                Character2.setImage(GetImages.getImage("src/Resources/Images/Enemigo23.png"));
                PauseTransition pause=new PauseTransition();
                EventHandler<ActionEvent> Finished=p->{
                    Character2.setImage(GetImages.getImage("src/Resources/Images/Enemigo21.png"));
                };
                pause.setOnFinished(Finished);
                pause.play();
                pressed=false;
            });
            time.play();
        }
        else{
            BalaDerecha.setImage(GetImages.getImage("src/Resources/Images/BD2.png"));
            double AxisX=BalaDerecha.getX();
            KeyValue key1=new KeyValue(BalaDerecha.xProperty(),-330,Interpolator.LINEAR);
            KeyFrame keyFrame1=new KeyFrame(Duration.millis(1000),key1);
            time=new Timeline(keyFrame1);
            time.setCycleCount(1);
            time.setAutoReverse(false);
            time.setOnFinished(e->{
                BalaDerecha.setX(AxisX);
                BalaDerecha.setImage(null);
               Character1.setImage(GetImages.getImage("src/Resources/Images/Enemigo13.png"));
               PauseTransition pause=new PauseTransition();
               EventHandler<ActionEvent> Finished=p->{
                   Character1.setImage(GetImages.getImage("src/Resources/Images/Enemigo11.png"));
               };
               pause.setOnFinished(Finished);
               pause.play();
               pressed=false;

            });
            time.play();
        }
    }
    public void closeGame(){

    }

    /**
     * @author Andrey Zuñiga
     * @param name1
     */
    public void setName1(String name1){


        Name1.setText("Player:"+name1);
        Name1.setStyle("-fx-fill: white");
        Name1.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
    }

    /**
     *
     * @author Andrey Zuñiga
     * @param name2
     */

    public void setName2(String name2){

        Name2.setText("Player:"+name2);
        Name2.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
    }

    /**
     *
     * @param rounds
     */
    public void setRounds(int rounds){
        if(rounds<0)return;
        this.rounds=rounds;
    }

    /**
     * This method stops the game
     * @author Andrey Zuñiga
     *
     */
    public void stopGame(){
        if(!signal){
            if (scoreplayer2<scoreplayer1){
                new AfterGameEvent().AfterGameEventData(player1,player2);
            }else if(scoreplayer2>scoreplayer1){
                new AfterGameEvent().AfterGameEventData(player2,player1);
            }
            primaryStage.close();
        }
    }
}