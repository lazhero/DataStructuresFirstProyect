package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AfterGameEvent {

    public void AfterGameEvent(){
        System.out.println("Llego aca");


    }
    public void AfterGameEventData(int numberofplayerwin,int numberofplayerlose){
        String Data;
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);

        VBox vb = new VBox();
        gameManager.setRunning(true);

        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);
        Data="Player :"+ numberofplayerlose+"You lose : 1 Coins "+"and \n" +
                "go back one box" +"\n"+"Player "+ numberofplayerwin+"You win 1 coin";
        Text data = new Text();
        data.setText(Data);

        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            System.out.println("Estoy acá");
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            AfterGameEvent();
            gameManager.setRunning(false);
            return;
        });
        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);
    }



}
