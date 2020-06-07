package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

public class AfterGameEvent {
    private String Data;

    public void AfterGameEvent(int playerwin, int playerlose){
        System.out.println(playerwin);
        System.out.println(playerlose);
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.MovePlayer(gameManager.getPlayerList().get(playerlose),-1);

        gameManager.getPlayerList().get(playerwin).setCoins(gameManager.getPlayerList().get(playerwin).getCoins()+1);
        if (gameManager.getPlayerList().get(playerlose).getCoins()==0){
            gameManager.getPlayerList().get(playerlose).setCoins(0);
        }
        else{
            gameManager.getPlayerList().get(playerlose).setCoins(gameManager.getPlayerList().get(playerlose).getCoins()-1);

        }






    }
    public void AfterGameEventData(int numberofplayerwin,int numberofplayerlose){
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);

        Data="The player who won was the player number: "+ numberofplayerwin+ "\n Player :"+numberofplayerwin +" wins 1 coin: "+"\n The player who lost was the player number :"+numberofplayerlose+" \n The player"+numberofplayerlose+"Lose 1 coin";
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(570);
        vb.setMaxWidth(570);
        vb.setMinHeight(370);
        vb.setMaxHeight(370);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(new Font("Verdana",16));
        data.setTextAlignment(TextAlignment.CENTER);


        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            AfterGameEvent(numberofplayerwin,numberofplayerlose);
            return;

        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);

    }



}
