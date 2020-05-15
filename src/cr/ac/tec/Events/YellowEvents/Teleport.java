package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Board.Square.Square;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Random.Random;
import cr.ac.tecLinkedList.Nodes.DoubleNode;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

public class Teleport extends Event {
    /**
     * The player is teleported to some random place on the map.
     * @param player
     */
    @Override
    public void event1(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.teleport(player);
    }


    @Override
    public void event2(Player player1, Player change) {

    }
    /**
     * Information of the event
     * @param player
     */
    @Override

    public void EventData(Player player) {
        VBox vb = new VBox();
        ListOfEvents.getInstance().getDoubleList().delete(0);
        String Data;
        Data="you will be teleported to a random location";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
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
            event1(player);
            return;

        });
        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
