package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.LinkedList.List.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;
/**
 * It’s the after Tournament-game event
 * @author Gabriel Solano
 */
public class AfterTournamentEvent {
    private String Data;

    /**
     * Action after the tournament, Losing and winning coins
     * @author Gabriel Solano
     * @param playerList
     */
    public void AfterTournament(DoubleList playerList) {
        GameManager gameManager = GameManager.getInstance(0,0);
        if (playerList.getLength() == 2) {
            gameManager.getPlayerList().get((Integer) playerList.get(0)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(0)).getCoins()+5);
            gameManager.getPlayerList().get((Integer) playerList.get(1)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(1)).getCoins()+3);
        } else if (playerList.getLength() == 3) {
            gameManager.getPlayerList().get((Integer) playerList.get(0)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(0)).getCoins()+5);
            gameManager.getPlayerList().get((Integer) playerList.get(1)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(1)).getCoins()+3);
            gameManager.getPlayerList().get((Integer) playerList.get(2)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(2)).getCoins()+2);
        } else if (playerList.getLength() == 4) {
            gameManager.getPlayerList().get((Integer) playerList.get(0)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(0)).getCoins()+5);
            gameManager.getPlayerList().get((Integer) playerList.get(1)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(1)).getCoins()+3);
            gameManager.getPlayerList().get((Integer) playerList.get(2)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(2)).getCoins()+2);
            gameManager.getPlayerList().get((Integer) playerList.get(3)).setCoins(gameManager.getPlayerList().get((Integer) playerList.get(3)).getCoins()+1);
        }
    }

    /**
     * Information after tournament
     * @author Gabriel Solano
     * @param playerList
     */
    public void AfterTournamentData(DoubleList playerList){
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);
        if (playerList.getLength()==2){
            Data=" Hello!! this is the rank \n \n First position player: " +playerList.get(0)+ " Win 5 coins " +
                    "\n Second position player: "+playerList.get(1)+ "Win 3 coins";
        }else if(playerList.getLength()==3){
            Data=" Hello!! this is the rank \n \n First position player: " +playerList.get(0)+ " Win 5 coins " +
                    " \n Second position player: "+playerList.get(1)+ "Win 3 coins"+
                    " \n Third position player: "+playerList.get(2)+ "Win 2 coins";
        }else if(playerList.getLength()==4){
            Data=" Hello!! this is the rank \n \n First position player: " +playerList.get(0)+ " Win 5 coins \n" +
                    "\n Second position player: "+playerList.get(1)+ "Win 3 coins"+
                    "\n Third position player: "+playerList.get(2)+ "Win 2 coins"+
                    "\n Fourth position player: "+playerList.get(3)+ "Win 1 coins";
        }
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

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 13));
        data.setTextAlignment(TextAlignment.CENTER);
        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            return;
        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
