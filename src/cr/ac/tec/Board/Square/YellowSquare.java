package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Events.lists.ListOfMiniGames;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;


import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.Minigames.PRS.PRSGAME;
import cr.ac.tec.Minigames.Shoot.Prove;
import javafx.scene.paint.Color;


import java.util.concurrent.TimeUnit;

public class YellowSquare extends Square {
    private int random;

    /**
     *
     * @param coordx x-axis position
     * @param coordy y-axis position
     * @param sideSize side's size
     */
    public YellowSquare(double coordx, double coordy, double sideSize){
        super(Color.YELLOW,coordx,coordy,sideSize);
    }

    /**
     *
     * @return
     */
    @Override
    public String Color() {
        return "YELLOW";
    }

    /**
     *
     * @param player
     */
    @Override
    public void event(Player player) {
        GameManager gameManager = GameManager.getInstance(0,0);
        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
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
        //new Duel().EventData(player);
        //new memorygame().StarGame(1,3);
        //new pressfirst().StartGame(0,1);
        //new PRSGAME().StarGame(1,3);
        //new Prove().StartGame(0,1);
        //new DiamondHunterGame().StartGame(gameManager.getPlayerList());
        //new Duel().EventData(player);
        //new GiveAwayCoins().EventData(player);
        //new Main().StartGame(0,1);
        //new PRSGAME().StarGame(1,3);
        //new TicTacToe().StartGame(0,1);
        //DoubleList d = new DoubleList();
        //d.AddHead(1);
        //d.AddHead(2);
        //d.AddHead(3);
        //new DiamondHunterGame().StartGame(d);
        new Prove().StartGame(1,2);
    }

    /**
     *
     * @param object
     * @return
     */
    public Event CallToEvent (Object object){
        return (Event) object;
    }
}
