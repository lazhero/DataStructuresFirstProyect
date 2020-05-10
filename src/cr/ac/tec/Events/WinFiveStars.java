package cr.ac.tec.Events;

import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WinFiveStars extends Event {

    /**
     * The player wins five stars and feels cooler.
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
        tittle.setText("Win 5 Stars");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("You will win 5 stars");
        buttock.setOnMouseClicked(e->{
            event1(player);



        });


        vb.getChildren().addAll(buttock,tittle,buttock);




    }
}
