package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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

    /**
     *
     * @param player
     */
    public void eventlosecoins(Player player){
    }

    /**
     *
     * @param player1
     * @param player2
     */
    @Override
    public void event2(Player player1, Player player2) {
    }

    /**
     *
     * @param player1
     * @param player2
     * @param coins
     */
    public void event3(Player player1,Player player2,int coins){
        GameManager gameManager = GameManager.getInstance(0,0);
        if (player1.getCoins()<gameManager.getPlayerList().getLength()){
            player1.setCoins(0);
        }
        else{
            player1.setCoins(player1.getCoins()-gameManager.getPlayerList().getLength());
            player2.setCoins(player2.getCoins()+1);
        }
    }

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     * @param coins
     */
    public void event4(Player player1,Player player2,Player player3,int coins){
        GameManager gameManager = GameManager.getInstance(0,0);
        if (player1.getCoins()<gameManager.getPlayerList().getLength()){
            player1.setCoins(0);
        }
        else{
            player1.setCoins(player1.getCoins()-gameManager.getPlayerList().getLength());
            player2.setCoins(player2.getCoins()+1);
            player3.setCoins(player3.getCoins()+1);
        }
    }

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     * @param player4
     * @param coins
     */
    public void event5(Player player1, Player player2, Player player3, Player player4,int coins){
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
        coins = new Random().nextInt(gameManager.getPlayerList().getLength()-1)+1;

        System.out.println("giveawaycoins");
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(500);
        vb.setMaxWidth(500);
        vb.setMinHeight(370);
        vb.setMaxHeight(370);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);
        Data = "Sorry You activated  this event!! \n You lost " + coins + " coins, will be dealt to the other players \n if your coin count is less than the number of other players,  \n your coins will be reduced to zero";
        Button buttock = new Button("OK");
        buttock.setOnMouseClicked(e -> {
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            if(gameManager.getPlayerList().getLength()==2){
                if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                    event3(player,gameManager.getPlayerList().get(1),coins);
                }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                    event3(player,gameManager.getPlayerList().get(0),coins);
                }
            }else if(gameManager.getPlayerList().getLength()==3){
                if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                    event4(player,gameManager.getPlayerList().get(1),gameManager.getPlayerList().get(2),coins);
                }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                    event4(player,gameManager.getPlayerList().get(0),gameManager.getPlayerList().get(2),coins);
                }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==2) {
                    event4(player, gameManager.getPlayerList().get(0), gameManager.getPlayerList().get(1), coins);
                }
            }else if(gameManager.getPlayerList().getLength()==4) {
                if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 0) {
                    event5(player, gameManager.getPlayerList().get(1), gameManager.getPlayerList().get(2), gameManager.getPlayerList().get(3), coins);
                } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 1) {
                    event5(player, gameManager.getPlayerList().get(0), gameManager.getPlayerList().get(2), gameManager.getPlayerList().get(3), coins);
                } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 2) {
                    event5(player, gameManager.getPlayerList().get(0), gameManager.getPlayerList().get(1), gameManager.getPlayerList().get(3), coins);
                } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 3) {
                    event5(player, gameManager.getPlayerList().get(0), gameManager.getPlayerList().get(1), gameManager.getPlayerList().get(2), coins);
                }
                return;
            }
        });
        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(new Font("Verdana",16));
        data.setTextAlignment(TextAlignment.CENTER);
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
