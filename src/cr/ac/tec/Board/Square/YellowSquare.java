package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.Events.lists.ListOfEvents;


import cr.ac.tecLinkedList.List.List;
import javafx.scene.paint.Color;


import java.util.concurrent.TimeUnit;

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
    public String Color() {
        return "YELLOW";
    }

    @Override
    public void event(Player player) {
        if(ListOfEvents.getInstance().getDoubleList().isEmpty()){
            ListOfEvents.instance=null;
            try{
                TimeUnit.MILLISECONDS.sleep(400);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //CallToEvent(ListOfEvents.getInstance().getDoubleList().get(0)).EventData(player);
        new StealStar().EventData(player);
    }






    public Event CallToEvent (Object object){
        return (Event) object;
    }
}
