package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.Minigames.Memory.memorygame;
import cr.ac.tec.Minigames.ticTacToe.Main;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import cr.ac.tec.Events.lists.ListOfMiniGames;

import cr.ac.tec.Minigames.Memory.*;
import cr.ac.tec.Minigames.PressFirst.*;
import cr.ac.tec.Minigames.PRS.*;

import cr.ac.tec.Minigames.RandomNumber.*;
import cr.ac.tec.Minigames.Shoot.*;
import cr.ac.tec.Minigames.ticTacToe.*;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Duel extends Event {
    private String Data;
    private int random;


    /**
     * A mini-game is triggered, where the randomly chosen players will face a duel (minigame 1v1),
     * the winner will get glory (coins), and the loser will lose coins.
     *
     * @param player
     */

    @Override
    public void event1(Player player) {



    }

    @Override
    public void event2(Player player1, Player player2) {

    }


    public void event3(Player player1, Player player2,DoubleList milista,int dato1,int dato2) {

        if(milista.get(0).toString()=="MemoryGame"){
            new memorygame().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="PRS"){
            //new PRSGAME().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="TicTacToe"){
            //new Main().StartGame(dato1,dato2);
            milista.delete(0);

        }else if(milista.get(0).toString()=="PressFirst"){
            new pressfirst().StartGame(dato1,dato2);
            milista.delete(0);

        }else if(milista.get(0).toString()=="DiamondHunter"){
            //new DiamondHunterGame().StartGame(dato1,dato2);
            milista.delete(0);

        }else if(milista.get(0).toString()=="Shoot"){
            //new Prove().StartGame(dato1,dato2);
            milista.delete(0);

        }else if(milista.get(0).toString()=="RandomNumber"){
            new cr.ac.tec.Minigames.RandomNumber.Main().StartGame();
            milista.delete(0);

        }
    }

    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        ListOfEvents.getInstance().getDoubleList().delete(0);
        System.out.println(ListOfMiniGames.getInstance().getDoubleList().get(0).toString());
        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        int dato1;
        int dato2;
        if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
            listaaleatoria.AddTail(1);
            listaaleatoria.AddTail(2);
            listaaleatoria.AddTail(3);
        }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
            listaaleatoria.AddTail(0);
            listaaleatoria.AddTail(2);
            listaaleatoria.AddTail(3);

        }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==2){
            listaaleatoria.AddTail(0);
            listaaleatoria.AddTail(1);
            listaaleatoria.AddTail(3);
        }
        else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==3){
            listaaleatoria.AddTail(0);
            listaaleatoria.AddTail(1);
            listaaleatoria.AddTail(2);
        }
        random= new Random().nextInt(3);
        dato1=gameManager.getTurns()%gameManager.getPlayerList().getLength();
        dato2=listaaleatoria.get(random);
        Data="You’ll have a duel with the player"+dato2;
        VBox vb = new VBox();
        gameManager.setRunning(true);

        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text data = new Text();
        data.setText(Data);
        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event3(player,gameManager.getPlayerList().get(listaaleatoria.get(random)),ListOfMiniGames.getInstance().getDoubleList(),dato1,dato2);
            return;

        });
        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);

    }
}



