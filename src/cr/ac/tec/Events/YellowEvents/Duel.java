package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.Minigames.Memory.memorygame;
import cr.ac.tec.Minigames.PRS.PRSGAME;
import cr.ac.tec.Minigames.Shoot.Prove;
import cr.ac.tec.Minigames.ticTacToe.TicTacToe;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import cr.ac.tec.Events.lists.ListOfMiniGames;

import cr.ac.tec.Minigames.PressFirst.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Defines the event information and its activation
 * @author Gabriel Solano
 */
public class Duel extends Event {
    private String Data;
    private int random;
    private String gamedescription;


    @Override
    public void event1(Player player) {

    }

    @Override
    public void event2(Player player1, Player player2) {

    }
    public void duelinthesamebox(Player player1, Player player2,int dato1 ,int dato2){

        if (ListOfMiniGames.getInstance().getDoubleList().get(0)=="MemoryGame") {
            gamedescription = "\n Welcome to the Memory game, in this game \n  you must choose the pairs, first it will be \n the turn of one player, if it \n succeeds will continue to  \n play it, if it fails goes \n the other player. It is a game by points,\n  each hit gives 10 points, the  \n player with the most points will be the winner, the \n loser will back up one square and lose 1 star,  \n the winner gets 1 coin. ";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="PRS"){
            gamedescription="Welcome to the scissors paper \n stone set  in this game you will \n have to choose between\n paper stone or scissors, \n then give the button ok and so we \n will know who will be the winner, remember,\n  rock wins to scissors \n scissors wins to paper and paper\n beats to stone, good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="TicTacToe"){
            gamedescription="Welcome to the game Tictactoe! \n in this game the first \n to make three \n online wins  vertica;\n  horizontal and diagonal counts. \n First place one player, then the other,\n  there may be a draw";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="PressFirst"){
            gamedescription="Welcome to who’s the fastest?! \n In this game you must press the \n key that appears on your side \n  as fast as possible, there is a counter the \n first to bring it down to \n zero, win, good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="Shoot"){
            gamedescription="Welcome to the game Shoot! \n In this game will appear random words \n  when the word Bang \n appears on the screen!\n  You must press the key to shoot, the first \n to press wins, if you \n  press when the word is \n not yet on screen,\n you will lose! Good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="RandomNumber"){
            gamedescription="Welcome to the game Random! \n The game will generate a random number, \n the which is going to be hidden each \n player will have a chance to \n write a number, and the player \n closest to the real number will be \n the winner! Good luck to you!";
        }
        GameManager gameManager = GameManager.getInstance(0,0);
        Data="Hello! You activated an event\n \n"+"You’ll have a duel with the player:  "+dato2+" \n "+gamedescription;
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(600);
        vb.setMaxWidth(600);
        vb.setMinHeight(450);
        vb.setMaxHeight(450);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        data.setTextAlignment(TextAlignment.CENTER);


        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event3(player1,player2,ListOfMiniGames.getInstance().getDoubleList(),dato1,dato2);
            return;

        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }




    public void eventduelo(Player player1, Player player2,int dato1 ,int dato2) {
        DoubleList milista = ListOfMiniGames.getInstance().getDoubleList();
        GameManager gameManager= GameManager.getInstance(0,0);
        if(milista.get(0).toString()=="MemoryGame"){
            new memorygame().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="PRS"){
            new PRSGAME().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="TicTacToe"){
            new TicTacToe().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="PressFirst"){
            new pressfirst().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="Shoot"){
            new Prove().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="RandomNumber"){
            new cr.ac.tec.Minigames.RandomNumber.Main().StartGame(dato1,dato2);
            milista.delete(0);
        }
    }

    /**
     * A mini-game is triggered, where the randomly chosen players will face a duel (minigame 1v1),
     * the winner will get glory (coins), and the loser will lose coins.
     * @author Gabriel Solano
     * @param player1
     * @param player2
     * @param milista
     * @param dato1
     * @param dato2
     */
    public void event3(Player player1, Player player2,DoubleList milista,int dato1,int dato2) {
        GameManager gameManager= GameManager.getInstance(0,0);

        if(milista.get(0).toString()=="MemoryGame"){
            new memorygame().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="PRS"){
            new PRSGAME().StarGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="TicTacToe"){
            new TicTacToe().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="PressFirst"){
            new pressfirst().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="Shoot"){
            new Prove().StartGame(dato1,dato2);
            milista.delete(0);
        }else if(milista.get(0).toString()=="RandomNumber"){
            new cr.ac.tec.Minigames.RandomNumber.Main().StartGame(dato1,dato2);
            milista.delete(0);
        }
    }

    /**
     * Information of the event
     * @author Gabriel Solano
     * @param player
     */
    @Override
    public void EventData(Player player) {
        if (ListOfMiniGames.getInstance().getDoubleList().get(0)=="MemoryGame") {
            gamedescription = "\n Welcome to the Memory game, in this game \n  you must choose the pairs, first it will be \n the turn of one player, if it \n succeeds will continue to  \n play it, if it fails goes \n the other player. It is a game by points,\n  each hit gives 10 points, the  \n player with the most points will be the winner, the \n loser will back up one square and lose 1 star,  \n the winner gets 1 coin. ";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="PRS"){
            gamedescription="Welcome to the scissors paper \n stone set  in this game you will \n have to choose between\n paper stone or scissors,\n then give the button ok and so we \n will know who will be the winner, \n remember, rock wins to scissors \n scissors wins to paper and paper \n beats to stone, good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="TicTacToe"){
            gamedescription="Welcome to the game Tictactoe! \n in this game the first to make three \n online wins  vertica;\n  horizontal and diagonal counts. \n First place one player, then the other,\n  there may be a draw";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="PressFirst"){
            gamedescription="Welcome to who’s the fastest?! \n In this game you must press the \n key that appears on your side \n  as fast as possible, there is a counter the \n first to bring it down to \n zero, win, good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="Shoot"){
            gamedescription="Welcome to the game Shoot! \n In this game will appear random words \n  when the word Bang \n appears on the screen!\n  You must press the key to shoot, the first \n to press wins, if you \n  press when the word is \n not yet on screen,\n you will lose! Good luck!";
        }else if(ListOfMiniGames.getInstance().getDoubleList().get(0)=="RandomNumber"){
            gamedescription="Welcome to the game Random! \n The game will generate a random number, \n the which is going to be hidden each \n player will have a chance to \n write a number, and the player \n closest to the real number will be \n the winner! Good luck to you!";
        }

        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        int dato1;
        int dato2;
        if (gameManager.getPlayerList().getLength() == 2) {
            if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                listaaleatoria.AddTail(1);
            }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                listaaleatoria.AddTail(0);
            }
            random= 0;
        }else if(gameManager.getPlayerList().getLength()==3){
            if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                listaaleatoria.AddTail(1);
                listaaleatoria.AddTail(2);
            }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                listaaleatoria.AddTail(0);
                listaaleatoria.AddTail(2);
            }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==2){
                listaaleatoria.AddTail(0);
                listaaleatoria.AddTail(1);
            }
            random=new Random().nextInt(2);
        }
        else if(gameManager.getPlayerList().getLength()==4) {
            if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 0) {
                listaaleatoria.AddTail(1);
                listaaleatoria.AddTail(2);
                listaaleatoria.AddTail(3);
            } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 1) {
                listaaleatoria.AddTail(0);
                listaaleatoria.AddTail(2);
                listaaleatoria.AddTail(3);

            } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 2) {
                listaaleatoria.AddTail(0);
                listaaleatoria.AddTail(1);
                listaaleatoria.AddTail(3);
            } else if (gameManager.getTurns() % gameManager.getPlayerList().getLength() == 3) {
                listaaleatoria.AddTail(0);
                listaaleatoria.AddTail(1);
                listaaleatoria.AddTail(2);
            }
            random = new Random().nextInt(3);
        }
        dato1=gameManager.getTurns()%gameManager.getPlayerList().getLength();
        dato2=listaaleatoria.get(random);
        Data="Hello! You activated an event\n \n"+"You’ll have a duel with the player:  "+dato2+" \n "+gamedescription;
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(600);
        vb.setMaxWidth(600);
        vb.setMinHeight(450);
        vb.setMaxHeight(450);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        data.setTextAlignment(TextAlignment.CENTER);


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
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}



