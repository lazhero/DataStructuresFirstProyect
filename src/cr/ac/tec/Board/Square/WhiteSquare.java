package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
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

        int casillasN = new Random().nextInt(2)-2;
        int casillasP = new Random().nextInt(2)+1;
        int random = new Random().nextInt(2);
        if (random==0){
            System.out.println("jugador"+ListPlayer().get(0)+"seras retrocedido"+casillasN+"pos");
            GameManager gameManager = GameManager.getInstance(0,0);
            gameManager.MovePlayer(super.ListPlayer().get(0),casillasN);
        }else if (random==1){
            System.out.println("jugador"+ListPlayer().get(0)+"seras adelantado"+casillasP+"pos");

            GameManager gameManager = GameManager.getInstance(0,0);
            gameManager.MovePlayer(super.ListPlayer().get(0),casillasP);

        }
    }

    /**
     * Definde Square's color
     * @return
     */

    @Override
    public String Color() {
        return "WHITE";
    }
}
