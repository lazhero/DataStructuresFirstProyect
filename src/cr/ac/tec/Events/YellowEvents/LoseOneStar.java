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
public class LoseOneStar extends Event {
    private String Data;
    @Override
    public void event1(Player player) {


    }

    /**
     * The player loses a star and it is given to another random player.
     * @author Gabriel Solano
     * @param player1
     * @param player2
     */
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
     * @author Gabriel Solano
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
        int aleatorio=random;
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(500);
        vb.setMaxWidth(500);
        vb.setMinHeight(370);
        vb.setMaxHeight(370);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        Data="Sorry, you activated this event! \n ,you lose 1 star, this will be \n obtained by the random player: " + listaaleatoria.get(aleatorio) ;
        gameManager.setRunning(true);

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
            event2(player,gameManager.getPlayerList().get(listaaleatoria.get(aleatorio)));
            return;
        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
