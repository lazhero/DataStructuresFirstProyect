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

public class Duel extends Event {
    private int playerchange = new Random().nextInt(4)+1;
    /**
     * A mini-game is triggered, where the randomly chosen players will face a duel (minigame 1v1),
     * the winner will get glory (coins), and the loser will lose coins.
     *
     * @param player
     */

    @Override
    public void event1(Player player) {


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
        ListOfEvents.getInstance().getDoubleList().delete(0);
        System.out.println("AACA");
        String Data;
        Data="You’ll have a duel with the player"+playerchange;
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

        Text data = new Text();
        data.setText(Data);
        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            return;

        });

        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);






    }


}



