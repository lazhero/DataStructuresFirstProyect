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

import java.util.concurrent.TimeUnit;

/**
 * Defines the event information and its activation
 * @author Gabriel Solano
 */
public class Teleport extends Event {
    /**
     * The player is teleported to some random place on the map.
     * @author Gabriel Solano
     * @param player
     */
    @Override
    public void event1(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.teleport(player);
    }


    @Override
    public void event2(Player player1, Player player2) {

    }

    /**
     * Information of the event
     * @author Gabriel Solano
     * @param player
     */
    @Override
    public void EventData(Player player) {
        String Data;
        Data="Hello!! You activated this event \n\n you will be teleported to a random location";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);

        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(550);
        vb.setMaxWidth(550);
        vb.setMinHeight(400);
        vb.setMaxHeight(400);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text data = new Text();
        data.setText(Data);
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        data.setTextAlignment(TextAlignment.CENTER);

        Button buttock = new Button("OK");
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
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
