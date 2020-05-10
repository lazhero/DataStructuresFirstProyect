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

public class ChangePlace extends Event {
    /**
     * In this event one player will be changed instead of another player
     * @param player
     */
    private int playerchange = new Random().nextInt(4)+1;
    private String message;

    @Override
    public void event1(Player player) {

    }

    /**
     *
     * @param player1
     * @param player2
     */

    @Override
    public void event2 (Player player1, Player player2) {

    }

    /**
     * Is the information of the event
     * @param player
     */

    @Override
    public void EventData(Player player) {

        String Data;
        Data="You will be exchanged with the player:"+playerchange;
        GameManager gameManager = GameManager.getInstance(0,0);

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
