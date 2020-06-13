package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * It’s red square event(lose coins)
 * @author Gabriel Solano
 */

public class RedEvent{
    public String Data;

    /**
     * Player Lose Coins
     * @author Gabriel Solano
     * @param coins
     * @param player
     */
    public RedEvent (int coins, Player player){
        Data= "Hello! You activated an event \n\n You Lose: "+coins+" coins";
        VBox vb = new VBox();
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(600);
        vb.setMaxWidth(600);
        vb.setMinHeight(450);
        vb.setMaxHeight(450);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Button buttock = new Button("OK");

        Text message = new Text();
        message.setTextAlignment(TextAlignment.CENTER);
        message.setText(Data);
        message.setStyle("-fx-fill: white");
        message.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        message.setTextAlignment(TextAlignment.CENTER);
        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            if (player.getCoins()<=coins){
                player.setCoins(0);

            }else {
                int actualCoins = player.getCoins();
                player.setCoins(actualCoins - coins);

                return;
            }
        });
        vb.getChildren().addAll(message,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
