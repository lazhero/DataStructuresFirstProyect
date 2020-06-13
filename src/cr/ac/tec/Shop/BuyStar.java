package cr.ac.tec.Shop;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.lists.ListOfMiniGames;
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
 *
 */
public class BuyStar {
    private String Data;
    /**
     *
     */
    public void BuyStar(Player player){
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);

        Data="Hey, you can buy a star,do you want to buy it?";
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
        gameManager.setRunning(true);

        Button yesbutton = new Button("YES");
        Button nobutton = new Button("NO");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        data.setTextAlignment(TextAlignment.CENTER);

        yesbutton.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            player.setStars(player.getStars()+1);
            player.setCoins(player.getCoins()-3);

            gameManager.setStarTaken(true);
            gameManager.setRunning(false);
            return;


        });
        nobutton.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);

            return;

        });
        vb.getChildren().addAll(data,yesbutton,nobutton);
        gameManager.getAnchorPane().getChildren().add(vb);
    }

}

