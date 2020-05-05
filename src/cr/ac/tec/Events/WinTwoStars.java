
package cr.ac.tec.Events;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import cr.ac.tec.Board.Player;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WinTwoStars extends Event {
    /**
     * The player wins two stars and feels cool.
     * @param player
     */
    @Override
    public void event(Player player) {

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
        tittle.setText("Win 2 stars");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text changeT = new Text();
        changeT.setText("You will win 2 stars ");
        buttock.setOnMouseClicked(e->{
            event(player);



        });


        vb.getChildren().addAll(buttock,tittle,buttock);




    }
}
