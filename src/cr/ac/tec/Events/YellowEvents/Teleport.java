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

    /**
     *
     * @param player1
     * @param change
     */
    @Override
    public void event2(Player player1, Player change) {

    }

    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        String Data;
        Data="Hello!! You activated this event \n\n you will be teleported to a random location";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);
        System.out.println("telepor");

        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(360);
        vb.setMaxWidth(360);
        vb.setMinHeight(270);
        vb.setMaxHeight(270);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

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
