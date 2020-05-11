package cr.ac.tec.Events.YellowEvents;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.YellowEvents.Event;
import cr.ac.tec.Events.lists.ListOfEvents;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StealStar extends Event {
    private int amountplayer;
    /**
     * The player can steal a star from another random player.
     * @param player
     */
    @Override
    public void event1(Player player) {

    }

    @Override
    public void event2(Player player1, Player player2) {

    }
    /**
     * Information of the event
     * @param player
     */
    @Override
    public void EventData(Player player) {
        amountplayer= new Random().nextInt(3)+1;
        VBox vb = new VBox();
        ListOfEvents.getInstance().getDoubleList().delete(0);
        String Data;
        Data="Congratulations, you can steal 1 star from another player";
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);



        Text tittle = new Text();
        tittle.setText("You activated an event, select the player");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text data = new Text();
        data.setText(Data);

        if (amountplayer==1){
            Button b1= new Button("Player"+amountplayer);
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);
            vb.getChildren().addAll(tittle,data,b1);
            gameManager.getAnchorPane().getChildren().add(vb);
            b1.setOnMouseClicked(e->{
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                }catch (InterruptedException interruptedException){
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;

            });

        }else  if(amountplayer==2){
            Button b1= new Button("Player"+(amountplayer-1));
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);

            Button b2= new Button("Player"+amountplayer);
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);
            vb.getChildren().addAll(tittle,data,b1,b2);
            gameManager.getAnchorPane().getChildren().add(vb);
            b1.setOnMouseClicked(e-> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });
            b2.setOnMouseClicked(e-> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });



        }else if(amountplayer==3){
            Button b1= new Button("Player"+(amountplayer-2));
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);

            Button b3= new Button("Player"+(amountplayer-1));
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);

            Button b2= new Button("Player"+amountplayer);
            vb.setLayoutX(300);
            vb.setLayoutY(300);
            vb.setAlignment(Pos.CENTER);
            vb.getChildren().addAll(tittle,data,b1,b2,b3);
            gameManager.getAnchorPane().getChildren().add(vb);
            b1.setOnMouseClicked(e-> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });
            b2.setOnMouseClicked(e-> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });
            b3.setOnMouseClicked(e-> {
                gameManager.getAnchorPane().getChildren().remove(vb);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                gameManager.setRunning(false);
                return;
            });


        }

    }
}
