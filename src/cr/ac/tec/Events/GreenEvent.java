package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GreenEvent{
    public String Data;

    public GreenEvent (int coins, Player player){

        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);
        Data= "Hello! You activated an event \n\n You win: "+coins+" coins";
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(350);
        vb.setMaxWidth(350);
        vb.setMinHeight(250);
        vb.setMaxHeight(250);
        vb.setLayoutX(300);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text message = new Text();
        message.setText(Data);
        message.setStyle("-fx-fill: white");
        message.setFont(new Font("Verdana",16));
        message.setTextAlignment(TextAlignment.CENTER);

        Button buttock = new Button("OK");
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

        vb.getChildren().addAll(message,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);


    }
}
