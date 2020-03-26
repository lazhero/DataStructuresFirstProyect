package cr.ac.tec.Board;

import javafx.scene.paint.Paint;

public class RedSquare extends Square {
    RedSquare(Paint color, double coordx, double coordy, double sideSize){
        super(color,coordx,coordy,sideSize);

    }

    @Override
    public void DuelTime() {
        //lacks event
    }
}
