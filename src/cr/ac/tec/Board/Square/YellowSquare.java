package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.Teleport;
import javafx.scene.layout.Pane;
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

    /**
     * This event activate different events
     * @param player
     */

    @Override
    public void event(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.teleport(super.ListPlayer().get(0));
        

    }

    /**
     * Define the square's color
     * @return
     */

    @Override
    public String Color() {
        return "YELLOW";
    }
}
