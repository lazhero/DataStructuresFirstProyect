package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.WhiteEvent;
import cr.ac.tec.Minigames.RandomNumber.Main;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.game;

/**
 * Defines features and the event that happens in this square
 * @author Gabriel Solano & Andrey Zuñiga
 */
public class WhiteSquare extends Square {

    /**
     * Class's constructor
     * @author Andrey Zuñiga
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public WhiteSquare(double coordx, double coordy, double sideSize){
        super(Color.WHITE,coordx,coordy,sideSize);
    }

    /**
     * This event goes back or forward to the player who activates it
     * @author Gabriel Solano
     * @param player player who activates the event
     */
    @Override
    public void event(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        int casillasN = new Random().nextInt(2) - 2;
        int casillasP = new Random().nextInt(2) + 1;
        int random = new Random().nextInt(2);
        if(gameManager.getPlayerList().get(gameManager.getTurns()%gameManager.getPlayerList().getLength())==player){
            if (random == 0) {
                System.out.println("jugador" + player + "seras retrocedido" + casillasN + "pos");
                new WhiteEvent("back", casillasN, ListPlayer().get(0));
            } else if (random == 1) {
                System.out.println("jugador" + player + "seras adelantado" + casillasP + "pos");
                new WhiteEvent("advance", casillasP, ListPlayer().get(0));
            }
        }


    }

    /**
     * Define Square's color
     * @author Andrey Zuñiga
     * @return
     */
    @Override
    public String Color() {
        return "WHITE"; }
}
