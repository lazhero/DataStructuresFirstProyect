package cr.ac.tec.Board.Square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class BlueSquare extends Square {
    /**
     * The class constructor
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize Side's size
     */
    BlueSquare(double coordx, double coordy, double sideSize){
        super(Color.BLUE,coordx,coordy,sideSize);

    }

    @Override
    public void Event() {
        //lacks event
    }
}
