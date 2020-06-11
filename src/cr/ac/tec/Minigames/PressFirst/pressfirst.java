package cr.ac.tec.Minigames.PressFirst;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Events.AfterGameEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

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
    int lose;
    private Text p1 = new Text();
    private Text p2 = new Text();
    private Text random = new Text();
    private int dat1;
    private int dat2;
    private MediaPlayer mediaPlayer;

    /**
     *
     * @param dato1
     * @param dato2
     * @param primaryStage
     * @return
     */
    public Parent createContent(int dato1, int dato2,Stage primaryStage){
        Pane root = new Pane();
        root.setPrefSize(700,700);
        Image img = new Image("/Resources/images/fondo.png");
        ImageView fondo = new ImageView(img);

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
        winnerp.setStyle("-fx-fill: white");
        winnerp.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        p1.setText("Player"+ dato1 + "\nPress 'A'");
        p1.setTranslateY(530);
        p1.setTranslateX(120);
        p1.setStyle("-fx-fill: white");
        p1.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        p2.setText("Player "+ dato2+ " \nPress 'L' " );
        p2.setTranslateY(530);
        p2.setTranslateX(450);
        p2.setStyle("-fx-fill: white");
        p2.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));

        random.setText("Deben presionar su respectiva tecla hasta llegar a 0: \n el primero gana GO! \n "+n);
        random.setTranslateY(30);
        random.setTranslateX(50);
        random.setStyle("-fx-fill: white");
        random.setFont(Font.loadFont(getClass().getResourceAsStream("/Resources/Fonts/04B_30__.ttf"), 15));
        dat1=dato1;
        dat2=dato2;

        Button buttok = new Button("End Game");
        buttok.setOnMouseClicked(event -> {
            System.out.println(scorep1);
            System.out.println(scorep2);
            if(scorep1<=0||scorep2<=0){

                new AfterGameEvent().AfterGameEventData(victory,lose);
                primaryStage.close();
                mediaPlayer.stop();
            }
            else{
                System.out.println("Xd");
            }

        });
        root.getChildren().addAll(fondo,score1,score2,p1,p2,random,winnerp,buttok);
        return root;
    }

    /**
     *
     * @param a
     * @param b
     */
    public void winner(int a,int b){
        if (a==0 && b>0){
            winnerp.setText("Player "+dat1 + " win");
            victory=dat1;
            lose=dat2;
        }
        else if(b==0 && a>0){
            victory=dat2;
            lose=dat1;
            winnerp.setText("Player "+ dat2+" win");
        }
    }

    /**
     *
     * @return
     */
    public int getVictory() {
        return victory;
    }

    /**
     *
     * @param dat1
     * @param dat2
     */
    public void StartGame(int dat1, int dat2){
        GameManager gameManager = GameManager.getInstance(0,0);
        gameManager.getAnchorPane().setVisible(true);

        String path="src/Resources/Music/PressFirstMusic.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);


        Stage primaryStage = new Stage();
        Scene scene = new Scene(createContent(dat1,dat2,primaryStage));
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
        primaryStage.setScene(scene);
        primaryStage.setTitle("Press First, GOOD LUCK!");
        primaryStage.show();
    }
}
