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

public class YellowSquare extends Square {
    private int random;
    public static DoubleList<Integer> lista;

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
        //CallToEvent(ListOfEvents.getInstance().getMystack().pop()).EventData(player);
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
        new TicTacToe().StartGame(0,1);

        //new Prove().StartGame(1,2);
        //lista = new DoubleList<>();
        //lista.AddHead(1);
        //lista.AddHead(2);
        //DiamondHunterGame xd = new DiamondHunterGame();
        //xd.StartGame(lista);

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
