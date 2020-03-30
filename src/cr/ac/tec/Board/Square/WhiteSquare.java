package cr.ac.tec.Board.Square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class WhiteSquare extends Square {
    /**
     * Class's constructor
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public WhiteSquare(double coordx, double coordy, double sideSize){
        super(Color.WHITE,coordx,coordy,sideSize);
    }
    @Override
    public void Event() {
        //lacks event
    }
}
