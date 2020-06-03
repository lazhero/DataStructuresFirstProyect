package cr.ac.tec.Board.Square;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;

import cr.ac.tec.Events.AfterGameEvent;
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


import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.List;
import javafx.scene.paint.Color;


import java.util.Random;
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
    @Override
    public String Color() {
        return "YELLOW";
    }

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
        new Main().StartGame(0,1);
        //new PRSGAME().StarGame(1,3);
        //new TicTacToe().StartGame(0,1);


    }






    public Event CallToEvent (Object object){
        return (Event) object;
    }
}
