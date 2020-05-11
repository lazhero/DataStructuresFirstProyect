package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.util.concurrent.TimeUnit;

public class WhiteEvent {
    public String Data;

    public WhiteEvent(String action,int squares, Player player){
        VBox vb = new VBox();
        if(action=="back"){
            Data="You will be returned: "+ squares*-1 +" Squares";
        }
        else if(action=="advance"){
            Data="You will be advance: "+ squares +" Squares";
        }
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);


        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text message = new Text();
        message.setText(Data);
        message.setTextAlignment(TextAlignment.CENTER);

        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            gameManager.MovePlayer(player,squares);
            return;

        });

        vb.getChildren().addAll(buttock,tittle,message);
        gameManager.getAnchorPane().getChildren().add(vb);


    }
}
