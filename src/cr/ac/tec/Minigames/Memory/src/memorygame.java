import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Duration;


public class memorygame extends Application {

    private static final int NUM_OF_PAIRS=8;
    private  static final int NUM_PER_ROW=4;
    private Tile selected = null;
    private int clickCount = 2;
    int cont;
    int correct;
    int victory;
    private int scorep1=0;
    private int scorep2=0;
    private Text turn= new Text();
    private Text score1=new Text("Score:"+ scorep1);
    private Text score2=new Text("Score:"+ scorep2);

    public Parent createContent(){


        Pane root = new Pane();
        root.setPrefSize(700,700);
        Image img = new Image("/imagenes/fondo1.jpg");
        ImageView fondo = new ImageView(img);
        root.getChildren().addAll(fondo,turn);
        if (cont%2==0){
            turn.setText("Player 1 turn");
            turn.setTranslateY(650);
            turn.setTranslateX(120);
            turn.setFont(Font.font(30));

        }
        else{
            turn.setText("Player 2 turn");
            turn.setTranslateY(580);
            turn.setTranslateX(300);
            turn.setFont(Font.font(30));
        }

        char c='A';
        List<Tile> tiles =new ArrayList<>();
        for(int i=0; i<NUM_OF_PAIRS;i++){
            tiles.add(new Tile(String.valueOf(c)));
            tiles.add(new Tile(String.valueOf(c)));
            c++;
        }
        Collections.shuffle(tiles);
        for (int i=0;i<tiles.size();i++){
            Tile tile = tiles.get(i);
            tile.setTranslateX(130*((i)%NUM_PER_ROW)+80);
            tile.setTranslateY(130*((i)/NUM_PER_ROW)+10);
            root.getChildren().add(tile);
        }

        Text player1t = new Text("Player 1");
        player1t.setTranslateY(580);
        player1t.setTranslateX(80);
        player1t.setFont(Font.font(30));

        Text player2t = new Text("Player 2");
        player2t.setTranslateX(450);
        player2t.setTranslateY(580);
        player2t.setFont(Font.font(30));

        score1.setTranslateX(80);
        score1.setTranslateY(620);
        score1.setFont(Font.font(27));

        score2.setTranslateX(450);
        score2.setTranslateY(620);
        score2.setFont(Font.font(27));

        root.getChildren().addAll(player1t,player2t,score1,score2);

        return root;
    }
    

    public class Tile extends StackPane{

        private Text text= new Text();

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
                            changeturn("Player 1 turn");
                        }

                        else changeturn("Player 2 turn");

                    }
                    else{
                        if (cont%2==0){
                            correct+=1;
                            scorep1=scorep1+10;
                            changeturn("Player 2 turn");
                            score1.setText("Score:"+ scorep1);
                            System.out.println("player 1  "+scorep1);
                            cont=cont+1;
                        }
                        else{
                            correct+=1;
                            scorep2=scorep2+10;
                            score2.setText("Score:"+ scorep2);
                            System.out.println("EStoy aqui");
                            changeturn("Player 1 turn");
                            System.out.println("player 2  "+ scorep2);;
                            cont=cont+1;
                            System.out.println(correct);
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
        public  boolean isOpen(){
            return text.getOpacity()==1;

        }
        public void winner(int a){
            if (a==1){
                victory=1;
            }
            if(a==2){
                victory=2;
            }
        }
        public void open(Runnable action){
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5),text);
            ft.setToValue(1);
            ft.setOnFinished(e-> action.run());
            ft.play();
        }
        public void close(){
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5),text);
            ft.setToValue(0);
            ft.play();
        }
        public boolean hasSameValue(Tile other){
            return text.getText().equals(other.text.getText());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Memory Game, GOOD LUCK!");
        primaryStage.show();
    }
}