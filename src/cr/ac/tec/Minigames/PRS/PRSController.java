package cr.ac.tec.Minigames.PRS;

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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Hand hand1;
    private Hand hand2;
    private Image winner= GetImages.getImage("src/Images/Winner.png");
    private Image loser= GetImages.getImage("src/Images/Loser.png");
    private Image tie= GetImages.getImage("src/Images/tie.png");
    private ExecuteButtonAction ScreenColorChanger=new ExecuteButtonAction();

    public void rock1Action(){
        hand1=Hand.getHand(0);
        ScreenColorChanger.setBtn1(rock1);
        System.out.println("Piedra 1");
    }
    public void rock2Action(){
        hand2=Hand.getHand(0);
        ScreenColorChanger.setBtn2(rock2);
        System.out.println("piedra 2");
    }
    public void sccisors1Action(){
        hand1=Hand.getHand(1);
        ScreenColorChanger.setBtn1(sccisors1);
        System.out.println("Tijeras 1");
    }
    public void sccisors2Action(){
        hand2=Hand.getHand(1);
        ScreenColorChanger.setBtn2(sccisors2);
        System.out.println("Tijeras 2");
    }
    public void paper1Action(){
        hand1=Hand.getHand(2);
        ScreenColorChanger.setBtn1(paper1);
        System.out.println("Papel 1");
    }
    public void paper2Action(){
        hand2=Hand.getHand(2);
        ScreenColorChanger.setBtn2(paper2);
        System.out.println("Papel 2");
    }
    public void duelAction(){

        if(hand1!=null && hand2!=null){
            ScreenColorChanger.illuminateBtn1();
            ScreenColorChanger.illuminateBtn2();
            int state =HandsDuel.winner(hand1,hand2);
            if(state==1){
                ImageRight.setImage(winner);
                ImageLeft.setImage(loser);
                //falta accion al ganar
            }
            else if(state==2){
                ImageRight.setImage(loser);
                ImageLeft.setImage(winner);
                //falta accion al ganar
            }
            else{


                ImageRight.setImage(tie);
                ImageLeft.setImage(tie);
                System.out.println("Hola");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event ->{
                            ImageRight.setImage(null);
                            ImageLeft.setImage(null);
                            ScreenColorChanger.turnoffBtn1();
                            ScreenColorChanger.turnoffBtn2();
                            hand1=null;
                            hand2=null;
                            ScreenColorChanger.setBtn1(null);
                            ScreenColorChanger.setBtn2(null);

                        }


                );
                pause.play();



            }
        }
    }




}
