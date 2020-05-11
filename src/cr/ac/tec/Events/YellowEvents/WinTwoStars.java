
package cr.ac.tec.Events.YellowEvents;
import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import cr.ac.tec.Board.Player;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

public class WinTwoStars extends Event {
    /**
     * The player wins two stars and feels cool.
     * @param player
     */
    @Override
    public void event1(Player player) {
        int actualstars=player.getStars();
        player.setStars(actualstars+2);
        System.out.println(player.getStars());
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
        System.out.println(player.getStars());
        VBox vb = new VBox();
        ListOfEvents.getInstance().getDoubleList().delete(0);
        String Data;
        Data="Congrats!!! you won 2 stars";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);
        System.out.println("AACA");
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
