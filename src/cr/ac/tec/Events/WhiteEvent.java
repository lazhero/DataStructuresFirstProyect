package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.util.concurrent.TimeUnit;

public class WhiteEvent {
    public String Data;

    public WhiteEvent(String action,int squares, Player player){
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Images/Vboxbg.jpg)");
        if(action=="back"){
            Data=" Hello! You activated an event \n\n You will be returned: "+ squares*-1 +" Squares";
        }
        else if(action=="advance"){
            Data=" Hello! You activated an event \n \n You will be advance: "+ squares +" Squares";
        }
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);


        Button buttock = new Button("OK");
        vb.setMinWidth(400);
        vb.setMaxWidth(400);
        vb.setMinHeight(270);
        vb.setMaxHeight(270);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);;

        Text message = new Text();
        message.setText(Data);
        message.setTextAlignment(TextAlignment.CENTER);
        message.setStyle("-fx-fill: white");
        message.setFont(new Font("Verdana",16));

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

        vb.getChildren().addAll(message,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);


    }
}
