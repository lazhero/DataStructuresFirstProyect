package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

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

    /**
     *
     * this event gives coins to the one who activates it
     * @param player
     */

    @Override
    public void event(Player player) {
        System.out.println(player.getCoins());
        int win= new Random().nextInt(3)+1;
        int actualCoins= player.getCoins();
        player.setCoins(actualCoins+win);
        //Actualizar
        System.out.println(player.getCoins());

    }

    /**
     * Define the square's color
     * @return
     */
    @Override
    public String Color() {
        return "GREEN";
    }
}
