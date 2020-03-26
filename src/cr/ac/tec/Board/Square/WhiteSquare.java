package cr.ac.tec.Board.Square;

import javafx.scene.paint.Paint;

public class WhiteSquare extends Square {
    WhiteSquare(Paint color, double coordx, double coordy, double sideSize){
        super(color,coordx,coordy,sideSize);

    }

    @Override
    public void DuelTime() {
        //lacks event
    }
}
