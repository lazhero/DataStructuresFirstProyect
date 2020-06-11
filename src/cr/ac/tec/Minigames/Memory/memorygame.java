package cr.ac.tec.Minigames.Memory;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Events.AfterGameEvent;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;

import javafx.util.Duration;

import java.io.File;


public class memorygame {

    private static final int NUM_OF_PAIRS=8;
    private  static final int NUM_PER_ROW=4;
    private Tile selected = null;
    private int clickCount = 2;
    int cont;
    int correct;
    int victory;
    int lose;
    private int scorep1=0;
    private int scorep2=0;
    private int dat1;
    private int dat2;
    private Text turn= new Text();
    private Text score1=new Text("Score:"+ scorep1);
    private Text score2=new Text("Score:"+ scorep2);
    private MediaPlayer mediaPlayer;

    /**
     *
     * @param player1
     * @param player2
     * @param primaryStage
     * @return
     */
    public Parent createContent(int player1,int player2,Stage primaryStage){

        Pane root = new Pane();
        root.setPrefSize(700,700);
        Image img = new Image("/Resources/images/fondo1.jpg");
        ImageView fondo = new ImageView(img);
        root.getChildren().addAll(fondo,turn);
        if (cont%2==0){
            turn.setText("Player " +player1+ "turn");
            turn.setTranslateY(650);
            turn.setTranslateX(120);
            turn.setStyle("-fx-fill: white");
            turn.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        }
        else{
            turn.setText("Player "+player2+" turn");
            turn.setTranslateY(580);
            turn.setTranslateX(300);
            turn.setStyle("-fx-fill: white");
            turn.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        }
        char c='A';
        DoubleList<Tile> tiles = new DoubleList<>();
        for(int i=0; i<NUM_OF_PAIRS;i++){
            tiles.AddTail(new Tile(String.valueOf(c)));
            tiles.AddTail(new Tile(String.valueOf(c)));
            c++;
        }
        tiles=tiles.Shuffle();
        for (int i=0;i<tiles.getLength();i++){
            Tile tile = tiles.get(i);
            tile.setTranslateX(130*((i)%NUM_PER_ROW)+80);
            tile.setTranslateY(130*((i)/NUM_PER_ROW)+10);
            root.getChildren().add(tile);
        }

        Text player1t = new Text("Player "+player1);
        player1t.setTranslateY(580);
        player1t.setTranslateX(80);
        player1t.setStyle("-fx-fill: white");
        player1t.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        Text player2t = new Text("Player "+player2);
        player2t.setTranslateX(450);
        player2t.setTranslateY(580);
        player2t.setFont(Font.font(30));
        player2t.setStyle("-fx-fill: white");
        player2t.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        score1.setTranslateX(80);
        score1.setTranslateY(620);
        score1.setFont(Font.font(27));

        score2.setTranslateX(450);
        score2.setTranslateY(620);
        score2.setFont(Font.font(27));
        dat1=player1;
        dat2=player2;
        Button butto = new Button("End Game");
        butto.setOnMouseClicked(event -> {
            if ((correct==8)){
                new AfterGameEvent().AfterGameEventData(victory,lose);
                primaryStage.close();
                mediaPlayer.stop();
            }else{
            }

        });
        root.getChildren().addAll(player1t,player2t,score1,score2,butto);
        return root;
    }

    /**
     *
     * @param str
     */
    public void changeturn(String str){
        turn.setText(str);
    }


    public class Tile extends StackPane{
        private Text text= new Text();

        /**
         *
         * @param value
         */
        public Tile(String value){
            Rectangle border = new Rectangle(120,120);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setText(value);
            text.setFont(Font.font(50));
            setAlignment(Pos.CENTER);
            getChildren().addAll(border,text);
            setOnMouseClicked(this::handleMouseClick);
            close();
        }

        /**
         *
         * @param event
         */
        public void handleMouseClick(MouseEvent event){
            if (isOpen() || clickCount==0)
                return;
            clickCount--;
            if (selected==null){
                selected= this;
                open(()->{});
            }
            else {
                open(() -> {
                    if (!hasSameValue(selected)) {
                        selected.close();
                        this.close();
                        cont=cont+1;
                        if(cont%2==0){
                            changeturn("Player "+dat1+" turn");
                        }
                        else changeturn("Player "+dat2+ " turn");
                    }
                    else{
                        if (cont%2==0){
                            correct+=1;
                            scorep1=scorep1+10;
                            score1.setText("Score:"+ scorep1);
                            cont=cont+2;
                        }
                        else{
                            correct+=1;
                            scorep2=scorep2+10;
                            score2.setText("Score:"+ scorep2);
                            cont=cont+2;

                        }
                        if (correct==8){
                            if(scorep1>scorep2){
                                winner(1);
                            }
                            else{
                                winner(2);
                            }
                        }
                    }
                    selected = null;
                    clickCount=2;
                });
            }
        }

        /**
         *
         * @return
         */
        public  boolean isOpen(){
            return text.getOpacity()==1;
        }
        /**
         *
         * @param a
         * @return
         */
        public Player winner(int a){
            if (a==1){
                victory=dat1;
                lose=dat2;

            }
            if(a==2){
                victory=dat2;
                lose=dat1;

            }
            return null ;
        }

        /**
         *
         * @param action
         */
        public void open(Runnable action){
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5),text);
            ft.setToValue(1);
            ft.setOnFinished(e-> action.run());
            ft.play();
        }

        /**
         *
         */
        public void close(){
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5),text);
            ft.setToValue(0);
            ft.play();
        }

        /**
         *
         * @param other
         * @return
         */
        public boolean hasSameValue(Tile other){
            return text.getText().equals(other.text.getText());
        }
    }

    /**
     *
     * @param player1
     * @param player2
     */
    public void StarGame(int player1, int player2){
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.getAnchorPane().setVisible(true);


        String path="src/Resources/Music/MemoryGameMusic.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(createContent(player1,player2,primaryStage)));
        primaryStage.setTitle("Memory Game, GOOD LUCK!");
        primaryStage.show();
    }
}