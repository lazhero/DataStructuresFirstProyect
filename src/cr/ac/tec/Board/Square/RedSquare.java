package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.GreenEvent;
import cr.ac.tec.Events.RedEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class RedSquare extends Square {

    /**
     * Class's contructor
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public RedSquare(double coordx, double coordy, double sideSize){
        super(Color.RED,coordx,coordy,sideSize);
    }

    /**
     *this event removes coins from the activator
     * @param player
     */

    @Override
    public void event(Player player) {
        int lose= new Random().nextInt(3)+1;
        new RedEvent(lose,ListPlayer().get(0));
        }

    /**
     * Definde the square's color
     * @return
     */

    @Override
    public String Color() {
        return "RED";
    }
}
