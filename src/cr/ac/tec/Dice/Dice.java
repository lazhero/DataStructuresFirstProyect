package cr.ac.tec.Dice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static cr.ac.tec.Dice.Animation.*;

public class Dice {
    private static double diceNumber;


    static void rollDice(){
        Animation xd = new Animation();
        Animation.playAnimation();
        randomNumber();
        if (diceNumber==1){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice1iv);
                }
            });
        }
        if (diceNumber==2){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice2iv);
                }
            });
        }
        if (diceNumber==3){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice3iv);
                }
            });
        }
        if (diceNumber==4){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice4iv);
                }
            });
        }
        if (diceNumber==5){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice5iv);
                }
            });
        }
        if (diceNumber==6){
            Animation.t.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dice.getChildren().setAll(Dice6iv);
                }
            });
        }
    }



    private static void randomNumber(){
        diceNumber= (int)(Math.random()*((6-1)+1))+1;
        System.out.println(diceNumber);
    }

}
