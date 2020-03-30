package cr.ac.tec.Board.Square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class YellowSquare extends Square {
    /**
     *
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    YellowSquare(double coordx, double coordy, double sideSize){
        super(Color.YELLOW,coordx,coordy,sideSize);

    }

    @Override
    public void Event() {
        //lacks event
    }
}
