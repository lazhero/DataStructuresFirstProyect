package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Duel extends Event {
    /**
     * A mini-game is triggered, where the randomly chosen players will face a duel (minigame 1v1),
     * the winner will get glory (coins), and the loser will lose coins.
     *
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
        tittle.setText("Duel");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("2 players will face each other in a duel");
        buttock.setOnMouseClicked(e->{
            event1(player);



        });


        vb.getChildren().addAll(buttock,tittle,buttock);






    }


}



