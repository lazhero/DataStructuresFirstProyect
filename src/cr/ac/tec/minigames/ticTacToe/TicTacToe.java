package cr.ac.tec.Minigames.ticTacToe;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class TicTacToe extends Application {
    private boolean playable = true;
    private boolean turnX = true;

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(600,600);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j*200);
                tile.setTranslateY(i*200);

                root.getChildren().add(tile);
            }
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private void checkState(){

    }



    private class Tile extends StackPane {

        private Text text = new Text();

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

                if (event.getButton()== MouseButton.PRIMARY){
                    if (!turnX)
                        return;
                    drawX();
                    turnX = false;
                    checkState();
                }
                else if (event.getButton() == MouseButton.SECONDARY){
                    if (turnX)
                        return;
                    drawO();
                    turnX = true;
                    checkState();
                }
            });
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

    public static void main(String[] args){
        launch(args);
    }
}
