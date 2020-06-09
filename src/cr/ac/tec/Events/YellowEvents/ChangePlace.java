package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChangePlace extends Event {

    private int playerchange = new Random().nextInt(4)+1;
    private String message;

    /**
     * In this event one player will be changed instead of another player
     * @param player
     */
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
        System.out.println("Change");
        DoubleList<Integer> listaaleatoria = new DoubleList<Integer>();
        int random= new Random().nextInt(3);
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
        DoubleList<Integer> finalListaaleatoria = listaaleatoria;
        VBox vb = new VBox();

        gameManager.setRunning(true);


        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(500);
        vb.setMaxWidth(500);
        vb.setMinHeight(370);
        vb.setMaxHeight(370);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);
        Data="Hello! You activated an event \n\n You will be exchanged with the player: "+finalListaaleatoria.get(random);
        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(new Font("Verdana",16));
        data.setTextAlignment(TextAlignment.CENTER);

        Button buttock = new Button("OK");
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
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
