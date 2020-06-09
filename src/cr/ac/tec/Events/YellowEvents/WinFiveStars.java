package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

public class WinFiveStars extends Event {
    private String Data;

    /**
     * The player wins five stars and feels cooler.
     * @param player
     */
    @Override
    public void event1(Player player) {
        int actualstars=player.getStars();
        player.setStars(actualstars+5);
        System.out.println(player.getStars());
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
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        VBox vb = new VBox();
        ListOfEvents.getInstance().getDoubleList().delete(0);
        System.out.println("winfivestar");
        Data="Hello! You activated this event " +
                "\n\n Congrats!!, you win 5 stars";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);

        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(400);
        vb.setMaxWidth(400);
        vb.setMinHeight(270);
        vb.setMaxHeight(270);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text data = new Text();
        data.setText(Data);
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(new Font("Verdana",16));
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
