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

/**
 * Defines the event information and its activation
 * @author Gabriel Solano
 */
public class ChangePlace extends Event {

    private int playerchange = new Random().nextInt(4)+1;
    private String message;

    @Override
    public void event1(Player player) {
    }

    /**
     * In this event one player will be changed instead of another player
     * @author Gabriel Solano
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
     * @author Gabriel Solano
     * @param player
     */
    @Override
    public void EventData(Player player) {
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
        vb.setMinWidth(550);
        vb.setMaxWidth(550);
        vb.setMinHeight(400);
        vb.setMaxHeight(400);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setStyle("-fx-fill: white");
        tittle.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        tittle.setTextAlignment(TextAlignment.CENTER);
        Data="Hello! You activated an event \n\n You will be exchanged with the player: "+finalListaaleatoria.get(random);
        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
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

            return;
        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
