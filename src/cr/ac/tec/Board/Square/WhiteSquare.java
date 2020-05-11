package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.WhiteEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

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

    /**
     *this event goes back or forward to the player who activates it
     * @param player
     */
    @Override
    public void event(Player player) {

        int casillasN = new Random().nextInt(2) - 2;
        int casillasP = new Random().nextInt(2) + 1;
        int random = new Random().nextInt(2);
        if (random == 0) {
            System.out.println("jugador" + player + "seras retrocedido" + casillasN + "pos");
            new WhiteEvent("back", casillasN, ListPlayer().get(0));
        } else if (random == 1) {
            System.out.println("jugador" + player + "seras adelantado" + casillasP + "pos");
            new WhiteEvent("advance", casillasP, ListPlayer().get(0));

        }
    }

    /**
     * Define Square's color
     * @return
     */
    @Override
    public String Color() {
        return "WHITE"; }
}
