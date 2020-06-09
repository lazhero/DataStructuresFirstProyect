package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.GreenEvent;
import cr.ac.tec.Events.lists.ListOfEvents;
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
        int win= new Random().nextInt(3)+1;
        new GreenEvent(win,ListPlayer().get(0));
        System.out.println(ListOfEvents.getInstance().getDoubleList());
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
