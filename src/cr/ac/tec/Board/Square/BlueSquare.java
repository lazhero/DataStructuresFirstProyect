package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


/**
 * Defines features and the event that happens in this square
 * @author Gabriel Solano & Andrey Zuñiga
 */
public class BlueSquare extends Square {

    /**
     * The class constructor
     * @author Andrey Zuñiga
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize Side's size
     */
    public BlueSquare(double coordx, double coordy, double sideSize){
        super(Color.BLUE,coordx,coordy,sideSize);
    }

    /**
     *It is neutral, it does nothing
     * @author Gabriel Solano
     * @param player player who activates the event
     */
    @Override
    public void event(Player player) {
        //nothing
    }

    /**
     * define the square's color
     * @author Andrey Zuñiga
     * @return
     */
    @Override
    public String Color() {
        return "BLUE";
    }
}
