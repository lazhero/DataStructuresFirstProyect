package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class YellowSquare extends Square {
    /**
     *
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public YellowSquare(double coordx, double coordy, double sideSize){
        super(Color.YELLOW,coordx,coordy,sideSize);

    }

    @Override
    public void Event() {
        GameManager gameManager=GameManager.getInstance(0,0);
        gameManager.teleport(super.ListPlayer().get(0));
    }

    @Override
    public String Color() {
        return "YELLOW";
    }
}
