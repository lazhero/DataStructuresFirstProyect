package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

/**
 * It’s the after-game event
 * @author Gabriel Solano
 */
public class AfterGameEvent {
    private String Data;

    /**
     * The winner wins coins and the loser loses coins and backs a square
     * @author Gabriel Solano
     * @param playerwin
     * @param playerlose
     */
    public void AfterGameEvent(int playerwin, int playerlose){
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

    /**
     * Information of the event
     * @author Gabriel Solano
     * @param numberofplayerwin
     * @param numberofplayerlose
     */
    public void AfterGameEventData(int numberofplayerwin,int numberofplayerlose){
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);

        Data="The player who won was the player number: "+ numberofplayerwin+ "\n Player :"+numberofplayerwin +" wins 1 coin: "+"\n The player who lost was the player number :"+numberofplayerlose+" \n The player"+numberofplayerlose+"Lose 1 coin";
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(580);
        vb.setMaxWidth(580);
        vb.setMinHeight(380);
        vb.setMaxHeight(380);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
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
