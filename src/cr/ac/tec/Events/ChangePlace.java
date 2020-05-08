package cr.ac.tec.Events;

import cr.ac.tec.Board.Board;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ChangePlace extends Event {
    /**
     * In this event one player will be changed instead of another player
     * @param player
     */


    @Override
    public void event(Player player) {

    }

    @Override
    public void event2 (Player player1, Player player2) {

    }

    /**
     * Is the information of the event
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
        tittle.setText("Change Place");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("You will be changed by");
        buttock.setOnMouseClicked(e->{
            event(player);




        });



        vb.getChildren().addAll(buttock,tittle,buttock);




    }

}
