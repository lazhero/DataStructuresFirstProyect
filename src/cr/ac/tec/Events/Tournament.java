package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.concurrent.TimeUnit;

/**
 * It’s the tournament event
 * @author Gabriel Solano
 */
public class Tournament {
    private String Data;
    public static DoubleList<Integer> lista;

    /**
     * Runs the tournament
     * @author Gabriel Solano
     * @param playerList
     */
    public void Tournament(DoubleList playerList) {

        DiamondHunterGame xd = new DiamondHunterGame();
        xd.StartGame(playerList);
    }

    /**
     * Information about tournament
     * @author Gabriel Solano
     * @param playerList
     */
    public void TournamentData(DoubleList playerList) {
        GameManager gameManager = GameManager.getInstance(0,0,0,null,null,null);

        Data="Hello!! At the end of each round there \n will be a tournament, in this we \n will play Diamond Hunter, the game consists \n of hunting diamonds by turns, each player \n has to find 5, the less time later up on the \n podium will be, the prize will be coins, \n the first player : will win 5 coins, \n the second: 3 the third: 2 and the last: 1, \n the positioning continues even if there \n are 2,3,4 players. Good luck!";
        VBox vb = new VBox();
        vb.setStyle("-fx-background-image: url(/Resources/Images/Vboxbg.jpg)");
        vb.setMinWidth(550);
        vb.setMaxWidth(550);
        vb.setMinHeight(400);
        vb.setMaxHeight(400);
        vb.setLayoutX(310);
        vb.setLayoutY(150);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        gameManager.setRunning(true);

        Button buttock = new Button("OK");

        Text data = new Text();
        data.setText(Data);
        data.setStyle("-fx-fill: white");
        data.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        data.setTextAlignment(TextAlignment.CENTER);


        buttock.setOnMouseClicked(e->{
            gameManager.getAnchorPane().getChildren().remove(vb);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            gameManager.setRunning(false);
            Tournament(playerList);
            return;
        });
        vb.getChildren().addAll(data,buttock);
        gameManager.getAnchorPane().getChildren().add(vb);
    }
}
