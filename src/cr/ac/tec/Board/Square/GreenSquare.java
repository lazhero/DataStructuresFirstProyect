package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.GreenEvent;
import cr.ac.tec.Events.lists.ListOfEvents;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * Defines features and the event that happens in this square
 * @author Andrey Zuñiga & Gaabriel Solano
 */
public class GreenSquare extends Square {

    /**
     *@author Andrey Zuñiga
     * @param coordx X-axis position
     * @param coordy Y-axis position
     * @param sideSize side's size
     */
    public GreenSquare(double coordx, double coordy, double sideSize){
        super(Color.GREEN,coordx,coordy,sideSize);

    }

    /**
     * This event gives coins to the one who activates it
     * @author Gabriel Solano
     * @param player player who activates the event
     */
    @Override
    public void event(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        System.out.println(gameManager.getTurns()%gameManager.getPlayerList().getLength());
        if(gameManager.getPlayerList().get(gameManager.getTurns()%gameManager.getPlayerList().getLength())==player){

            int win= new Random().nextInt(3)+1;
            new GreenEvent(win,player);
        }

        
    }

    /**
     * Define the square's color
     * @author Andrey Zuñiga
     * @return
     */
    @Override
    public String Color() {
        return "GREEN";
    }
}
