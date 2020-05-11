package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
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
    public void event3(Player player1, Player player2, Player player3, Player player4,int coins){
        GameManager gameManager = GameManager.getInstance(0,0);
        if (player1.getCoins()<gameManager.getPlayerList().getLength()){
            player1.setCoins(0);
        }
        else{
            player1.setCoins(player1.getCoins()-gameManager.getPlayerList().getLength());
            player2.setCoins(player2.getCoins()+1);
            player3.setCoins(player2.getCoins()+1);
            player4.setCoins(player2.getCoins()+1);

        }

    }


    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        ListOfEvents.getInstance().getDoubleList().delete(0);
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        coins = new Random().nextInt(gameManager.getPlayerList().getLength())-1;

        VBox vb = new VBox();
        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);
        gameManager.setRunning(true);
        Data = "Sorry!! You lost" + coins + " coins, will be dealt to the other player s";
        buttock.setOnMouseClicked(e -> {
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event3(player,gameManager.getPlayerList().get(0),gameManager.getPlayerList().get(1),gameManager.getPlayerList().get(2),coins);
            return;

        });

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text data = new Text();
        data.setText(Data);

        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);

    }
}
