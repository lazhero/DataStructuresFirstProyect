package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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

    @Override
    public void event(Player player) {
        //lacks event
    }

    @Override
    public String Color() {
        return "RED";
    }
}
