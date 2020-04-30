package cr.ac.tec.Dice;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animation {

    public static Group dice;
    public static Timeline t = new Timeline();

    public static Image Dice0 = new Image("Images/Dice/Dice0.png");
    public static Image Dice1 = new Image("Images/Dice/Dice1.png");
    public static Image Dice2 = new Image("Images/Dice/Dice2.png");
    public static Image Dice3 = new Image("Images/Dice/Dice3.png");
    public static Image Dice4 = new Image("Images/Dice/Dice4.png");
    public static Image Dice5 = new Image("Images/Dice/Dice5.png");
    public static Image Dice6 = new Image("Images/Dice/Dice6.png");


    public static ImageView Dice0iv = new ImageView(Dice0);
    public static ImageView Dice1iv = new ImageView(Dice1);
    public static ImageView Dice2iv = new ImageView(Dice2);
    public static ImageView Dice3iv = new ImageView(Dice3);
    public static ImageView Dice4iv = new ImageView(Dice4);
    public static ImageView Dice5iv = new ImageView(Dice5);
    public static ImageView Dice6iv = new ImageView(Dice6);


    public Animation(){
        /*
        Image Dice0 = new Image("Images/Dice/Dice0.png");
        Image Dice1 = new Image("Images/Dice/Dice1.png");
        Image Dice2 = new Image("Images/Dice/Dice2.png");
        Image Dice3 = new Image("Images/Dice/Dice3.png");
        Image Dice4 = new Image("Images/Dice/Dice4.png");
        Image Dice5 = new Image("Images/Dice/Dice5.png");
        Image Dice6 = new Image("Images/Dice/Dice6.png");


        final ImageView Dice0iv = new ImageView(Dice0);
        final ImageView Dice1iv = new ImageView(Dice1);
        final ImageView Dice2iv = new ImageView(Dice2);
        final ImageView Dice3iv = new ImageView(Dice3);
        final ImageView Dice4iv = new ImageView(Dice4);
        final ImageView Dice5iv = new ImageView(Dice5);
        final ImageView Dice6iv = new ImageView(Dice6);

         */

        dice = new Group(Dice0iv);

        //t.setCycleCount(Timeline.INDEFINITE);
        t.setCycleCount(1);



        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice1iv);
                }

        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1200),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice2iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1800),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice3iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(2400),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice3iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(3000),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice4iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(3600),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice5iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(4200),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice6iv);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(4800),
                (ActionEvent event)-> {
                    dice.getChildren().setAll(Dice6iv);
                }
        ));


    }


    public static void playAnimation(){
        t.play();
    }

    public static void stopAnimation(){
        t.stop();
    }

}
