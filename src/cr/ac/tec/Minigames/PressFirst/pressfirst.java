package cr.ac.tec.Minigames.PressFirst;

import cr.ac.tec.Board.Manage.GameManager;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.Random;

public class pressfirst  {

    Random Aleatorio = new Random();
    int n = (Aleatorio.nextInt(4)+2)*4;
    private int scorep1=n;
    private int scorep2=n;
    private Text score1 = new Text("Score: " + scorep1);
    private Text score2 = new Text("Score:" + scorep2);
    private Text winnerp= new Text("");
    int cont1;
    int cont2;
    int victory;
    private Text p1 = new Text();
    private Text p2 = new Text();
    private Text random = new Text();

    public Parent createContent(){
        Pane root = new Pane();

        root.setPrefSize(700,700);


        score1.setTranslateY(600);
        score1.setTranslateX(120);
        score1.setFont(Font.font(25));
        score1.setFill(Color.WHITE);

        score2.setTranslateY(600);
        score2.setTranslateX(450);
        score2.setFont(Font.font(25));
        score2.setFill(Color.WHITE);

        winnerp.setTranslateY(100);
        winnerp.setTranslateX(300);
        winnerp.setFont(Font.font(25));
        winnerp.setFill(Color.WHITE);

        p1.setText("Player 1 \nPress 'A'");
        p1.setTranslateY(530);
        p1.setTranslateX(120);
        p1.setFont(Font.font(25));
        p1.setFill(Color.WHITE);

        p2.setText("Player 2 \nPress 'L' " );
        p2.setTranslateY(530);
        p2.setTranslateX(450);
        p2.setFont(Font.font(25));
        p2.setFill(Color.WHITE);

        random.setText("Deben presionar su respectiva tecla hasta llegar a 0: \n el primero gana GO! \n "+n);
        random.setTranslateY(30);
        random.setTranslateX(50);
        random.setFont(Font.font(25));
        random.setFill(Color.WHITE);

        root.getChildren().addAll(score1,score2,p1,p2,random,winnerp);
        return root;
    }
    public void winner(int a,int b){
        if (a==0 && b>0){
            winnerp.setText("Player 1 win");
        }
        else if(b==0 && a>0){
            winnerp.setText("Player 2 win");
        }
    }
    public void StartGame(){
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.getAnchorPane().setVisible(true);

        //String path = "src/musicf.mp3";
        //Media audio = new Media(new File(path).toURI().toString());
        //MediaPlayer repro = new MediaPlayer(audio);
       // repro.setAutoPlay(true);
        Stage primaryStage = new Stage();
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event->{
            switch (event.getCode()){
                case A: break;
                case L: break;
            }
        });
        scene.setOnKeyReleased(event-> {
            switch (event.getCode()){
                case A:
                    scorep1-=1;
                    score1.setText("Score: "+scorep1 );
                    winner(scorep1,scorep2);
                    if(scorep1<0){
                        score1.setText("Score: "+0);
                    }
                    break;
                case L:
                    scorep2-=1;
                    score2.setText("Score: "+ scorep2);
                    winner(scorep1,scorep2);
                    if(scorep2<0){
                        score2.setText("Score: "+0);
                    }
                    break;
            }
        });

        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Press First, GOOD LUCK!");
        primaryStage.show();

    }

}