package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StealStar extends Event {
    /**
     * The player can steal a star from another random player.
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
        VBox vb = new VBox();
        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("Steal Star");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("You can steal one star from another player");
        buttock.setOnMouseClicked(e->{
            event1(player);



        });


        vb.getChildren().addAll(buttock,tittle,buttock);




    }
}
