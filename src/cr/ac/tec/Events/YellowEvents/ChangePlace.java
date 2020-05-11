package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChangePlace extends Event {
    /**
     * In this event one player will be changed instead of another player
     * @param player
     */
    private int playerchange = new Random().nextInt(4)+1;
    private String message;

    @Override
    public void event1(Player player) {

    }

    /**
     *
     * @param player1
     * @param player2
     */

    @Override
    public void event2 (Player player1, Player player2) {
        GameManager gameManager = GameManager.getInstance();
        gameManager.exchangePosition(player1,player2);

    }

    /**
     * Is the information of the event
     * @param player
     */

    @Override
    public void EventData(Player player) {
        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
        int random= new Random().nextInt(3);
        ListOfEvents.getInstance().getDoubleList().delete(0);
        String Data;
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
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
        VBox vb = new VBox();
        System.out.println(listaaleatoria);
        DoubleList<Integer> finalListaaleatoria = listaaleatoria;
        System.out.println(finalListaaleatoria);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);
        Data="You will be exchanged with the player:"+finalListaaleatoria.get(random);
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
            event2(player,gameManager.getPlayerList().get(finalListaaleatoria.get(random)));
            System.out.println(gameManager.getTurns());
            return;

        });

        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);




    }

}
