package cr.ac.tec.Board.Square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GreenSquare extends Square {
    /**
     *
     * @param coordx X-axis position
     * @param coordy Y-axis position
     * @param sideSize side's size
     */
    GreenSquare(double coordx, double coordy, double sideSize){
        super(Color.GREEN,coordx,coordy,sideSize);

    }

    @Override
    public void Event() {
        //lacks event
    }
}
