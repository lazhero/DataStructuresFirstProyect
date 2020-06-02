package cr.ac.tec.Minigames.ticTacToe;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * Tic tac toe game.
 *
 * @author migue
 */
public class TicTacToe{
    public static Button button = new Button("Try again!");
    public static boolean playable = true;
    public static boolean turnX = true;
    public static Tile[][] board = new Tile[3][3];
    public static DoubleList<Combo> combos = new DoubleList<>();
    public static Pane root = new Pane();


    public static void restart(){

    }


    /**
     * Creates the interface which the player interacts with.
     * @return root
     */
    public static Parent createContent(){
        button.setPrefSize(100,20);
        button.setFont(Font.font(16));
        button.setTranslateX(250);
        button.setTranslateY(604);
        //button.setOnMouseClicked(e -> createContent());

        root.getChildren().add(button);
        root.setPrefSize(600,643);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j*200);
                tile.setTranslateY(i*200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }
        //horizontal
        for (int y = 0; y < 3; y++){
            combos.AddHead(new Combo(board[0][y],board[1][y],board[2][y]));
        }

        //vertical
        for (int x = 0; x < 3; x++) {
            combos.AddHead(new Combo(board[x][0], board[x][1], board[x][2]));
        }

        //diagonals
        combos.AddHead(new Combo(board[0][0],board[1][1],board[2][2]));
        combos.AddHead(new Combo(board[2][0],board[1][1],board[0][2]));

        return root;
    }



    /**
     * Checks if the game is still playable.
     */
    private static void checkState(){
        for (int i=0; i<combos.getLength();i++){
            if (combos.get(i).isComplete()){
                playable = false;
                playWinAnimation(combos.get(i));
                break;
            }
        }

    }

    /**
     * Draws a line across the winning combo
     * @param combo combination of characters as "x" or "o" that makes a player win a match.
     */
    private static void playWinAnimation(Combo combo){
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());

        root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));
        timeline.play();
    }

    /**
     * Array of combinations that makes a player win a game.
     */
    private static class Combo{
        private Tile[] tiles;
        public Combo(Tile... tiles){
            this.tiles = tiles;
        }

        /**
         * Checks if a combination is complete.
         * @return
         */
        public boolean isComplete(){
            if (tiles[0].getValue().isEmpty())
                return false;

            return tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());
        }

    }



    private static class Tile extends StackPane {

        boolean editable = true;
        private Text text = new Text();

        /**
         * Creates each square(tile) with a blank text in which a player can draw an "x" or "o".
         */
        public Tile(){
            Rectangle border = new Rectangle(200,200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event ->{
                if (!playable)
                    return;

                if (event.getButton()== MouseButton.PRIMARY && editable){
                    if (!turnX)
                        return;
                    editable = false;
                    drawX();
                    turnX = false;
                    checkState();
                }
                else if (event.getButton() == MouseButton.SECONDARY && editable){
                    if (turnX)
                        return;
                    editable = false;
                    drawO();
                    turnX = true;
                    checkState();
                }
            });
        }

        public double getCenterX(){
            return getTranslateX() + 100;
        }

        public double getCenterY(){
            return getTranslateY() + 100;
        }

        public String getValue(){
            return text.getText();
        }

        private void drawX(){
            text.setText("X");
        }

        private void drawO(){
            text.setText("O");
        }
    }

    public void StartGame(int dato1, int dato2){
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

}
