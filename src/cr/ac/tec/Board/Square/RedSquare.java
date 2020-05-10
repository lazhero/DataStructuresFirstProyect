package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class RedSquare extends Square {
    /**
     * Class's contructor
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public RedSquare(double coordx, double coordy, double sideSize){
        super(Color.RED,coordx,coordy,sideSize);
    }

    @Override
    public void event(Player player) {

        System.out.println(player.getCoins());
        int lose= new Random().nextInt(3)+1;
        if (player.getCoins()<=lose){
            player.setCoins(0);
        }else{
            int actualCoins= player.getCoins();
            player.setCoins(actualCoins-lose);
           
        }



    }

    @Override
    public String Color() {
        return "RED";
    }
}
