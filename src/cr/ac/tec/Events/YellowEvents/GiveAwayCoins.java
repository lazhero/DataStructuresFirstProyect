package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GiveAwayCoins extends Event {
    private int coins;
    private int amountplayers;
    private String Data;
    /**
     * The player who activates the event loses a random amount of coins and is dealt equally among the other players.
     * @param player
     *
     */

    @Override
    public void event1(Player player) {


    }
    public void eventlosecoins(Player player){

    }

    @Override
    public void event2(Player player1, Player player2) {

    }


    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        amountplayers = new Random().nextInt(3)+1;
        coins = new Random().nextInt(amountplayers)+1;
        GameManager gameManager = GameManager.getInstance(0,0);
        VBox vb = new VBox();
        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);
        gameManager.setRunning(true);

        if (coins%amountplayers==0) {
            Data = "Sorry!! You lost" + coins + " coins, will be dealt to the other player s";
            buttock.setOnMouseClicked(e -> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;

            });
        }else if (coins>amountplayers){
            Data="Sorry!! You lost"+amountplayers+" coins, will be dealt to the other player s";
            buttock.setOnMouseClicked(e -> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });

        } else {
            Data="You don’t have enough funds, lose all you coins";
            Data="Sorry!! You lost"+amountplayers+" coins, will be dealt to the other player s";
            buttock.setOnMouseClicked(e -> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });
        }

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text data = new Text();
        data.setText(Data);

        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);

    }
}
