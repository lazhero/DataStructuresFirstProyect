package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.GreenEvent;
import cr.ac.tec.Events.RedEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * Defines features and the event that happens in this square
 * @author Gabriel Solano & Andrey Zuñiga
 */
public class RedSquare extends Square {

    /**
     * Class's contructor
     * @author Andrey Zuñiga
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public RedSquare(double coordx, double coordy, double sideSize){
        super(Color.RED,coordx,coordy,sideSize);
    }

    /**
     * This event removes coins from the activator
     * @author Gabriel Solano
     * @param player player who activates the event
     */

    @Override
    public void event(Player player) {
        int lose= new Random().nextInt(3)+1;
        new RedEvent(lose,ListPlayer().get(0));
        }

    /**
     * Definde the square's color
     * @author Andrey Zuñiga
     * @return
     */

    @Override
    public String Color() {
        return "RED";
    }
}
