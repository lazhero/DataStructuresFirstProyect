package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Events.lists.ListOfMiniGames;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;


import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.Minigames.Memory.memorygame;
import cr.ac.tec.Minigames.PRS.PRSGAME;
import cr.ac.tec.Minigames.PressFirst.pressfirst;
import cr.ac.tec.Minigames.RandomNumber.Main;
import cr.ac.tec.Minigames.Shoot.Prove;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import javafx.scene.paint.Color;
import cr.ac.tec.Stack.*;
import javafx.stage.Stage;


import java.util.concurrent.TimeUnit;

/**
 * Defines features and the event that happens in this square
 * @author Gabriel Solano & Andrey Zuñiga
 */
public class YellowSquare extends Square {
    private int random;
    public static DoubleList<Integer> lista;

    /**
     * @author Andrey Zuñiga
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public YellowSquare(double coordx, double coordy, double sideSize){
        super(Color.YELLOW,coordx,coordy,sideSize);
    }

    /**
     * @author Andrey Zuñiga
     * @return
     */
    @Override
    public String Color() {
        return "YELLOW";
    }

    /**
     * This square enables a list of events
     * @author Gabriel Solano
     * @param player player who activates the event
     */
    @Override
    public void event(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        if(ListOfEvents.getInstance().getMystack().isEmpty()){
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
        if(gameManager.getPlayerList().get(gameManager.getTurns()%gameManager.getPlayerList().getLength())==player){
            CallToEvent(ListOfEvents.getInstance().getMystack().pop()).EventData(player);
        }


    }

    /**
     * Become an Event object
     * @author Gabriel Solano
     * @param object object to be converted
     * @return
     */
    public Event CallToEvent (Object object){

        return (Event) object;
    }
}
