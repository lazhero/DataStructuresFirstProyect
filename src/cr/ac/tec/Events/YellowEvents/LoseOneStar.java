package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoseOneStar extends Event {
    private int amountplayer;
    private int star;
    /**
     * The player loses a star and it is given to another random player.
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
        amountplayer= new Random().nextInt(3)+1;
        VBox vb = new VBox();

        String Data;
        Data="Sorry,you lose 1 star, this will be obtained by the player: " + amountplayer ;
        GameManager gameManager = GameManager.getInstance(0,0);
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
