package cr.ac.tec.Events;

import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GiveAwayCoins extends Event {
    /**
     * The player who activates the event loses a random amount of coins and is dealt equally among the other players.
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
        tittle.setText("Give Aways Coins");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("You will be given coins");
        buttock.setOnMouseClicked(e->{
            event1(player);



        });


        vb.getChildren().addAll(buttock,tittle,buttock);





    }
}
