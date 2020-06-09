package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class BlueSquare extends Square {

    /**
     * The class constructor
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize Side's size
     */
    public BlueSquare(double coordx, double coordy, double sideSize){
        super(Color.BLUE,coordx,coordy,sideSize);
    }

    /**
     *It is neutral, it does nothing
     * @param player
     */
    @Override
    public void event(Player player) {
        //nothing
    }

    /**
     * define the square's color
     * @return
     */
    @Override
    public String Color() {
        return "BLUE";
    }
}
