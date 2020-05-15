package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoseOneStar extends Event {
    private String Data;
    /**
     * The player loses a star and it is given to another random player.
     * @param player
     */

    @Override
    public void event1(Player player) {


    }

    @Override
    public void event2(Player player1, Player player2) {
        if (player1.getStars()<1){
            player1.setStars(0);
            player2.setStars(player2.getStars());
        }
        else {
            player1.setStars(player1.getStars()+-1);
            player2.setStars(player2.getStars()+1);
        }

    }
    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        int random = 0;
        if (gameManager.getPlayerList().getLength() == 2) {
            if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                listaaleatoria.AddTail(1);
            }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                listaaleatoria.AddTail(0);
            }
            random=0;

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
        else if(gameManager.getPlayerList().getLength()==4){
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
            random=new Random().nextInt(3);
        }
        ListOfEvents.getInstance().getDoubleList().delete(0);
        int aleatorio=random;
        VBox vb = new VBox();
        Data="Sorry,you lose 1 star, this will be obtained by the player: " + listaaleatoria.get(aleatorio) ;
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
            event2(player,gameManager.getPlayerList().get(listaaleatoria.get(aleatorio)));
            return;

        });
        vb.getChildren().addAll(tittle,buttock,data);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
