package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Events.lists.ListOfMiniGames;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.Minigames.Memory.memorygame;
import cr.ac.tec.Minigames.PRS.*;
import cr.ac.tec.Minigames.PressFirst.*;
import cr.ac.tec.Minigames.RandomNumber.Main;
import cr.ac.tec.Minigames.Shoot.*;
import cr.ac.tec.Minigames.ticTacToe.*;
import cr.ac.tec.Minigames.RandomNumber.*;


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
        if(ListOfMiniGames.getInstance().getDoubleList().isEmpty()){
            ListOfMiniGames.instance=null;
            try{
                TimeUnit.MILLISECONDS.sleep(400);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //CallToEvent(ListOfEvents.getInstance().getDoubleList().get(0)).EventData(player);
        new Duel().EventData(player);
        //new memorygame().StarGame();
        //new pressfirst().StartGame();
        //new PRSGAME().StarGame();
        //new Prove().StartGame();
        //new DiamondHunterGame().StartGame();

    }






    public Event CallToEvent (Object object){
        return (Event) object;
    }
}
