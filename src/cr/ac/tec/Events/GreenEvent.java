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

/**
 * It’s the green square event(win coins)
 * @author Gabriel Solano
 */
public class GreenEvent{
    public String Data;

    /**
     * Player win coins
     * @author Gabriel Solano
     * @param coins
     * @param player
     */
    public GreenEvent (int coins, Player player){



        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        gameManager.setRunning(true);

        System.out.println("jugador "+ player + "ti"+ player.getCoins());
        Data= "Hello! You activated an event \n\n You win: "+coins+" coins";
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(600);
        vb.setMaxWidth(600);
        vb.setMinHeight(450);
        vb.setMaxHeight(450);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);

        Text message = new Text();
        message.setText(Data);
        message.setStyle("-fx-fill: white");
        message.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
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
            System.out.println("jugador "+ player + "ti"+ player.getCoins());
            return;
        });
        vb.getChildren().addAll(message,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
