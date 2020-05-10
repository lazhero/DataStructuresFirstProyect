package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GreenSquare extends Square {
    /**
     *
     * @param coordx X-axis position
     * @param coordy Y-axis position
     * @param sideSize side's size
     */
    public GreenSquare(double coordx, double coordy, double sideSize){
        super(Color.GREEN,coordx,coordy,sideSize);

    }

    @Override
    public void event(Player player) {
        //lacks event
    }

    @Override
    public String Color() {
        return "GREEN";
    }
}
