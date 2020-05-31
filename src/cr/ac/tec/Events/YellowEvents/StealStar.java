package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StealStar extends Event {
    private String Data;
    /**
     * The player can steal a star from another random player.
     * @param player
     */
    @Override
    public void event1(Player player) {

    }

    @Override
    public void event2(Player player1, Player player2) {
        if (player2.getStars()==1){
            player1.setStars(player1.getStars());
            player2.setStars(0);
        }else{
            player2.setStars(player2.getStars());
            player1.setStars(player1.getStars()+1);

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
        System.out.println("stealstar");

        ListOfEvents.getInstance().getDoubleList().delete(0);
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Images/Vboxbg.jpg)");
        vb.setMinWidth(500);
        vb.setMaxWidth(500);
        vb.setMinHeight(370);
        vb.setMaxHeight(370);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Data="Hey!! You activated this event \n\n" +
                " Congratulations, you can steal 1 star from another player \n";
        gameManager.setRunning(true);

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(new Font("Verdana",16));
        data.setTextAlignment(TextAlignment.CENTER);

        Button b1= new Button();
        Button b2= new Button();
        Button b3= new Button();
        if (gameManager.getPlayerList().getLength() == 2) {
            if(gameManager.getTurns()%gameManager.getPlayerList().getLength() ==0){
                listaaleatoria.AddTail(1);
            }else if(gameManager.getTurns()%gameManager.getPlayerList().getLength()==1){
                listaaleatoria.AddTail(0);
            }
            b1.setText("Player"+listaaleatoria.get(0));
            b2.relocate(1000,1000);
            b3.relocate(1000,1000);
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
            b1.setText("Player"+listaaleatoria.get(0));
            b2.setText("Player"+listaaleatoria.get(1));
            b3.relocate(1000,1000);
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
            b1.setText("Player"+listaaleatoria.get(0));
            b2.setText("Player"+listaaleatoria.get(1));
            b3.setText("Player"+listaaleatoria.get(2));
        }



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
        vb.getChildren().addAll(data,b1,b2,b3);
        gameManager.getAnchorPane().getChildren().add(vb);
        }
    }

