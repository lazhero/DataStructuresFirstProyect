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

public class StealCoins extends Event {
    private String Data;
    /**
     * The player who obtains the event has the right to steal a number of Random Coins from another player of his choice.
     *
     * @param player
     */
    @Override
    public void event1(Player player) {

    }

    @Override
    public void event2(Player player1, Player player2) {
        if (player2.getCoins()==1){
            player1.setCoins(player1.getCoins());
            player2.setCoins(0);
        }else{
            player2.setCoins(player2.getCoins());
            player1.setCoins(player1.getCoins()+1);

        }

    }
    /**
     * Information of the event
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
        ListOfEvents.getInstance().getDoubleList().delete(0);

        Data="Congratulations, you can steal 1 coin from another player";
        gameManager.setRunning(true);

        Text tittle = new Text();
        tittle.setText("You activated an event, select the player");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text data = new Text();
        data.setText(Data);


        Button b1= new Button("Player"+listaaleatoria.get(0));
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Button b2= new Button("Player"+listaaleatoria.get(1));
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Button b3= new Button("Player"+listaaleatoria.get(2));
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        b1.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event2(player,gameManager.getPlayerList().get(listaaleatoria.get(0)));
            return;

        });
        b2.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event2(player,gameManager.getPlayerList().get(listaaleatoria.get(1)));
            return;

        });
        b3.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            event2(player,gameManager.getPlayerList().get(listaaleatoria.get(2)));
            return;

        });

        vb.getChildren().addAll(tittle,data,b1,b2,b3);
        gameManager.getAnchorPane().getChildren().add(vb);

    }
}
