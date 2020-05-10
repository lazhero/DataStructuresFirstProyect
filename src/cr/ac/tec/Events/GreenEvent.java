package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GreenEvent{
    public String Data;

    public GreenEvent (int coins, Player player){
        VBox vb = new VBox();
        Data= "You win: "+coins+" coins";
        System.out.println(player.getCoins());

        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.setRunning(true);


        Button buttock = new Button("OK");
        vb.setLayoutX(300);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Text tittle = new Text();
        tittle.setText("You activated an event");
        tittle.setTextAlignment(TextAlignment.CENTER);

        Text message = new Text();
        message.setText(Data);
        message.setTextAlignment(TextAlignment.CENTER);

        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            int actualCoins= player.getCoins();
            player.setCoins(actualCoins+coins);
            System.out.println(player.getCoins());
            return;

        });

        vb.getChildren().addAll(buttock,tittle,message);
        gameManager.getAnchorPane().getChildren().add(vb);


    }
}
